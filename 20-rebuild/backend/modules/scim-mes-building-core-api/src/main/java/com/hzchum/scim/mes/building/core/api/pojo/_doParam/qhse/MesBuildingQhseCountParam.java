package com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingQhseCountParam对象", description = "问题汇总对象 ")
public class MesBuildingQhseCountParam {
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "完成日期")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", value = "车间id")
   private Long workShopId;
   @ApiModelProperty(name = "status", value = "状态0全部1需质检2无质检")
   private Integer status;
   @ApiModelProperty(name = "insepctUserIds", value = "质检员列表")
   private List<Long> insepctUserIds;
   @ApiModelProperty(name = "insepectUserId", value = "质检员筛选id")
   private Long insepectUserId;
   @ApiModelProperty(name = "serialNumber", value = "车间id")
   private String serialNumber;

   public static MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder builder() {
      return new MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder();
   }

   public MesBuildingQhseCountParam() {
   }

   public MesBuildingQhseCountParam(
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Long projectId,
      final Long workShopId,
      final Integer status,
      final List<Long> insepctUserIds,
      final Long insepectUserId,
      final String serialNumber
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.status = status;
      this.insepctUserIds = insepctUserIds;
      this.insepectUserId = insepectUserId;
      this.serialNumber = serialNumber;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<Long> getInsepctUserIds() {
      return this.insepctUserIds;
   }

   public Long getInsepectUserId() {
      return this.insepectUserId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public MesBuildingQhseCountParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public MesBuildingQhseCountParam setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public MesBuildingQhseCountParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingQhseCountParam setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   public MesBuildingQhseCountParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public MesBuildingQhseCountParam setInsepctUserIds(final List<Long> insepctUserIds) {
      this.insepctUserIds = insepctUserIds;
      return this;
   }

   public MesBuildingQhseCountParam setInsepectUserId(final Long insepectUserId) {
      this.insepectUserId = insepectUserId;
      return this;
   }

   public MesBuildingQhseCountParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseCountParam)) {
         return false;
      }

      MesBuildingQhseCountParam other = (MesBuildingQhseCountParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$insepectUserId = this.getInsepectUserId();
               Object other$insepectUserId = other.getInsepectUserId();
               if (this$insepectUserId == null ? other$insepectUserId == null : this$insepectUserId.equals(other$insepectUserId)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$insepctUserIds = this.getInsepctUserIds();
                        Object other$insepctUserIds = other.getInsepctUserIds();
                        if (this$insepctUserIds == null ? other$insepctUserIds == null : this$insepctUserIds.equals(other$insepctUserIds)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof MesBuildingQhseCountParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $insepectUserId = this.getInsepectUserId();
      result = result * 59 + ($insepectUserId == null ? 43 : $insepectUserId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $insepctUserIds = this.getInsepctUserIds();
      result = result * 59 + ($insepctUserIds == null ? 43 : $insepctUserIds.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingQhseCountParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", status="
         + this.getStatus()
         + ", insepctUserIds="
         + this.getInsepctUserIds()
         + ", insepectUserId="
         + this.getInsepectUserId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   public static class MesBuildingQhseCountParamBuilder {
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Long projectId;
      private Long workShopId;
      private Integer status;
      private List<Long> insepctUserIds;
      private Long insepectUserId;
      private String serialNumber;

      MesBuildingQhseCountParamBuilder() {
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder insepctUserIds(final List<Long> insepctUserIds) {
         this.insepctUserIds = insepctUserIds;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder insepectUserId(final Long insepectUserId) {
         this.insepectUserId = insepectUserId;
         return this;
      }

      public MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingQhseCountParam build() {
         return new MesBuildingQhseCountParam(
            this.startDate, this.endDate, this.projectId, this.workShopId, this.status, this.insepctUserIds, this.insepectUserId, this.serialNumber
         );
      }

      @Override
      public String toString() {
         return "MesBuildingQhseCountParam.MesBuildingQhseCountParamBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", status="
            + this.status
            + ", insepctUserIds="
            + this.insepctUserIds
            + ", insepectUserId="
            + this.insepectUserId
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
