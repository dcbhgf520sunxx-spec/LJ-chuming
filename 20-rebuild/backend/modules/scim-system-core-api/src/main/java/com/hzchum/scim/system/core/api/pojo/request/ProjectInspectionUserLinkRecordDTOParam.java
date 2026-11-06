package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectInspectionUserLinkRecordDTOParam", description = "巡检删除申请记录Param")
public class ProjectInspectionUserLinkRecordDTOParam {
   @ApiModelProperty(name = "inspectionUserId", value = "巡检线", notes = "巡检线")
   private Long inspectionUserId;
   @ApiModelProperty(name = "projectId", value = "项目", notes = "项目")
   private Long projectId;
   @ApiModelProperty(name = "removePointJson", value = "待删除的点位", notes = "待删除的点位")
   private String removePointJson;
   @ApiModelProperty(name = "applyAnnexJson", value = "申请附件")
   private String applyAnnexJson;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "申请人", notes = "申请人")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "申请人", notes = "申请人")
   private String createUserName;
   @ApiModelProperty(name = "canAuditId", value = "可审核人", notes = "可审核人")
   private Long canAuditId;

   public static ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder builder() {
      return new ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder();
   }

   public ProjectInspectionUserLinkRecordDTOParam() {
   }

   public ProjectInspectionUserLinkRecordDTOParam(
      final Long inspectionUserId,
      final Long projectId,
      final String removePointJson,
      final String applyAnnexJson,
      final String remark,
      final Long createUserId,
      final String createUserName,
      final Long canAuditId
   ) {
      this.inspectionUserId = inspectionUserId;
      this.projectId = projectId;
      this.removePointJson = removePointJson;
      this.applyAnnexJson = applyAnnexJson;
      this.remark = remark;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.canAuditId = canAuditId;
   }

   public Long getInspectionUserId() {
      return this.inspectionUserId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemovePointJson() {
      return this.removePointJson;
   }

   public String getApplyAnnexJson() {
      return this.applyAnnexJson;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCanAuditId() {
      return this.canAuditId;
   }

   public ProjectInspectionUserLinkRecordDTOParam setInspectionUserId(final Long inspectionUserId) {
      this.inspectionUserId = inspectionUserId;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setRemovePointJson(final String removePointJson) {
      this.removePointJson = removePointJson;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setApplyAnnexJson(final String applyAnnexJson) {
      this.applyAnnexJson = applyAnnexJson;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public ProjectInspectionUserLinkRecordDTOParam setCanAuditId(final Long canAuditId) {
      this.canAuditId = canAuditId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionUserLinkRecordDTOParam)) {
         return false;
      }

      ProjectInspectionUserLinkRecordDTOParam other = (ProjectInspectionUserLinkRecordDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inspectionUserId = this.getInspectionUserId();
      Object other$inspectionUserId = other.getInspectionUserId();
      if (this$inspectionUserId == null ? other$inspectionUserId == null : this$inspectionUserId.equals(other$inspectionUserId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$canAuditId = this.getCanAuditId();
               Object other$canAuditId = other.getCanAuditId();
               if (this$canAuditId == null ? other$canAuditId == null : this$canAuditId.equals(other$canAuditId)) {
                  Object this$removePointJson = this.getRemovePointJson();
                  Object other$removePointJson = other.getRemovePointJson();
                  if (this$removePointJson == null ? other$removePointJson == null : this$removePointJson.equals(other$removePointJson)) {
                     Object this$applyAnnexJson = this.getApplyAnnexJson();
                     Object other$applyAnnexJson = other.getApplyAnnexJson();
                     if (this$applyAnnexJson == null ? other$applyAnnexJson == null : this$applyAnnexJson.equals(other$applyAnnexJson)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInspectionUserLinkRecordDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inspectionUserId = this.getInspectionUserId();
      result = result * 59 + ($inspectionUserId == null ? 43 : $inspectionUserId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $canAuditId = this.getCanAuditId();
      result = result * 59 + ($canAuditId == null ? 43 : $canAuditId.hashCode());
      Object $removePointJson = this.getRemovePointJson();
      result = result * 59 + ($removePointJson == null ? 43 : $removePointJson.hashCode());
      Object $applyAnnexJson = this.getApplyAnnexJson();
      result = result * 59 + ($applyAnnexJson == null ? 43 : $applyAnnexJson.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInspectionUserLinkRecordDTOParam(inspectionUserId="
         + this.getInspectionUserId()
         + ", projectId="
         + this.getProjectId()
         + ", removePointJson="
         + this.getRemovePointJson()
         + ", applyAnnexJson="
         + this.getApplyAnnexJson()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", canAuditId="
         + this.getCanAuditId()
         + ")";
   }

   public static class ProjectInspectionUserLinkRecordDTOParamBuilder {
      private Long inspectionUserId;
      private Long projectId;
      private String removePointJson;
      private String applyAnnexJson;
      private String remark;
      private Long createUserId;
      private String createUserName;
      private Long canAuditId;

      ProjectInspectionUserLinkRecordDTOParamBuilder() {
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder inspectionUserId(final Long inspectionUserId) {
         this.inspectionUserId = inspectionUserId;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder removePointJson(final String removePointJson) {
         this.removePointJson = removePointJson;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder applyAnnexJson(final String applyAnnexJson) {
         this.applyAnnexJson = applyAnnexJson;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder canAuditId(final Long canAuditId) {
         this.canAuditId = canAuditId;
         return this;
      }

      public ProjectInspectionUserLinkRecordDTOParam build() {
         return new ProjectInspectionUserLinkRecordDTOParam(
            this.inspectionUserId,
            this.projectId,
            this.removePointJson,
            this.applyAnnexJson,
            this.remark,
            this.createUserId,
            this.createUserName,
            this.canAuditId
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionUserLinkRecordDTOParam.ProjectInspectionUserLinkRecordDTOParamBuilder(inspectionUserId="
            + this.inspectionUserId
            + ", projectId="
            + this.projectId
            + ", removePointJson="
            + this.removePointJson
            + ", applyAnnexJson="
            + this.applyAnnexJson
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", canAuditId="
            + this.canAuditId
            + ")";
      }
   }
}
