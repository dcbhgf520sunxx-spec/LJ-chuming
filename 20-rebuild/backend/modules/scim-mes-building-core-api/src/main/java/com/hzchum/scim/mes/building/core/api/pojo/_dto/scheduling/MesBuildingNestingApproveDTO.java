package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingNestingApproveDTO", description = "每个月份需要排产的数量")
public class MesBuildingNestingApproveDTO {
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "wmsApproveRecordId", value = "审批记录id", notes = "审批记录id")
   @JsonProperty("wmsApproveRecordId")
   @JSONField(name = "wmsApproveRecordId")
   private Long wmsApproveRecordId;
   @ApiModelProperty(name = "orderNumber", value = "工单编号", notes = "工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "jobId", value = "作业id", notes = "作业id")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   private Long jobId;
   @ApiModelProperty(
      name = "reviewStatus",
      value = "2审核通过  4审核退回 8撤销 16审核中 32意外中断 ReviewStatusEnum 默认16 审核中",
      notes = "2审核通过  4审核退回 8撤销 16审核中 ReviewStatusEnum 默认16 审核中"
   )
   private Integer reviewStatus;

   public static MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder builder() {
      return new MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder();
   }

   public MesBuildingNestingApproveDTO(
      final Long schedulingId, final Long wmsApproveRecordId, final String orderNumber, final Long jobId, final Integer reviewStatus
   ) {
      this.schedulingId = schedulingId;
      this.wmsApproveRecordId = wmsApproveRecordId;
      this.orderNumber = orderNumber;
      this.jobId = jobId;
      this.reviewStatus = reviewStatus;
   }

   public MesBuildingNestingApproveDTO() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getWmsApproveRecordId() {
      return this.wmsApproveRecordId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getJobId() {
      return this.jobId;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   @JsonProperty("schedulingId")
   public MesBuildingNestingApproveDTO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("wmsApproveRecordId")
   public MesBuildingNestingApproveDTO setWmsApproveRecordId(final Long wmsApproveRecordId) {
      this.wmsApproveRecordId = wmsApproveRecordId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingNestingApproveDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingNestingApproveDTO setJobId(final Long jobId) {
      this.jobId = jobId;
      return this;
   }

   public MesBuildingNestingApproveDTO setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestingApproveDTO(schedulingId="
         + this.getSchedulingId()
         + ", wmsApproveRecordId="
         + this.getWmsApproveRecordId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", jobId="
         + this.getJobId()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingApproveDTO)) {
         return false;
      }

      MesBuildingNestingApproveDTO other = (MesBuildingNestingApproveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$wmsApproveRecordId = this.getWmsApproveRecordId();
         Object other$wmsApproveRecordId = other.getWmsApproveRecordId();
         if (this$wmsApproveRecordId == null ? other$wmsApproveRecordId == null : this$wmsApproveRecordId.equals(other$wmsApproveRecordId)) {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$orderNumber = this.getOrderNumber();
                  Object other$orderNumber = other.getOrderNumber();
                  return this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber);
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
      return other instanceof MesBuildingNestingApproveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $wmsApproveRecordId = this.getWmsApproveRecordId();
      result = result * 59 + ($wmsApproveRecordId == null ? 43 : $wmsApproveRecordId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public static class MesBuildingNestingApproveDTOBuilder {
      private Long schedulingId;
      private Long wmsApproveRecordId;
      private String orderNumber;
      private Long jobId;
      private Integer reviewStatus;

      MesBuildingNestingApproveDTOBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("wmsApproveRecordId")
      public MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder wmsApproveRecordId(final Long wmsApproveRecordId) {
         this.wmsApproveRecordId = wmsApproveRecordId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder jobId(final Long jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public MesBuildingNestingApproveDTO build() {
         return new MesBuildingNestingApproveDTO(this.schedulingId, this.wmsApproveRecordId, this.orderNumber, this.jobId, this.reviewStatus);
      }

      @Override
      public String toString() {
         return "MesBuildingNestingApproveDTO.MesBuildingNestingApproveDTOBuilder(schedulingId="
            + this.schedulingId
            + ", wmsApproveRecordId="
            + this.wmsApproveRecordId
            + ", orderNumber="
            + this.orderNumber
            + ", jobId="
            + this.jobId
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
