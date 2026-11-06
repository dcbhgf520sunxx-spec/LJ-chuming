package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectSettlementSaveParam {
   @NotNull(message = "项目id不能为空!")
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "level", value = "单位等级")
   private Integer level;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id/项目负责人id")
   private Long projectManagerId;
   @NotNull(message = "结算金额不能为空!")
   @ApiModelProperty(name = "settlementAmount", value = "结算额")
   private BigDecimal settlementAmount;
   @NotNull(message = "结算日期不能为空!")
   @ApiModelProperty(name = "settlementTime", value = "结算日期")
   private LocalDateTime settlementTime;
   @Size(max = 255, message = "备注字数超出限制!")
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "attachmentId", value = "附件id列表")
   private List<Long> attachmentId;

   public static ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder builder() {
      return new ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public LocalDateTime getSettlementTime() {
      return this.settlementTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setSettlementTime(final LocalDateTime settlementTime) {
      this.settlementTime = settlementTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSettlementSaveParam)) {
         return false;
      }

      ProjectSettlementSaveParam other = (ProjectSettlementSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$projectManagerId = this.getProjectManagerId();
               Object other$projectManagerId = other.getProjectManagerId();
               if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                  Object this$settlementAmount = this.getSettlementAmount();
                  Object other$settlementAmount = other.getSettlementAmount();
                  if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                     Object this$settlementTime = this.getSettlementTime();
                     Object other$settlementTime = other.getSettlementTime();
                     if (this$settlementTime == null ? other$settlementTime == null : this$settlementTime.equals(other$settlementTime)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$attachmentId = this.getAttachmentId();
                           Object other$attachmentId = other.getAttachmentId();
                           return this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof ProjectSettlementSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $settlementTime = this.getSettlementTime();
      result = result * 59 + ($settlementTime == null ? 43 : $settlementTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSettlementSaveParam(projectId="
         + this.getProjectId()
         + ", level="
         + this.getLevel()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", settlementTime="
         + this.getSettlementTime()
         + ", remark="
         + this.getRemark()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }

   public ProjectSettlementSaveParam(
      final Long projectId,
      final Integer level,
      final Long branchCompanyId,
      final Long projectManagerId,
      final BigDecimal settlementAmount,
      final LocalDateTime settlementTime,
      final String remark,
      final List<Long> attachmentId
   ) {
      this.projectId = projectId;
      this.level = level;
      this.branchCompanyId = branchCompanyId;
      this.projectManagerId = projectManagerId;
      this.settlementAmount = settlementAmount;
      this.settlementTime = settlementTime;
      this.remark = remark;
      this.attachmentId = attachmentId;
   }

   public ProjectSettlementSaveParam() {
   }

   public static class ProjectSettlementSaveParamBuilder {
      private Long projectId;
      private Integer level;
      private Long branchCompanyId;
      private Long projectManagerId;
      private BigDecimal settlementAmount;
      private LocalDateTime settlementTime;
      private String remark;
      private List<Long> attachmentId;

      ProjectSettlementSaveParamBuilder() {
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder settlementTime(final LocalDateTime settlementTime) {
         this.settlementTime = settlementTime;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder attachmentId(final List<Long> attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectSettlementSaveParam build() {
         return new ProjectSettlementSaveParam(
            this.projectId, this.level, this.branchCompanyId, this.projectManagerId, this.settlementAmount, this.settlementTime, this.remark, this.attachmentId
         );
      }

      @Override
      public String toString() {
         return "ProjectSettlementSaveParam.ProjectSettlementSaveParamBuilder(projectId="
            + this.projectId
            + ", level="
            + this.level
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", projectManagerId="
            + this.projectManagerId
            + ", settlementAmount="
            + this.settlementAmount
            + ", settlementTime="
            + this.settlementTime
            + ", remark="
            + this.remark
            + ", attachmentId="
            + this.attachmentId
            + ")";
      }
   }
}
