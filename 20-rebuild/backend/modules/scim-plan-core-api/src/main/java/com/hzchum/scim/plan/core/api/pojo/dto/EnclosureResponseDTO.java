package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("围护清单 响应类")
public class EnclosureResponseDTO {
   @ApiModelProperty(name = "id", value = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   private Long dictionaryId;
   @ApiModelProperty(name = "dictionaryName", value = "字典名")
   private String dictionaryName;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停 1进行中")
   private Integer boolStatusEnum;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "coating", value = "涂层")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   private String plating;
   @ApiModelProperty(name = "weight", value = "单重(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "宽度（mm）")
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(米)")
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "unit", value = "计量单位")
   private String unit;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "bendTimes", value = "折边件弯折次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "weightMeter", value = "(桁架楼承板)米重(kg/m)")
   private BigDecimal weightMeter;
   @ApiModelProperty(name = "attachmentId", value = "附件id")
   private Long attachmentId;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人(导入人)")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "producedQuantity", value = "已生产数")
   private Integer producedQuantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "shippedQuantity", value = "发运数量")
   private Integer shippedQuantity;
   @ApiModelProperty(name = "attachmentDTO", value = "附件对象")
   private AttachmentDTO attachmentDTO;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty("规格")
   private String specification;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getDictionaryName() {
      return this.dictionaryName;
   }

   public Integer getBoolStatusEnum() {
      return this.boolStatusEnum;
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

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
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

   public BigDecimal getAccountingVolume() {
      return this.accountingVolume;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public BigDecimal getWeightMeter() {
      return this.weightMeter;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getShippedQuantity() {
      return this.shippedQuantity;
   }

   public AttachmentDTO getAttachmentDTO() {
      return this.attachmentDTO;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getSpecification() {
      return this.specification;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("category")
   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setDictionaryName(final String dictionaryName) {
      this.dictionaryName = dictionaryName;
   }

   public void setBoolStatusEnum(final Integer boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
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

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setAccountingVolume(final BigDecimal accountingVolume) {
      this.accountingVolume = accountingVolume;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
   }

   public void setWeightMeter(final BigDecimal weightMeter) {
      this.weightMeter = weightMeter;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
   }

   public void setShippedQuantity(final Integer shippedQuantity) {
      this.shippedQuantity = shippedQuantity;
   }

   public void setAttachmentDTO(final AttachmentDTO attachmentDTO) {
      this.attachmentDTO = attachmentDTO;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureResponseDTO)) {
         return false;
      }

      EnclosureResponseDTO other = (EnclosureResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$enclosurePlanId = this.getEnclosurePlanId();
            Object other$enclosurePlanId = other.getEnclosurePlanId();
            if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$dictionaryId = this.getDictionaryId();
                     Object other$dictionaryId = other.getDictionaryId();
                     if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                        Object this$boolStatusEnum = this.getBoolStatusEnum();
                        Object other$boolStatusEnum = other.getBoolStatusEnum();
                        if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$bendTimes = this.getBendTimes();
                              Object other$bendTimes = other.getBendTimes();
                              if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                                 Object this$attachmentId = this.getAttachmentId();
                                 Object other$attachmentId = other.getAttachmentId();
                                 if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$producedQuantity = this.getProducedQuantity();
                                       Object other$producedQuantity = other.getProducedQuantity();
                                       if (this$producedQuantity == null
                                          ? other$producedQuantity == null
                                          : this$producedQuantity.equals(other$producedQuantity)) {
                                          Object this$schedulingQuantity = this.getSchedulingQuantity();
                                          Object other$schedulingQuantity = other.getSchedulingQuantity();
                                          if (this$schedulingQuantity == null
                                             ? other$schedulingQuantity == null
                                             : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                                             Object this$shippedQuantity = this.getShippedQuantity();
                                             Object other$shippedQuantity = other.getShippedQuantity();
                                             if (this$shippedQuantity == null
                                                ? other$shippedQuantity == null
                                                : this$shippedQuantity.equals(other$shippedQuantity)) {
                                                Object this$projectName = this.getProjectName();
                                                Object other$projectName = other.getProjectName();
                                                if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                   Object this$dictionaryName = this.getDictionaryName();
                                                   Object other$dictionaryName = other.getDictionaryName();
                                                   if (this$dictionaryName == null
                                                      ? other$dictionaryName == null
                                                      : this$dictionaryName.equals(other$dictionaryName)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$plate = this.getPlate();
                                                            Object other$plate = other.getPlate();
                                                            if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                               Object this$brand = this.getBrand();
                                                               Object other$brand = other.getBrand();
                                                               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                  Object this$color = this.getColor();
                                                                  Object other$color = other.getColor();
                                                                  if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                     Object this$material = this.getMaterial();
                                                                     Object other$material = other.getMaterial();
                                                                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                        Object this$coating = this.getCoating();
                                                                        Object other$coating = other.getCoating();
                                                                        if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                                           Object this$plating = this.getPlating();
                                                                           Object other$plating = other.getPlating();
                                                                           if (this$plating == null
                                                                              ? other$plating == null
                                                                              : this$plating.equals(other$plating)) {
                                                                              Object this$weight = this.getWeight();
                                                                              Object other$weight = other.getWeight();
                                                                              if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)
                                                                                 )
                                                                               {
                                                                                 Object this$totalWeight = this.getTotalWeight();
                                                                                 Object other$totalWeight = other.getTotalWeight();
                                                                                 if (this$totalWeight == null
                                                                                    ? other$totalWeight == null
                                                                                    : this$totalWeight.equals(other$totalWeight)) {
                                                                                    Object this$thickness = this.getThickness();
                                                                                    Object other$thickness = other.getThickness();
                                                                                    if (this$thickness == null
                                                                                       ? other$thickness == null
                                                                                       : this$thickness.equals(other$thickness)) {
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
                                                                                                   Object this$accountingVolume = this.getAccountingVolume();
                                                                                                   Object other$accountingVolume = other.getAccountingVolume();
                                                                                                   if (this$accountingVolume == null
                                                                                                      ? other$accountingVolume == null
                                                                                                      : this$accountingVolume.equals(other$accountingVolume)) {
                                                                                                      Object this$unit = this.getUnit();
                                                                                                      Object other$unit = other.getUnit();
                                                                                                      if (this$unit == null
                                                                                                         ? other$unit == null
                                                                                                         : this$unit.equals(other$unit)) {
                                                                                                         Object this$surfaceArea = this.getSurfaceArea();
                                                                                                         Object other$surfaceArea = other.getSurfaceArea();
                                                                                                         if (this$surfaceArea == null
                                                                                                            ? other$surfaceArea == null
                                                                                                            : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                            Object this$totalArea = this.getTotalArea();
                                                                                                            Object other$totalArea = other.getTotalArea();
                                                                                                            if (this$totalArea == null
                                                                                                               ? other$totalArea == null
                                                                                                               : this$totalArea.equals(other$totalArea)) {
                                                                                                               Object this$drawingNumber = this.getDrawingNumber();
                                                                                                               Object other$drawingNumber = other.getDrawingNumber();
                                                                                                               if (this$drawingNumber == null
                                                                                                                  ? other$drawingNumber == null
                                                                                                                  : this$drawingNumber.equals(
                                                                                                                     other$drawingNumber
                                                                                                                  )) {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  if (this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark)) {
                                                                                                                     Object this$weightMeter = this.getWeightMeter();
                                                                                                                     Object other$weightMeter = other.getWeightMeter();
                                                                                                                     if (this$weightMeter == null
                                                                                                                        ? other$weightMeter == null
                                                                                                                        : this$weightMeter.equals(
                                                                                                                           other$weightMeter
                                                                                                                        )) {
                                                                                                                        Object this$userName = this.getUserName();
                                                                                                                        Object other$userName = other.getUserName();
                                                                                                                        if (this$userName == null
                                                                                                                           ? other$userName == null
                                                                                                                           : this$userName.equals(
                                                                                                                              other$userName
                                                                                                                           )) {
                                                                                                                           Object this$createTime = this.getCreateTime();
                                                                                                                           Object other$createTime = other.getCreateTime();
                                                                                                                           if (this$createTime == null
                                                                                                                              ? other$createTime == null
                                                                                                                              : this$createTime.equals(
                                                                                                                                 other$createTime
                                                                                                                              )) {
                                                                                                                              Object this$attachmentDTO = this.getAttachmentDTO();
                                                                                                                              Object other$attachmentDTO = other.getAttachmentDTO();
                                                                                                                              if (this$attachmentDTO == null
                                                                                                                                 ? other$attachmentDTO == null
                                                                                                                                 : this$attachmentDTO.equals(
                                                                                                                                    other$attachmentDTO
                                                                                                                                 )) {
                                                                                                                                 Object this$monomer = this.getMonomer();
                                                                                                                                 Object other$monomer = other.getMonomer();
                                                                                                                                 if (this$monomer == null
                                                                                                                                    ? other$monomer == null
                                                                                                                                    : this$monomer.equals(
                                                                                                                                       other$monomer
                                                                                                                                    )) {
                                                                                                                                    Object this$area = this.getArea();
                                                                                                                                    Object other$area = other.getArea();
                                                                                                                                    if (this$area == null
                                                                                                                                       ? other$area == null
                                                                                                                                       : this$area.equals(
                                                                                                                                          other$area
                                                                                                                                       )) {
                                                                                                                                       Object this$specification = this.getSpecification();
                                                                                                                                       Object other$specification = other.getSpecification();
                                                                                                                                       return this$specification
                                                                                                                                             == null
                                                                                                                                          ? other$specification
                                                                                                                                             == null
                                                                                                                                          : this$specification.equals(
                                                                                                                                             other$specification
                                                                                                                                          );
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
      return other instanceof EnclosureResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $shippedQuantity = this.getShippedQuantity();
      result = result * 59 + ($shippedQuantity == null ? 43 : $shippedQuantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $dictionaryName = this.getDictionaryName();
      result = result * 59 + ($dictionaryName == null ? 43 : $dictionaryName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $accountingVolume = this.getAccountingVolume();
      result = result * 59 + ($accountingVolume == null ? 43 : $accountingVolume.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $weightMeter = this.getWeightMeter();
      result = result * 59 + ($weightMeter == null ? 43 : $weightMeter.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $attachmentDTO = this.getAttachmentDTO();
      result = result * 59 + ($attachmentDTO == null ? 43 : $attachmentDTO.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureResponseDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dictionaryName="
         + this.getDictionaryName()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", quantity="
         + this.getQuantity()
         + ", accountingVolume="
         + this.getAccountingVolume()
         + ", unit="
         + this.getUnit()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", bendTimes="
         + this.getBendTimes()
         + ", weightMeter="
         + this.getWeightMeter()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", shippedQuantity="
         + this.getShippedQuantity()
         + ", attachmentDTO="
         + this.getAttachmentDTO()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", specification="
         + this.getSpecification()
         + ")";
   }
}
