package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

public class ListReportSummaryDTO {
   private Long id;
   private Long taskProcessId;
   private Long groupId;
   private Long teamId;
   private Integer taskTypeEnum;
   private Integer quantity;
   private Integer inspectionQuantity;
   private Integer problemQuantity;

   public static ListReportSummaryDTO.ListReportSummaryDTOBuilder builder() {
      return new ListReportSummaryDTO.ListReportSummaryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   public void setGroupId(final Long groupId) {
      this.groupId = groupId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ListReportSummaryDTO)) {
         return false;
      }

      ListReportSummaryDTO other = (ListReportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskProcessId = this.getTaskProcessId();
         Object other$taskProcessId = other.getTaskProcessId();
         if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
            Object this$groupId = this.getGroupId();
            Object other$groupId = other.getGroupId();
            if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$taskTypeEnum = this.getTaskTypeEnum();
                  Object other$taskTypeEnum = other.getTaskTypeEnum();
                  if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$inspectionQuantity = this.getInspectionQuantity();
                        Object other$inspectionQuantity = other.getInspectionQuantity();
                        if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                           Object this$problemQuantity = this.getProblemQuantity();
                           Object other$problemQuantity = other.getProblemQuantity();
                           return this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity);
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
      return other instanceof ListReportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      return result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "ListReportSummaryDTO(id="
         + this.getId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", groupId="
         + this.getGroupId()
         + ", teamId="
         + this.getTeamId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ")";
   }

   public ListReportSummaryDTO(
      final Long id,
      final Long taskProcessId,
      final Long groupId,
      final Long teamId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer inspectionQuantity,
      final Integer problemQuantity
   ) {
      this.id = id;
      this.taskProcessId = taskProcessId;
      this.groupId = groupId;
      this.teamId = teamId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
      this.problemQuantity = problemQuantity;
   }

   public ListReportSummaryDTO() {
   }

   public static class ListReportSummaryDTOBuilder {
      private Long id;
      private Long taskProcessId;
      private Long groupId;
      private Long teamId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer inspectionQuantity;
      private Integer problemQuantity;

      ListReportSummaryDTOBuilder() {
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ListReportSummaryDTO.ListReportSummaryDTOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      public ListReportSummaryDTO build() {
         return new ListReportSummaryDTO(
            this.id, this.taskProcessId, this.groupId, this.teamId, this.taskTypeEnum, this.quantity, this.inspectionQuantity, this.problemQuantity
         );
      }

      @Override
      public String toString() {
         return "ListReportSummaryDTO.ListReportSummaryDTOBuilder(id="
            + this.id
            + ", taskProcessId="
            + this.taskProcessId
            + ", groupId="
            + this.groupId
            + ", teamId="
            + this.teamId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", problemQuantity="
            + this.problemQuantity
            + ")";
      }
   }
}
