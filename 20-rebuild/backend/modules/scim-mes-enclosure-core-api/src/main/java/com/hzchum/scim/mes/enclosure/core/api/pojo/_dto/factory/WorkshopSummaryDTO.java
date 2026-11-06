package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "WorkshopSummaryDTO", description = "车间报表清单")
public class WorkshopSummaryDTO {
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "completeTime", value = "时间", notes = "时间")
   private LocalDateTime completeTime;
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
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   @JsonProperty("bendTimes")
   @JSONField(name = "bendTimes")
   private Integer bendTimes;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
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

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
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

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public Integer getQuantity() {
      return this.quantity;
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

   @JsonProperty("project")
   public WorkshopSummaryDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   public WorkshopSummaryDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("category")
   public WorkshopSummaryDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public WorkshopSummaryDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public WorkshopSummaryDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("brand")
   public WorkshopSummaryDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public WorkshopSummaryDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public WorkshopSummaryDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public WorkshopSummaryDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public WorkshopSummaryDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public WorkshopSummaryDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public WorkshopSummaryDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public WorkshopSummaryDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("width")
   public WorkshopSummaryDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public WorkshopSummaryDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @JsonProperty("length")
   public WorkshopSummaryDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("totalLength")
   public WorkshopSummaryDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("bendTimes")
   public WorkshopSummaryDTO setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
      return this;
   }

   @JsonProperty("quantity")
   public WorkshopSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public WorkshopSummaryDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public WorkshopSummaryDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("status")
   public WorkshopSummaryDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopSummaryDTO(project="
         + this.getProject()
         + ", completeTime="
         + this.getCompleteTime()
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
         + ", totalLength="
         + this.getTotalLength()
         + ", bendTimes="
         + this.getBendTimes()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopSummaryDTO)) {
         return false;
      }

      WorkshopSummaryDTO other = (WorkshopSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$bendTimes = this.getBendTimes();
         Object other$bendTimes = other.getBendTimes();
         if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                           Object this$completeTime = this.getCompleteTime();
                           Object other$completeTime = other.getCompleteTime();
                           if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
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
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
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
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$totalLength = this.getTotalLength();
                                                                     Object other$totalLength = other.getTotalLength();
                                                                     return this$totalLength == null
                                                                        ? other$totalLength == null
                                                                        : this$totalLength.equals(other$totalLength);
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
      return other instanceof WorkshopSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
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
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }
}
