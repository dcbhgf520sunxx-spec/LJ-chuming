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

@ApiModel(value = "MesEnclosureScheduling对象", description = "排产分配表 ")
@Entity
@TableName("mes_enclosure_scheduling")
@Table(name = "mes_enclosure_scheduling")
public class MesEnclosureScheduling extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "planId", value = "区域id", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long planId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productProcessId", value = "总工序id", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   @TableField("product_process_id")
   @Column(name = "product_process_id", columnDefinition = "bigint(20)  COMMENT '总工序id'", nullable = false)
   private Long productProcessId;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   @TableField("scheduling_quantity")
   @Column(name = "scheduling_quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
   private Integer schedulingQuantity;
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
   @ApiModelProperty(name = "status", value = "状态 [0 暂停, 1 正常]", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 [0 暂停, 1 正常]'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "team_id", value = "班组id", notes = "班组id")
   @JsonProperty("team_id")
   @JSONField(name = "team_id")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) default '0' COMMENT '班组id'", nullable = false)
   private Long teamId;

   public static MesEnclosureScheduling.MesEnclosureSchedulingBuilder builder() {
      return new MesEnclosureScheduling.MesEnclosureSchedulingBuilder();
   }

   public MesEnclosureScheduling() {
   }

   public MesEnclosureScheduling(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long planId,
      final Long productId,
      final Long productProcessId,
      final Integer schedulingQuantity,
      final Integer completeQuantity,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Long userId,
      final Long teamId
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.planId = planId;
      this.productId = productId;
      this.productProcessId = productProcessId;
      this.schedulingQuantity = schedulingQuantity;
      this.completeQuantity = completeQuantity;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.userId = userId;
      this.teamId = teamId;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
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

   public Boolean getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("id")
   public MesEnclosureScheduling setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureScheduling setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureScheduling setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureScheduling setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureScheduling setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureScheduling setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureScheduling setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesEnclosureScheduling setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesEnclosureScheduling setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesEnclosureScheduling setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureScheduling setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureScheduling setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureScheduling setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureScheduling setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("team_id")
   public MesEnclosureScheduling setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureScheduling(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectId="
         + this.getProjectId()
         + ", planId="
         + this.getPlanId()
         + ", productId="
         + this.getProductId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", teamId="
         + this.getTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureScheduling)) {
         return false;
      }

      MesEnclosureScheduling other = (MesEnclosureScheduling)o;
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
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$planId = this.getPlanId();
                     Object other$planId = other.getPlanId();
                     if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                        Object this$productId = this.getProductId();
                        Object other$productId = other.getProductId();
                        if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                           Object this$productProcessId = this.getProductProcessId();
                           Object other$productProcessId = other.getProductProcessId();
                           if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
                              Object this$schedulingQuantity = this.getSchedulingQuantity();
                              Object other$schedulingQuantity = other.getSchedulingQuantity();
                              if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)
                                 )
                               {
                                 Object this$completeQuantity = this.getCompleteQuantity();
                                 Object other$completeQuantity = other.getCompleteQuantity();
                                 if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                    Object this$status = this.getStatus();
                                    Object other$status = other.getStatus();
                                    if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                       Object this$userId = this.getUserId();
                                       Object other$userId = other.getUserId();
                                       if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                          Object this$teamId = this.getTeamId();
                                          Object other$teamId = other.getTeamId();
                                          if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                             Object this$askCompleteTime = this.getAskCompleteTime();
                                             Object other$askCompleteTime = other.getAskCompleteTime();
                                             if (this$askCompleteTime == null
                                                ? other$askCompleteTime == null
                                                : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                Object this$completeTime = this.getCompleteTime();
                                                Object other$completeTime = other.getCompleteTime();
                                                return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
      return other instanceof MesEnclosureScheduling;
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesEnclosureSchedulingBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long planId;
      private Long productId;
      private Long productProcessId;
      private Integer schedulingQuantity;
      private Integer completeQuantity;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Long userId;
      private Long teamId;

      MesEnclosureSchedulingBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("team_id")
      public MesEnclosureScheduling.MesEnclosureSchedulingBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesEnclosureScheduling build() {
         return new MesEnclosureScheduling(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.projectId,
            this.planId,
            this.productId,
            this.productProcessId,
            this.schedulingQuantity,
            this.completeQuantity,
            this.askCompleteTime,
            this.completeTime,
            this.status,
            this.userId,
            this.teamId
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureScheduling.MesEnclosureSchedulingBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectId="
            + this.projectId
            + ", planId="
            + this.planId
            + ", productId="
            + this.productId
            + ", productProcessId="
            + this.productProcessId
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
