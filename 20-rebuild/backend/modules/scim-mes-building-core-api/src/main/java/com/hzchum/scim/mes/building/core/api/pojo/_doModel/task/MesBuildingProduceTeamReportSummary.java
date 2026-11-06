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

@ApiModel(value = "MesBuildingProduceTeamReportSummary对象", description = "班组生产上报记录汇总表 ")
@Entity
@TableName("mes_building_produce_team_report_summary")
@Table(name = "mes_building_produce_team_report_summary")
public class MesBuildingProduceTeamReportSummary extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'")
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "已质检通过数量", notes = "已质检通过数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '已质检通过数量'", nullable = false)
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "problemQuantity", value = "问题上报数量", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   @TableField("problem_quantity")
   @Column(name = "problem_quantity", columnDefinition = "int(11) default '0' COMMENT '问题上报数量'", nullable = false)
   private Integer problemQuantity;
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
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = true)
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;

   public static MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder builder() {
      return new MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder();
   }

   public MesBuildingProduceTeamReportSummary() {
   }

   public MesBuildingProduceTeamReportSummary(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer inspectionQuantity,
      final Integer problemQuantity,
      final Long groupsId,
      final Long productionLineId,
      final Long teamId,
      final Long userId
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
      this.problemQuantity = problemQuantity;
      this.groupsId = groupsId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
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

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
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

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingProduceTeamReportSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProduceTeamReportSummary setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingProduceTeamReportSummary setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProduceTeamReportSummary setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingProduceTeamReportSummary setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProduceTeamReportSummary setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingProduceTeamReportSummary setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProduceTeamReportSummary setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingProduceTeamReportSummary setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingProduceTeamReportSummary setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingProduceTeamReportSummary setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingProduceTeamReportSummary setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceTeamReportSummary setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProduceTeamReportSummary setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceTeamReportSummary(id="
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
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", groupsId="
         + this.getGroupsId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceTeamReportSummary)) {
         return false;
      }

      MesBuildingProduceTeamReportSummary other = (MesBuildingProduceTeamReportSummary)o;
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
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$inspectionQuantity = this.getInspectionQuantity();
                              Object other$inspectionQuantity = other.getInspectionQuantity();
                              if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)
                                 )
                               {
                                 Object this$problemQuantity = this.getProblemQuantity();
                                 Object other$problemQuantity = other.getProblemQuantity();
                                 if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
                                    Object this$groupsId = this.getGroupsId();
                                    Object other$groupsId = other.getGroupsId();
                                    if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                       Object this$productionLineId = this.getProductionLineId();
                                       Object other$productionLineId = other.getProductionLineId();
                                       if (this$productionLineId == null
                                          ? other$productionLineId == null
                                          : this$productionLineId.equals(other$productionLineId)) {
                                          Object this$teamId = this.getTeamId();
                                          Object other$teamId = other.getTeamId();
                                          if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
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
      return other instanceof MesBuildingProduceTeamReportSummary;
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
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesBuildingProduceTeamReportSummaryBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer inspectionQuantity;
      private Integer problemQuantity;
      private Long groupsId;
      private Long productionLineId;
      private Long teamId;
      private Long userId;

      MesBuildingProduceTeamReportSummaryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingProduceTeamReportSummary build() {
         return new MesBuildingProduceTeamReportSummary(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.inspectionQuantity,
            this.problemQuantity,
            this.groupsId,
            this.productionLineId,
            this.teamId,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceTeamReportSummary.MesBuildingProduceTeamReportSummaryBuilder(id="
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
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", problemQuantity="
            + this.problemQuantity
            + ", groupsId="
            + this.groupsId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
