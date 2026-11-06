package com.hzchum.scim.mes.building.core.api.pojo._doParam.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "SchedulingDetailListDOParam", description = "")
public class SchedulingDetailListDOParam {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "projectIds", notes = "项目ids")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   private List<Long> projectIds;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "status", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Boolean status;
   @ApiModelProperty(name = "issueStatus", notes = "状态 [0 未下发, 1 已下发]")
   @JsonProperty("issueStatus")
   @JSONField(name = "issueStatus")
   private Boolean issueStatus;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
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
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "date", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private LocalDateTime date;
   @ApiModelProperty(name = "startDate", notes = "开始日期")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", notes = "结束日期")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;

   public static SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder builder() {
      return new SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder();
   }

   public SchedulingDetailListDOParam() {
   }

   public SchedulingDetailListDOParam(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final List<Long> projectIds,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final String plate,
      final String color,
      final Integer category,
      final LocalDateTime date,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Boolean boolAbnormalEnum
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectIds = projectIds;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.status = status;
      this.issueStatus = issueStatus;
      this.userId = userId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.plate = plate;
      this.color = color;
      this.category = category;
      this.date = date;
      this.startDate = startDate;
      this.endDate = endDate;
      this.boolAbnormalEnum = boolAbnormalEnum;
   }

   public Long getId() {
      return this.id;
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

   public List<Long> getProjectIds() {
      return this.projectIds;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Boolean getIssueStatus() {
      return this.issueStatus;
   }

   public Long getUserId() {
      return this.userId;
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

   public Integer getCategory() {
      return this.category;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   @JsonProperty("id")
   public SchedulingDetailListDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public SchedulingDetailListDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public SchedulingDetailListDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public SchedulingDetailListDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectIds")
   public SchedulingDetailListDOParam setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("projectId")
   public SchedulingDetailListDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public SchedulingDetailListDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public SchedulingDetailListDOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productType")
   public SchedulingDetailListDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("status")
   public SchedulingDetailListDOParam setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public SchedulingDetailListDOParam setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public SchedulingDetailListDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("name")
   public SchedulingDetailListDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public SchedulingDetailListDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public SchedulingDetailListDOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public SchedulingDetailListDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("plate")
   public SchedulingDetailListDOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public SchedulingDetailListDOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("category")
   public SchedulingDetailListDOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("date")
   public SchedulingDetailListDOParam setDate(final LocalDateTime date) {
      this.date = date;
      return this;
   }

   @JsonProperty("startDate")
   public SchedulingDetailListDOParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public SchedulingDetailListDOParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public SchedulingDetailListDOParam setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingDetailListDOParam)) {
         return false;
      }

      SchedulingDetailListDOParam other = (SchedulingDetailListDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$productType = this.getProductType();
                           Object other$productType = other.getProductType();
                           if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$issueStatus = this.getIssueStatus();
                                 Object other$issueStatus = other.getIssueStatus();
                                 if (this$issueStatus == null ? other$issueStatus == null : this$issueStatus.equals(other$issueStatus)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$category = this.getCategory();
                                       Object other$category = other.getCategory();
                                       if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                          Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                          Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                          if (this$boolAbnormalEnum == null
                                             ? other$boolAbnormalEnum == null
                                             : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                             Object this$projectIds = this.getProjectIds();
                                             Object other$projectIds = other.getProjectIds();
                                             if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                      Object this$specification = this.getSpecification();
                                                      Object other$specification = other.getSpecification();
                                                      if (this$specification == null
                                                         ? other$specification == null
                                                         : this$specification.equals(other$specification)) {
                                                         Object this$material = this.getMaterial();
                                                         Object other$material = other.getMaterial();
                                                         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                            Object this$plate = this.getPlate();
                                                            Object other$plate = other.getPlate();
                                                            if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                               Object this$color = this.getColor();
                                                               Object other$color = other.getColor();
                                                               if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                  Object this$date = this.getDate();
                                                                  Object other$date = other.getDate();
                                                                  if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                                                     Object this$startDate = this.getStartDate();
                                                                     Object other$startDate = other.getStartDate();
                                                                     if (this$startDate == null
                                                                        ? other$startDate == null
                                                                        : this$startDate.equals(other$startDate)) {
                                                                        Object this$endDate = this.getEndDate();
                                                                        Object other$endDate = other.getEndDate();
                                                                        return this$endDate == null
                                                                           ? other$endDate == null
                                                                           : this$endDate.equals(other$endDate);
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
      return other instanceof SchedulingDetailListDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $issueStatus = this.getIssueStatus();
      result = result * 59 + ($issueStatus == null ? 43 : $issueStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
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
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "SchedulingDetailListDOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", status="
         + this.getStatus()
         + ", issueStatus="
         + this.getIssueStatus()
         + ", userId="
         + this.getUserId()
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
         + ", category="
         + this.getCategory()
         + ", date="
         + this.getDate()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ")";
   }

   public static class SchedulingDetailListDOParamBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private List<Long> projectIds;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Boolean status;
      private Boolean issueStatus;
      private Long userId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private String plate;
      private String color;
      private Integer category;
      private LocalDateTime date;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Boolean boolAbnormalEnum;

      SchedulingDetailListDOParamBuilder() {
      }

      @JsonProperty("id")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectIds")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("projectId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productType")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("status")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("name")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("plate")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("category")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("date")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      @JsonProperty("startDate")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public SchedulingDetailListDOParam build() {
         return new SchedulingDetailListDOParam(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.projectIds,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productType,
            this.status,
            this.issueStatus,
            this.userId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.plate,
            this.color,
            this.category,
            this.date,
            this.startDate,
            this.endDate,
            this.boolAbnormalEnum
         );
      }

      @Override
      public String toString() {
         return "SchedulingDetailListDOParam.SchedulingDetailListDOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectIds="
            + this.projectIds
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", status="
            + this.status
            + ", issueStatus="
            + this.issueStatus
            + ", userId="
            + this.userId
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
            + ", category="
            + this.category
            + ", date="
            + this.date
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ")";
      }
   }
}
