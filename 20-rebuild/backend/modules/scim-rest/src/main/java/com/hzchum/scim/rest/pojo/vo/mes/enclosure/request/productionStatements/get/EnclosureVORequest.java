package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.productionStatements.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "artifactVORequest", description = "查询 ")
public class EnclosureVORequest {
   @ApiModelProperty(name = "projectId", notes = "项目id", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "name", notes = "名称", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "plate", notes = "版型", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件  0楼承板", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件  0楼承板")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "startDate", notes = "开始时间", value = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "material", notes = "开始时间", value = "开始时间")
   @JsonProperty("material")
   @JSONField(name = "material")
   private LocalDateTime endDate;

   public static EnclosureVORequest.EnclosureVORequestBuilder builder() {
      return new EnclosureVORequest.EnclosureVORequestBuilder();
   }

   public EnclosureVORequest() {
   }

   public EnclosureVORequest(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final String name,
      final String serialNumber,
      final String specification,
      final String plate,
      final Integer category,
      final LocalDateTime startDate,
      final LocalDateTime endDate
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.plate = plate;
      this.category = category;
      this.startDate = startDate;
      this.endDate = endDate;
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

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
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

   public String getPlate() {
      return this.plate;
   }

   public Integer getCategory() {
      return this.category;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   @JsonProperty("projectId")
   public EnclosureVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public EnclosureVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public EnclosureVORequest setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("factoryId")
   public EnclosureVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public EnclosureVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public EnclosureVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("name")
   public EnclosureVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public EnclosureVORequest setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public EnclosureVORequest setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("plate")
   public EnclosureVORequest setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("category")
   public EnclosureVORequest setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("startDate")
   public EnclosureVORequest setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("material")
   public EnclosureVORequest setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureVORequest(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", plate="
         + this.getPlate()
         + ", category="
         + this.getCategory()
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

      if (!(o instanceof EnclosureVORequest)) {
         return false;
      }

      EnclosureVORequest other = (EnclosureVORequest)o;
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
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
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
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
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
      return other instanceof EnclosureVORequest;
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
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   public static class EnclosureVORequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private String name;
      private String serialNumber;
      private String specification;
      private String plate;
      private Integer category;
      private LocalDateTime startDate;
      private LocalDateTime endDate;

      EnclosureVORequestBuilder() {
      }

      @JsonProperty("projectId")
      public EnclosureVORequest.EnclosureVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public EnclosureVORequest.EnclosureVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public EnclosureVORequest.EnclosureVORequestBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("factoryId")
      public EnclosureVORequest.EnclosureVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public EnclosureVORequest.EnclosureVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public EnclosureVORequest.EnclosureVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("name")
      public EnclosureVORequest.EnclosureVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureVORequest.EnclosureVORequestBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public EnclosureVORequest.EnclosureVORequestBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("plate")
      public EnclosureVORequest.EnclosureVORequestBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("category")
      public EnclosureVORequest.EnclosureVORequestBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("startDate")
      public EnclosureVORequest.EnclosureVORequestBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("material")
      public EnclosureVORequest.EnclosureVORequestBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public EnclosureVORequest build() {
         return new EnclosureVORequest(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.name,
            this.serialNumber,
            this.specification,
            this.plate,
            this.category,
            this.startDate,
            this.endDate
         );
      }

      @Override
      public String toString() {
         return "EnclosureVORequest.EnclosureVORequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", plate="
            + this.plate
            + ", category="
            + this.category
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ")";
      }
   }
}
