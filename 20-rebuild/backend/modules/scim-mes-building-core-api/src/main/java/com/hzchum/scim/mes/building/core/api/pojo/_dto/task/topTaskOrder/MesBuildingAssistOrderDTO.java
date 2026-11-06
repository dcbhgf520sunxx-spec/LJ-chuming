package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingAssistOrderDTO", description = "协同关联工单")
public class MesBuildingAssistOrderDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   private Long taskProcessId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", value = "协同数量", notes = "协同数量")
   private Integer quantity;
   @ApiModelProperty(name = "produceQuantity", value = "完成数量", notes = "完成数量")
   private Integer produceQuantity;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "boolFinishEnum", value = "是否结束", notes = "是否结束")
   private Boolean boolFinishEnum;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   private Long userId;
   @ApiModelProperty(name = "orderNumber", value = "工单编号", notes = "工单编号")
   private String orderNumber;
   @ApiModelProperty(name = "productionLineId", value = "生产线Id", notes = "生产线Id")
   private Long productionLineId;

   public static MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder builder() {
      return new MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder();
   }

   public MesBuildingAssistOrderDTO() {
   }

   public MesBuildingAssistOrderDTO(
      final Long id,
      final Long projectId,
      final Long taskProcessId,
      final Long groupsId,
      final Integer quantity,
      final Integer produceQuantity,
      final Long processId,
      final Boolean boolFinishEnum,
      final Long userId,
      final String orderNumber,
      final Long productionLineId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.taskProcessId = taskProcessId;
      this.groupsId = groupsId;
      this.quantity = quantity;
      this.produceQuantity = produceQuantity;
      this.processId = processId;
      this.boolFinishEnum = boolFinishEnum;
      this.userId = userId;
      this.orderNumber = orderNumber;
      this.productionLineId = productionLineId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProduceQuantity() {
      return this.produceQuantity;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Boolean getBoolFinishEnum() {
      return this.boolFinishEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public MesBuildingAssistOrderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAssistOrderDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingAssistOrderDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingAssistOrderDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   public MesBuildingAssistOrderDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingAssistOrderDTO setProduceQuantity(final Integer produceQuantity) {
      this.produceQuantity = produceQuantity;
      return this;
   }

   public MesBuildingAssistOrderDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingAssistOrderDTO setBoolFinishEnum(final Boolean boolFinishEnum) {
      this.boolFinishEnum = boolFinishEnum;
      return this;
   }

   public MesBuildingAssistOrderDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesBuildingAssistOrderDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesBuildingAssistOrderDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistOrderDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", groupsId="
         + this.getGroupsId()
         + ", quantity="
         + this.getQuantity()
         + ", produceQuantity="
         + this.getProduceQuantity()
         + ", processId="
         + this.getProcessId()
         + ", boolFinishEnum="
         + this.getBoolFinishEnum()
         + ", userId="
         + this.getUserId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", productionLineId="
         + this.getProductionLineId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistOrderDTO)) {
         return false;
      }

      MesBuildingAssistOrderDTO other = (MesBuildingAssistOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$groupsId = this.getGroupsId();
               Object other$groupsId = other.getGroupsId();
               if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$produceQuantity = this.getProduceQuantity();
                     Object other$produceQuantity = other.getProduceQuantity();
                     if (this$produceQuantity == null ? other$produceQuantity == null : this$produceQuantity.equals(other$produceQuantity)) {
                        Object this$processId = this.getProcessId();
                        Object other$processId = other.getProcessId();
                        if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                           Object this$boolFinishEnum = this.getBoolFinishEnum();
                           Object other$boolFinishEnum = other.getBoolFinishEnum();
                           if (this$boolFinishEnum == null ? other$boolFinishEnum == null : this$boolFinishEnum.equals(other$boolFinishEnum)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$productionLineId = this.getProductionLineId();
                                 Object other$productionLineId = other.getProductionLineId();
                                 if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                    Object this$orderNumber = this.getOrderNumber();
                                    Object other$orderNumber = other.getOrderNumber();
                                    return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
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
      return other instanceof MesBuildingAssistOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $produceQuantity = this.getProduceQuantity();
      result = result * 59 + ($produceQuantity == null ? 43 : $produceQuantity.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $boolFinishEnum = this.getBoolFinishEnum();
      result = result * 59 + ($boolFinishEnum == null ? 43 : $boolFinishEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public static class MesBuildingAssistOrderDTOBuilder {
      private Long id;
      private Long projectId;
      private Long taskProcessId;
      private Long groupsId;
      private Integer quantity;
      private Integer produceQuantity;
      private Long processId;
      private Boolean boolFinishEnum;
      private Long userId;
      private String orderNumber;
      private Long productionLineId;

      MesBuildingAssistOrderDTOBuilder() {
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder produceQuantity(final Integer produceQuantity) {
         this.produceQuantity = produceQuantity;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder boolFinishEnum(final Boolean boolFinishEnum) {
         this.boolFinishEnum = boolFinishEnum;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesBuildingAssistOrderDTO build() {
         return new MesBuildingAssistOrderDTO(
            this.id,
            this.projectId,
            this.taskProcessId,
            this.groupsId,
            this.quantity,
            this.produceQuantity,
            this.processId,
            this.boolFinishEnum,
            this.userId,
            this.orderNumber,
            this.productionLineId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistOrderDTO.MesBuildingAssistOrderDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", taskProcessId="
            + this.taskProcessId
            + ", groupsId="
            + this.groupsId
            + ", quantity="
            + this.quantity
            + ", produceQuantity="
            + this.produceQuantity
            + ", processId="
            + this.processId
            + ", boolFinishEnum="
            + this.boolFinishEnum
            + ", userId="
            + this.userId
            + ", orderNumber="
            + this.orderNumber
            + ", productionLineId="
            + this.productionLineId
            + ")";
      }
   }
}
