package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class BatchBorrowReturnDTOParam {
   private Long id;
   private LocalDateTime time;
   private Long recipientId;
   private String recipientName;
   private List<BatchBorrowReturnDetailDTOParam> list;

   public static BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder builder() {
      return new BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getTime() {
      return this.time;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public List<BatchBorrowReturnDetailDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTime(final LocalDateTime time) {
      this.time = time;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setList(final List<BatchBorrowReturnDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchBorrowReturnDTOParam)) {
         return false;
      }

      BatchBorrowReturnDTOParam other = (BatchBorrowReturnDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$recipientId = this.getRecipientId();
         Object other$recipientId = other.getRecipientId();
         if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
            Object this$time = this.getTime();
            Object other$time = other.getTime();
            if (this$time == null ? other$time == null : this$time.equals(other$time)) {
               Object this$recipientName = this.getRecipientName();
               Object other$recipientName = other.getRecipientName();
               if (this$recipientName == null ? other$recipientName == null : this$recipientName.equals(other$recipientName)) {
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
      return other instanceof BatchBorrowReturnDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "BatchBorrowReturnDTOParam(id="
         + this.getId()
         + ", time="
         + this.getTime()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ", list="
         + this.getList()
         + ")";
   }

   public BatchBorrowReturnDTOParam(
      final Long id, final LocalDateTime time, final Long recipientId, final String recipientName, final List<BatchBorrowReturnDetailDTOParam> list
   ) {
      this.id = id;
      this.time = time;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
      this.list = list;
   }

   public BatchBorrowReturnDTOParam() {
   }

   public static class BatchBorrowReturnDTOParamBuilder {
      private Long id;
      private LocalDateTime time;
      private Long recipientId;
      private String recipientName;
      private List<BatchBorrowReturnDetailDTOParam> list;

      BatchBorrowReturnDTOParamBuilder() {
      }

      public BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder time(final LocalDateTime time) {
         this.time = time;
         return this;
      }

      public BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder list(final List<BatchBorrowReturnDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public BatchBorrowReturnDTOParam build() {
         return new BatchBorrowReturnDTOParam(this.id, this.time, this.recipientId, this.recipientName, this.list);
      }

      @Override
      public String toString() {
         return "BatchBorrowReturnDTOParam.BatchBorrowReturnDTOParamBuilder(id="
            + this.id
            + ", time="
            + this.time
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ", list="
            + this.list
            + ")";
      }
   }
}
