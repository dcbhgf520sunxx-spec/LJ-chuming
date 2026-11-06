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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingAssist对象", description = "班组协同表 ")
@Entity
@TableName("mes_building_assist")
@Table(
   name = "mes_building_assist",
   indexes = {
         @Index(name = "task_id_index", columnList = "task_id"),
         @Index(name = "task_process_id_index", columnList = "task_process_id"),
         @Index(name = "groups_id_index", columnList = "groups_id"),
         @Index(name = "process_id_index", columnList = "process_id"),
         @Index(name = "project_id_index", columnList = "project_id")
   }
)
public class MesBuildingAssist extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务id", notes = "任务id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组Id", notes = "班组Id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组Id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "quantity", value = "协同数量", notes = "协同数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '总数'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "produceQuantity", value = "完成数量", notes = "完成数量")
   @JsonProperty("produceQuantity")
   @JSONField(name = "produceQuantity")
   @TableField("produce_quantity")
   @Column(name = "produce_quantity", columnDefinition = "int(11) default '0' COMMENT '完成数量'", nullable = false)
   private Integer produceQuantity;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "boolFinishEnum", value = "是否结束", notes = "是否结束")
   @JsonProperty("boolFinishEnum")
   @JSONField(name = "boolFinishEnum")
   @TableField("bool_finish_enum")
   @Column(name = "bool_finish_enum", columnDefinition = "tinyint(1)  COMMENT '是否结束'", nullable = false)
   private Boolean boolFinishEnum;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "productType", value = "产品类型 [0 零件,1  构件,2  围护]", notes = "产品类型 [2  构件,16  部件]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) default '0' COMMENT '产品类型 [2  构件,16  部件]'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "classId", value = "产品种类Id", notes = "产品种类Id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   @TableField("class_id")
   @Column(name = "class_id", columnDefinition = "bigint(20)  COMMENT '产品种类Id'", nullable = false)
   private Long classId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @TableField("sequence")
   @Column(name = "sequence", columnDefinition = "int(11) default '0' COMMENT '工序顺序'")
   private Integer sequence;
   @ApiModelProperty(name = "taskCreateTime", value = "任务创建时间", notes = "任务创建时间")
   @TableField("task_create_time")
   @Column(name = "task_create_time", columnDefinition = "datetime(6) COMMENT '任务创建时间'")
   private LocalDateTime taskCreateTime;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'")
   private Integer taskTypeEnum;

   public static MesBuildingAssist.MesBuildingAssistBuilder builder() {
      return new MesBuildingAssist.MesBuildingAssistBuilder();
   }

   public MesBuildingAssist() {
   }

   public MesBuildingAssist(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long groupsId,
      final Long productionLineId,
      final Long teamId,
      final Integer quantity,
      final Integer produceQuantity,
      final Long processId,
      final Boolean boolFinishEnum,
      final Long userId,
      final Long projectId,
      final Integer productType,
      final Long classId,
      final Long workshopId,
      final Integer sequence,
      final LocalDateTime taskCreateTime,
      final Integer taskTypeEnum
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.groupsId = groupsId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.quantity = quantity;
      this.produceQuantity = produceQuantity;
      this.processId = processId;
      this.boolFinishEnum = boolFinishEnum;
      this.userId = userId;
      this.projectId = projectId;
      this.productType = productType;
      this.classId = classId;
      this.workshopId = workshopId;
      this.sequence = sequence;
      this.taskCreateTime = taskCreateTime;
      this.taskTypeEnum = taskTypeEnum;
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

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public LocalDateTime getTaskCreateTime() {
      return this.taskCreateTime;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("id")
   public MesBuildingAssist setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingAssist setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingAssist setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingAssist setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingAssist setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingAssist setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssist setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("produceQuantity")
   public MesBuildingAssist setProduceQuantity(final Integer produceQuantity) {
      this.produceQuantity = produceQuantity;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingAssist setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("boolFinishEnum")
   public MesBuildingAssist setBoolFinishEnum(final Boolean boolFinishEnum) {
      this.boolFinishEnum = boolFinishEnum;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingAssist setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingAssist setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingAssist setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("classId")
   public MesBuildingAssist setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingAssist setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingAssist setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   public MesBuildingAssist setTaskCreateTime(final LocalDateTime taskCreateTime) {
      this.taskCreateTime = taskCreateTime;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingAssist setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssist(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", groupsId="
         + this.getGroupsId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
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
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", classId="
         + this.getClassId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", sequence="
         + this.getSequence()
         + ", taskCreateTime="
         + this.getTaskCreateTime()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssist)) {
         return false;
      }

      MesBuildingAssist other = (MesBuildingAssist)o;
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
               Object this$groupsId = this.getGroupsId();
               Object other$groupsId = other.getGroupsId();
               if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$teamId = this.getTeamId();
                     Object other$teamId = other.getTeamId();
                     if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
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
                                       Object this$projectId = this.getProjectId();
                                       Object other$projectId = other.getProjectId();
                                       if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                          Object this$productType = this.getProductType();
                                          Object other$productType = other.getProductType();
                                          if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                             Object this$classId = this.getClassId();
                                             Object other$classId = other.getClassId();
                                             if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
                                                Object this$workshopId = this.getWorkshopId();
                                                Object other$workshopId = other.getWorkshopId();
                                                if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                   Object this$sequence = this.getSequence();
                                                   Object other$sequence = other.getSequence();
                                                   if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                                                      Object this$taskTypeEnum = this.getTaskTypeEnum();
                                                      Object other$taskTypeEnum = other.getTaskTypeEnum();
                                                      if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)
                                                         )
                                                       {
                                                         Object this$taskCreateTime = this.getTaskCreateTime();
                                                         Object other$taskCreateTime = other.getTaskCreateTime();
                                                         return this$taskCreateTime == null
                                                            ? other$taskCreateTime == null
                                                            : this$taskCreateTime.equals(other$taskCreateTime);
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
      return other instanceof MesBuildingAssist;
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
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $taskCreateTime = this.getTaskCreateTime();
      return result * 59 + ($taskCreateTime == null ? 43 : $taskCreateTime.hashCode());
   }

   public static class MesBuildingAssistBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long groupsId;
      private Long productionLineId;
      private Long teamId;
      private Integer quantity;
      private Integer produceQuantity;
      private Long processId;
      private Boolean boolFinishEnum;
      private Long userId;
      private Long projectId;
      private Integer productType;
      private Long classId;
      private Long workshopId;
      private Integer sequence;
      private LocalDateTime taskCreateTime;
      private Integer taskTypeEnum;

      MesBuildingAssistBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssist.MesBuildingAssistBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingAssist.MesBuildingAssistBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingAssist.MesBuildingAssistBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingAssist.MesBuildingAssistBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingAssist.MesBuildingAssistBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingAssist.MesBuildingAssistBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssist.MesBuildingAssistBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("produceQuantity")
      public MesBuildingAssist.MesBuildingAssistBuilder produceQuantity(final Integer produceQuantity) {
         this.produceQuantity = produceQuantity;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingAssist.MesBuildingAssistBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("boolFinishEnum")
      public MesBuildingAssist.MesBuildingAssistBuilder boolFinishEnum(final Boolean boolFinishEnum) {
         this.boolFinishEnum = boolFinishEnum;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingAssist.MesBuildingAssistBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingAssist.MesBuildingAssistBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingAssist.MesBuildingAssistBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("classId")
      public MesBuildingAssist.MesBuildingAssistBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingAssist.MesBuildingAssistBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingAssist.MesBuildingAssistBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBuildingAssist.MesBuildingAssistBuilder taskCreateTime(final LocalDateTime taskCreateTime) {
         this.taskCreateTime = taskCreateTime;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingAssist.MesBuildingAssistBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesBuildingAssist build() {
         return new MesBuildingAssist(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.groupsId,
            this.productionLineId,
            this.teamId,
            this.quantity,
            this.produceQuantity,
            this.processId,
            this.boolFinishEnum,
            this.userId,
            this.projectId,
            this.productType,
            this.classId,
            this.workshopId,
            this.sequence,
            this.taskCreateTime,
            this.taskTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssist.MesBuildingAssistBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", groupsId="
            + this.groupsId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
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
            + ", projectId="
            + this.projectId
            + ", productType="
            + this.productType
            + ", classId="
            + this.classId
            + ", workshopId="
            + this.workshopId
            + ", sequence="
            + this.sequence
            + ", taskCreateTime="
            + this.taskCreateTime
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
