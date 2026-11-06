package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class BatchBorrowDTOParam {
   private Long projectId;
   private Long recipientId;
   private Boolean boolPartyA;
   private LocalDateTime outboundTime;
   private List<BatchOutboundDetailDTOParam> list;

   public static BatchBorrowDTOParam.BatchBorrowDTOParamBuilder builder() {
      return new BatchBorrowDTOParam.BatchBorrowDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public List<BatchOutboundDetailDTOParam> getList() {
      return this.list;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setList(final List<BatchOutboundDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchBorrowDTOParam)) {
         return false;
      }

      BatchBorrowDTOParam other = (BatchBorrowDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$recipientId = this.getRecipientId();
         Object other$recipientId = other.getRecipientId();
         if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$outboundTime = this.getOutboundTime();
               Object other$outboundTime = other.getOutboundTime();
               if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                  Object this$list = this.getList();
                  Object other$list = other.getList();
                  return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof BatchBorrowDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "BatchBorrowDTOParam(projectId="
         + this.getProjectId()
         + ", recipientId="
         + this.getRecipientId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", list="
         + this.getList()
         + ")";
   }

   public BatchBorrowDTOParam(
      final Long projectId, final Long recipientId, final Boolean boolPartyA, final LocalDateTime outboundTime, final List<BatchOutboundDetailDTOParam> list
   ) {
      this.projectId = projectId;
      this.recipientId = recipientId;
      this.boolPartyA = boolPartyA;
      this.outboundTime = outboundTime;
      this.list = list;
   }

   public BatchBorrowDTOParam() {
   }

   public static class BatchBorrowDTOParamBuilder {
      private Long projectId;
      private Long recipientId;
      private Boolean boolPartyA;
      private LocalDateTime outboundTime;
      private List<BatchOutboundDetailDTOParam> list;

      BatchBorrowDTOParamBuilder() {
      }

      public BatchBorrowDTOParam.BatchBorrowDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BatchBorrowDTOParam.BatchBorrowDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public BatchBorrowDTOParam.BatchBorrowDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public BatchBorrowDTOParam.BatchBorrowDTOParamBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public BatchBorrowDTOParam.BatchBorrowDTOParamBuilder list(final List<BatchOutboundDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public BatchBorrowDTOParam build() {
         return new BatchBorrowDTOParam(this.projectId, this.recipientId, this.boolPartyA, this.outboundTime, this.list);
      }

      @Override
      public String toString() {
         return "BatchBorrowDTOParam.BatchBorrowDTOParamBuilder(projectId="
            + this.projectId
            + ", recipientId="
            + this.recipientId
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundTime="
            + this.outboundTime
            + ", list="
            + this.list
            + ")";
      }
   }
}
