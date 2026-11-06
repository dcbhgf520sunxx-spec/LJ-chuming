package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingAssistProjectDTO", description = "任务工单工序生产信息")
public class MesBuildingAssistProjectDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
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

   public static MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder builder() {
      return new MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder();
   }

   public MesBuildingAssistProjectDTO() {
   }

   public MesBuildingAssistProjectDTO(
      final Long id,
      final ProjectDetailDO project,
      final Long taskProcessId,
      final Long groupsId,
      final Integer quantity,
      final Integer produceQuantity,
      final Long processId,
      final Boolean boolFinishEnum,
      final Long userId
   ) {
      this.id = id;
      this.project = project;
      this.taskProcessId = taskProcessId;
      this.groupsId = groupsId;
      this.quantity = quantity;
      this.produceQuantity = produceQuantity;
      this.processId = processId;
      this.boolFinishEnum = boolFinishEnum;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectDetailDO getProject() {
      return this.project;
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

   public MesBuildingAssistProjectDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingAssistProjectDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   public MesBuildingAssistProjectDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingAssistProjectDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   public MesBuildingAssistProjectDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingAssistProjectDTO setProduceQuantity(final Integer produceQuantity) {
      this.produceQuantity = produceQuantity;
      return this;
   }

   public MesBuildingAssistProjectDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingAssistProjectDTO setBoolFinishEnum(final Boolean boolFinishEnum) {
      this.boolFinishEnum = boolFinishEnum;
      return this;
   }

   public MesBuildingAssistProjectDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistProjectDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistProjectDTO)) {
         return false;
      }

      MesBuildingAssistProjectDTO other = (MesBuildingAssistProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof MesBuildingAssistProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   public static class MesBuildingAssistProjectDTOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private Long taskProcessId;
      private Long groupsId;
      private Integer quantity;
      private Integer produceQuantity;
      private Long processId;
      private Boolean boolFinishEnum;
      private Long userId;

      MesBuildingAssistProjectDTOBuilder() {
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder produceQuantity(final Integer produceQuantity) {
         this.produceQuantity = produceQuantity;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder boolFinishEnum(final Boolean boolFinishEnum) {
         this.boolFinishEnum = boolFinishEnum;
         return this;
      }

      public MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAssistProjectDTO build() {
         return new MesBuildingAssistProjectDTO(
            this.id, this.project, this.taskProcessId, this.groupsId, this.quantity, this.produceQuantity, this.processId, this.boolFinishEnum, this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistProjectDTO.MesBuildingAssistProjectDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
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
            + ")";
      }
   }
}
