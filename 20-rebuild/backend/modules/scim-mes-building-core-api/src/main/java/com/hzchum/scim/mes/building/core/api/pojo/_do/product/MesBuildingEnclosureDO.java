package com.hzchum.scim.mes.building.core.api.pojo._do.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("MesBuildingEnclosureDO")
public class MesBuildingEnclosureDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
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
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "totalSchedulingQuantity", notes = "排产总数量")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalTaskQuantity", notes = "已下发总数量")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "projectName", value = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "attachmentId", value = "附件id")
   @JsonProperty("attachmentId")
   @JSONField(name = "attachmentId")
   private Integer attachmentId;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "unfoldedWidth", notes = "展宽(mm)")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   private BigDecimal unfoldedWidth;

   public static MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder builder() {
      return new MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder();
   }

   public MesBuildingEnclosureDO() {
   }

   public MesBuildingEnclosureDO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
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
      final Integer producedQuantity,
      final Integer totalSchedulingQuantity,
      final Integer totalTaskQuantity,
      final String projectName,
      final String monomerName,
      final String areaName,
      final Integer attachmentId,
      final Boolean boolAbnormalEnum,
      final BigDecimal unfoldedWidth
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
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
      this.producedQuantity = producedQuantity;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
      this.projectName = projectName;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.attachmentId = attachmentId;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.unfoldedWidth = unfoldedWidth;
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

   public Long getAreaId() {
      return this.areaId;
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

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getAttachmentId() {
      return this.attachmentId;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   @JsonProperty("id")
   public MesBuildingEnclosureDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingEnclosureDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingEnclosureDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingEnclosureDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public MesBuildingEnclosureDO setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("category")
   public MesBuildingEnclosureDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingEnclosureDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingEnclosureDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public MesBuildingEnclosureDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public MesBuildingEnclosureDO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingEnclosureDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingEnclosureDO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingEnclosureDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public MesBuildingEnclosureDO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingEnclosureDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingEnclosureDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public MesBuildingEnclosureDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public MesBuildingEnclosureDO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingEnclosureDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("businessId")
   public MesBuildingEnclosureDO setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("brand")
   public MesBuildingEnclosureDO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesBuildingEnclosureDO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public MesBuildingEnclosureDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalTaskQuantity")
   public MesBuildingEnclosureDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingEnclosureDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingEnclosureDO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingEnclosureDO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("attachmentId")
   public MesBuildingEnclosureDO setAttachmentId(final Integer attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MesBuildingEnclosureDO setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public MesBuildingEnclosureDO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingEnclosureDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingEnclosureDO)) {
         return false;
      }

      MesBuildingEnclosureDO other = (MesBuildingEnclosureDO)o;
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
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
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
                              Object this$producedQuantity = this.getProducedQuantity();
                              Object other$producedQuantity = other.getProducedQuantity();
                              if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                 Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                                 Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                                 if (this$totalSchedulingQuantity == null
                                    ? other$totalSchedulingQuantity == null
                                    : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                                    Object this$totalTaskQuantity = this.getTotalTaskQuantity();
                                    Object other$totalTaskQuantity = other.getTotalTaskQuantity();
                                    if (this$totalTaskQuantity == null
                                       ? other$totalTaskQuantity == null
                                       : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
                                       Object this$attachmentId = this.getAttachmentId();
                                       Object other$attachmentId = other.getAttachmentId();
                                       if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                          Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                          Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                          if (this$boolAbnormalEnum == null
                                             ? other$boolAbnormalEnum == null
                                             : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
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
                                                                           if (this$totalArea == null
                                                                              ? other$totalArea == null
                                                                              : this$totalArea.equals(other$totalArea)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$brand = this.getBrand();
                                                                                 Object other$brand = other.getBrand();
                                                                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                                    Object this$projectName = this.getProjectName();
                                                                                    Object other$projectName = other.getProjectName();
                                                                                    if (this$projectName == null
                                                                                       ? other$projectName == null
                                                                                       : this$projectName.equals(other$projectName)) {
                                                                                       Object this$monomerName = this.getMonomerName();
                                                                                       Object other$monomerName = other.getMonomerName();
                                                                                       if (this$monomerName == null
                                                                                          ? other$monomerName == null
                                                                                          : this$monomerName.equals(other$monomerName)) {
                                                                                          Object this$areaName = this.getAreaName();
                                                                                          Object other$areaName = other.getAreaName();
                                                                                          if (this$areaName == null
                                                                                             ? other$areaName == null
                                                                                             : this$areaName.equals(other$areaName)) {
                                                                                             Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                                             Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                                             return this$unfoldedWidth == null
                                                                                                ? other$unfoldedWidth == null
                                                                                                : this$unfoldedWidth.equals(other$unfoldedWidth);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingEnclosureDO;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
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
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      return result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
   }

   public static class MesBuildingEnclosureDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
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
      private Integer producedQuantity;
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private String projectName;
      private String monomerName;
      private String areaName;
      private Integer attachmentId;
      private Boolean boolAbnormalEnum;
      private BigDecimal unfoldedWidth;

      MesBuildingEnclosureDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("category")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("businessId")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("brand")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("attachmentId")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder attachmentId(final Integer attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public MesBuildingEnclosureDO build() {
         return new MesBuildingEnclosureDO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
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
            this.producedQuantity,
            this.totalSchedulingQuantity,
            this.totalTaskQuantity,
            this.projectName,
            this.monomerName,
            this.areaName,
            this.attachmentId,
            this.boolAbnormalEnum,
            this.unfoldedWidth
         );
      }

      @Override
      public String toString() {
         return "MesBuildingEnclosureDO.MesBuildingEnclosureDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ", producedQuantity="
            + this.producedQuantity
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", projectName="
            + this.projectName
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", attachmentId="
            + this.attachmentId
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ")";
      }
   }
}
