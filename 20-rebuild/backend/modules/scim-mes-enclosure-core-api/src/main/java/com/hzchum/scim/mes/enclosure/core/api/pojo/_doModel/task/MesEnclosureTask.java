package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task;

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
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureTask对象", description = "任务分配表 ")
@Entity
@TableName("mes_enclosure_task")
@Table(name = "mes_enclosure_task")
public class MesEnclosureTask extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) default '0' COMMENT '班组id'")
   private Long teamId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "planId", value = "区域id", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long planId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskQuantity", value = "任务数量", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @TableField("task_quantity")
   @Column(name = "task_quantity", columnDefinition = "int(11) default '0' COMMENT '任务数量'", nullable = false)
   private Integer taskQuantity;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(20) comment '字典表id'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "completeQuantity", value = "已完成数量", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   @TableField("complete_quantity")
   @Column(name = "complete_quantity", columnDefinition = "int(11) default '0' COMMENT '已完成数量'", nullable = false)
   private Integer completeQuantity;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   @TableField("complete_time")
   @Column(name = "complete_time", columnDefinition = "datetime  COMMENT '完成日期'", nullable = true)
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "boolCompleteEnum", value = "是否完成", notes = "是否完成")
   @JsonProperty("boolCompleteEnum")
   @JSONField(name = "boolCompleteEnum")
   @TableField("bool_complete_enum")
   @Column(name = "bool_complete_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否完成'")
   private Boolean boolCompleteEnum;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'")
   private Long processId;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", nullable = false, columnDefinition = "tinyint(1) default 0 COMMENT '是否打印: 0 未打印,1 打印'")
   private Boolean boolPrinted;

   public static MesEnclosureTask.MesEnclosureTaskBuilder builder() {
      return new MesEnclosureTask.MesEnclosureTaskBuilder();
   }

   public MesEnclosureTask() {
   }

   public MesEnclosureTask(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long teamId,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Long areaId,
      final Long productId,
      final Integer taskQuantity,
      final Integer category,
      final Long dictionaryId,
      final Integer completeQuantity,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Long userId,
      final Long taskOrderId,
      final Boolean boolCompleteEnum,
      final Long processId,
      final Boolean boolPrinted
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.areaId = areaId;
      this.productId = productId;
      this.taskQuantity = taskQuantity;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.completeQuantity = completeQuantity;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.userId = userId;
      this.taskOrderId = taskOrderId;
      this.boolCompleteEnum = boolCompleteEnum;
      this.processId = processId;
      this.boolPrinted = boolPrinted;
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

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
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

   public Long getUserId() {
      return this.userId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Boolean getBoolCompleteEnum() {
      return this.boolCompleteEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   @JsonProperty("id")
   public MesEnclosureTask setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTask setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureTask setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTask setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureTask setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureTask setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureTask setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureTask setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("areaId")
   public MesEnclosureTask setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureTask setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesEnclosureTask setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("category")
   public MesEnclosureTask setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("dictionaryId")
   public MesEnclosureTask setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesEnclosureTask setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTask setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureTask setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTask setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesEnclosureTask setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("boolCompleteEnum")
   public MesEnclosureTask setBoolCompleteEnum(final Boolean boolCompleteEnum) {
      this.boolCompleteEnum = boolCompleteEnum;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureTask setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("boolPrinted")
   public MesEnclosureTask setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTask(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", userId="
         + this.getUserId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", boolCompleteEnum="
         + this.getBoolCompleteEnum()
         + ", processId="
         + this.getProcessId()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTask)) {
         return false;
      }

      MesEnclosureTask other = (MesEnclosureTask)o;
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
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$planId = this.getPlanId();
                           Object other$planId = other.getPlanId();
                           if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$taskQuantity = this.getTaskQuantity();
                                    Object other$taskQuantity = other.getTaskQuantity();
                                    if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                       Object this$category = this.getCategory();
                                       Object other$category = other.getCategory();
                                       if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                          Object this$dictionaryId = this.getDictionaryId();
                                          Object other$dictionaryId = other.getDictionaryId();
                                          if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                             Object this$completeQuantity = this.getCompleteQuantity();
                                             Object other$completeQuantity = other.getCompleteQuantity();
                                             if (this$completeQuantity == null
                                                ? other$completeQuantity == null
                                                : this$completeQuantity.equals(other$completeQuantity)) {
                                                Object this$userId = this.getUserId();
                                                Object other$userId = other.getUserId();
                                                if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                   Object this$taskOrderId = this.getTaskOrderId();
                                                   Object other$taskOrderId = other.getTaskOrderId();
                                                   if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                                      Object this$boolCompleteEnum = this.getBoolCompleteEnum();
                                                      Object other$boolCompleteEnum = other.getBoolCompleteEnum();
                                                      if (this$boolCompleteEnum == null
                                                         ? other$boolCompleteEnum == null
                                                         : this$boolCompleteEnum.equals(other$boolCompleteEnum)) {
                                                         Object this$processId = this.getProcessId();
                                                         Object other$processId = other.getProcessId();
                                                         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                                            Object this$boolPrinted = this.getBoolPrinted();
                                                            Object other$boolPrinted = other.getBoolPrinted();
                                                            if (this$boolPrinted == null
                                                               ? other$boolPrinted == null
                                                               : this$boolPrinted.equals(other$boolPrinted)) {
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
      return other instanceof MesEnclosureTask;
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolCompleteEnum = this.getBoolCompleteEnum();
      result = result * 59 + ($boolCompleteEnum == null ? 43 : $boolCompleteEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesEnclosureTaskBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long teamId;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Long areaId;
      private Long productId;
      private Integer taskQuantity;
      private Integer category;
      private Long dictionaryId;
      private Integer completeQuantity;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Long userId;
      private Long taskOrderId;
      private Boolean boolCompleteEnum;
      private Long processId;
      private Boolean boolPrinted;

      MesEnclosureTaskBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTask.MesEnclosureTaskBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTask.MesEnclosureTaskBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureTask.MesEnclosureTaskBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTask.MesEnclosureTaskBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureTask.MesEnclosureTaskBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureTask.MesEnclosureTaskBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureTask.MesEnclosureTaskBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureTask.MesEnclosureTaskBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("areaId")
      public MesEnclosureTask.MesEnclosureTaskBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureTask.MesEnclosureTaskBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesEnclosureTask.MesEnclosureTaskBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("category")
      public MesEnclosureTask.MesEnclosureTaskBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("dictionaryId")
      public MesEnclosureTask.MesEnclosureTaskBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesEnclosureTask.MesEnclosureTaskBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTask.MesEnclosureTaskBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureTask.MesEnclosureTaskBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTask.MesEnclosureTaskBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesEnclosureTask.MesEnclosureTaskBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("boolCompleteEnum")
      public MesEnclosureTask.MesEnclosureTaskBuilder boolCompleteEnum(final Boolean boolCompleteEnum) {
         this.boolCompleteEnum = boolCompleteEnum;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureTask.MesEnclosureTaskBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("boolPrinted")
      public MesEnclosureTask.MesEnclosureTaskBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public MesEnclosureTask build() {
         return new MesEnclosureTask(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.teamId,
            this.projectId,
            this.monomerId,
            this.planId,
            this.areaId,
            this.productId,
            this.taskQuantity,
            this.category,
            this.dictionaryId,
            this.completeQuantity,
            this.askCompleteTime,
            this.completeTime,
            this.userId,
            this.taskOrderId,
            this.boolCompleteEnum,
            this.processId,
            this.boolPrinted
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureTask.MesEnclosureTaskBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", areaId="
            + this.areaId
            + ", productId="
            + this.productId
            + ", taskQuantity="
            + this.taskQuantity
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", completeQuantity="
            + this.completeQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", userId="
            + this.userId
            + ", taskOrderId="
            + this.taskOrderId
            + ", boolCompleteEnum="
            + this.boolCompleteEnum
            + ", processId="
            + this.processId
            + ", boolPrinted="
            + this.boolPrinted
            + ")";
      }
   }
}
