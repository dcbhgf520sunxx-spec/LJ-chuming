package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("围护可打包列表DO")
public class ProductPackageDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "areaId", notes = "围护计划id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 100;
   @ApiModelProperty("排序")
   private List<String> sort;

   public static ProductPackageDOParam.ProductPackageDOParamBuilder builder() {
      return new ProductPackageDOParam.ProductPackageDOParamBuilder();
   }

   public ProductPackageDOParam() {
   }

   public ProductPackageDOParam(
      final Long projectId,
      final Long areaId,
      final Long factoryId,
      final Long workshopId,
      final String name,
      final String serialNumber,
      final Integer category,
      final String material,
      final String color,
      final String plate,
      final Integer pageNumber,
      final Integer pageSize,
      final List<String> sort
   ) {
      this.projectId = projectId;
      this.areaId = areaId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.category = category;
      this.material = material;
      this.color = color;
      this.plate = plate;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.sort = sort;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getColor() {
      return this.color;
   }

   public String getPlate() {
      return this.plate;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   @JsonProperty("projectId")
   public ProductPackageDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("areaId")
   public ProductPackageDOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("factoryId")
   public ProductPackageDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public ProductPackageDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("name")
   public ProductPackageDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductPackageDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProductPackageDOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("material")
   public ProductPackageDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("color")
   public ProductPackageDOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("plate")
   public ProductPackageDOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public ProductPackageDOParam setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
   }

   public ProductPackageDOParam setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
      return this;
   }

   public ProductPackageDOParam setSort(final List<String> sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "ProductPackageDOParam(projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", category="
         + this.getCategory()
         + ", material="
         + this.getMaterial()
         + ", color="
         + this.getColor()
         + ", plate="
         + this.getPlate()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductPackageDOParam)) {
         return false;
      }

      ProductPackageDOParam other = (ProductPackageDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$pageNumber = this.getPageNumber();
                     Object other$pageNumber = other.getPageNumber();
                     if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                        Object this$pageSize = this.getPageSize();
                        Object other$pageSize = other.getPageSize();
                        if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$color = this.getColor();
                                    Object other$color = other.getColor();
                                    if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                       Object this$plate = this.getPlate();
                                       Object other$plate = other.getPlate();
                                       if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                          Object this$sort = this.getSort();
                                          Object other$sort = other.getSort();
                                          return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
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
      return other instanceof ProductPackageDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   public static class ProductPackageDOParamBuilder {
      private Long projectId;
      private Long areaId;
      private Long factoryId;
      private Long workshopId;
      private String name;
      private String serialNumber;
      private Integer category;
      private String material;
      private String color;
      private String plate;
      private Integer pageNumber;
      private Integer pageSize;
      private List<String> sort;

      ProductPackageDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("areaId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("factoryId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("name")
      public ProductPackageDOParam.ProductPackageDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductPackageDOParam.ProductPackageDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("material")
      public ProductPackageDOParam.ProductPackageDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("color")
      public ProductPackageDOParam.ProductPackageDOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("plate")
      public ProductPackageDOParam.ProductPackageDOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder sort(final List<String> sort) {
         this.sort = sort;
         return this;
      }

      public ProductPackageDOParam build() {
         return new ProductPackageDOParam(
            this.projectId,
            this.areaId,
            this.factoryId,
            this.workshopId,
            this.name,
            this.serialNumber,
            this.category,
            this.material,
            this.color,
            this.plate,
            this.pageNumber,
            this.pageSize,
            this.sort
         );
      }

      @Override
      public String toString() {
         return "ProductPackageDOParam.ProductPackageDOParamBuilder(projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", category="
            + this.category
            + ", material="
            + this.material
            + ", color="
            + this.color
            + ", plate="
            + this.plate
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
