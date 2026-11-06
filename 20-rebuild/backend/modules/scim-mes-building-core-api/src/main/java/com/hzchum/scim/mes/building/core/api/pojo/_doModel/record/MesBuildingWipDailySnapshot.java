package com.hzchum.scim.mes.building.core.api.pojo._doModel.record;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWipDailySnapshot对象", description = "")
@Entity
@TableName("mes_building_wip_daily_snapshot")
@Table(name = "mes_building_wip_daily_snapshot")
public class MesBuildingWipDailySnapshot extends BaseEntity<Long> implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskLists")
   @JsonProperty("taskLists")
   @JSONField(name = "taskLists")
   @TableField("task_lists")
   @Column(name = "task_lists", columnDefinition = "longtext  COMMENT '在制品任务汇总列表'", nullable = true)
   private String taskLists;
   @ApiModelProperty(name = "taskDetails")
   @JsonProperty("taskDetails")
   @JSONField(name = "taskDetails")
   @TableField("task_details")
   @Column(name = "task_details", columnDefinition = "longtext  COMMENT '在制品任务详情列表'", nullable = true)
   private String taskDetails;
   @ApiModelProperty(name = "processList")
   @JsonProperty("processList")
   @JSONField(name = "processList")
   @TableField("process_list")
   @Column(name = "process_list", columnDefinition = "longtext  COMMENT '工序列表'", nullable = true)
   private String processList;

   public static MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder builder() {
      return new MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder();
   }

   public MesBuildingWipDailySnapshot() {
   }

   public MesBuildingWipDailySnapshot(final Long id, final String taskLists, final String taskDetails, final String processList) {
      this.id = id;
      this.taskLists = taskLists;
      this.taskDetails = taskDetails;
      this.processList = processList;
   }

   public Long getId() {
      return this.id;
   }

   public String getTaskLists() {
      return this.taskLists;
   }

   public String getTaskDetails() {
      return this.taskDetails;
   }

   public String getProcessList() {
      return this.processList;
   }

   public MesBuildingWipDailySnapshot setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskLists")
   public MesBuildingWipDailySnapshot setTaskLists(final String taskLists) {
      this.taskLists = taskLists;
      return this;
   }

   @JsonProperty("taskDetails")
   public MesBuildingWipDailySnapshot setTaskDetails(final String taskDetails) {
      this.taskDetails = taskDetails;
      return this;
   }

   @JsonProperty("processList")
   public MesBuildingWipDailySnapshot setProcessList(final String processList) {
      this.processList = processList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWipDailySnapshot(id="
         + this.getId()
         + ", taskLists="
         + this.getTaskLists()
         + ", taskDetails="
         + this.getTaskDetails()
         + ", processList="
         + this.getProcessList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWipDailySnapshot)) {
         return false;
      }

      MesBuildingWipDailySnapshot other = (MesBuildingWipDailySnapshot)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskLists = this.getTaskLists();
         Object other$taskLists = other.getTaskLists();
         if (this$taskLists == null ? other$taskLists == null : this$taskLists.equals(other$taskLists)) {
            Object this$taskDetails = this.getTaskDetails();
            Object other$taskDetails = other.getTaskDetails();
            if (this$taskDetails == null ? other$taskDetails == null : this$taskDetails.equals(other$taskDetails)) {
               Object this$processList = this.getProcessList();
               Object other$processList = other.getProcessList();
               return this$processList == null ? other$processList == null : this$processList.equals(other$processList);
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
      return other instanceof MesBuildingWipDailySnapshot;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskLists = this.getTaskLists();
      result = result * 59 + ($taskLists == null ? 43 : $taskLists.hashCode());
      Object $taskDetails = this.getTaskDetails();
      result = result * 59 + ($taskDetails == null ? 43 : $taskDetails.hashCode());
      Object $processList = this.getProcessList();
      return result * 59 + ($processList == null ? 43 : $processList.hashCode());
   }

   public static class MesBuildingWipDailySnapshotBuilder {
      private Long id;
      private String taskLists;
      private String taskDetails;
      private String processList;

      MesBuildingWipDailySnapshotBuilder() {
      }

      public MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskLists")
      public MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder taskLists(final String taskLists) {
         this.taskLists = taskLists;
         return this;
      }

      @JsonProperty("taskDetails")
      public MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder taskDetails(final String taskDetails) {
         this.taskDetails = taskDetails;
         return this;
      }

      @JsonProperty("processList")
      public MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder processList(final String processList) {
         this.processList = processList;
         return this;
      }

      public MesBuildingWipDailySnapshot build() {
         return new MesBuildingWipDailySnapshot(this.id, this.taskLists, this.taskDetails, this.processList);
      }

      @Override
      public String toString() {
         return "MesBuildingWipDailySnapshot.MesBuildingWipDailySnapshotBuilder(id="
            + this.id
            + ", taskLists="
            + this.taskLists
            + ", taskDetails="
            + this.taskDetails
            + ", processList="
            + this.processList
            + ")";
      }
   }
}
