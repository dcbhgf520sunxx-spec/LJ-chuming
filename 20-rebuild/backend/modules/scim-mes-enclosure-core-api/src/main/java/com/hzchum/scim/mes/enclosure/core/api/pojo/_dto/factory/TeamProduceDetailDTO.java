package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "TeamProduceDetailDTO", description = "产线下班组生产详细信息返回类")
public class TeamProduceDetailDTO {
   @ApiModelProperty(name = "project", notes = "项目", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "plan", notes = "区域")
   @JsonProperty("plan")
   @JSONField(name = "plan")
   private AreaDetailDO plan;
   @ApiModelProperty(name = "productId", value = "产品id")
   private Long productId;
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
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "listQuantity", value = "清单数量")
   @JsonProperty("listQuantity")
   @JSONField(name = "listQuantity")
   private Integer listQuantity;
   @ApiModelProperty(name = "listTotalLength", value = "清单长度（m）")
   @JsonProperty("listTotalLength")
   @JSONField(name = "listTotalLength")
   private BigDecimal listTotalLength;
   @ApiModelProperty(name = "reportQuantity", value = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "reportTotalLength", value = "上报长度（m）")
   @JsonProperty("reportTotalLength")
   @JSONField(name = "reportTotalLength")
   private BigDecimal reportTotalLength;
   @ApiModelProperty(name = "reportTime", value = "上报时间")
   @JsonProperty("reportTime")
   @JSONField(name = "reportTime")
   private LocalDateTime reportTime;
   @ApiModelProperty(name = "taskOrderId", value = "工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Integer taskOrderId;
   @ApiModelProperty(name = "orderNumber", value = "工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private Integer orderNumber;
   @ApiModelProperty(name = "price", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static TeamProduceDetailDTO.TeamProduceDetailDTOBuilder builder() {
      return new TeamProduceDetailDTO.TeamProduceDetailDTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public AreaDetailDO getPlan() {
      return this.plan;
   }

   public Long getProductId() {
      return this.productId;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getListQuantity() {
      return this.listQuantity;
   }

   public BigDecimal getListTotalLength() {
      return this.listTotalLength;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportTotalLength() {
      return this.reportTotalLength;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Integer getTaskOrderId() {
      return this.taskOrderId;
   }

   public Integer getOrderNumber() {
      return this.orderNumber;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("project")
   public TeamProduceDetailDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("plan")
   public TeamProduceDetailDTO setPlan(final AreaDetailDO plan) {
      this.plan = plan;
      return this;
   }

   public TeamProduceDetailDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("category")
   public TeamProduceDetailDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public TeamProduceDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamProduceDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("brand")
   public TeamProduceDetailDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public TeamProduceDetailDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public TeamProduceDetailDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public TeamProduceDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public TeamProduceDetailDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public TeamProduceDetailDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public TeamProduceDetailDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public TeamProduceDetailDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("length")
   public TeamProduceDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("listQuantity")
   public TeamProduceDetailDTO setListQuantity(final Integer listQuantity) {
      this.listQuantity = listQuantity;
      return this;
   }

   @JsonProperty("listTotalLength")
   public TeamProduceDetailDTO setListTotalLength(final BigDecimal listTotalLength) {
      this.listTotalLength = listTotalLength;
      return this;
   }

   @JsonProperty("reportQuantity")
   public TeamProduceDetailDTO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportTotalLength")
   public TeamProduceDetailDTO setReportTotalLength(final BigDecimal reportTotalLength) {
      this.reportTotalLength = reportTotalLength;
      return this;
   }

   @JsonProperty("reportTime")
   public TeamProduceDetailDTO setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   @JsonProperty("taskOrderId")
   public TeamProduceDetailDTO setTaskOrderId(final Integer taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public TeamProduceDetailDTO setOrderNumber(final Integer orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("price")
   public TeamProduceDetailDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProduceDetailDTO)) {
         return false;
      }

      TeamProduceDetailDTO other = (TeamProduceDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$listQuantity = this.getListQuantity();
            Object other$listQuantity = other.getListQuantity();
            if (this$listQuantity == null ? other$listQuantity == null : this$listQuantity.equals(other$listQuantity)) {
               Object this$reportQuantity = this.getReportQuantity();
               Object other$reportQuantity = other.getReportQuantity();
               if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                  Object this$taskOrderId = this.getTaskOrderId();
                  Object other$taskOrderId = other.getTaskOrderId();
                  if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                     Object this$orderNumber = this.getOrderNumber();
                     Object other$orderNumber = other.getOrderNumber();
                     if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                      Object this$coating = this.getCoating();
                                                      Object other$coating = other.getCoating();
                                                      if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                         Object this$plating = this.getPlating();
                                                         Object other$plating = other.getPlating();
                                                         if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$listTotalLength = this.getListTotalLength();
                                                               Object other$listTotalLength = other.getListTotalLength();
                                                               if (this$listTotalLength == null
                                                                  ? other$listTotalLength == null
                                                                  : this$listTotalLength.equals(other$listTotalLength)) {
                                                                  Object this$reportTotalLength = this.getReportTotalLength();
                                                                  Object other$reportTotalLength = other.getReportTotalLength();
                                                                  if (this$reportTotalLength == null
                                                                     ? other$reportTotalLength == null
                                                                     : this$reportTotalLength.equals(other$reportTotalLength)) {
                                                                     Object this$reportTime = this.getReportTime();
                                                                     Object other$reportTime = other.getReportTime();
                                                                     if (this$reportTime == null
                                                                        ? other$reportTime == null
                                                                        : this$reportTime.equals(other$reportTime)) {
                                                                        Object this$price = this.getPrice();
                                                                        Object other$price = other.getPrice();
                                                                        return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof TeamProduceDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $listQuantity = this.getListQuantity();
      result = result * 59 + ($listQuantity == null ? 43 : $listQuantity.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
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
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $listTotalLength = this.getListTotalLength();
      result = result * 59 + ($listTotalLength == null ? 43 : $listTotalLength.hashCode());
      Object $reportTotalLength = this.getReportTotalLength();
      result = result * 59 + ($reportTotalLength == null ? 43 : $reportTotalLength.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "TeamProduceDetailDTO(project="
         + this.getProject()
         + ", plan="
         + this.getPlan()
         + ", productId="
         + this.getProductId()
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
         + ", length="
         + this.getLength()
         + ", listQuantity="
         + this.getListQuantity()
         + ", listTotalLength="
         + this.getListTotalLength()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportTotalLength="
         + this.getReportTotalLength()
         + ", reportTime="
         + this.getReportTime()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", price="
         + this.getPrice()
         + ")";
   }

   public TeamProduceDetailDTO(
      final ProjectInfo project,
      final AreaDetailDO plan,
      final Long productId,
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
      final BigDecimal length,
      final Integer listQuantity,
      final BigDecimal listTotalLength,
      final Integer reportQuantity,
      final BigDecimal reportTotalLength,
      final LocalDateTime reportTime,
      final Integer taskOrderId,
      final Integer orderNumber,
      final BigDecimal price
   ) {
      this.project = project;
      this.plan = plan;
      this.productId = productId;
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
      this.length = length;
      this.listQuantity = listQuantity;
      this.listTotalLength = listTotalLength;
      this.reportQuantity = reportQuantity;
      this.reportTotalLength = reportTotalLength;
      this.reportTime = reportTime;
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.price = price;
   }

   public TeamProduceDetailDTO() {
   }

   public static class TeamProduceDetailDTOBuilder {
      private ProjectInfo project;
      private AreaDetailDO plan;
      private Long productId;
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
      private BigDecimal length;
      private Integer listQuantity;
      private BigDecimal listTotalLength;
      private Integer reportQuantity;
      private BigDecimal reportTotalLength;
      private LocalDateTime reportTime;
      private Integer taskOrderId;
      private Integer orderNumber;
      private BigDecimal price;

      TeamProduceDetailDTOBuilder() {
      }

      @JsonProperty("project")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("plan")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder plan(final AreaDetailDO plan) {
         this.plan = plan;
         return this;
      }

      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("category")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("brand")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("weight")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("length")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("listQuantity")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder listQuantity(final Integer listQuantity) {
         this.listQuantity = listQuantity;
         return this;
      }

      @JsonProperty("listTotalLength")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder listTotalLength(final BigDecimal listTotalLength) {
         this.listTotalLength = listTotalLength;
         return this;
      }

      @JsonProperty("reportQuantity")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportTotalLength")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder reportTotalLength(final BigDecimal reportTotalLength) {
         this.reportTotalLength = reportTotalLength;
         return this;
      }

      @JsonProperty("reportTime")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      @JsonProperty("taskOrderId")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder taskOrderId(final Integer taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder orderNumber(final Integer orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("price")
      public TeamProduceDetailDTO.TeamProduceDetailDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public TeamProduceDetailDTO build() {
         return new TeamProduceDetailDTO(
            this.project,
            this.plan,
            this.productId,
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
            this.length,
            this.listQuantity,
            this.listTotalLength,
            this.reportQuantity,
            this.reportTotalLength,
            this.reportTime,
            this.taskOrderId,
            this.orderNumber,
            this.price
         );
      }

      @Override
      public String toString() {
         return "TeamProduceDetailDTO.TeamProduceDetailDTOBuilder(project="
            + this.project
            + ", plan="
            + this.plan
            + ", productId="
            + this.productId
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
            + ", length="
            + this.length
            + ", listQuantity="
            + this.listQuantity
            + ", listTotalLength="
            + this.listTotalLength
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportTotalLength="
            + this.reportTotalLength
            + ", reportTime="
            + this.reportTime
            + ", taskOrderId="
            + this.taskOrderId
            + ", orderNumber="
            + this.orderNumber
            + ", price="
            + this.price
            + ")";
      }
   }
}
