package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "EnclosureProductDetailDTO", description = "项目全貌生产看板返回类")
public class EnclosureProductDetailDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private PlanMonomerDTO monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private PlanAreaDTO area;
   @ApiModelProperty(name = "plan", value = "区域")
   @JsonProperty("plan")
   @JSONField(name = "plan")
   private EnclosurePlanDTO plan;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型id")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   private Long dictionaryId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   private String brand;
   @ApiModelProperty(name = "plate", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "weight", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "coating", value = "涂层")
   @JsonProperty("coating")
   @JSONField(name = "coating")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @JsonProperty("plating")
   @JSONField(name = "plating")
   private String plating;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   @JsonProperty("bendTimes")
   @JSONField(name = "bendTimes")
   private Integer bendTimes;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人(导入人)")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "status", value = "产品状态  1:未生产 ,2:生产中 4:生产完毕 ")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder builder() {
      return new EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder();
   }

   public EnclosureProductDetailDTO() {
   }

   public EnclosureProductDetailDTO(
      final Long id,
      final ProjectInfo project,
      final PlanMonomerDTO monomer,
      final PlanAreaDTO area,
      final EnclosurePlanDTO plan,
      final Long dictionaryId,
      final Integer category,
      final String name,
      final String serialNumber,
      final String brand,
      final String plate,
      final String color,
      final String material,
      final BigDecimal weight,
      final BigDecimal thickness,
      final String coating,
      final String plating,
      final BigDecimal width,
      final BigDecimal unfoldedWidth,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer bendTimes,
      final Long userId,
      final String userName,
      final Integer producedQuantity,
      final Integer schedulingQuantity,
      final Integer status
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.plan = plan;
      this.dictionaryId = dictionaryId;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.weight = weight;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
      this.width = width;
      this.unfoldedWidth = unfoldedWidth;
      this.length = length;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.bendTimes = bendTimes;
      this.userId = userId;
      this.userName = userName;
      this.producedQuantity = producedQuantity;
      this.schedulingQuantity = schedulingQuantity;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public PlanMonomerDTO getMonomer() {
      return this.monomer;
   }

   public PlanAreaDTO getArea() {
      return this.area;
   }

   public EnclosurePlanDTO getPlan() {
      return this.plan;
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

   public String getPlating() {
      return this.plating;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public EnclosureProductDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public EnclosureProductDetailDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public EnclosureProductDetailDTO setMonomer(final PlanMonomerDTO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public EnclosureProductDetailDTO setArea(final PlanAreaDTO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("plan")
   public EnclosureProductDetailDTO setPlan(final EnclosurePlanDTO plan) {
      this.plan = plan;
      return this;
   }

   @JsonProperty("dictionaryId")
   public EnclosureProductDetailDTO setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @JsonProperty("category")
   public EnclosureProductDetailDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public EnclosureProductDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public EnclosureProductDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("brand")
   public EnclosureProductDetailDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public EnclosureProductDetailDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public EnclosureProductDetailDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public EnclosureProductDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public EnclosureProductDetailDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public EnclosureProductDetailDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public EnclosureProductDetailDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public EnclosureProductDetailDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("width")
   public EnclosureProductDetailDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public EnclosureProductDetailDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @JsonProperty("length")
   public EnclosureProductDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public EnclosureProductDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public EnclosureProductDetailDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public EnclosureProductDetailDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("bendTimes")
   public EnclosureProductDetailDTO setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
      return this;
   }

   @JsonProperty("userId")
   public EnclosureProductDetailDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public EnclosureProductDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("producedQuantity")
   public EnclosureProductDetailDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public EnclosureProductDetailDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("status")
   public EnclosureProductDetailDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProductDetailDTO)) {
         return false;
      }

      EnclosureProductDetailDTO other = (EnclosureProductDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$dictionaryId = this.getDictionaryId();
         Object other$dictionaryId = other.getDictionaryId();
         if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$bendTimes = this.getBendTimes();
                  Object other$bendTimes = other.getBendTimes();
                  if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$producedQuantity = this.getProducedQuantity();
                        Object other$producedQuantity = other.getProducedQuantity();
                        if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                           Object this$schedulingQuantity = this.getSchedulingQuantity();
                           Object other$schedulingQuantity = other.getSchedulingQuantity();
                           if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$monomer = this.getMonomer();
                                    Object other$monomer = other.getMonomer();
                                    if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                       Object this$area = this.getArea();
                                       Object other$area = other.getArea();
                                       if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                          Object this$plan = this.getPlan();
                                          Object other$plan = other.getPlan();
                                          if (this$plan == null ? other$plan == null : this$plan.equals(other$plan)) {
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
                                                                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)
                                                                     )
                                                                   {
                                                                     Object this$coating = this.getCoating();
                                                                     Object other$coating = other.getCoating();
                                                                     if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                                        Object this$plating = this.getPlating();
                                                                        Object other$plating = other.getPlating();
                                                                        if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                                                           Object this$width = this.getWidth();
                                                                           Object other$width = other.getWidth();
                                                                           if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
                                                                                       Object this$totalArea = this.getTotalArea();
                                                                                       Object other$totalArea = other.getTotalArea();
                                                                                       if (this$totalArea == null
                                                                                          ? other$totalArea == null
                                                                                          : this$totalArea.equals(other$totalArea)) {
                                                                                          Object this$userName = this.getUserName();
                                                                                          Object other$userName = other.getUserName();
                                                                                          return this$userName == null
                                                                                             ? other$userName == null
                                                                                             : this$userName.equals(other$userName);
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
      return other instanceof EnclosureProductDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $plan = this.getPlan();
      result = result * 59 + ($plan == null ? 43 : $plan.hashCode());
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
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureProductDetailDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", plan="
         + this.getPlan()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", category="
         + this.getCategory()
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
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", bendTimes="
         + this.getBendTimes()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class EnclosureProductDetailDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private PlanMonomerDTO monomer;
      private PlanAreaDTO area;
      private EnclosurePlanDTO plan;
      private Long dictionaryId;
      private Integer category;
      private String name;
      private String serialNumber;
      private String brand;
      private String plate;
      private String color;
      private String material;
      private BigDecimal weight;
      private BigDecimal thickness;
      private String coating;
      private String plating;
      private BigDecimal width;
      private BigDecimal unfoldedWidth;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer bendTimes;
      private Long userId;
      private String userName;
      private Integer producedQuantity;
      private Integer schedulingQuantity;
      private Integer status;

      EnclosureProductDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder monomer(final PlanMonomerDTO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder area(final PlanAreaDTO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("plan")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder plan(final EnclosurePlanDTO plan) {
         this.plan = plan;
         return this;
      }

      @JsonProperty("dictionaryId")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      @JsonProperty("category")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("brand")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("weight")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("width")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      @JsonProperty("length")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("bendTimes")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      @JsonProperty("userId")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("producedQuantity")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("status")
      public EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public EnclosureProductDetailDTO build() {
         return new EnclosureProductDetailDTO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.plan,
            this.dictionaryId,
            this.category,
            this.name,
            this.serialNumber,
            this.brand,
            this.plate,
            this.color,
            this.material,
            this.weight,
            this.thickness,
            this.coating,
            this.plating,
            this.width,
            this.unfoldedWidth,
            this.length,
            this.quantity,
            this.totalLength,
            this.totalArea,
            this.bendTimes,
            this.userId,
            this.userName,
            this.producedQuantity,
            this.schedulingQuantity,
            this.status
         );
      }

      @Override
      public String toString() {
         return "EnclosureProductDetailDTO.EnclosureProductDetailDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", plan="
            + this.plan
            + ", dictionaryId="
            + this.dictionaryId
            + ", category="
            + this.category
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
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", width="
            + this.width
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", bendTimes="
            + this.bendTimes
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", producedQuantity="
            + this.producedQuantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", status="
            + this.status
            + ")";
      }
   }
}
