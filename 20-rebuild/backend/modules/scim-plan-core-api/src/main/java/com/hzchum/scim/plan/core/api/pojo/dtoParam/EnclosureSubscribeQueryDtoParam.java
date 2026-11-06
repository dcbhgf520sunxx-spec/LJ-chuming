package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("围护申购列表-查询类")
public class EnclosureSubscribeQueryDtoParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "请选择项目!")
   private Long projectId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;

   public static EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder builder() {
      return new EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder();
   }

   public EnclosureSubscribeQueryDtoParam() {
   }

   public EnclosureSubscribeQueryDtoParam(
      final Long projectId,
      final Integer category,
      final Long enclosurePlanId,
      final String name,
      final String serialNumber,
      final String brand,
      final String plate
   ) {
      this.projectId = projectId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.brand = brand;
      this.plate = plate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSubscribeQueryDtoParam)) {
         return false;
      }

      EnclosureSubscribeQueryDtoParam other = (EnclosureSubscribeQueryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$enclosurePlanId = this.getEnclosurePlanId();
            Object other$enclosurePlanId = other.getEnclosurePlanId();
            if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
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
                        return this$plate == null ? other$plate == null : this$plate.equals(other$plate);
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
      return other instanceof EnclosureSubscribeQueryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $plate = this.getPlate();
      return result * 59 + ($plate == null ? 43 : $plate.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureSubscribeQueryDtoParam(projectId="
         + this.getProjectId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", brand="
         + this.getBrand()
         + ", plate="
         + this.getPlate()
         + ")";
   }

   public static class EnclosureSubscribeQueryDtoParamBuilder {
      private Long projectId;
      private Integer category;
      private Long enclosurePlanId;
      private String name;
      private String serialNumber;
      private String brand;
      private String plate;

      EnclosureSubscribeQueryDtoParamBuilder() {
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public EnclosureSubscribeQueryDtoParam build() {
         return new EnclosureSubscribeQueryDtoParam(this.projectId, this.category, this.enclosurePlanId, this.name, this.serialNumber, this.brand, this.plate);
      }

      @Override
      public String toString() {
         return "EnclosureSubscribeQueryDtoParam.EnclosureSubscribeQueryDtoParamBuilder(projectId="
            + this.projectId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", brand="
            + this.brand
            + ", plate="
            + this.plate
            + ")";
      }
   }
}
