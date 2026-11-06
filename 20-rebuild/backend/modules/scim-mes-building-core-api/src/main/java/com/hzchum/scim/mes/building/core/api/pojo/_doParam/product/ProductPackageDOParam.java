package com.hzchum.scim.mes.building.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("可打包列表")
public class ProductPackageDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域(计划)id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", notes = "批次id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   private Long areaBatchId;
   @ApiModelProperty(name = "classifyName", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   private String classifyName;
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
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
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
   @ApiModelProperty(name = "minLength", notes = "最小长度")
   @JsonProperty("minLength")
   @JSONField(name = "minLength")
   private Integer minLength;
   @ApiModelProperty(name = "maxLength", notes = "最小长度")
   @JsonProperty("maxLength")
   @JSONField(name = "maxLength")
   private Integer maxLength;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 100;
   @ApiModelProperty("排序")
   private List<String> sort;
   @ApiModelProperty("产品类型集合")
   private List<Integer> productTypeList;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂 AuxiliaryUsePropertyEnum", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty(name = "createUserName", value = "导入人")
   private String createUserName;
   @ApiModelProperty(name = "boolOutsourcing", value = "是否外购")
   private Boolean boolOutsourcing;

   private static Boolean $default$boolOutsourcing() {
      return Boolean.FALSE;
   }

   public static ProductPackageDOParam.ProductPackageDOParamBuilder builder() {
      return new ProductPackageDOParam.ProductPackageDOParamBuilder();
   }

   public ProductPackageDOParam() {
      this.boolOutsourcing = $default$boolOutsourcing();
   }

   public ProductPackageDOParam(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final String classifyName,
      final Long factoryId,
      final Long workshopId,
      final String name,
      final String serialNumber,
      final Integer category,
      final String specification,
      final String material,
      final String color,
      final String plate,
      final Integer minLength,
      final Integer maxLength,
      final Integer pageNumber,
      final Integer pageSize,
      final List<String> sort,
      final List<Integer> productTypeList,
      final Integer useProperty,
      final Integer productType,
      final String createUserName,
      final Boolean boolOutsourcing
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.classifyName = classifyName;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.category = category;
      this.specification = specification;
      this.material = material;
      this.color = color;
      this.plate = plate;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.sort = sort;
      this.productTypeList = productTypeList;
      this.useProperty = useProperty;
      this.productType = productType;
      this.createUserName = createUserName;
      this.boolOutsourcing = boolOutsourcing;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getClassifyName() {
      return this.classifyName;
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

   public String getSpecification() {
      return this.specification;
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

   public Integer getMinLength() {
      return this.minLength;
   }

   public Integer getMaxLength() {
      return this.maxLength;
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

   public List<Integer> getProductTypeList() {
      return this.productTypeList;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Boolean getBoolOutsourcing() {
      return this.boolOutsourcing;
   }

   @JsonProperty("projectId")
   public ProductPackageDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProductPackageDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProductPackageDOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public ProductPackageDOParam setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("classifyName")
   public ProductPackageDOParam setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
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

   @JsonProperty("specification")
   public ProductPackageDOParam setSpecification(final String specification) {
      this.specification = specification;
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

   @JsonProperty("minLength")
   public ProductPackageDOParam setMinLength(final Integer minLength) {
      this.minLength = minLength;
      return this;
   }

   @JsonProperty("maxLength")
   public ProductPackageDOParam setMaxLength(final Integer maxLength) {
      this.maxLength = maxLength;
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

   public ProductPackageDOParam setProductTypeList(final List<Integer> productTypeList) {
      this.productTypeList = productTypeList;
      return this;
   }

   public ProductPackageDOParam setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   public ProductPackageDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProductPackageDOParam setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public ProductPackageDOParam setBoolOutsourcing(final Boolean boolOutsourcing) {
      this.boolOutsourcing = boolOutsourcing;
      return this;
   }

   @Override
   public String toString() {
      return "ProductPackageDOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", classifyName="
         + this.getClassifyName()
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
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", color="
         + this.getColor()
         + ", plate="
         + this.getPlate()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ", productTypeList="
         + this.getProductTypeList()
         + ", useProperty="
         + this.getUseProperty()
         + ", productType="
         + this.getProductType()
         + ", createUserName="
         + this.getCreateUserName()
         + ", boolOutsourcing="
         + this.getBoolOutsourcing()
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
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$minLength = this.getMinLength();
                           Object other$minLength = other.getMinLength();
                           if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                              Object this$maxLength = this.getMaxLength();
                              Object other$maxLength = other.getMaxLength();
                              if (this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength)) {
                                 Object this$pageNumber = this.getPageNumber();
                                 Object other$pageNumber = other.getPageNumber();
                                 if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                                    Object this$pageSize = this.getPageSize();
                                    Object other$pageSize = other.getPageSize();
                                    if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                                       Object this$useProperty = this.getUseProperty();
                                       Object other$useProperty = other.getUseProperty();
                                       if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                          Object this$productType = this.getProductType();
                                          Object other$productType = other.getProductType();
                                          if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                             Object this$boolOutsourcing = this.getBoolOutsourcing();
                                             Object other$boolOutsourcing = other.getBoolOutsourcing();
                                             if (this$boolOutsourcing == null
                                                ? other$boolOutsourcing == null
                                                : this$boolOutsourcing.equals(other$boolOutsourcing)) {
                                                Object this$classifyName = this.getClassifyName();
                                                Object other$classifyName = other.getClassifyName();
                                                if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                   Object this$name = this.getName();
                                                   Object other$name = other.getName();
                                                   if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
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
                                                                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                                                        Object this$productTypeList = this.getProductTypeList();
                                                                        Object other$productTypeList = other.getProductTypeList();
                                                                        if (this$productTypeList == null
                                                                           ? other$productTypeList == null
                                                                           : this$productTypeList.equals(other$productTypeList)) {
                                                                           Object this$createUserName = this.getCreateUserName();
                                                                           Object other$createUserName = other.getCreateUserName();
                                                                           return this$createUserName == null
                                                                              ? other$createUserName == null
                                                                              : this$createUserName.equals(other$createUserName);
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
      return other instanceof ProductPackageDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolOutsourcing = this.getBoolOutsourcing();
      result = result * 59 + ($boolOutsourcing == null ? 43 : $boolOutsourcing.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $productTypeList = this.getProductTypeList();
      result = result * 59 + ($productTypeList == null ? 43 : $productTypeList.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class ProductPackageDOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private String classifyName;
      private Long factoryId;
      private Long workshopId;
      private String name;
      private String serialNumber;
      private Integer category;
      private String specification;
      private String material;
      private String color;
      private String plate;
      private Integer minLength;
      private Integer maxLength;
      private Integer pageNumber;
      private Integer pageSize;
      private List<String> sort;
      private List<Integer> productTypeList;
      private Integer useProperty;
      private Integer productType;
      private String createUserName;
      private boolean boolOutsourcing$set;
      private Boolean boolOutsourcing$value;

      ProductPackageDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public ProductPackageDOParam.ProductPackageDOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("classifyName")
      public ProductPackageDOParam.ProductPackageDOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
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

      @JsonProperty("specification")
      public ProductPackageDOParam.ProductPackageDOParamBuilder specification(final String specification) {
         this.specification = specification;
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

      @JsonProperty("minLength")
      public ProductPackageDOParam.ProductPackageDOParamBuilder minLength(final Integer minLength) {
         this.minLength = minLength;
         return this;
      }

      @JsonProperty("maxLength")
      public ProductPackageDOParam.ProductPackageDOParamBuilder maxLength(final Integer maxLength) {
         this.maxLength = maxLength;
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

      public ProductPackageDOParam.ProductPackageDOParamBuilder productTypeList(final List<Integer> productTypeList) {
         this.productTypeList = productTypeList;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ProductPackageDOParam.ProductPackageDOParamBuilder boolOutsourcing(final Boolean boolOutsourcing) {
         this.boolOutsourcing$value = boolOutsourcing;
         this.boolOutsourcing$set = true;
         return this;
      }

      public ProductPackageDOParam build() {
         Boolean boolOutsourcing$value = this.boolOutsourcing$value;
         if (!this.boolOutsourcing$set) {
            boolOutsourcing$value = ProductPackageDOParam.$default$boolOutsourcing();
         }

         return new ProductPackageDOParam(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.classifyName,
            this.factoryId,
            this.workshopId,
            this.name,
            this.serialNumber,
            this.category,
            this.specification,
            this.material,
            this.color,
            this.plate,
            this.minLength,
            this.maxLength,
            this.pageNumber,
            this.pageSize,
            this.sort,
            this.productTypeList,
            this.useProperty,
            this.productType,
            this.createUserName,
            boolOutsourcing$value
         );
      }

      @Override
      public String toString() {
         return "ProductPackageDOParam.ProductPackageDOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", classifyName="
            + this.classifyName
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
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", color="
            + this.color
            + ", plate="
            + this.plate
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", sort="
            + this.sort
            + ", productTypeList="
            + this.productTypeList
            + ", useProperty="
            + this.useProperty
            + ", productType="
            + this.productType
            + ", createUserName="
            + this.createUserName
            + ", boolOutsourcing$value="
            + this.boolOutsourcing$value
            + ")";
      }
   }
}
