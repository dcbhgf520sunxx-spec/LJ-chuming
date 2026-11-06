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

@ApiModel(value = "MesBuildingTypesettingComplete对象", description = "生产完成表 ")
@Entity
@TableName("mes_building_typesetting_complete")
@Table(name = "mes_building_typesetting_complete")
public class MesBuildingTypesettingComplete extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;

   public static MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder builder() {
      return new MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder();
   }

   public MesBuildingTypesettingComplete() {
   }

   public MesBuildingTypesettingComplete(
      final Long id,
      final Long projectId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long teamId,
      final Long taskId,
      final Long productId,
      final Long userId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.teamId = teamId;
      this.taskId = taskId;
      this.productId = productId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingTypesettingComplete setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTypesettingComplete setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTypesettingComplete setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTypesettingComplete setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTypesettingComplete setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTypesettingComplete setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingTypesettingComplete setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingTypesettingComplete setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTypesettingComplete setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTypesettingComplete setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTypesettingComplete(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
         + ", taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTypesettingComplete)) {
         return false;
      }

      MesBuildingTypesettingComplete other = (MesBuildingTypesettingComplete)o;
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
                        Object this$teamId = this.getTeamId();
                        Object other$teamId = other.getTeamId();
                        if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                           Object this$taskId = this.getTaskId();
                           Object other$taskId = other.getTaskId();
                           if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTypesettingComplete;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesBuildingTypesettingCompleteBuilder {
      private Long id;
      private Long projectId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long teamId;
      private Long taskId;
      private Long productId;
      private Long userId;

      MesBuildingTypesettingCompleteBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingTypesettingComplete build() {
         return new MesBuildingTypesettingComplete(
            this.id,
            this.projectId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.teamId,
            this.taskId,
            this.productId,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTypesettingComplete.MesBuildingTypesettingCompleteBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
            + ", taskId="
            + this.taskId
            + ", productId="
            + this.productId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
