package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel("点工查询参数")
public class MesTempWorkQuery {
   @ApiModelProperty("ID")
   private Long id;
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("上报人")
   private Long reporterId;
   @ApiModelProperty("审批人")
   private Long approverId;
   @ApiModelProperty("审批状态列表")
   private List<Integer> approvalStatusList;
   @ApiModelProperty("审批日志详情状态")
   private Integer approveRecordDetailStatus;

   MesTempWorkQuery(
      final Long id,
      final LocalDate startDate,
      final LocalDate endDate,
      final Long reporterId,
      final Long approverId,
      final List<Integer> approvalStatusList,
      final Integer approveRecordDetailStatus
   ) {
      this.id = id;
      this.startDate = startDate;
      this.endDate = endDate;
      this.reporterId = reporterId;
      this.approverId = approverId;
      this.approvalStatusList = approvalStatusList;
      this.approveRecordDetailStatus = approveRecordDetailStatus;
   }

   public static MesTempWorkQuery.MesTempWorkQueryBuilder builder() {
      return new MesTempWorkQuery.MesTempWorkQueryBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getReporterId() {
      return this.reporterId;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public List<Integer> getApprovalStatusList() {
      return this.approvalStatusList;
   }

   public Integer getApproveRecordDetailStatus() {
      return this.approveRecordDetailStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setReporterId(final Long reporterId) {
      this.reporterId = reporterId;
   }

   public void setApproverId(final Long approverId) {
      this.approverId = approverId;
   }

   public void setApprovalStatusList(final List<Integer> approvalStatusList) {
      this.approvalStatusList = approvalStatusList;
   }

   public void setApproveRecordDetailStatus(final Integer approveRecordDetailStatus) {
      this.approveRecordDetailStatus = approveRecordDetailStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkQuery)) {
         return false;
      }

      MesTempWorkQuery other = (MesTempWorkQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reporterId = this.getReporterId();
         Object other$reporterId = other.getReporterId();
         if (this$reporterId == null ? other$reporterId == null : this$reporterId.equals(other$reporterId)) {
            Object this$approverId = this.getApproverId();
            Object other$approverId = other.getApproverId();
            if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
               Object this$approveRecordDetailStatus = this.getApproveRecordDetailStatus();
               Object other$approveRecordDetailStatus = other.getApproveRecordDetailStatus();
               if (this$approveRecordDetailStatus == null
                  ? other$approveRecordDetailStatus == null
                  : this$approveRecordDetailStatus.equals(other$approveRecordDetailStatus)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$approvalStatusList = this.getApprovalStatusList();
                        Object other$approvalStatusList = other.getApprovalStatusList();
                        return this$approvalStatusList == null ? other$approvalStatusList == null : this$approvalStatusList.equals(other$approvalStatusList);
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
      return other instanceof MesTempWorkQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reporterId = this.getReporterId();
      result = result * 59 + ($reporterId == null ? 43 : $reporterId.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $approveRecordDetailStatus = this.getApproveRecordDetailStatus();
      result = result * 59 + ($approveRecordDetailStatus == null ? 43 : $approveRecordDetailStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $approvalStatusList = this.getApprovalStatusList();
      return result * 59 + ($approvalStatusList == null ? 43 : $approvalStatusList.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkQuery(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", reporterId="
         + this.getReporterId()
         + ", approverId="
         + this.getApproverId()
         + ", approvalStatusList="
         + this.getApprovalStatusList()
         + ", approveRecordDetailStatus="
         + this.getApproveRecordDetailStatus()
         + ")";
   }

   public static class MesTempWorkQueryBuilder {
      private Long id;
      private LocalDate startDate;
      private LocalDate endDate;
      private Long reporterId;
      private Long approverId;
      private List<Integer> approvalStatusList;
      private Integer approveRecordDetailStatus;

      MesTempWorkQueryBuilder() {
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder reporterId(final Long reporterId) {
         this.reporterId = reporterId;
         return this;
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder approvalStatusList(final List<Integer> approvalStatusList) {
         this.approvalStatusList = approvalStatusList;
         return this;
      }

      public MesTempWorkQuery.MesTempWorkQueryBuilder approveRecordDetailStatus(final Integer approveRecordDetailStatus) {
         this.approveRecordDetailStatus = approveRecordDetailStatus;
         return this;
      }

      public MesTempWorkQuery build() {
         return new MesTempWorkQuery(
            this.id, this.startDate, this.endDate, this.reporterId, this.approverId, this.approvalStatusList, this.approveRecordDetailStatus
         );
      }

      @Override
      public String toString() {
         return "MesTempWorkQuery.MesTempWorkQueryBuilder(id="
            + this.id
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", reporterId="
            + this.reporterId
            + ", approverId="
            + this.approverId
            + ", approvalStatusList="
            + this.approvalStatusList
            + ", approveRecordDetailStatus="
            + this.approveRecordDetailStatus
            + ")";
      }
   }
}
