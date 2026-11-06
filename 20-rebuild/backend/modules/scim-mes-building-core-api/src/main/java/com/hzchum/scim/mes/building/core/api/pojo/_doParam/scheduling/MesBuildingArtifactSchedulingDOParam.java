package com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingArtifactSchedulingDOParam", description = "构件排产信息")
public class MesBuildingArtifactSchedulingDOParam {
   @ApiModelProperty(name = "areaIdList", value = "区域id")
   @JsonProperty("areaIdList")
   @JSONField(name = "areaIdList")
   @NotNull(message = "区域id不能为空")
   private List<Long> areaIdList;
   @ApiModelProperty(name = "structureClassIds", value = "构件种类id")
   @JsonProperty("structureClassIds")
   @JSONField(name = "structureClassIds")
   @NotNull(message = "构件种类id不能为空")
   private List<Long> structureClassIds;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "artNames", value = "构件名称")
   @JsonProperty("artNames")
   @JSONField(name = "artNames")
   private List<String> artNames;
   @ApiModelProperty(name = "artName", notes = "用户构件名称类型筛选")
   @JsonProperty("artName")
   @JSONField(name = "artName")
   private String artName;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "taskQuantity", value = "已下发数量", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "status", value = "状态 [0 暂停, 1 正常]", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Boolean status;
   @ApiModelProperty(name = "issueStatus", value = "下发状态 [0 未下发 1 已下发]", notes = "下发状态 [0 未下发 1 已下发]")
   @JsonProperty("issueStatus")
   @JSONField(name = "issueStatus")
   private Boolean issueStatus;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "构件规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "构件材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "name", notes = "构件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   private Integer mesProductEnum;
   @ApiModelProperty(name = "maxAskCompleteTime", value = "最大要求完成日期）")
   @JsonProperty("maxAskCompleteTime")
   @JSONField(name = "maxAskCompleteTime")
   private LocalDateTime maxAskCompleteTime;
   @ApiModelProperty(name = "minAskCompleteTime", value = "最小要求完成日期）")
   @JsonProperty("minAskCompleteTime")
   @JSONField(name = "minAskCompleteTime")
   private LocalDateTime minAskCompleteTime;

   public static MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder builder() {
      return new MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder();
   }

   public MesBuildingArtifactSchedulingDOParam(
      final List<Long> areaIdList,
      final List<Long> structureClassIds,
      final Long structureClassId,
      final List<String> artNames,
      final String artName,
      final Integer productionLineTypeEnum,
      final Long id,
      final Long productId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer quantity,
      final Integer taskQuantity,
      final LocalDateTime askCompleteTime,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final String serialNumber,
      final String specification,
      final String material,
      final String name,
      final Integer mesProductEnum,
      final LocalDateTime maxAskCompleteTime,
      final LocalDateTime minAskCompleteTime
   ) {
      this.areaIdList = areaIdList;
      this.structureClassIds = structureClassIds;
      this.structureClassId = structureClassId;
      this.artNames = artNames;
      this.artName = artName;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.id = id;
      this.productId = productId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.askCompleteTime = askCompleteTime;
      this.status = status;
      this.issueStatus = issueStatus;
      this.userId = userId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.name = name;
      this.mesProductEnum = mesProductEnum;
      this.maxAskCompleteTime = maxAskCompleteTime;
      this.minAskCompleteTime = minAskCompleteTime;
   }

   public MesBuildingArtifactSchedulingDOParam() {
   }

   public List<Long> getAreaIdList() {
      return this.areaIdList;
   }

   public List<Long> getStructureClassIds() {
      return this.structureClassIds;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public List<String> getArtNames() {
      return this.artNames;
   }

   public String getArtName() {
      return this.artName;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
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

   public Long getGroupsId() {
      return this.groupsId;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public LocalDateTime getMaxAskCompleteTime() {
      return this.maxAskCompleteTime;
   }

   public LocalDateTime getMinAskCompleteTime() {
      return this.minAskCompleteTime;
   }

   @JsonProperty("areaIdList")
   public MesBuildingArtifactSchedulingDOParam setAreaIdList(final List<Long> areaIdList) {
      this.areaIdList = areaIdList;
      return this;
   }

   @JsonProperty("structureClassIds")
   public MesBuildingArtifactSchedulingDOParam setStructureClassIds(final List<Long> structureClassIds) {
      this.structureClassIds = structureClassIds;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesBuildingArtifactSchedulingDOParam setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("artNames")
   public MesBuildingArtifactSchedulingDOParam setArtNames(final List<String> artNames) {
      this.artNames = artNames;
      return this;
   }

   @JsonProperty("artName")
   public MesBuildingArtifactSchedulingDOParam setArtName(final String artName) {
      this.artName = artName;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingArtifactSchedulingDOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("id")
   public MesBuildingArtifactSchedulingDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingArtifactSchedulingDOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingArtifactSchedulingDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingArtifactSchedulingDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingArtifactSchedulingDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingArtifactSchedulingDOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingArtifactSchedulingDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingArtifactSchedulingDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingArtifactSchedulingDOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactSchedulingDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingArtifactSchedulingDOParam setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingArtifactSchedulingDOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingArtifactSchedulingDOParam setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public MesBuildingArtifactSchedulingDOParam setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingArtifactSchedulingDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingArtifactSchedulingDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingArtifactSchedulingDOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingArtifactSchedulingDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingArtifactSchedulingDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingArtifactSchedulingDOParam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @JsonProperty("maxAskCompleteTime")
   public MesBuildingArtifactSchedulingDOParam setMaxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
      this.maxAskCompleteTime = maxAskCompleteTime;
      return this;
   }

   @JsonProperty("minAskCompleteTime")
   public MesBuildingArtifactSchedulingDOParam setMinAskCompleteTime(final LocalDateTime minAskCompleteTime) {
      this.minAskCompleteTime = minAskCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingDOParam(areaIdList="
         + this.getAreaIdList()
         + ", structureClassIds="
         + this.getStructureClassIds()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", artNames="
         + this.getArtNames()
         + ", artName="
         + this.getArtName()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", status="
         + this.getStatus()
         + ", issueStatus="
         + this.getIssueStatus()
         + ", userId="
         + this.getUserId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", name="
         + this.getName()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", maxAskCompleteTime="
         + this.getMaxAskCompleteTime()
         + ", minAskCompleteTime="
         + this.getMinAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingDOParam)) {
         return false;
      }

      MesBuildingArtifactSchedulingDOParam other = (MesBuildingArtifactSchedulingDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureClassId = this.getStructureClassId();
      Object other$structureClassId = other.getStructureClassId();
      if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$productionLineId = this.getProductionLineId();
                        Object other$productionLineId = other.getProductionLineId();
                        if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                           Object this$groupsId = this.getGroupsId();
                           Object other$groupsId = other.getGroupsId();
                           if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                              Object this$projectId = this.getProjectId();
                              Object other$projectId = other.getProjectId();
                              if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                 Object this$monomerId = this.getMonomerId();
                                 Object other$monomerId = other.getMonomerId();
                                 if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                    Object this$areaId = this.getAreaId();
                                    Object other$areaId = other.getAreaId();
                                    if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$taskQuantity = this.getTaskQuantity();
                                          Object other$taskQuantity = other.getTaskQuantity();
                                          if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                             Object this$status = this.getStatus();
                                             Object other$status = other.getStatus();
                                             if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                Object this$issueStatus = this.getIssueStatus();
                                                Object other$issueStatus = other.getIssueStatus();
                                                if (this$issueStatus == null ? other$issueStatus == null : this$issueStatus.equals(other$issueStatus)) {
                                                   Object this$userId = this.getUserId();
                                                   Object other$userId = other.getUserId();
                                                   if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                      Object this$mesProductEnum = this.getMesProductEnum();
                                                      Object other$mesProductEnum = other.getMesProductEnum();
                                                      if (this$mesProductEnum == null
                                                         ? other$mesProductEnum == null
                                                         : this$mesProductEnum.equals(other$mesProductEnum)) {
                                                         Object this$areaIdList = this.getAreaIdList();
                                                         Object other$areaIdList = other.getAreaIdList();
                                                         if (this$areaIdList == null ? other$areaIdList == null : this$areaIdList.equals(other$areaIdList)) {
                                                            Object this$structureClassIds = this.getStructureClassIds();
                                                            Object other$structureClassIds = other.getStructureClassIds();
                                                            if (this$structureClassIds == null
                                                               ? other$structureClassIds == null
                                                               : this$structureClassIds.equals(other$structureClassIds)) {
                                                               Object this$artNames = this.getArtNames();
                                                               Object other$artNames = other.getArtNames();
                                                               if (this$artNames == null ? other$artNames == null : this$artNames.equals(other$artNames)) {
                                                                  Object this$artName = this.getArtName();
                                                                  Object other$artName = other.getArtName();
                                                                  if (this$artName == null ? other$artName == null : this$artName.equals(other$artName)) {
                                                                     Object this$askCompleteTime = this.getAskCompleteTime();
                                                                     Object other$askCompleteTime = other.getAskCompleteTime();
                                                                     if (this$askCompleteTime == null
                                                                        ? other$askCompleteTime == null
                                                                        : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                        Object this$serialNumber = this.getSerialNumber();
                                                                        Object other$serialNumber = other.getSerialNumber();
                                                                        if (this$serialNumber == null
                                                                           ? other$serialNumber == null
                                                                           : this$serialNumber.equals(other$serialNumber)) {
                                                                           Object this$specification = this.getSpecification();
                                                                           Object other$specification = other.getSpecification();
                                                                           if (this$specification == null
                                                                              ? other$specification == null
                                                                              : this$specification.equals(other$specification)) {
                                                                              Object this$material = this.getMaterial();
                                                                              Object other$material = other.getMaterial();
                                                                              if (this$material == null
                                                                                 ? other$material == null
                                                                                 : this$material.equals(other$material)) {
                                                                                 Object this$name = this.getName();
                                                                                 Object other$name = other.getName();
                                                                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                                    Object this$maxAskCompleteTime = this.getMaxAskCompleteTime();
                                                                                    Object other$maxAskCompleteTime = other.getMaxAskCompleteTime();
                                                                                    if (this$maxAskCompleteTime == null
                                                                                       ? other$maxAskCompleteTime == null
                                                                                       : this$maxAskCompleteTime.equals(other$maxAskCompleteTime)) {
                                                                                       Object this$minAskCompleteTime = this.getMinAskCompleteTime();
                                                                                       Object other$minAskCompleteTime = other.getMinAskCompleteTime();
                                                                                       return this$minAskCompleteTime == null
                                                                                          ? other$minAskCompleteTime == null
                                                                                          : this$minAskCompleteTime.equals(other$minAskCompleteTime);
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
      return other instanceof MesBuildingArtifactSchedulingDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $issueStatus = this.getIssueStatus();
      result = result * 59 + ($issueStatus == null ? 43 : $issueStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $areaIdList = this.getAreaIdList();
      result = result * 59 + ($areaIdList == null ? 43 : $areaIdList.hashCode());
      Object $structureClassIds = this.getStructureClassIds();
      result = result * 59 + ($structureClassIds == null ? 43 : $structureClassIds.hashCode());
      Object $artNames = this.getArtNames();
      result = result * 59 + ($artNames == null ? 43 : $artNames.hashCode());
      Object $artName = this.getArtName();
      result = result * 59 + ($artName == null ? 43 : $artName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $maxAskCompleteTime = this.getMaxAskCompleteTime();
      result = result * 59 + ($maxAskCompleteTime == null ? 43 : $maxAskCompleteTime.hashCode());
      Object $minAskCompleteTime = this.getMinAskCompleteTime();
      return result * 59 + ($minAskCompleteTime == null ? 43 : $minAskCompleteTime.hashCode());
   }

   public static class MesBuildingArtifactSchedulingDOParamBuilder {
      private List<Long> areaIdList;
      private List<Long> structureClassIds;
      private Long structureClassId;
      private List<String> artNames;
      private String artName;
      private Integer productionLineTypeEnum;
      private Long id;
      private Long productId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer quantity;
      private Integer taskQuantity;
      private LocalDateTime askCompleteTime;
      private Boolean status;
      private Boolean issueStatus;
      private Long userId;
      private String serialNumber;
      private String specification;
      private String material;
      private String name;
      private Integer mesProductEnum;
      private LocalDateTime maxAskCompleteTime;
      private LocalDateTime minAskCompleteTime;

      MesBuildingArtifactSchedulingDOParamBuilder() {
      }

      @JsonProperty("areaIdList")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder areaIdList(final List<Long> areaIdList) {
         this.areaIdList = areaIdList;
         return this;
      }

      @JsonProperty("structureClassIds")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder structureClassIds(final List<Long> structureClassIds) {
         this.structureClassIds = structureClassIds;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("artNames")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder artNames(final List<String> artNames) {
         this.artNames = artNames;
         return this;
      }

      @JsonProperty("artName")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder artName(final String artName) {
         this.artName = artName;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("id")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      @JsonProperty("maxAskCompleteTime")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder maxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
         this.maxAskCompleteTime = maxAskCompleteTime;
         return this;
      }

      @JsonProperty("minAskCompleteTime")
      public MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder minAskCompleteTime(final LocalDateTime minAskCompleteTime) {
         this.minAskCompleteTime = minAskCompleteTime;
         return this;
      }

      public MesBuildingArtifactSchedulingDOParam build() {
         return new MesBuildingArtifactSchedulingDOParam(
            this.areaIdList,
            this.structureClassIds,
            this.structureClassId,
            this.artNames,
            this.artName,
            this.productionLineTypeEnum,
            this.id,
            this.productId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.quantity,
            this.taskQuantity,
            this.askCompleteTime,
            this.status,
            this.issueStatus,
            this.userId,
            this.serialNumber,
            this.specification,
            this.material,
            this.name,
            this.mesProductEnum,
            this.maxAskCompleteTime,
            this.minAskCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingDOParam.MesBuildingArtifactSchedulingDOParamBuilder(areaIdList="
            + this.areaIdList
            + ", structureClassIds="
            + this.structureClassIds
            + ", structureClassId="
            + this.structureClassId
            + ", artNames="
            + this.artNames
            + ", artName="
            + this.artName
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", id="
            + this.id
            + ", productId="
            + this.productId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", status="
            + this.status
            + ", issueStatus="
            + this.issueStatus
            + ", userId="
            + this.userId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", name="
            + this.name
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", maxAskCompleteTime="
            + this.maxAskCompleteTime
            + ", minAskCompleteTime="
            + this.minAskCompleteTime
            + ")";
      }
   }
}
