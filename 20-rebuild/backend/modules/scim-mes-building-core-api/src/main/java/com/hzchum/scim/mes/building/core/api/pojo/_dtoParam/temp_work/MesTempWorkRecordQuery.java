package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("点工记录Query")
public class MesTempWorkRecordQuery {
   @ApiModelProperty("创建开始日期")
   private LocalDate createStartDate;
   @ApiModelProperty("创建结束日期")
   private LocalDate createEndDate;
   @ApiModelProperty("上报开始日期")
   private LocalDate reportStartDate;
   @ApiModelProperty("上报结束日期")
   private LocalDate reportEndDate;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("点工类型")
   private Long tempWorkQuotaConfigId;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("审批状态")
   private Integer approvalStatus;
   @ApiModelProperty("班组名称")
   private String teamName;
   @ApiModelProperty("上报人名称")
   private String reporterName;

   public static MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder builder() {
      return new MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder();
   }

   public LocalDate getCreateStartDate() {
      return this.createStartDate;
   }

   public LocalDate getCreateEndDate() {
      return this.createEndDate;
   }

   public LocalDate getReportStartDate() {
      return this.reportStartDate;
   }

   public LocalDate getReportEndDate() {
      return this.reportEndDate;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getTempWorkQuotaConfigId() {
      return this.tempWorkQuotaConfigId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getApprovalStatus() {
      return this.approvalStatus;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getReporterName() {
      return this.reporterName;
   }

   public void setCreateStartDate(final LocalDate createStartDate) {
      this.createStartDate = createStartDate;
   }

   public void setCreateEndDate(final LocalDate createEndDate) {
      this.createEndDate = createEndDate;
   }

   public void setReportStartDate(final LocalDate reportStartDate) {
      this.reportStartDate = reportStartDate;
   }

   public void setReportEndDate(final LocalDate reportEndDate) {
      this.reportEndDate = reportEndDate;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setTempWorkQuotaConfigId(final Long tempWorkQuotaConfigId) {
      this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setReporterName(final String reporterName) {
      this.reporterName = reporterName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkRecordQuery)) {
         return false;
      }

      MesTempWorkRecordQuery other = (MesTempWorkRecordQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$tempWorkQuotaConfigId = this.getTempWorkQuotaConfigId();
         Object other$tempWorkQuotaConfigId = other.getTempWorkQuotaConfigId();
         if (this$tempWorkQuotaConfigId == null ? other$tempWorkQuotaConfigId == null : this$tempWorkQuotaConfigId.equals(other$tempWorkQuotaConfigId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$approvalStatus = this.getApprovalStatus();
               Object other$approvalStatus = other.getApprovalStatus();
               if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
                  Object this$createStartDate = this.getCreateStartDate();
                  Object other$createStartDate = other.getCreateStartDate();
                  if (this$createStartDate == null ? other$createStartDate == null : this$createStartDate.equals(other$createStartDate)) {
                     Object this$createEndDate = this.getCreateEndDate();
                     Object other$createEndDate = other.getCreateEndDate();
                     if (this$createEndDate == null ? other$createEndDate == null : this$createEndDate.equals(other$createEndDate)) {
                        Object this$reportStartDate = this.getReportStartDate();
                        Object other$reportStartDate = other.getReportStartDate();
                        if (this$reportStartDate == null ? other$reportStartDate == null : this$reportStartDate.equals(other$reportStartDate)) {
                           Object this$reportEndDate = this.getReportEndDate();
                           Object other$reportEndDate = other.getReportEndDate();
                           if (this$reportEndDate == null ? other$reportEndDate == null : this$reportEndDate.equals(other$reportEndDate)) {
                              Object this$teamName = this.getTeamName();
                              Object other$teamName = other.getTeamName();
                              if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                 Object this$reporterName = this.getReporterName();
                                 Object other$reporterName = other.getReporterName();
                                 return this$reporterName == null ? other$reporterName == null : this$reporterName.equals(other$reporterName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesTempWorkRecordQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $tempWorkQuotaConfigId = this.getTempWorkQuotaConfigId();
      result = result * 59 + ($tempWorkQuotaConfigId == null ? 43 : $tempWorkQuotaConfigId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $createStartDate = this.getCreateStartDate();
      result = result * 59 + ($createStartDate == null ? 43 : $createStartDate.hashCode());
      Object $createEndDate = this.getCreateEndDate();
      result = result * 59 + ($createEndDate == null ? 43 : $createEndDate.hashCode());
      Object $reportStartDate = this.getReportStartDate();
      result = result * 59 + ($reportStartDate == null ? 43 : $reportStartDate.hashCode());
      Object $reportEndDate = this.getReportEndDate();
      result = result * 59 + ($reportEndDate == null ? 43 : $reportEndDate.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $reporterName = this.getReporterName();
      return result * 59 + ($reporterName == null ? 43 : $reporterName.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkRecordQuery(createStartDate="
         + this.getCreateStartDate()
         + ", createEndDate="
         + this.getCreateEndDate()
         + ", reportStartDate="
         + this.getReportStartDate()
         + ", reportEndDate="
         + this.getReportEndDate()
         + ", workshopId="
         + this.getWorkshopId()
         + ", tempWorkQuotaConfigId="
         + this.getTempWorkQuotaConfigId()
         + ", projectId="
         + this.getProjectId()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ", teamName="
         + this.getTeamName()
         + ", reporterName="
         + this.getReporterName()
         + ")";
   }

   public MesTempWorkRecordQuery() {
   }

   public MesTempWorkRecordQuery(
      final LocalDate createStartDate,
      final LocalDate createEndDate,
      final LocalDate reportStartDate,
      final LocalDate reportEndDate,
      final Long workshopId,
      final Long tempWorkQuotaConfigId,
      final Long projectId,
      final Integer approvalStatus,
      final String teamName,
      final String reporterName
   ) {
      this.createStartDate = createStartDate;
      this.createEndDate = createEndDate;
      this.reportStartDate = reportStartDate;
      this.reportEndDate = reportEndDate;
      this.workshopId = workshopId;
      this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
      this.projectId = projectId;
      this.approvalStatus = approvalStatus;
      this.teamName = teamName;
      this.reporterName = reporterName;
   }

   public static class MesTempWorkRecordQueryBuilder {
      private LocalDate createStartDate;
      private LocalDate createEndDate;
      private LocalDate reportStartDate;
      private LocalDate reportEndDate;
      private Long workshopId;
      private Long tempWorkQuotaConfigId;
      private Long projectId;
      private Integer approvalStatus;
      private String teamName;
      private String reporterName;

      MesTempWorkRecordQueryBuilder() {
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder createStartDate(final LocalDate createStartDate) {
         this.createStartDate = createStartDate;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder createEndDate(final LocalDate createEndDate) {
         this.createEndDate = createEndDate;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder reportStartDate(final LocalDate reportStartDate) {
         this.reportStartDate = reportStartDate;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder reportEndDate(final LocalDate reportEndDate) {
         this.reportEndDate = reportEndDate;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder tempWorkQuotaConfigId(final Long tempWorkQuotaConfigId) {
         this.tempWorkQuotaConfigId = tempWorkQuotaConfigId;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder approvalStatus(final Integer approvalStatus) {
         this.approvalStatus = approvalStatus;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder reporterName(final String reporterName) {
         this.reporterName = reporterName;
         return this;
      }

      public MesTempWorkRecordQuery build() {
         return new MesTempWorkRecordQuery(
            this.createStartDate,
            this.createEndDate,
            this.reportStartDate,
            this.reportEndDate,
            this.workshopId,
            this.tempWorkQuotaConfigId,
            this.projectId,
            this.approvalStatus,
            this.teamName,
            this.reporterName
         );
      }

      @Override
      public String toString() {
         return "MesTempWorkRecordQuery.MesTempWorkRecordQueryBuilder(createStartDate="
            + this.createStartDate
            + ", createEndDate="
            + this.createEndDate
            + ", reportStartDate="
            + this.reportStartDate
            + ", reportEndDate="
            + this.reportEndDate
            + ", workshopId="
            + this.workshopId
            + ", tempWorkQuotaConfigId="
            + this.tempWorkQuotaConfigId
            + ", projectId="
            + this.projectId
            + ", approvalStatus="
            + this.approvalStatus
            + ", teamName="
            + this.teamName
            + ", reporterName="
            + this.reporterName
            + ")";
      }
   }
}
