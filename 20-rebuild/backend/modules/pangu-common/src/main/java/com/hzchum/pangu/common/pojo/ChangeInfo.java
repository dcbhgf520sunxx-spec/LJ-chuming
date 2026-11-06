package com.hzchum.pangu.common.pojo;

public class ChangeInfo {
   String field;
   Object oldData;
   Object newData;
   Boolean isChange;

   ChangeInfo(final String field, final Object oldData, final Object newData, final Boolean isChange) {
      this.field = field;
      this.oldData = oldData;
      this.newData = newData;
      this.isChange = isChange;
   }

   public static ChangeInfo.ChangeInfoBuilder builder() {
      return new ChangeInfo.ChangeInfoBuilder();
   }

   public String getField() {
      return this.field;
   }

   public Object getOldData() {
      return this.oldData;
   }

   public Object getNewData() {
      return this.newData;
   }

   public Boolean getIsChange() {
      return this.isChange;
   }

   public void setField(final String field) {
      this.field = field;
   }

   public void setOldData(final Object oldData) {
      this.oldData = oldData;
   }

   public void setNewData(final Object newData) {
      this.newData = newData;
   }

   public void setIsChange(final Boolean isChange) {
      this.isChange = isChange;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeInfo)) {
         return false;
      }

      ChangeInfo other = (ChangeInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isChange = this.getIsChange();
      Object other$isChange = other.getIsChange();
      if (this$isChange == null ? other$isChange == null : this$isChange.equals(other$isChange)) {
         Object this$field = this.getField();
         Object other$field = other.getField();
         if (this$field == null ? other$field == null : this$field.equals(other$field)) {
            Object this$oldData = this.getOldData();
            Object other$oldData = other.getOldData();
            if (this$oldData == null ? other$oldData == null : this$oldData.equals(other$oldData)) {
               Object this$newData = this.getNewData();
               Object other$newData = other.getNewData();
               return this$newData == null ? other$newData == null : this$newData.equals(other$newData);
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
      return other instanceof ChangeInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isChange = this.getIsChange();
      result = result * 59 + ($isChange == null ? 43 : $isChange.hashCode());
      Object $field = this.getField();
      result = result * 59 + ($field == null ? 43 : $field.hashCode());
      Object $oldData = this.getOldData();
      result = result * 59 + ($oldData == null ? 43 : $oldData.hashCode());
      Object $newData = this.getNewData();
      return result * 59 + ($newData == null ? 43 : $newData.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeInfo(field="
         + this.getField()
         + ", oldData="
         + this.getOldData()
         + ", newData="
         + this.getNewData()
         + ", isChange="
         + this.getIsChange()
         + ")";
   }

   public static class ChangeInfoBuilder {
      private String field;
      private Object oldData;
      private Object newData;
      private Boolean isChange;

      ChangeInfoBuilder() {
      }

      public ChangeInfo.ChangeInfoBuilder field(final String field) {
         this.field = field;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder oldData(final Object oldData) {
         this.oldData = oldData;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder newData(final Object newData) {
         this.newData = newData;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder isChange(final Boolean isChange) {
         this.isChange = isChange;
         return this;
      }

      public ChangeInfo build() {
         return new ChangeInfo(this.field, this.oldData, this.newData, this.isChange);
      }

      @Override
      public String toString() {
         return "ChangeInfo.ChangeInfoBuilder(field="
            + this.field
            + ", oldData="
            + this.oldData
            + ", newData="
            + this.newData
            + ", isChange="
            + this.isChange
            + ")";
      }
   }
}
