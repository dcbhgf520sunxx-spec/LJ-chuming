package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EnclosureTaskPrintDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long productId;
   @ApiModelProperty(name = "id", value = "产品id")
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id")
   private Long factoryId;
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   private NameInfo plan;
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
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "taskQuantity", value = "任务数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", value = "总完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "booleanlag", notes = "是否滞后 0:滞后 1: 正常")
   @JsonProperty("booleanlag")
   @JSONField(name = "booleanlag")
   private Integer booleanlag;
   @ApiModelProperty(name = "taskId", value = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印")
   private Boolean boolPrinted;
   @ApiModelProperty("入库数量")
   private Integer warehouseQuantity;

   public static EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder builder() {
      return new EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder();
   }

   public EnclosureTaskPrintDTO(
      final Long productId,
      final Long id,
      final Long factoryId,
      final ProjectInfo project,
      final NameInfo plan,
      final Integer category,
      final String name,
      final String serialNumber,
      final String brand,
      final String plate,
      final String color,
      final String material,
      final BigDecimal thickness,
      final String coating,
      final String plating,
      final BigDecimal length,
      final Integer quantity,
      final Integer taskQuantity,
      final BigDecimal totalLength,
      final Integer completeQuantity,
      final BigDecimal completeLength,
      final Long userId,
      final String userName,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Integer booleanlag,
      final Long taskId,
      final Boolean boolPrinted,
      final Integer warehouseQuantity
   ) {
      this.productId = productId;
      this.id = id;
      this.factoryId = factoryId;
      this.project = project;
      this.plan = plan;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
      this.length = length;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.totalLength = totalLength;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.userId = userId;
      this.userName = userName;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.booleanlag = booleanlag;
      this.taskId = taskId;
      this.boolPrinted = boolPrinted;
      this.warehouseQuantity = warehouseQuantity;
   }

   public EnclosureTaskPrintDTO() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getPlan() {
      return this.plan;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getBooleanlag() {
      return this.booleanlag;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Integer getWarehouseQuantity() {
      return this.warehouseQuantity;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setPlan(final NameInfo plan) {
      this.plan = plan;
   }

   @JsonProperty("category")
   public void setCategory(final Integer category) {
      this.category = category;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("brand")
   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @JsonProperty("plate")
   public void setPlate(final String plate) {
      this.plate = plate;
   }

   @JsonProperty("color")
   public void setColor(final String color) {
      this.color = color;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("coating")
   public void setCoating(final String coating) {
      this.coating = coating;
   }

   @JsonProperty("plating")
   public void setPlating(final String plating) {
      this.plating = plating;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @JsonProperty("completeQuantity")
   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @JsonProperty("completeLength")
   public void setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
   }

   @JsonProperty("userId")
   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @JsonProperty("userName")
   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @JsonProperty("askCompleteTime")
   public void setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
   }

   @JsonProperty("completeTime")
   public void setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
   }

   @JsonProperty("booleanlag")
   public void setBooleanlag(final Integer booleanlag) {
      this.booleanlag = booleanlag;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   public void setWarehouseQuantity(final Integer warehouseQuantity) {
      this.warehouseQuantity = warehouseQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureTaskPrintDTO)) {
         return false;
      }

      EnclosureTaskPrintDTO other = (EnclosureTaskPrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$taskQuantity = this.getTaskQuantity();
                     Object other$taskQuantity = other.getTaskQuantity();
                     if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                        Object this$completeQuantity = this.getCompleteQuantity();
                        Object other$completeQuantity = other.getCompleteQuantity();
                        if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$booleanlag = this.getBooleanlag();
                              Object other$booleanlag = other.getBooleanlag();
                              if (this$booleanlag == null ? other$booleanlag == null : this$booleanlag.equals(other$booleanlag)) {
                                 Object this$taskId = this.getTaskId();
                                 Object other$taskId = other.getTaskId();
                                 if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                    Object this$boolPrinted = this.getBoolPrinted();
                                    Object other$boolPrinted = other.getBoolPrinted();
                                    if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                       Object this$warehouseQuantity = this.getWarehouseQuantity();
                                       Object other$warehouseQuantity = other.getWarehouseQuantity();
                                       if (this$warehouseQuantity == null
                                          ? other$warehouseQuantity == null
                                          : this$warehouseQuantity.equals(other$warehouseQuantity)) {
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
                                                                           Object this$length = this.getLength();
                                                                           Object other$length = other.getLength();
                                                                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                              Object this$totalLength = this.getTotalLength();
                                                                              Object other$totalLength = other.getTotalLength();
                                                                              if (this$totalLength == null
                                                                                 ? other$totalLength == null
                                                                                 : this$totalLength.equals(other$totalLength)) {
                                                                                 Object this$completeLength = this.getCompleteLength();
                                                                                 Object other$completeLength = other.getCompleteLength();
                                                                                 if (this$completeLength == null
                                                                                    ? other$completeLength == null
                                                                                    : this$completeLength.equals(other$completeLength)) {
                                                                                    Object this$userName = this.getUserName();
                                                                                    Object other$userName = other.getUserName();
                                                                                    if (this$userName == null
                                                                                       ? other$userName == null
                                                                                       : this$userName.equals(other$userName)) {
                                                                                       Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                       Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                       if (this$askCompleteTime == null
                                                                                          ? other$askCompleteTime == null
                                                                                          : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                                          Object this$completeTime = this.getCompleteTime();
                                                                                          Object other$completeTime = other.getCompleteTime();
                                                                                          return this$completeTime == null
                                                                                             ? other$completeTime == null
                                                                                             : this$completeTime.equals(other$completeTime);
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
      return other instanceof EnclosureTaskPrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $booleanlag = this.getBooleanlag();
      result = result * 59 + ($booleanlag == null ? 43 : $booleanlag.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $warehouseQuantity = this.getWarehouseQuantity();
      result = result * 59 + ($warehouseQuantity == null ? 43 : $warehouseQuantity.hashCode());
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
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureTaskPrintDTO(productId="
         + this.getProductId()
         + ", id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", project="
         + this.getProject()
         + ", plan="
         + this.getPlan()
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
         + ", thickness="
         + this.getThickness()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", booleanlag="
         + this.getBooleanlag()
         + ", taskId="
         + this.getTaskId()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", warehouseQuantity="
         + this.getWarehouseQuantity()
         + ")";
   }

   public static class EnclosureTaskPrintDTOBuilder {
      private Long productId;
      private Long id;
      private Long factoryId;
      private ProjectInfo project;
      private NameInfo plan;
      private Integer category;
      private String name;
      private String serialNumber;
      private String brand;
      private String plate;
      private String color;
      private String material;
      private BigDecimal thickness;
      private String coating;
      private String plating;
      private BigDecimal length;
      private Integer quantity;
      private Integer taskQuantity;
      private BigDecimal totalLength;
      private Integer completeQuantity;
      private BigDecimal completeLength;
      private Long userId;
      private String userName;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Integer booleanlag;
      private Long taskId;
      private Boolean boolPrinted;
      private Integer warehouseQuantity;

      EnclosureTaskPrintDTOBuilder() {
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder plan(final NameInfo plan) {
         this.plan = plan;
         return this;
      }

      @JsonProperty("category")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("brand")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thickness")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("length")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("totalLength")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("completeQuantity")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("userId")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("booleanlag")
      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder booleanlag(final Integer booleanlag) {
         this.booleanlag = booleanlag;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder warehouseQuantity(final Integer warehouseQuantity) {
         this.warehouseQuantity = warehouseQuantity;
         return this;
      }

      public EnclosureTaskPrintDTO build() {
         return new EnclosureTaskPrintDTO(
            this.productId,
            this.id,
            this.factoryId,
            this.project,
            this.plan,
            this.category,
            this.name,
            this.serialNumber,
            this.brand,
            this.plate,
            this.color,
            this.material,
            this.thickness,
            this.coating,
            this.plating,
            this.length,
            this.quantity,
            this.taskQuantity,
            this.totalLength,
            this.completeQuantity,
            this.completeLength,
            this.userId,
            this.userName,
            this.askCompleteTime,
            this.completeTime,
            this.booleanlag,
            this.taskId,
            this.boolPrinted,
            this.warehouseQuantity
         );
      }

      @Override
      public String toString() {
         return "EnclosureTaskPrintDTO.EnclosureTaskPrintDTOBuilder(productId="
            + this.productId
            + ", id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", project="
            + this.project
            + ", plan="
            + this.plan
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
            + ", thickness="
            + this.thickness
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", totalLength="
            + this.totalLength
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeLength="
            + this.completeLength
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", booleanlag="
            + this.booleanlag
            + ", taskId="
            + this.taskId
            + ", boolPrinted="
            + this.boolPrinted
            + ", warehouseQuantity="
            + this.warehouseQuantity
            + ")";
      }
   }
}
