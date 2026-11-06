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

@ApiModel(value = "MesBuildingMachinePartSchedulingArtifactTaskLink对象", description = "")
@Entity
@TableName("mes_building_machine_part_scheduling_artifact_task_link")
@Table(name = "mes_building_machine_part_scheduling_artifact_task_link", indexes = @Index(name = "taskIdIndex", columnList = "task_id"))
public class MesBuildingMachinePartSchedulingArtifactTaskLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'", nullable = false)
   private Long schedulingId;
   @ApiModelProperty(name = "schedulingLinkId", value = "零件排产关联表id", notes = "零件排产关联表id")
   @JsonProperty("schedulingLinkId")
   @JSONField(name = "schedulingLinkId")
   @TableField("scheduling_link_id")
   @Column(name = "scheduling_link_id", columnDefinition = "bigint(20)  COMMENT '零件排产关联表id'", nullable = false)
   private Long schedulingLinkId;
   @ApiModelProperty(name = "needLinkId", value = "需要排产关联表id", notes = "需要排产关联表id")
   @JsonProperty("needLinkId")
   @JSONField(name = "needLinkId")
   @TableField("need_link_id")
   @Column(name = "need_link_id", columnDefinition = "bigint(20)  COMMENT '需要排产关联表id'", nullable = false)
   private Long needLinkId;
   @ApiModelProperty(name = "taskId", value = "需要排产关联表id", notes = "需要排产关联表id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '需要排产关联表id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
   private Integer quantity;

   public static MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder builder() {
      return new MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder();
   }

   public MesBuildingMachinePartSchedulingArtifactTaskLink() {
   }

   public MesBuildingMachinePartSchedulingArtifactTaskLink(
      final Long id, final Long schedulingId, final Long schedulingLinkId, final Long needLinkId, final Long taskId, final Integer quantity
   ) {
      this.id = id;
      this.schedulingId = schedulingId;
      this.schedulingLinkId = schedulingLinkId;
      this.needLinkId = needLinkId;
      this.taskId = taskId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getSchedulingLinkId() {
      return this.schedulingLinkId;
   }

   public Long getNeedLinkId() {
      return this.needLinkId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSchedulingArtifactTaskLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartSchedulingArtifactTaskLink setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("schedulingLinkId")
   public MesBuildingMachinePartSchedulingArtifactTaskLink setSchedulingLinkId(final Long schedulingLinkId) {
      this.schedulingLinkId = schedulingLinkId;
      return this;
   }

   @JsonProperty("needLinkId")
   public MesBuildingMachinePartSchedulingArtifactTaskLink setNeedLinkId(final Long needLinkId) {
      this.needLinkId = needLinkId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingMachinePartSchedulingArtifactTaskLink setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingArtifactTaskLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingArtifactTaskLink(id="
         + this.getId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", schedulingLinkId="
         + this.getSchedulingLinkId()
         + ", needLinkId="
         + this.getNeedLinkId()
         + ", taskId="
         + this.getTaskId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingArtifactTaskLink)) {
         return false;
      }

      MesBuildingMachinePartSchedulingArtifactTaskLink other = (MesBuildingMachinePartSchedulingArtifactTaskLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$schedulingId = this.getSchedulingId();
         Object other$schedulingId = other.getSchedulingId();
         if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
            Object this$schedulingLinkId = this.getSchedulingLinkId();
            Object other$schedulingLinkId = other.getSchedulingLinkId();
            if (this$schedulingLinkId == null ? other$schedulingLinkId == null : this$schedulingLinkId.equals(other$schedulingLinkId)) {
               Object this$needLinkId = this.getNeedLinkId();
               Object other$needLinkId = other.getNeedLinkId();
               if (this$needLinkId == null ? other$needLinkId == null : this$needLinkId.equals(other$needLinkId)) {
                  Object this$taskId = this.getTaskId();
                  Object other$taskId = other.getTaskId();
                  if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof MesBuildingMachinePartSchedulingArtifactTaskLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $schedulingLinkId = this.getSchedulingLinkId();
      result = result * 59 + ($schedulingLinkId == null ? 43 : $schedulingLinkId.hashCode());
      Object $needLinkId = this.getNeedLinkId();
      result = result * 59 + ($needLinkId == null ? 43 : $needLinkId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder {
      private Long id;
      private Long schedulingId;
      private Long schedulingLinkId;
      private Long needLinkId;
      private Long taskId;
      private Integer quantity;

      MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("schedulingLinkId")
      public MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder schedulingLinkId(
         final Long schedulingLinkId
      ) {
         this.schedulingLinkId = schedulingLinkId;
         return this;
      }

      @JsonProperty("needLinkId")
      public MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder needLinkId(final Long needLinkId) {
         this.needLinkId = needLinkId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingMachinePartSchedulingArtifactTaskLink build() {
         return new MesBuildingMachinePartSchedulingArtifactTaskLink(
            this.id, this.schedulingId, this.schedulingLinkId, this.needLinkId, this.taskId, this.quantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingArtifactTaskLink.MesBuildingMachinePartSchedulingArtifactTaskLinkBuilder(id="
            + this.id
            + ", schedulingId="
            + this.schedulingId
            + ", schedulingLinkId="
            + this.schedulingLinkId
            + ", needLinkId="
            + this.needLinkId
            + ", taskId="
            + this.taskId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
