package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ProjectLineApplyRemovePointDTOParam", description = "巡检删除申请Param")
public class ProjectLineApplyRemovePointDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目", notes = "项目")
   @NotNull(message = "项目不能为空！")
   private Long projectId;
   @ApiModelProperty(name = "pointIds", value = "待删除的点位", notes = "待删除的点位")
   @NotEmpty(message = "待删点位不能为空！")
   @Size(min = 1, message = "待删点位不能为空！")
   private List<Long> pointIds;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "applyAnnexIds", value = "申请附件")
   @NotEmpty(message = "申请附件不能为空！")
   @Size(min = 1, message = "申请附件不能为空！")
   private List<Long> applyAnnexIds;

   public static ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder builder() {
      return new ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder();
   }

   public ProjectLineApplyRemovePointDTOParam() {
   }

   public ProjectLineApplyRemovePointDTOParam(final Long projectId, final List<Long> pointIds, final String remark, final List<Long> applyAnnexIds) {
      this.projectId = projectId;
      this.pointIds = pointIds;
      this.remark = remark;
      this.applyAnnexIds = applyAnnexIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getPointIds() {
      return this.pointIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getApplyAnnexIds() {
      return this.applyAnnexIds;
   }

   public ProjectLineApplyRemovePointDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectLineApplyRemovePointDTOParam setPointIds(final List<Long> pointIds) {
      this.pointIds = pointIds;
      return this;
   }

   public ProjectLineApplyRemovePointDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectLineApplyRemovePointDTOParam setApplyAnnexIds(final List<Long> applyAnnexIds) {
      this.applyAnnexIds = applyAnnexIds;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLineApplyRemovePointDTOParam)) {
         return false;
      }

      ProjectLineApplyRemovePointDTOParam other = (ProjectLineApplyRemovePointDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$pointIds = this.getPointIds();
         Object other$pointIds = other.getPointIds();
         if (this$pointIds == null ? other$pointIds == null : this$pointIds.equals(other$pointIds)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$applyAnnexIds = this.getApplyAnnexIds();
               Object other$applyAnnexIds = other.getApplyAnnexIds();
               return this$applyAnnexIds == null ? other$applyAnnexIds == null : this$applyAnnexIds.equals(other$applyAnnexIds);
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
      return other instanceof ProjectLineApplyRemovePointDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $pointIds = this.getPointIds();
      result = result * 59 + ($pointIds == null ? 43 : $pointIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $applyAnnexIds = this.getApplyAnnexIds();
      return result * 59 + ($applyAnnexIds == null ? 43 : $applyAnnexIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLineApplyRemovePointDTOParam(projectId="
         + this.getProjectId()
         + ", pointIds="
         + this.getPointIds()
         + ", remark="
         + this.getRemark()
         + ", applyAnnexIds="
         + this.getApplyAnnexIds()
         + ")";
   }

   public static class ProjectLineApplyRemovePointDTOParamBuilder {
      private Long projectId;
      private List<Long> pointIds;
      private String remark;
      private List<Long> applyAnnexIds;

      ProjectLineApplyRemovePointDTOParamBuilder() {
      }

      public ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder pointIds(final List<Long> pointIds) {
         this.pointIds = pointIds;
         return this;
      }

      public ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder applyAnnexIds(final List<Long> applyAnnexIds) {
         this.applyAnnexIds = applyAnnexIds;
         return this;
      }

      public ProjectLineApplyRemovePointDTOParam build() {
         return new ProjectLineApplyRemovePointDTOParam(this.projectId, this.pointIds, this.remark, this.applyAnnexIds);
      }

      @Override
      public String toString() {
         return "ProjectLineApplyRemovePointDTOParam.ProjectLineApplyRemovePointDTOParamBuilder(projectId="
            + this.projectId
            + ", pointIds="
            + this.pointIds
            + ", remark="
            + this.remark
            + ", applyAnnexIds="
            + this.applyAnnexIds
            + ")";
      }
   }
}
