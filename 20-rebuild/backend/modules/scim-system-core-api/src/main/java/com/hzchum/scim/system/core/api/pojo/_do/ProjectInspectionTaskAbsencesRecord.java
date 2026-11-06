package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectInspectionTaskAbsencesRecord对象", description = "巡检任务缺卡记录表")
@Entity
@TableName("project_inspection_task_absences_record")
@Table(name = "project_inspection_task_absences_record")
@org.hibernate.annotations.Table(appliesTo = "project_inspection_task_absences_record", comment = "巡检任务缺卡记录表 ")
public class ProjectInspectionTaskAbsencesRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inspectionDate", notes = "巡检日期（同缺卡日期）")
   @JsonProperty("inspectionDate")
   @JSONField(name = "inspectionDate")
   @TableField("inspection_date")
   @Column(name = "inspection_date", columnDefinition = "date  COMMENT '巡检日期（同缺卡日期）'")
   private LocalDate inspectionDate;
   @ApiModelProperty(name = "userId", notes = "缺卡用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '缺卡用户id'")
   private Long userId;
   @ApiModelProperty(name = "projectInspectionId", value = "巡检点位id", notes = "巡检点位id")
   @JsonProperty("projectInspectionId")
   @JSONField(name = "projectInspectionId")
   @TableField("project_inspection_id")
   @Column(name = "project_inspection_id", columnDefinition = "int(11)  COMMENT '巡检点位id'")
   private Long projectInspectionId;

   public static ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder builder() {
      return new ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder();
   }

   public ProjectInspectionTaskAbsencesRecord() {
   }

   public ProjectInspectionTaskAbsencesRecord(final Long id, final LocalDate inspectionDate, final Long userId, final Long projectInspectionId) {
      this.id = id;
      this.inspectionDate = inspectionDate;
      this.userId = userId;
      this.projectInspectionId = projectInspectionId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getInspectionDate() {
      return this.inspectionDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectInspectionId() {
      return this.projectInspectionId;
   }

   @JsonProperty("id")
   public ProjectInspectionTaskAbsencesRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inspectionDate")
   public ProjectInspectionTaskAbsencesRecord setInspectionDate(final LocalDate inspectionDate) {
      this.inspectionDate = inspectionDate;
      return this;
   }

   @JsonProperty("userId")
   public ProjectInspectionTaskAbsencesRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("projectInspectionId")
   public ProjectInspectionTaskAbsencesRecord setProjectInspectionId(final Long projectInspectionId) {
      this.projectInspectionId = projectInspectionId;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionTaskAbsencesRecord(id="
         + this.getId()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", userId="
         + this.getUserId()
         + ", projectInspectionId="
         + this.getProjectInspectionId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionTaskAbsencesRecord)) {
         return false;
      }

      ProjectInspectionTaskAbsencesRecord other = (ProjectInspectionTaskAbsencesRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectInspectionId = this.getProjectInspectionId();
            Object other$projectInspectionId = other.getProjectInspectionId();
            if (this$projectInspectionId == null ? other$projectInspectionId == null : this$projectInspectionId.equals(other$projectInspectionId)) {
               Object this$inspectionDate = this.getInspectionDate();
               Object other$inspectionDate = other.getInspectionDate();
               return this$inspectionDate == null ? other$inspectionDate == null : this$inspectionDate.equals(other$inspectionDate);
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
      return other instanceof ProjectInspectionTaskAbsencesRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectInspectionId = this.getProjectInspectionId();
      result = result * 59 + ($projectInspectionId == null ? 43 : $projectInspectionId.hashCode());
      Object $inspectionDate = this.getInspectionDate();
      return result * 59 + ($inspectionDate == null ? 43 : $inspectionDate.hashCode());
   }

   public static class ProjectInspectionTaskAbsencesRecordBuilder {
      private Long id;
      private LocalDate inspectionDate;
      private Long userId;
      private Long projectInspectionId;

      ProjectInspectionTaskAbsencesRecordBuilder() {
      }

      @JsonProperty("id")
      public ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inspectionDate")
      public ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder inspectionDate(final LocalDate inspectionDate) {
         this.inspectionDate = inspectionDate;
         return this;
      }

      @JsonProperty("userId")
      public ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("projectInspectionId")
      public ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder projectInspectionId(final Long projectInspectionId) {
         this.projectInspectionId = projectInspectionId;
         return this;
      }

      public ProjectInspectionTaskAbsencesRecord build() {
         return new ProjectInspectionTaskAbsencesRecord(this.id, this.inspectionDate, this.userId, this.projectInspectionId);
      }

      @Override
      public String toString() {
         return "ProjectInspectionTaskAbsencesRecord.ProjectInspectionTaskAbsencesRecordBuilder(id="
            + this.id
            + ", inspectionDate="
            + this.inspectionDate
            + ", userId="
            + this.userId
            + ", projectInspectionId="
            + this.projectInspectionId
            + ")";
      }
   }
}
