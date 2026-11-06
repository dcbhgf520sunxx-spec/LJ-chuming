package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

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

@ApiModel(value = "MesBuildingBoChuJobDirectory对象", description = "柏楚作业目录记录表")
@Entity
@TableName("mes_building_bo_chu_job_directory")
@Table(name = "mes_building_bo_chu_job_directory")
public class MesBuildingBoChuJobDirectory extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "jobId")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "int(11) COMMENT '作业id'", nullable = false)
   private Integer jobId;
   @ApiModelProperty(name = "parentId")
   @JsonProperty("parentId")
   @JSONField(name = "parentId")
   @TableField("parent_id")
   @Column(name = "parent_id", columnDefinition = "int(11)  COMMENT '父目录id'", nullable = false)
   private Integer parentId;
   @ApiModelProperty(name = "jobName")
   @JsonProperty("jobName")
   @JSONField(name = "jobName")
   @TableField("job_name")
   @Column(name = "job_name", columnDefinition = "varchar(255)  COMMENT '作业名称'", nullable = false)
   private String jobName;
   @ApiModelProperty(name = "jobType")
   @JsonProperty("jobType")
   @JSONField(name = "jobType")
   @TableField("job_type")
   @Column(name = "job_type", columnDefinition = "int(11)  COMMENT '作业类型0:目录 1:作业'", nullable = false)
   private Integer jobType;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "varchar(255)  COMMENT '项目id'", nullable = true)
   private String projectId;
   @ApiModelProperty(name = "teamId")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "varchar(255)  COMMENT '班组id'", nullable = true)
   private String teamId;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "varchar(255) COMMENT '车间id'", nullable = true)
   private String workshopId;
   @ApiModelProperty(name = "teamCodeId")
   @JsonProperty("teamCodeId")
   @JSONField(name = "teamCodeId")
   @TableField("team_code_id")
   @Column(name = "team_code_id", columnDefinition = "bigint(20) COMMENT '团队码id'", nullable = false)
   private Long teamCodeId;
   @ApiModelProperty(name = "partSchedulingStatus")
   @JsonProperty("partSchedulingStatus")
   @JSONField(name = "partSchedulingStatus")
   @TableField("part_scheduling_status")
   @Column(name = "part_scheduling_status", columnDefinition = "int(11) COMMENT '零件排产状态'", nullable = true)
   private Integer partSchedulingStatus;
   @ApiModelProperty("任务工单id")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) COMMENT '任务工单id'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty("零件类型[1:零件板,2:翼腹板,4:成品型材]")
   @TableField("steel_plate_type_enum")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) COMMENT '零件类型[1:零件板,2:翼腹板,4:成品型材]'")
   private Integer steelPlateTypeEnum;

   public static MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder builder() {
      return new MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder();
   }

   public MesBuildingBoChuJobDirectory() {
   }

   public MesBuildingBoChuJobDirectory(
      final Long id,
      final Integer jobId,
      final Integer parentId,
      final String jobName,
      final Integer jobType,
      final String projectId,
      final String teamId,
      final String workshopId,
      final Long teamCodeId,
      final Integer partSchedulingStatus,
      final Long taskOrderId,
      final Integer steelPlateTypeEnum
   ) {
      this.id = id;
      this.jobId = jobId;
      this.parentId = parentId;
      this.jobName = jobName;
      this.jobType = jobType;
      this.projectId = projectId;
      this.teamId = teamId;
      this.workshopId = workshopId;
      this.teamCodeId = teamCodeId;
      this.partSchedulingStatus = partSchedulingStatus;
      this.taskOrderId = taskOrderId;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Integer getParentId() {
      return this.parentId;
   }

   public String getJobName() {
      return this.jobName;
   }

   public Integer getJobType() {
      return this.jobType;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public String getTeamId() {
      return this.teamId;
   }

   public String getWorkshopId() {
      return this.workshopId;
   }

   public Long getTeamCodeId() {
      return this.teamCodeId;
   }

   public Integer getPartSchedulingStatus() {
      return this.partSchedulingStatus;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   @JsonProperty("id")
   public MesBuildingBoChuJobDirectory setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingBoChuJobDirectory setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("parentId")
   public MesBuildingBoChuJobDirectory setParentId(final Integer parentId) {
      this.parentId = parentId;
      return this;
   }

   @JsonProperty("jobName")
   public MesBuildingBoChuJobDirectory setJobName(final String jobName) {
      this.jobName = jobName;
      return this;
   }

   @JsonProperty("jobType")
   public MesBuildingBoChuJobDirectory setJobType(final Integer jobType) {
      this.jobType = jobType;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingBoChuJobDirectory setProjectId(final String projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingBoChuJobDirectory setTeamId(final String teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingBoChuJobDirectory setWorkshopId(final String workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("teamCodeId")
   public MesBuildingBoChuJobDirectory setTeamCodeId(final Long teamCodeId) {
      this.teamCodeId = teamCodeId;
      return this;
   }

   @JsonProperty("partSchedulingStatus")
   public MesBuildingBoChuJobDirectory setPartSchedulingStatus(final Integer partSchedulingStatus) {
      this.partSchedulingStatus = partSchedulingStatus;
      return this;
   }

   public MesBuildingBoChuJobDirectory setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public MesBuildingBoChuJobDirectory setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuJobDirectory(id="
         + this.getId()
         + ", jobId="
         + this.getJobId()
         + ", parentId="
         + this.getParentId()
         + ", jobName="
         + this.getJobName()
         + ", jobType="
         + this.getJobType()
         + ", projectId="
         + this.getProjectId()
         + ", teamId="
         + this.getTeamId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", teamCodeId="
         + this.getTeamCodeId()
         + ", partSchedulingStatus="
         + this.getPartSchedulingStatus()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuJobDirectory)) {
         return false;
      }

      MesBuildingBoChuJobDirectory other = (MesBuildingBoChuJobDirectory)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$parentId = this.getParentId();
            Object other$parentId = other.getParentId();
            if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
               Object this$jobType = this.getJobType();
               Object other$jobType = other.getJobType();
               if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
                  Object this$teamCodeId = this.getTeamCodeId();
                  Object other$teamCodeId = other.getTeamCodeId();
                  if (this$teamCodeId == null ? other$teamCodeId == null : this$teamCodeId.equals(other$teamCodeId)) {
                     Object this$partSchedulingStatus = this.getPartSchedulingStatus();
                     Object other$partSchedulingStatus = other.getPartSchedulingStatus();
                     if (this$partSchedulingStatus == null ? other$partSchedulingStatus == null : this$partSchedulingStatus.equals(other$partSchedulingStatus)) {
                        Object this$taskOrderId = this.getTaskOrderId();
                        Object other$taskOrderId = other.getTaskOrderId();
                        if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                           Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                           Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                           if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                              Object this$jobName = this.getJobName();
                              Object other$jobName = other.getJobName();
                              if (this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName)) {
                                 Object this$projectId = this.getProjectId();
                                 Object other$projectId = other.getProjectId();
                                 if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                    Object this$teamId = this.getTeamId();
                                    Object other$teamId = other.getTeamId();
                                    if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                       Object this$workshopId = this.getWorkshopId();
                                       Object other$workshopId = other.getWorkshopId();
                                       return this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId);
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
      return other instanceof MesBuildingBoChuJobDirectory;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $teamCodeId = this.getTeamCodeId();
      result = result * 59 + ($teamCodeId == null ? 43 : $teamCodeId.hashCode());
      Object $partSchedulingStatus = this.getPartSchedulingStatus();
      result = result * 59 + ($partSchedulingStatus == null ? 43 : $partSchedulingStatus.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $workshopId = this.getWorkshopId();
      return result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
   }

   public static class MesBuildingBoChuJobDirectoryBuilder {
      private Long id;
      private Integer jobId;
      private Integer parentId;
      private String jobName;
      private Integer jobType;
      private String projectId;
      private String teamId;
      private String workshopId;
      private Long teamCodeId;
      private Integer partSchedulingStatus;
      private Long taskOrderId;
      private Integer steelPlateTypeEnum;

      MesBuildingBoChuJobDirectoryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("parentId")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder parentId(final Integer parentId) {
         this.parentId = parentId;
         return this;
      }

      @JsonProperty("jobName")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      @JsonProperty("jobType")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder jobType(final Integer jobType) {
         this.jobType = jobType;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder projectId(final String projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder teamId(final String teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder workshopId(final String workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("teamCodeId")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder teamCodeId(final Long teamCodeId) {
         this.teamCodeId = teamCodeId;
         return this;
      }

      @JsonProperty("partSchedulingStatus")
      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder partSchedulingStatus(final Integer partSchedulingStatus) {
         this.partSchedulingStatus = partSchedulingStatus;
         return this;
      }

      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public MesBuildingBoChuJobDirectory build() {
         return new MesBuildingBoChuJobDirectory(
            this.id,
            this.jobId,
            this.parentId,
            this.jobName,
            this.jobType,
            this.projectId,
            this.teamId,
            this.workshopId,
            this.teamCodeId,
            this.partSchedulingStatus,
            this.taskOrderId,
            this.steelPlateTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuJobDirectory.MesBuildingBoChuJobDirectoryBuilder(id="
            + this.id
            + ", jobId="
            + this.jobId
            + ", parentId="
            + this.parentId
            + ", jobName="
            + this.jobName
            + ", jobType="
            + this.jobType
            + ", projectId="
            + this.projectId
            + ", teamId="
            + this.teamId
            + ", workshopId="
            + this.workshopId
            + ", teamCodeId="
            + this.teamCodeId
            + ", partSchedulingStatus="
            + this.partSchedulingStatus
            + ", taskOrderId="
            + this.taskOrderId
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ")";
      }
   }
}
