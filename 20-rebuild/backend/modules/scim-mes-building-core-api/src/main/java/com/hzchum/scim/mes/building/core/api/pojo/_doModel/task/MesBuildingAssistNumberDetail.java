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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingAssistNumberDetail对象", description = "工序协同码号详情关系表")
@Entity
@TableName("mes_building_assist_number_detail")
@Table(
   name = "mes_building_assist_number_detail",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id"),
         @Index(name = "task_id", columnList = "task_id"),
         @Index(name = "task_process_id", columnList = "task_process_id"),
         @Index(name = "process_id", columnList = "process_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_assist_number_detail", comment = "工序协同码号详情关系表")
public class MesBuildingAssistNumberDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assistId", value = "协同id", notes = "协同id")
   @TableField("assist_id")
   @Column(name = "assist_id", columnDefinition = "bigint(20)  COMMENT '协同id'", nullable = false)
   private Long assistId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = true)
   private Long productionLineId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "int(11) default '0' COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskType", value = "任务类型", notes = "任务类型")
   @TableField("task_type")
   @Column(name = "task_type", columnDefinition = "int(11) default '0' COMMENT '任务类型'", nullable = false)
   private Integer taskType;
   @ApiModelProperty(name = "number", value = "一物一码号", notes = "一物一码号")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11) default '0' COMMENT '一物一码号'", nullable = false)
   private Integer number;
   @ApiModelProperty(name = "boolFinishEnum", value = "是否完成", notes = "是否完成")
   @TableField("bool_finish_enum")
   @Column(name = "bool_finish_enum", columnDefinition = "tinyint(1)  COMMENT '是否完成'", nullable = false)
   private Boolean boolFinishEnum;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "teamId", value = "班组Id", notes = "班组Id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组Id'", nullable = false)
   private Long teamId;
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

   public static MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder builder() {
      return new MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder();
   }

   public MesBuildingAssistNumberDetail() {
   }

   public MesBuildingAssistNumberDetail(
      final Long id,
      final Long assistId,
      final Long taskId,
      final Long taskProcessId,
      final Long groupsId,
      final Long productionLineId,
      final Long userId,
      final Long productId,
      final Integer taskType,
      final Integer number,
      final Boolean boolFinishEnum,
      final Long processId,
      final Long teamId,
      final Long projectId,
      final Integer productType
   ) {
      this.id = id;
      this.assistId = assistId;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.groupsId = groupsId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.productId = productId;
      this.taskType = taskType;
      this.number = number;
      this.boolFinishEnum = boolFinishEnum;
      this.processId = processId;
      this.teamId = teamId;
      this.projectId = projectId;
      this.productType = productType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssistId() {
      return this.assistId;
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

   public Long getUserId() {
      return this.userId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Boolean getBoolFinishEnum() {
      return this.boolFinishEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public MesBuildingAssistNumberDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAssistNumberDetail setAssistId(final Long assistId) {
      this.assistId = assistId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingAssistNumberDetail setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingAssistNumberDetail setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingAssistNumberDetail setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   public MesBuildingAssistNumberDetail setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MesBuildingAssistNumberDetail setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesBuildingAssistNumberDetail setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingAssistNumberDetail setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   public MesBuildingAssistNumberDetail setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesBuildingAssistNumberDetail setBoolFinishEnum(final Boolean boolFinishEnum) {
      this.boolFinishEnum = boolFinishEnum;
      return this;
   }

   public MesBuildingAssistNumberDetail setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingAssistNumberDetail setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingAssistNumberDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingAssistNumberDetail setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistNumberDetail(id="
         + this.getId()
         + ", assistId="
         + this.getAssistId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", groupsId="
         + this.getGroupsId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", userId="
         + this.getUserId()
         + ", productId="
         + this.getProductId()
         + ", taskType="
         + this.getTaskType()
         + ", number="
         + this.getNumber()
         + ", boolFinishEnum="
         + this.getBoolFinishEnum()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistNumberDetail)) {
         return false;
      }

      MesBuildingAssistNumberDetail other = (MesBuildingAssistNumberDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assistId = this.getAssistId();
         Object other$assistId = other.getAssistId();
         if (this$assistId == null ? other$assistId == null : this$assistId.equals(other$assistId)) {
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
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$taskType = this.getTaskType();
                              Object other$taskType = other.getTaskType();
                              if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$boolFinishEnum = this.getBoolFinishEnum();
                                    Object other$boolFinishEnum = other.getBoolFinishEnum();
                                    if (this$boolFinishEnum == null ? other$boolFinishEnum == null : this$boolFinishEnum.equals(other$boolFinishEnum)) {
                                       Object this$processId = this.getProcessId();
                                       Object other$processId = other.getProcessId();
                                       if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                          Object this$teamId = this.getTeamId();
                                          Object other$teamId = other.getTeamId();
                                          if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                             Object this$projectId = this.getProjectId();
                                             Object other$projectId = other.getProjectId();
                                             if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                                Object this$productType = this.getProductType();
                                                Object other$productType = other.getProductType();
                                                return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
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
      return other instanceof MesBuildingAssistNumberDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolFinishEnum = this.getBoolFinishEnum();
      result = result * 59 + ($boolFinishEnum == null ? 43 : $boolFinishEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   public static class MesBuildingAssistNumberDetailBuilder {
      private Long id;
      private Long assistId;
      private Long taskId;
      private Long taskProcessId;
      private Long groupsId;
      private Long productionLineId;
      private Long userId;
      private Long productId;
      private Integer taskType;
      private Integer number;
      private Boolean boolFinishEnum;
      private Long processId;
      private Long teamId;
      private Long projectId;
      private Integer productType;

      MesBuildingAssistNumberDetailBuilder() {
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder boolFinishEnum(final Boolean boolFinishEnum) {
         this.boolFinishEnum = boolFinishEnum;
         return this;
      }

      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingAssistNumberDetail build() {
         return new MesBuildingAssistNumberDetail(
            this.id,
            this.assistId,
            this.taskId,
            this.taskProcessId,
            this.groupsId,
            this.productionLineId,
            this.userId,
            this.productId,
            this.taskType,
            this.number,
            this.boolFinishEnum,
            this.processId,
            this.teamId,
            this.projectId,
            this.productType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistNumberDetail.MesBuildingAssistNumberDetailBuilder(id="
            + this.id
            + ", assistId="
            + this.assistId
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", groupsId="
            + this.groupsId
            + ", productionLineId="
            + this.productionLineId
            + ", userId="
            + this.userId
            + ", productId="
            + this.productId
            + ", taskType="
            + this.taskType
            + ", number="
            + this.number
            + ", boolFinishEnum="
            + this.boolFinishEnum
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", projectId="
            + this.projectId
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
