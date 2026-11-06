package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("MesEnclosureProduceInspectionTeamDO")
public class MesEnclosureProduceInspectionTeamReportDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "schedulingId", value = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamId", value = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "inspectionTeamId", value = "质检班组id")
   @JsonProperty("inspectionTeamId")
   @JSONField(name = "inspectionTeamId")
   private Long inspectionTeamId;
   @ApiModelProperty(name = "userId", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder builder() {
      return new MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder();
   }

   public MesEnclosureProduceInspectionTeamReportDO() {
   }

   public MesEnclosureProduceInspectionTeamReportDO(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer productType,
      final Integer inspectionQuantity,
      final Long teamId,
      final Long inspectionTeamId,
      final Long userId
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.productType = productType;
      this.inspectionQuantity = inspectionQuantity;
      this.teamId = teamId;
      this.inspectionTeamId = inspectionTeamId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getInspectionTeamId() {
      return this.inspectionTeamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesEnclosureProduceInspectionTeamReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureProduceInspectionTeamReportDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesEnclosureProduceInspectionTeamReportDO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureProduceInspectionTeamReportDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureProduceInspectionTeamReportDO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureProduceInspectionTeamReportDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureProduceInspectionTeamReportDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesEnclosureProduceInspectionTeamReportDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureProduceInspectionTeamReportDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("inspectionTeamId")
   public MesEnclosureProduceInspectionTeamReportDO setInspectionTeamId(final Long inspectionTeamId) {
      this.inspectionTeamId = inspectionTeamId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProduceInspectionTeamReportDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceInspectionTeamReportDO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", inspectionTeamId="
         + this.getInspectionTeamId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceInspectionTeamReportDO)) {
         return false;
      }

      MesEnclosureProduceInspectionTeamReportDO other = (MesEnclosureProduceInspectionTeamReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$schedulingId = this.getSchedulingId();
                  Object other$schedulingId = other.getSchedulingId();
                  if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$inspectionQuantity = this.getInspectionQuantity();
                           Object other$inspectionQuantity = other.getInspectionQuantity();
                           if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$inspectionTeamId = this.getInspectionTeamId();
                                 Object other$inspectionTeamId = other.getInspectionTeamId();
                                 if (this$inspectionTeamId == null ? other$inspectionTeamId == null : this$inspectionTeamId.equals(other$inspectionTeamId)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof MesEnclosureProduceInspectionTeamReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $inspectionTeamId = this.getInspectionTeamId();
      result = result * 59 + ($inspectionTeamId == null ? 43 : $inspectionTeamId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesEnclosureProduceInspectionTeamReportDOBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer productType;
      private Integer inspectionQuantity;
      private Long teamId;
      private Long inspectionTeamId;
      private Long userId;

      MesEnclosureProduceInspectionTeamReportDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("inspectionTeamId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder inspectionTeamId(final Long inspectionTeamId) {
         this.inspectionTeamId = inspectionTeamId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesEnclosureProduceInspectionTeamReportDO build() {
         return new MesEnclosureProduceInspectionTeamReportDO(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.productType,
            this.inspectionQuantity,
            this.teamId,
            this.inspectionTeamId,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProduceInspectionTeamReportDO.MesEnclosureProduceInspectionTeamReportDOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamId="
            + this.teamId
            + ", inspectionTeamId="
            + this.inspectionTeamId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
