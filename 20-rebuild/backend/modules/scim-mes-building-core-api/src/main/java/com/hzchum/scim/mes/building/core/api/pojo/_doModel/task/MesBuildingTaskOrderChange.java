package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingTaskOrderChange对象", description = "")
@Entity
@TableName("mes_building_task_order_change")
@Table(name = "mes_building_task_order_change")
public class MesBuildingTaskOrderChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "topTaskOrderId", value = "最顶级任务工单id", notes = "最顶级任务工单id")
   @JsonProperty("topTaskOrderId")
   @JSONField(name = "topTaskOrderId")
   @TableField("top_task_order_id")
   @Column(name = "top_task_order_id", columnDefinition = "bigint(20)  COMMENT '最顶级任务工单id'", nullable = true)
   private Long topTaskOrderId;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default '1' COMMENT '生产线类型 1传统线 2智能线'", nullable = true)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "oldTaskOrderId", value = "原任务工单id", notes = "原任务工单id")
   @JsonProperty("oldTaskOrderId")
   @JSONField(name = "oldTaskOrderId")
   @TableField("old_task_order_id")
   @Column(name = "old_task_order_id", columnDefinition = "bigint(20)  COMMENT '原任务工单id'", nullable = false)
   private Long oldTaskOrderId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;

   public static MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder builder() {
      return new MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder();
   }

   public MesBuildingTaskOrderChange() {
   }

   public MesBuildingTaskOrderChange(
      final Long id,
      final Integer taskTypeEnum,
      final Long userId,
      final Long topTaskOrderId,
      final Integer productionLineTypeEnum,
      final Long oldTaskOrderId,
      final Long groupsId
   ) {
      this.id = id;
      this.taskTypeEnum = taskTypeEnum;
      this.userId = userId;
      this.topTaskOrderId = topTaskOrderId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.oldTaskOrderId = oldTaskOrderId;
      this.groupsId = groupsId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getTopTaskOrderId() {
      return this.topTaskOrderId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getOldTaskOrderId() {
      return this.oldTaskOrderId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   @JsonProperty("id")
   public MesBuildingTaskOrderChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskOrderChange setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTaskOrderChange setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("topTaskOrderId")
   public MesBuildingTaskOrderChange setTopTaskOrderId(final Long topTaskOrderId) {
      this.topTaskOrderId = topTaskOrderId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTaskOrderChange setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("oldTaskOrderId")
   public MesBuildingTaskOrderChange setOldTaskOrderId(final Long oldTaskOrderId) {
      this.oldTaskOrderId = oldTaskOrderId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskOrderChange setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderChange(id="
         + this.getId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", userId="
         + this.getUserId()
         + ", topTaskOrderId="
         + this.getTopTaskOrderId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", oldTaskOrderId="
         + this.getOldTaskOrderId()
         + ", groupsId="
         + this.getGroupsId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderChange)) {
         return false;
      }

      MesBuildingTaskOrderChange other = (MesBuildingTaskOrderChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$topTaskOrderId = this.getTopTaskOrderId();
               Object other$topTaskOrderId = other.getTopTaskOrderId();
               if (this$topTaskOrderId == null ? other$topTaskOrderId == null : this$topTaskOrderId.equals(other$topTaskOrderId)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                     Object this$oldTaskOrderId = this.getOldTaskOrderId();
                     Object other$oldTaskOrderId = other.getOldTaskOrderId();
                     if (this$oldTaskOrderId == null ? other$oldTaskOrderId == null : this$oldTaskOrderId.equals(other$oldTaskOrderId)) {
                        Object this$groupsId = this.getGroupsId();
                        Object other$groupsId = other.getGroupsId();
                        return this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId);
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
      return other instanceof MesBuildingTaskOrderChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $topTaskOrderId = this.getTopTaskOrderId();
      result = result * 59 + ($topTaskOrderId == null ? 43 : $topTaskOrderId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $oldTaskOrderId = this.getOldTaskOrderId();
      result = result * 59 + ($oldTaskOrderId == null ? 43 : $oldTaskOrderId.hashCode());
      Object $groupsId = this.getGroupsId();
      return result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
   }

   public static class MesBuildingTaskOrderChangeBuilder {
      private Long id;
      private Integer taskTypeEnum;
      private Long userId;
      private Long topTaskOrderId;
      private Integer productionLineTypeEnum;
      private Long oldTaskOrderId;
      private Long groupsId;

      MesBuildingTaskOrderChangeBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("topTaskOrderId")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder topTaskOrderId(final Long topTaskOrderId) {
         this.topTaskOrderId = topTaskOrderId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("oldTaskOrderId")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder oldTaskOrderId(final Long oldTaskOrderId) {
         this.oldTaskOrderId = oldTaskOrderId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesBuildingTaskOrderChange build() {
         return new MesBuildingTaskOrderChange(
            this.id, this.taskTypeEnum, this.userId, this.topTaskOrderId, this.productionLineTypeEnum, this.oldTaskOrderId, this.groupsId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderChange.MesBuildingTaskOrderChangeBuilder(id="
            + this.id
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", userId="
            + this.userId
            + ", topTaskOrderId="
            + this.topTaskOrderId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", oldTaskOrderId="
            + this.oldTaskOrderId
            + ", groupsId="
            + this.groupsId
            + ")";
      }
   }
}
