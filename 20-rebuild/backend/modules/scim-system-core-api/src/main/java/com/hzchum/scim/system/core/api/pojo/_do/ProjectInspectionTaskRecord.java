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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "projectInspectionTaskRecord对象", description = "巡检任务记录表")
@Entity
@TableName("project_inspection_task_record")
@Table(name = "project_inspection_task_record")
@org.hibernate.annotations.Table(appliesTo = "project_inspection_task_record", comment = "巡检任务记录表 ")
public class ProjectInspectionTaskRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectInspectionUserLinkId", value = "巡检线记录表id", notes = "巡检线记录表id")
   @JsonProperty("projectInspectionUserLinkId")
   @JSONField(name = "projectInspectionUserLinkId")
   @TableField("project_inspection_user_link_id")
   @Column(name = "project_inspection_user_link_id", columnDefinition = "int(11)  COMMENT '巡检线记录表id'")
   private Long projectInspectionUserLinkId;
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
   @ApiModelProperty(name = "inspectionTime", value = "巡检扫码时间", notes = "巡检扫码时间")
   @JsonProperty("inspectionTime")
   @JSONField(name = "inspectionTime")
   @TableField("inspection_time")
   @Column(name = "inspection_time", columnDefinition = "datetime  COMMENT '巡检扫码时间'")
   private LocalDateTime inspectionTime;
   @ApiModelProperty(name = "attachmentIds", value = "附件id", notes = "附件id")
   @JsonProperty("attachmentIds")
   @JSONField(name = "attachmentIds")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id'")
   private String attachmentIds;
   @ApiModelProperty(name = "projectInspectionId", value = "巡检点位id", notes = "巡检点位id")
   @JsonProperty("projectInspectionId")
   @JSONField(name = "projectInspectionId")
   @TableField("project_inspection_id")
   @Column(name = "project_inspection_id", columnDefinition = "int(11)  COMMENT '巡检点位id'")
   private Long projectInspectionId;
   @ApiModelProperty(name = "point", notes = "点位")
   @JsonProperty("point")
   @JSONField(name = "point")
   @TableField("point")
   @Column(name = "point", columnDefinition = "varchar(255)  COMMENT '点位'")
   private String point;
   @ApiModelProperty(name = "remark", value = "巡检备注", notes = "巡检备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(2048)  COMMENT '巡检备注'")
   private String remark;

   public static ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder builder() {
      return new ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder();
   }

   public ProjectInspectionTaskRecord() {
   }

   public ProjectInspectionTaskRecord(
      final Long id,
      final Long projectInspectionUserLinkId,
      final LocalDate inspectionDate,
      final Long userId,
      final LocalDateTime inspectionTime,
      final String attachmentIds,
      final Long projectInspectionId,
      final String point,
      final String remark
   ) {
      this.id = id;
      this.projectInspectionUserLinkId = projectInspectionUserLinkId;
      this.inspectionDate = inspectionDate;
      this.userId = userId;
      this.inspectionTime = inspectionTime;
      this.attachmentIds = attachmentIds;
      this.projectInspectionId = projectInspectionId;
      this.point = point;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectInspectionUserLinkId() {
      return this.projectInspectionUserLinkId;
   }

   public LocalDate getInspectionDate() {
      return this.inspectionDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public LocalDateTime getInspectionTime() {
      return this.inspectionTime;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Long getProjectInspectionId() {
      return this.projectInspectionId;
   }

   public String getPoint() {
      return this.point;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public ProjectInspectionTaskRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectInspectionUserLinkId")
   public ProjectInspectionTaskRecord setProjectInspectionUserLinkId(final Long projectInspectionUserLinkId) {
      this.projectInspectionUserLinkId = projectInspectionUserLinkId;
      return this;
   }

   @JsonProperty("inspectionDate")
   public ProjectInspectionTaskRecord setInspectionDate(final LocalDate inspectionDate) {
      this.inspectionDate = inspectionDate;
      return this;
   }

   @JsonProperty("userId")
   public ProjectInspectionTaskRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("inspectionTime")
   public ProjectInspectionTaskRecord setInspectionTime(final LocalDateTime inspectionTime) {
      this.inspectionTime = inspectionTime;
      return this;
   }

   @JsonProperty("attachmentIds")
   public ProjectInspectionTaskRecord setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("projectInspectionId")
   public ProjectInspectionTaskRecord setProjectInspectionId(final Long projectInspectionId) {
      this.projectInspectionId = projectInspectionId;
      return this;
   }

   @JsonProperty("point")
   public ProjectInspectionTaskRecord setPoint(final String point) {
      this.point = point;
      return this;
   }

   @JsonProperty("remark")
   public ProjectInspectionTaskRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionTaskRecord(id="
         + this.getId()
         + ", projectInspectionUserLinkId="
         + this.getProjectInspectionUserLinkId()
         + ", inspectionDate="
         + this.getInspectionDate()
         + ", userId="
         + this.getUserId()
         + ", inspectionTime="
         + this.getInspectionTime()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", projectInspectionId="
         + this.getProjectInspectionId()
         + ", point="
         + this.getPoint()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionTaskRecord)) {
         return false;
      }

      ProjectInspectionTaskRecord other = (ProjectInspectionTaskRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectInspectionUserLinkId = this.getProjectInspectionUserLinkId();
         Object other$projectInspectionUserLinkId = other.getProjectInspectionUserLinkId();
         if (this$projectInspectionUserLinkId == null
            ? other$projectInspectionUserLinkId == null
            : this$projectInspectionUserLinkId.equals(other$projectInspectionUserLinkId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$projectInspectionId = this.getProjectInspectionId();
               Object other$projectInspectionId = other.getProjectInspectionId();
               if (this$projectInspectionId == null ? other$projectInspectionId == null : this$projectInspectionId.equals(other$projectInspectionId)) {
                  Object this$inspectionDate = this.getInspectionDate();
                  Object other$inspectionDate = other.getInspectionDate();
                  if (this$inspectionDate == null ? other$inspectionDate == null : this$inspectionDate.equals(other$inspectionDate)) {
                     Object this$inspectionTime = this.getInspectionTime();
                     Object other$inspectionTime = other.getInspectionTime();
                     if (this$inspectionTime == null ? other$inspectionTime == null : this$inspectionTime.equals(other$inspectionTime)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$point = this.getPoint();
                           Object other$point = other.getPoint();
                           if (this$point == null ? other$point == null : this$point.equals(other$point)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ProjectInspectionTaskRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectInspectionUserLinkId = this.getProjectInspectionUserLinkId();
      result = result * 59 + ($projectInspectionUserLinkId == null ? 43 : $projectInspectionUserLinkId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectInspectionId = this.getProjectInspectionId();
      result = result * 59 + ($projectInspectionId == null ? 43 : $projectInspectionId.hashCode());
      Object $inspectionDate = this.getInspectionDate();
      result = result * 59 + ($inspectionDate == null ? 43 : $inspectionDate.hashCode());
      Object $inspectionTime = this.getInspectionTime();
      result = result * 59 + ($inspectionTime == null ? 43 : $inspectionTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ProjectInspectionTaskRecordBuilder {
      private Long id;
      private Long projectInspectionUserLinkId;
      private LocalDate inspectionDate;
      private Long userId;
      private LocalDateTime inspectionTime;
      private String attachmentIds;
      private Long projectInspectionId;
      private String point;
      private String remark;

      ProjectInspectionTaskRecordBuilder() {
      }

      @JsonProperty("id")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectInspectionUserLinkId")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder projectInspectionUserLinkId(final Long projectInspectionUserLinkId) {
         this.projectInspectionUserLinkId = projectInspectionUserLinkId;
         return this;
      }

      @JsonProperty("inspectionDate")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder inspectionDate(final LocalDate inspectionDate) {
         this.inspectionDate = inspectionDate;
         return this;
      }

      @JsonProperty("userId")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("inspectionTime")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder inspectionTime(final LocalDateTime inspectionTime) {
         this.inspectionTime = inspectionTime;
         return this;
      }

      @JsonProperty("attachmentIds")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("projectInspectionId")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder projectInspectionId(final Long projectInspectionId) {
         this.projectInspectionId = projectInspectionId;
         return this;
      }

      @JsonProperty("point")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder point(final String point) {
         this.point = point;
         return this;
      }

      @JsonProperty("remark")
      public ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectInspectionTaskRecord build() {
         return new ProjectInspectionTaskRecord(
            this.id,
            this.projectInspectionUserLinkId,
            this.inspectionDate,
            this.userId,
            this.inspectionTime,
            this.attachmentIds,
            this.projectInspectionId,
            this.point,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionTaskRecord.ProjectInspectionTaskRecordBuilder(id="
            + this.id
            + ", projectInspectionUserLinkId="
            + this.projectInspectionUserLinkId
            + ", inspectionDate="
            + this.inspectionDate
            + ", userId="
            + this.userId
            + ", inspectionTime="
            + this.inspectionTime
            + ", attachmentIds="
            + this.attachmentIds
            + ", projectInspectionId="
            + this.projectInspectionId
            + ", point="
            + this.point
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
