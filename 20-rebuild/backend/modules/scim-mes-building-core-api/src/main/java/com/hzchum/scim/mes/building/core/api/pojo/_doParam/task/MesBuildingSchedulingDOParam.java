package com.hzchum.scim.mes.building.core.api.pojo._doParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingSchedulingDOParam对象", description = "")
public class MesBuildingSchedulingDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
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
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "taskQuantity", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
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
   @ApiModelProperty(name = "productProcessId", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;

   public static MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder builder() {
      return new MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder();
   }

   public MesBuildingSchedulingDOParam() {
   }

   public MesBuildingSchedulingDOParam(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long productId,
      final Integer productType,
      final Integer schedulingQuantity,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final Long productProcessId
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productId = productId;
      this.productType = productType;
      this.schedulingQuantity = schedulingQuantity;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.issueStatus = issueStatus;
      this.userId = userId;
      this.productProcessId = productProcessId;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
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

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   @JsonProperty("id")
   public MesBuildingSchedulingDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingSchedulingDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingSchedulingDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingSchedulingDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingSchedulingDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingSchedulingDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingSchedulingDOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingSchedulingDOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingSchedulingDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingSchedulingDOParam setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingSchedulingDOParam setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingSchedulingDOParam setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingSchedulingDOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingSchedulingDOParam setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingSchedulingDOParam setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public MesBuildingSchedulingDOParam setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingSchedulingDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingSchedulingDOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSchedulingDOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", status="
         + this.getStatus()
         + ", issueStatus="
         + this.getIssueStatus()
         + ", userId="
         + this.getUserId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSchedulingDOParam)) {
         return false;
      }

      MesBuildingSchedulingDOParam other = (MesBuildingSchedulingDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$schedulingQuantity = this.getSchedulingQuantity();
                                 Object other$schedulingQuantity = other.getSchedulingQuantity();
                                 if (this$schedulingQuantity == null
                                    ? other$schedulingQuantity == null
                                    : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                                    Object this$taskQuantity = this.getTaskQuantity();
                                    Object other$taskQuantity = other.getTaskQuantity();
                                    if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                       Object this$completeQuantity = this.getCompleteQuantity();
                                       Object other$completeQuantity = other.getCompleteQuantity();
                                       if (this$completeQuantity == null
                                          ? other$completeQuantity == null
                                          : this$completeQuantity.equals(other$completeQuantity)) {
                                          Object this$status = this.getStatus();
                                          Object other$status = other.getStatus();
                                          if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                             Object this$issueStatus = this.getIssueStatus();
                                             Object other$issueStatus = other.getIssueStatus();
                                             if (this$issueStatus == null ? other$issueStatus == null : this$issueStatus.equals(other$issueStatus)) {
                                                Object this$userId = this.getUserId();
                                                Object other$userId = other.getUserId();
                                                if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                   Object this$productProcessId = this.getProductProcessId();
                                                   Object other$productProcessId = other.getProductProcessId();
                                                   if (this$productProcessId == null
                                                      ? other$productProcessId == null
                                                      : this$productProcessId.equals(other$productProcessId)) {
                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                      if (this$askCompleteTime == null
                                                         ? other$askCompleteTime == null
                                                         : this$askCompleteTime.equals(other$askCompleteTime)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSchedulingDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $issueStatus = this.getIssueStatus();
      result = result * 59 + ($issueStatus == null ? 43 : $issueStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesBuildingSchedulingDOParamBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long productId;
      private Integer productType;
      private Integer schedulingQuantity;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Boolean issueStatus;
      private Long userId;
      private Long productProcessId;

      MesBuildingSchedulingDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      public MesBuildingSchedulingDOParam build() {
         return new MesBuildingSchedulingDOParam(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productId,
            this.productType,
            this.schedulingQuantity,
            this.taskQuantity,
            this.completeQuantity,
            this.askCompleteTime,
            this.completeTime,
            this.status,
            this.issueStatus,
            this.userId,
            this.productProcessId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSchedulingDOParam.MesBuildingSchedulingDOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", status="
            + this.status
            + ", issueStatus="
            + this.issueStatus
            + ", userId="
            + this.userId
            + ", productProcessId="
            + this.productProcessId
            + ")";
      }
   }
}
