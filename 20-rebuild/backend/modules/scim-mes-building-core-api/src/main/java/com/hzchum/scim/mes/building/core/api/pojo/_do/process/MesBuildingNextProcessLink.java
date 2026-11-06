package com.hzchum.scim.mes.building.core.api.pojo._do.process;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingNextProcessLink对象", description = "任务工序关联下一道工序表\t")
@Entity
@TableName("mes_building_next_process_link")
@Table(name = "mes_building_next_process_link")
@org.hibernate.annotations.Table(appliesTo = "mes_building_next_process_link", comment = "任务工序关联下一道工序表\t")
public class MesBuildingNextProcessLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序表id", notes = "任务工序表id")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序表id'", nullable = true)
   private Long taskProcessId;
   @ApiModelProperty(name = "nextProcessId", value = "下一道工序id", notes = "下一道工序id")
   @TableField("next_process_id")
   @Column(name = "next_process_id", columnDefinition = "bigint(20)  COMMENT '下一道工序id'", nullable = true)
   private Long nextProcessId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @TableField("sequence")
   @Column(name = "sequence", columnDefinition = "int(11) default '0' COMMENT '工序顺序'", nullable = false)
   private Integer sequence;

   public static MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder builder() {
      return new MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder();
   }

   public MesBuildingNextProcessLink() {
   }

   public MesBuildingNextProcessLink(final Long id, final Long taskProcessId, final Long nextProcessId, final Integer sequence) {
      this.id = id;
      this.taskProcessId = taskProcessId;
      this.nextProcessId = nextProcessId;
      this.sequence = sequence;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public MesBuildingNextProcessLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingNextProcessLink setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingNextProcessLink setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   public MesBuildingNextProcessLink setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNextProcessLink(id="
         + this.getId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ", sequence="
         + this.getSequence()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNextProcessLink)) {
         return false;
      }

      MesBuildingNextProcessLink other = (MesBuildingNextProcessLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskProcessId = this.getTaskProcessId();
         Object other$taskProcessId = other.getTaskProcessId();
         if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
            Object this$nextProcessId = this.getNextProcessId();
            Object other$nextProcessId = other.getNextProcessId();
            if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               return this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence);
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
      return other instanceof MesBuildingNextProcessLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $sequence = this.getSequence();
      return result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
   }

   public static class MesBuildingNextProcessLinkBuilder {
      private Long id;
      private Long taskProcessId;
      private Long nextProcessId;
      private Integer sequence;

      MesBuildingNextProcessLinkBuilder() {
      }

      public MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      public MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBuildingNextProcessLink build() {
         return new MesBuildingNextProcessLink(this.id, this.taskProcessId, this.nextProcessId, this.sequence);
      }

      @Override
      public String toString() {
         return "MesBuildingNextProcessLink.MesBuildingNextProcessLinkBuilder(id="
            + this.id
            + ", taskProcessId="
            + this.taskProcessId
            + ", nextProcessId="
            + this.nextProcessId
            + ", sequence="
            + this.sequence
            + ")";
      }
   }
}
