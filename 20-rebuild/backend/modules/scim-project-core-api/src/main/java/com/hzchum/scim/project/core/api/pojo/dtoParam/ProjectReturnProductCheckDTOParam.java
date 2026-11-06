package com.hzchum.scim.project.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectReturnProductCheckDTOParam {
   @NotNull(message = "id不能为空!")
   private Long id;
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   @NotNull(message = "审核状态不能为空!")
   private Integer auditStatus;
   @Size(max = 255, message = "审核备注超出字数限制!")
   private String auditRemark;

   public static ProjectReturnProductCheckDTOParam.ProjectReturnProductCheckDTOParamBuilder builder() {
      return new ProjectReturnProductCheckDTOParam.ProjectReturnProductCheckDTOParamBuilder();
   }

   public ProjectReturnProductCheckDTOParam(final Long id, final Integer auditStatus, final String auditRemark) {
      this.id = id;
      this.auditStatus = auditStatus;
      this.auditRemark = auditRemark;
   }

   public ProjectReturnProductCheckDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getAuditRemark() {
      return this.auditRemark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditRemark(final String auditRemark) {
      this.auditRemark = auditRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductCheckDTOParam)) {
         return false;
      }

      ProjectReturnProductCheckDTOParam other = (ProjectReturnProductCheckDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$auditRemark = this.getAuditRemark();
            Object other$auditRemark = other.getAuditRemark();
            return this$auditRemark == null ? other$auditRemark == null : this$auditRemark.equals(other$auditRemark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReturnProductCheckDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditRemark = this.getAuditRemark();
      return result * 59 + ($auditRemark == null ? 43 : $auditRemark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnProductCheckDTOParam(id=" + this.getId() + ", auditStatus=" + this.getAuditStatus() + ", auditRemark=" + this.getAuditRemark() + ")";
   }

   public static class ProjectReturnProductCheckDTOParamBuilder {
      private Long id;
      private Integer auditStatus;
      private String auditRemark;

      ProjectReturnProductCheckDTOParamBuilder() {
      }

      public ProjectReturnProductCheckDTOParam.ProjectReturnProductCheckDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReturnProductCheckDTOParam.ProjectReturnProductCheckDTOParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectReturnProductCheckDTOParam.ProjectReturnProductCheckDTOParamBuilder auditRemark(final String auditRemark) {
         this.auditRemark = auditRemark;
         return this;
      }

      public ProjectReturnProductCheckDTOParam build() {
         return new ProjectReturnProductCheckDTOParam(this.id, this.auditStatus, this.auditRemark);
      }

      @Override
      public String toString() {
         return "ProjectReturnProductCheckDTOParam.ProjectReturnProductCheckDTOParamBuilder(id="
            + this.id
            + ", auditStatus="
            + this.auditStatus
            + ", auditRemark="
            + this.auditRemark
            + ")";
      }
   }
}
