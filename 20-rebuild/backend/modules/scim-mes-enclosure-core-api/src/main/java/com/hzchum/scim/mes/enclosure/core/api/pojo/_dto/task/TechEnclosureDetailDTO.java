package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureDetailDTO", description = "工单详情返回类 ")
public class TechEnclosureDetailDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "产品Id")
   private Long productId;
   @ApiModelProperty(name = "planId", value = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "planName", value = "区域名")
   @JsonProperty("planName")
   @JSONField(name = "planName")
   private String planName;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @JsonProperty("unfoldedWidth")
   @JSONField(name = "unfoldedWidth")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
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
   @ApiModelProperty(name = "relativePath", value = "文件的相对路径(相对于所有的文件路径映射)")
   @JsonProperty("relativePath")
   @JSONField(name = "relativePath")
   private String relativePath;
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
   @ApiModelProperty(name = "weight", value = "单重量(kg)")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重量（Kg）")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
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
   @ApiModelProperty(name = "askCompleteTimeFormat", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTimeFormat")
   @JSONField(name = "askCompleteTimeFormat")
   private String askCompleteTimeFormat;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "booleanlag", notes = "是否滞后 0:滞后 1: 正常")
   @JsonProperty("booleanlag")
   @JSONField(name = "booleanlag")
   private Integer booleanlag;
   @ApiModelProperty(name = "booleReport", notes = "是否上报 0:未上报 1: 上报")
   @JsonProperty("booleReport")
   @JSONField(name = "booleReport")
   private Integer booleReport;

   public static TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder builder() {
      return new TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder();
   }

   public TechEnclosureDetailDTO() {
   }

   public TechEnclosureDetailDTO(
      final Long id,
      final Long productId,
      final Long planId,
      final String planName,
      final Long areaId,
      final String areaName,
      final Integer category,
      final String name,
      final BigDecimal unfoldedWidth,
      final BigDecimal width,
      final String serialNumber,
      final String brand,
      final String plate,
      final String color,
      final String material,
      final String relativePath,
      final BigDecimal thickness,
      final String coating,
      final String plating,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal totalLength,
      final Integer completeQuantity,
      final BigDecimal completeLength,
      final Long userId,
      final String userName,
      final LocalDateTime askCompleteTime,
      final String askCompleteTimeFormat,
      final LocalDateTime completeTime,
      final Integer booleanlag,
      final Integer booleReport
   ) {
      this.id = id;
      this.productId = productId;
      this.planId = planId;
      this.planName = planName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.category = category;
      this.name = name;
      this.unfoldedWidth = unfoldedWidth;
      this.width = width;
      this.serialNumber = serialNumber;
      this.brand = brand;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.relativePath = relativePath;
      this.thickness = thickness;
      this.coating = coating;
      this.plating = plating;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.length = length;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.userId = userId;
      this.userName = userName;
      this.askCompleteTime = askCompleteTime;
      this.askCompleteTimeFormat = askCompleteTimeFormat;
      this.completeTime = completeTime;
      this.booleanlag = booleanlag;
      this.booleReport = booleReport;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getPlanName() {
      return this.planName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getWidth() {
      return this.width;
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

   public String getRelativePath() {
      return this.relativePath;
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
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

   public String getAskCompleteTimeFormat() {
      return this.askCompleteTimeFormat;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getBooleanlag() {
      return this.booleanlag;
   }

   public Integer getBooleReport() {
      return this.booleReport;
   }

   public TechEnclosureDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosureDetailDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("planId")
   public TechEnclosureDetailDTO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("planName")
   public TechEnclosureDetailDTO setPlanName(final String planName) {
      this.planName = planName;
      return this;
   }

   @JsonProperty("areaId")
   public TechEnclosureDetailDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaName")
   public TechEnclosureDetailDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("category")
   public TechEnclosureDetailDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public TechEnclosureDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("unfoldedWidth")
   public TechEnclosureDetailDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   @JsonProperty("width")
   public TechEnclosureDetailDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechEnclosureDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("brand")
   public TechEnclosureDetailDTO setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("plate")
   public TechEnclosureDetailDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public TechEnclosureDetailDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public TechEnclosureDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("relativePath")
   public TechEnclosureDetailDTO setRelativePath(final String relativePath) {
      this.relativePath = relativePath;
      return this;
   }

   @JsonProperty("thickness")
   public TechEnclosureDetailDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("coating")
   public TechEnclosureDetailDTO setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   @JsonProperty("plating")
   public TechEnclosureDetailDTO setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   @JsonProperty("weight")
   public TechEnclosureDetailDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("totalWeight")
   public TechEnclosureDetailDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("length")
   public TechEnclosureDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public TechEnclosureDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public TechEnclosureDetailDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TechEnclosureDetailDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeLength")
   public TechEnclosureDetailDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("userId")
   public TechEnclosureDetailDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public TechEnclosureDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public TechEnclosureDetailDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("askCompleteTimeFormat")
   public TechEnclosureDetailDTO setAskCompleteTimeFormat(final String askCompleteTimeFormat) {
      this.askCompleteTimeFormat = askCompleteTimeFormat;
      return this;
   }

   @JsonProperty("completeTime")
   public TechEnclosureDetailDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("booleanlag")
   public TechEnclosureDetailDTO setBooleanlag(final Integer booleanlag) {
      this.booleanlag = booleanlag;
      return this;
   }

   @JsonProperty("booleReport")
   public TechEnclosureDetailDTO setBooleReport(final Integer booleReport) {
      this.booleReport = booleReport;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureDetailDTO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", planId="
         + this.getPlanId()
         + ", planName="
         + this.getPlanName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", width="
         + this.getWidth()
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
         + ", relativePath="
         + this.getRelativePath()
         + ", thickness="
         + this.getThickness()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
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
         + ", askCompleteTimeFormat="
         + this.getAskCompleteTimeFormat()
         + ", completeTime="
         + this.getCompleteTime()
         + ", booleanlag="
         + this.getBooleanlag()
         + ", booleReport="
         + this.getBooleReport()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureDetailDTO)) {
         return false;
      }

      TechEnclosureDetailDTO other = (TechEnclosureDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$completeQuantity = this.getCompleteQuantity();
                        Object other$completeQuantity = other.getCompleteQuantity();
                        if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$booleanlag = this.getBooleanlag();
                              Object other$booleanlag = other.getBooleanlag();
                              if (this$booleanlag == null ? other$booleanlag == null : this$booleanlag.equals(other$booleanlag)) {
                                 Object this$booleReport = this.getBooleReport();
                                 Object other$booleReport = other.getBooleReport();
                                 if (this$booleReport == null ? other$booleReport == null : this$booleReport.equals(other$booleReport)) {
                                    Object this$planName = this.getPlanName();
                                    Object other$planName = other.getPlanName();
                                    if (this$planName == null ? other$planName == null : this$planName.equals(other$planName)) {
                                       Object this$areaName = this.getAreaName();
                                       Object other$areaName = other.getAreaName();
                                       if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$unfoldedWidth = this.getUnfoldedWidth();
                                             Object other$unfoldedWidth = other.getUnfoldedWidth();
                                             if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                Object this$width = this.getWidth();
                                                Object other$width = other.getWidth();
                                                if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
                                                                  Object this$relativePath = this.getRelativePath();
                                                                  Object other$relativePath = other.getRelativePath();
                                                                  if (this$relativePath == null
                                                                     ? other$relativePath == null
                                                                     : this$relativePath.equals(other$relativePath)) {
                                                                     Object this$thickness = this.getThickness();
                                                                     Object other$thickness = other.getThickness();
                                                                     if (this$thickness == null
                                                                        ? other$thickness == null
                                                                        : this$thickness.equals(other$thickness)) {
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
                                                                                                   Object this$askCompleteTimeFormat = this.getAskCompleteTimeFormat();
                                                                                                   Object other$askCompleteTimeFormat = other.getAskCompleteTimeFormat();
                                                                                                   if (this$askCompleteTimeFormat == null
                                                                                                      ? other$askCompleteTimeFormat == null
                                                                                                      : this$askCompleteTimeFormat.equals(
                                                                                                         other$askCompleteTimeFormat
                                                                                                      )) {
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
      return other instanceof TechEnclosureDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $booleanlag = this.getBooleanlag();
      result = result * 59 + ($booleanlag == null ? 43 : $booleanlag.hashCode());
      Object $booleReport = this.getBooleReport();
      result = result * 59 + ($booleReport == null ? 43 : $booleReport.hashCode());
      Object $planName = this.getPlanName();
      result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
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
      Object $relativePath = this.getRelativePath();
      result = result * 59 + ($relativePath == null ? 43 : $relativePath.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
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
      Object $askCompleteTimeFormat = this.getAskCompleteTimeFormat();
      result = result * 59 + ($askCompleteTimeFormat == null ? 43 : $askCompleteTimeFormat.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class TechEnclosureDetailDTOBuilder {
      private Long id;
      private Long productId;
      private Long planId;
      private String planName;
      private Long areaId;
      private String areaName;
      private Integer category;
      private String name;
      private BigDecimal unfoldedWidth;
      private BigDecimal width;
      private String serialNumber;
      private String brand;
      private String plate;
      private String color;
      private String material;
      private String relativePath;
      private BigDecimal thickness;
      private String coating;
      private String plating;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal totalLength;
      private Integer completeQuantity;
      private BigDecimal completeLength;
      private Long userId;
      private String userName;
      private LocalDateTime askCompleteTime;
      private String askCompleteTimeFormat;
      private LocalDateTime completeTime;
      private Integer booleanlag;
      private Integer booleReport;

      TechEnclosureDetailDTOBuilder() {
      }

      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("planId")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("planName")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder planName(final String planName) {
         this.planName = planName;
         return this;
      }

      @JsonProperty("areaId")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("category")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("unfoldedWidth")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      @JsonProperty("width")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("brand")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("plate")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("relativePath")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder relativePath(final String relativePath) {
         this.relativePath = relativePath;
         return this;
      }

      @JsonProperty("thickness")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("coating")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      @JsonProperty("plating")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      @JsonProperty("weight")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("totalWeight")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("length")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("userId")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("askCompleteTimeFormat")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder askCompleteTimeFormat(final String askCompleteTimeFormat) {
         this.askCompleteTimeFormat = askCompleteTimeFormat;
         return this;
      }

      @JsonProperty("completeTime")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("booleanlag")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder booleanlag(final Integer booleanlag) {
         this.booleanlag = booleanlag;
         return this;
      }

      @JsonProperty("booleReport")
      public TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder booleReport(final Integer booleReport) {
         this.booleReport = booleReport;
         return this;
      }

      public TechEnclosureDetailDTO build() {
         return new TechEnclosureDetailDTO(
            this.id,
            this.productId,
            this.planId,
            this.planName,
            this.areaId,
            this.areaName,
            this.category,
            this.name,
            this.unfoldedWidth,
            this.width,
            this.serialNumber,
            this.brand,
            this.plate,
            this.color,
            this.material,
            this.relativePath,
            this.thickness,
            this.coating,
            this.plating,
            this.weight,
            this.totalWeight,
            this.length,
            this.quantity,
            this.totalLength,
            this.completeQuantity,
            this.completeLength,
            this.userId,
            this.userName,
            this.askCompleteTime,
            this.askCompleteTimeFormat,
            this.completeTime,
            this.booleanlag,
            this.booleReport
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureDetailDTO.TechEnclosureDetailDTOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", planId="
            + this.planId
            + ", planName="
            + this.planName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", width="
            + this.width
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
            + ", relativePath="
            + this.relativePath
            + ", thickness="
            + this.thickness
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
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
            + ", askCompleteTimeFormat="
            + this.askCompleteTimeFormat
            + ", completeTime="
            + this.completeTime
            + ", booleanlag="
            + this.booleanlag
            + ", booleReport="
            + this.booleReport
            + ")";
      }
   }
}
