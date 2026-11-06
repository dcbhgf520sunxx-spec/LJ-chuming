package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureProduceTeamDO", description = "质检记录表 ")
public class MesEnclosureProduceTeamReportDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "quantity", value = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "teamId", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "reportType", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Boolean reportType;

   public static MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder builder() {
      return new MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder();
   }

   public MesEnclosureProduceTeamReportDO() {
   }

   public MesEnclosureProduceTeamReportDO(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer productType,
      final Integer quantity,
      final Long teamId,
      final Long userId,
      final Boolean reportType
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.teamId = teamId;
      this.userId = userId;
      this.reportType = reportType;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getReportType() {
      return this.reportType;
   }

   @JsonProperty("id")
   public MesEnclosureProduceTeamReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureProduceTeamReportDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesEnclosureProduceTeamReportDO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureProduceTeamReportDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureProduceTeamReportDO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureProduceTeamReportDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureProduceTeamReportDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureProduceTeamReportDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureProduceTeamReportDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProduceTeamReportDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("reportType")
   public MesEnclosureProduceTeamReportDO setReportType(final Boolean reportType) {
      this.reportType = reportType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceTeamReportDO(id="
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
         + ", quantity="
         + this.getQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", reportType="
         + this.getReportType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceTeamReportDO)) {
         return false;
      }

      MesEnclosureProduceTeamReportDO other = (MesEnclosureProduceTeamReportDO)o;
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
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$reportType = this.getReportType();
                                    Object other$reportType = other.getReportType();
                                    return this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType);
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
      return other instanceof MesEnclosureProduceTeamReportDO;
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $reportType = this.getReportType();
      return result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
   }

   public static class MesEnclosureProduceTeamReportDOBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer productType;
      private Integer quantity;
      private Long teamId;
      private Long userId;
      private Boolean reportType;

      MesEnclosureProduceTeamReportDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("reportType")
      public MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder reportType(final Boolean reportType) {
         this.reportType = reportType;
         return this;
      }

      public MesEnclosureProduceTeamReportDO build() {
         return new MesEnclosureProduceTeamReportDO(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.productType,
            this.quantity,
            this.teamId,
            this.userId,
            this.reportType
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProduceTeamReportDO.MesEnclosureProduceTeamReportDOBuilder(id="
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
            + ", quantity="
            + this.quantity
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", reportType="
            + this.reportType
            + ")";
      }
   }
}
