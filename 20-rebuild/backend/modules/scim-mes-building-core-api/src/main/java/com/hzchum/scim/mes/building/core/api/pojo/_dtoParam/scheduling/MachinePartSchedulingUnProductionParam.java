package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MachinePartSchedulingUnProductionParam", description = "")
public class MachinePartSchedulingUnProductionParam extends BaseEntity<Long> {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
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
   @ApiModelProperty(name = "artifactTaskId", value = "需要排产关联表id", notes = "需要排产关联表id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;
   @ApiModelProperty(name = "taskOrderId", value = "区域id", notes = "区域id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
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
   @ApiModelProperty(name = "needId")
   @JsonProperty("needId")
   @JSONField(name = "needId")
   private Long needId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "取消生产数量", notes = "取消生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "useId", value = "用户id", notes = "用户id")
   @JsonProperty("useId")
   @JSONField(name = "useId")
   private Long useId;

   public static MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder builder() {
      return new MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder();
   }

   public MachinePartSchedulingUnProductionParam() {
   }

   public MachinePartSchedulingUnProductionParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long artifactTaskId,
      final Long taskOrderId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long needId,
      final Long productId,
      final Integer quantity,
      final Long useId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.artifactTaskId = artifactTaskId;
      this.taskOrderId = taskOrderId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.needId = needId;
      this.productId = productId;
      this.quantity = quantity;
      this.useId = useId;
   }

   public Long getId() {
      return this.id;
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

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
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

   public Long getNeedId() {
      return this.needId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUseId() {
      return this.useId;
   }

   @JsonProperty("id")
   public MachinePartSchedulingUnProductionParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MachinePartSchedulingUnProductionParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartSchedulingUnProductionParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MachinePartSchedulingUnProductionParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("artifactTaskId")
   public MachinePartSchedulingUnProductionParam setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MachinePartSchedulingUnProductionParam setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("workshopId")
   public MachinePartSchedulingUnProductionParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MachinePartSchedulingUnProductionParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MachinePartSchedulingUnProductionParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("needId")
   public MachinePartSchedulingUnProductionParam setNeedId(final Long needId) {
      this.needId = needId;
      return this;
   }

   @JsonProperty("productId")
   public MachinePartSchedulingUnProductionParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartSchedulingUnProductionParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("useId")
   public MachinePartSchedulingUnProductionParam setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSchedulingUnProductionParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", needId="
         + this.getNeedId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", useId="
         + this.getUseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartSchedulingUnProductionParam)) {
         return false;
      }

      MachinePartSchedulingUnProductionParam other = (MachinePartSchedulingUnProductionParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$artifactTaskId = this.getArtifactTaskId();
                  Object other$artifactTaskId = other.getArtifactTaskId();
                  if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
                     Object this$taskOrderId = this.getTaskOrderId();
                     Object other$taskOrderId = other.getTaskOrderId();
                     if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$groupsId = this.getGroupsId();
                              Object other$groupsId = other.getGroupsId();
                              if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                 Object this$needId = this.getNeedId();
                                 Object other$needId = other.getNeedId();
                                 if (this$needId == null ? other$needId == null : this$needId.equals(other$needId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$useId = this.getUseId();
                                          Object other$useId = other.getUseId();
                                          return this$useId == null ? other$useId == null : this$useId.equals(other$useId);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartSchedulingUnProductionParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $needId = this.getNeedId();
      result = result * 59 + ($needId == null ? 43 : $needId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $useId = this.getUseId();
      return result * 59 + ($useId == null ? 43 : $useId.hashCode());
   }

   public static class MachinePartSchedulingUnProductionParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long artifactTaskId;
      private Long taskOrderId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long needId;
      private Long productId;
      private Integer quantity;
      private Long useId;

      MachinePartSchedulingUnProductionParamBuilder() {
      }

      @JsonProperty("id")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("artifactTaskId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("workshopId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("needId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder needId(final Long needId) {
         this.needId = needId;
         return this;
      }

      @JsonProperty("productId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("useId")
      public MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      public MachinePartSchedulingUnProductionParam build() {
         return new MachinePartSchedulingUnProductionParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.artifactTaskId,
            this.taskOrderId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.needId,
            this.productId,
            this.quantity,
            this.useId
         );
      }

      @Override
      public String toString() {
         return "MachinePartSchedulingUnProductionParam.MachinePartSchedulingUnProductionParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", artifactTaskId="
            + this.artifactTaskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", needId="
            + this.needId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", useId="
            + this.useId
            + ")";
      }
   }
}
