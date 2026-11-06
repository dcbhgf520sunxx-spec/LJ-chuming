package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectInspectionTaskRecordDTOParam", description = "巡检记录Param")
public class ProjectInspectionTaskRecordDTOParam {
   @ApiModelProperty(name = "projectInspectionId", notes = "巡检点位id")
   private Long projectInspectionId;
   @ApiModelProperty(name = "point", notes = "点位")
   private String point;
   @ApiModelProperty(name = "attachmentIds", notes = "巡检照片id集合")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", notes = "巡检备注")
   private String remark;

   public static ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder builder() {
      return new ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder();
   }

   public ProjectInspectionTaskRecordDTOParam() {
   }

   public ProjectInspectionTaskRecordDTOParam(final Long projectInspectionId, final String point, final List<Long> attachmentIds, final String remark) {
      this.projectInspectionId = projectInspectionId;
      this.point = point;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getProjectInspectionId() {
      return this.projectInspectionId;
   }

   public String getPoint() {
      return this.point;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public ProjectInspectionTaskRecordDTOParam setProjectInspectionId(final Long projectInspectionId) {
      this.projectInspectionId = projectInspectionId;
      return this;
   }

   public ProjectInspectionTaskRecordDTOParam setPoint(final String point) {
      this.point = point;
      return this;
   }

   public ProjectInspectionTaskRecordDTOParam setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ProjectInspectionTaskRecordDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionTaskRecordDTOParam)) {
         return false;
      }

      ProjectInspectionTaskRecordDTOParam other = (ProjectInspectionTaskRecordDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectInspectionId = this.getProjectInspectionId();
      Object other$projectInspectionId = other.getProjectInspectionId();
      if (this$projectInspectionId == null ? other$projectInspectionId == null : this$projectInspectionId.equals(other$projectInspectionId)) {
         Object this$point = this.getPoint();
         Object other$point = other.getPoint();
         if (this$point == null ? other$point == null : this$point.equals(other$point)) {
            Object this$attachmentIds = this.getAttachmentIds();
            Object other$attachmentIds = other.getAttachmentIds();
            if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionTaskRecordDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectInspectionId = this.getProjectInspectionId();
      result = result * 59 + ($projectInspectionId == null ? 43 : $projectInspectionId.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInspectionTaskRecordDTOParam(projectInspectionId="
         + this.getProjectInspectionId()
         + ", point="
         + this.getPoint()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ProjectInspectionTaskRecordDTOParamBuilder {
      private Long projectInspectionId;
      private String point;
      private List<Long> attachmentIds;
      private String remark;

      ProjectInspectionTaskRecordDTOParamBuilder() {
      }

      public ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder projectInspectionId(final Long projectInspectionId) {
         this.projectInspectionId = projectInspectionId;
         return this;
      }

      public ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectInspectionTaskRecordDTOParam build() {
         return new ProjectInspectionTaskRecordDTOParam(this.projectInspectionId, this.point, this.attachmentIds, this.remark);
      }

      @Override
      public String toString() {
         return "ProjectInspectionTaskRecordDTOParam.ProjectInspectionTaskRecordDTOParamBuilder(projectInspectionId="
            + this.projectInspectionId
            + ", point="
            + this.point
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
