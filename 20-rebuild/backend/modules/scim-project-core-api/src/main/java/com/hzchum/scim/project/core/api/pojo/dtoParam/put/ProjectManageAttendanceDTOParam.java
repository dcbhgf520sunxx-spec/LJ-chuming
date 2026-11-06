package com.hzchum.scim.project.core.api.pojo.dtoParam.put;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.project.core.api.enums.ClockInTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectManageAttendanceDTOParam", description = "app劳务考勤打卡参数")
public class ProjectManageAttendanceDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "supplierId", notes = "分包id")
   private Long supplierId;
   @ApiModelProperty(name = "clockInTypeEnum", notes = "打卡所属类型")
   @NotNull(message = "打卡类型不能为空！,请刷新后重试！")
   @EnumValidator(value = ClockInTypeEnum.class, message = "打卡类型不正确！")
   private Integer clockInTypeEnum;
   @ApiModelProperty(name = "point", notes = "打卡点位")
   private String point;
   @ApiModelProperty(name = "attachmentIds", notes = "照片")
   private List<Long> attachmentIds;

   public static ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder builder() {
      return new ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder();
   }

   public ProjectManageAttendanceDTOParam() {
   }

   public ProjectManageAttendanceDTOParam(
      final Long projectId, final Long supplierId, final Integer clockInTypeEnum, final String point, final List<Long> attachmentIds
   ) {
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.clockInTypeEnum = clockInTypeEnum;
      this.point = point;
      this.attachmentIds = attachmentIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getClockInTypeEnum() {
      return this.clockInTypeEnum;
   }

   public String getPoint() {
      return this.point;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setClockInTypeEnum(final Integer clockInTypeEnum) {
      this.clockInTypeEnum = clockInTypeEnum;
   }

   public void setPoint(final String point) {
      this.point = point;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageAttendanceDTOParam)) {
         return false;
      }

      ProjectManageAttendanceDTOParam other = (ProjectManageAttendanceDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$clockInTypeEnum = this.getClockInTypeEnum();
            Object other$clockInTypeEnum = other.getClockInTypeEnum();
            if (this$clockInTypeEnum == null ? other$clockInTypeEnum == null : this$clockInTypeEnum.equals(other$clockInTypeEnum)) {
               Object this$point = this.getPoint();
               Object other$point = other.getPoint();
               if (this$point == null ? other$point == null : this$point.equals(other$point)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManageAttendanceDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $clockInTypeEnum = this.getClockInTypeEnum();
      result = result * 59 + ($clockInTypeEnum == null ? 43 : $clockInTypeEnum.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectManageAttendanceDTOParam(projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", clockInTypeEnum="
         + this.getClockInTypeEnum()
         + ", point="
         + this.getPoint()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   public static class ProjectManageAttendanceDTOParamBuilder {
      private Long projectId;
      private Long supplierId;
      private Integer clockInTypeEnum;
      private String point;
      private List<Long> attachmentIds;

      ProjectManageAttendanceDTOParamBuilder() {
      }

      public ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder clockInTypeEnum(final Integer clockInTypeEnum) {
         this.clockInTypeEnum = clockInTypeEnum;
         return this;
      }

      public ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectManageAttendanceDTOParam build() {
         return new ProjectManageAttendanceDTOParam(this.projectId, this.supplierId, this.clockInTypeEnum, this.point, this.attachmentIds);
      }

      @Override
      public String toString() {
         return "ProjectManageAttendanceDTOParam.ProjectManageAttendanceDTOParamBuilder(projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", clockInTypeEnum="
            + this.clockInTypeEnum
            + ", point="
            + this.point
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
