package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "FromVORequest", description = "项目报表请求类")
public class FormDTOParam {
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
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "产品类型")
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
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "startDate", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;

   public static FormDTOParam.FormDTOParamBuilder builder() {
      return new FormDTOParam.FormDTOParamBuilder();
   }

   public FormDTOParam() {
   }

   public FormDTOParam(
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Integer productType,
      final Integer category,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final String plate,
      final String color,
      final LocalDateTime startDate,
      final LocalDateTime endDate
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.productType = productType;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.plate = plate;
      this.color = color;
      this.startDate = startDate;
      this.endDate = endDate;
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

   public Integer getProductType() {
      return this.productType;
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

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   @JsonProperty("projectId")
   public FormDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public FormDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public FormDTOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("productType")
   public FormDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public FormDTOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public FormDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public FormDTOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public FormDTOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public FormDTOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("plate")
   public FormDTOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public FormDTOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("startDate")
   public FormDTOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public FormDTOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @Override
   public String toString() {
      return "FormDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormDTOParam)) {
         return false;
      }

      FormDTOParam other = (FormDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$plate = this.getPlate();
                                 Object other$plate = other.getPlate();
                                 if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                    Object this$color = this.getColor();
                                    Object other$color = other.getColor();
                                    if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                       Object this$startDate = this.getStartDate();
                                       Object other$startDate = other.getStartDate();
                                       if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                          Object this$endDate = this.getEndDate();
                                          Object other$endDate = other.getEndDate();
                                          return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof FormDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   public static class FormDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Integer productType;
      private Integer category;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private String plate;
      private String color;
      private LocalDateTime startDate;
      private LocalDateTime endDate;

      FormDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public FormDTOParam.FormDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public FormDTOParam.FormDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public FormDTOParam.FormDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("productType")
      public FormDTOParam.FormDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public FormDTOParam.FormDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public FormDTOParam.FormDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public FormDTOParam.FormDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public FormDTOParam.FormDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public FormDTOParam.FormDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("plate")
      public FormDTOParam.FormDTOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public FormDTOParam.FormDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("startDate")
      public FormDTOParam.FormDTOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public FormDTOParam.FormDTOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public FormDTOParam build() {
         return new FormDTOParam(
            this.projectId,
            this.monomerId,
            this.planId,
            this.productType,
            this.category,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.plate,
            this.color,
            this.startDate,
            this.endDate
         );
      }

      @Override
      public String toString() {
         return "FormDTOParam.FormDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ")";
      }
   }
}
