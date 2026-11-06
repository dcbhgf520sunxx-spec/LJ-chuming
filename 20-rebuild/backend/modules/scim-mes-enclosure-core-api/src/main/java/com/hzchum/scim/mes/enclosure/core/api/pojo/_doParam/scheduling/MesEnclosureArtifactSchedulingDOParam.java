package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureArtifactSchedulingDOParam", description = "构件排产信息")
public class MesEnclosureArtifactSchedulingDOParam {
   @ApiModelProperty(name = "planIdList", value = "区域id")
   @JsonProperty("planIdList")
   @JSONField(name = "planIdList")
   @NotNull(message = "区域id不能为空")
   private List<Long> planIdList;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   @NotNull(message = "构件种类id不能为空")
   private Long structureClassId;
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
   @ApiModelProperty(name = "planId", value = "区域id", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
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

   public static MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder builder() {
      return new MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder();
   }

   public MesEnclosureArtifactSchedulingDOParam(
      final List<Long> planIdList,
      final Long structureClassId,
      final Integer productionLineTypeEnum,
      final Long id,
      final Long productId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Integer quantity,
      final Integer taskQuantity,
      final LocalDateTime askCompleteTime,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final String serialNumber,
      final String specification,
      final String material,
      final String name
   ) {
      this.planIdList = planIdList;
      this.structureClassId = structureClassId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.id = id;
      this.productId = productId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
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
   }

   public MesEnclosureArtifactSchedulingDOParam() {
   }

   public List<Long> getPlanIdList() {
      return this.planIdList;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
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

   public Long getPlanId() {
      return this.planId;
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

   @JsonProperty("planIdList")
   public MesEnclosureArtifactSchedulingDOParam setPlanIdList(final List<Long> planIdList) {
      this.planIdList = planIdList;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesEnclosureArtifactSchedulingDOParam setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesEnclosureArtifactSchedulingDOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("id")
   public MesEnclosureArtifactSchedulingDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureArtifactSchedulingDOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureArtifactSchedulingDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureArtifactSchedulingDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureArtifactSchedulingDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureArtifactSchedulingDOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureArtifactSchedulingDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureArtifactSchedulingDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureArtifactSchedulingDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureArtifactSchedulingDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesEnclosureArtifactSchedulingDOParam setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureArtifactSchedulingDOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureArtifactSchedulingDOParam setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public MesEnclosureArtifactSchedulingDOParam setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureArtifactSchedulingDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureArtifactSchedulingDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureArtifactSchedulingDOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureArtifactSchedulingDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureArtifactSchedulingDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingDOParam(planIdList="
         + this.getPlanIdList()
         + ", structureClassId="
         + this.getStructureClassId()
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
         + ", planId="
         + this.getPlanId()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactSchedulingDOParam)) {
         return false;
      }

      MesEnclosureArtifactSchedulingDOParam other = (MesEnclosureArtifactSchedulingDOParam)o;
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
                                    Object this$planId = this.getPlanId();
                                    Object other$planId = other.getPlanId();
                                    if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
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
                                                      Object this$planIdList = this.getPlanIdList();
                                                      Object other$planIdList = other.getPlanIdList();
                                                      if (this$planIdList == null ? other$planIdList == null : this$planIdList.equals(other$planIdList)) {
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
                                                                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                     Object this$name = this.getName();
                                                                     Object other$name = other.getName();
                                                                     return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesEnclosureArtifactSchedulingDOParam;
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
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
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
      Object $planIdList = this.getPlanIdList();
      result = result * 59 + ($planIdList == null ? 43 : $planIdList.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesEnclosureArtifactSchedulingDOParamBuilder {
      private List<Long> planIdList;
      private Long structureClassId;
      private Integer productionLineTypeEnum;
      private Long id;
      private Long productId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long projectId;
      private Long monomerId;
      private Long planId;
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

      MesEnclosureArtifactSchedulingDOParamBuilder() {
      }

      @JsonProperty("planIdList")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder planIdList(final List<Long> planIdList) {
         this.planIdList = planIdList;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("id")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesEnclosureArtifactSchedulingDOParam build() {
         return new MesEnclosureArtifactSchedulingDOParam(
            this.planIdList,
            this.structureClassId,
            this.productionLineTypeEnum,
            this.id,
            this.productId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.projectId,
            this.monomerId,
            this.planId,
            this.quantity,
            this.taskQuantity,
            this.askCompleteTime,
            this.status,
            this.issueStatus,
            this.userId,
            this.serialNumber,
            this.specification,
            this.material,
            this.name
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingDOParam.MesEnclosureArtifactSchedulingDOParamBuilder(planIdList="
            + this.planIdList
            + ", structureClassId="
            + this.structureClassId
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
            + ", planId="
            + this.planId
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
            + ")";
      }
   }
}
