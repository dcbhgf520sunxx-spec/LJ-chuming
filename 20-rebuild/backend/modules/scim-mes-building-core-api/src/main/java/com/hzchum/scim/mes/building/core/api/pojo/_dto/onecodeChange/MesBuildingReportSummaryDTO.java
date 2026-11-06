package com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "班组生产上报汇总查询请求类 ")
public class MesBuildingReportSummaryDTO {
   private Long taskProcessId;
   private Long groupId;
   private Long prodLineId;
   private Long teamId;

   public static MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder builder() {
      return new MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder();
   }

   public MesBuildingReportSummaryDTO() {
   }

   public MesBuildingReportSummaryDTO(final Long taskProcessId, final Long groupId, final Long prodLineId, final Long teamId) {
      this.taskProcessId = taskProcessId;
      this.groupId = groupId;
      this.prodLineId = prodLineId;
      this.teamId = teamId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getProdLineId() {
      return this.prodLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   public void setGroupId(final Long groupId) {
      this.groupId = groupId;
   }

   public void setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingReportSummaryDTO)) {
         return false;
      }

      MesBuildingReportSummaryDTO other = (MesBuildingReportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$groupId = this.getGroupId();
         Object other$groupId = other.getGroupId();
         if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
            Object this$prodLineId = this.getProdLineId();
            Object other$prodLineId = other.getProdLineId();
            if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               return this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId);
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
      return other instanceof MesBuildingReportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingReportSummaryDTO(taskProcessId="
         + this.getTaskProcessId()
         + ", groupId="
         + this.getGroupId()
         + ", prodLineId="
         + this.getProdLineId()
         + ", teamId="
         + this.getTeamId()
         + ")";
   }

   public static class MesBuildingReportSummaryDTOBuilder {
      private Long taskProcessId;
      private Long groupId;
      private Long prodLineId;
      private Long teamId;

      MesBuildingReportSummaryDTOBuilder() {
      }

      public MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      public MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingReportSummaryDTO build() {
         return new MesBuildingReportSummaryDTO(this.taskProcessId, this.groupId, this.prodLineId, this.teamId);
      }

      @Override
      public String toString() {
         return "MesBuildingReportSummaryDTO.MesBuildingReportSummaryDTOBuilder(taskProcessId="
            + this.taskProcessId
            + ", groupId="
            + this.groupId
            + ", prodLineId="
            + this.prodLineId
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
