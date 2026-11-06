package com.hzchum.scim.contract.core.api.pojo.dto;

public class ChangeInfo {
   private String field;
   private String before;
   private String after;
   private int type;
   private String description;

   public static ChangeInfo.ChangeInfoBuilder builder() {
      return new ChangeInfo.ChangeInfoBuilder();
   }

   public String getField() {
      return this.field;
   }

   public String getBefore() {
      return this.before;
   }

   public String getAfter() {
      return this.after;
   }

   public int getType() {
      return this.type;
   }

   public String getDescription() {
      return this.description;
   }

   public void setField(final String field) {
      this.field = field;
   }

   public void setBefore(final String before) {
      this.before = before;
   }

   public void setAfter(final String after) {
      this.after = after;
   }

   public void setType(final int type) {
      this.type = type;
   }

   public void setDescription(final String description) {
      this.description = description;
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

      if (this.getType() != other.getType()) {
         return false;
      }

      Object this$field = this.getField();
      Object other$field = other.getField();
      if (this$field == null ? other$field == null : this$field.equals(other$field)) {
         Object this$before = this.getBefore();
         Object other$before = other.getBefore();
         if (this$before == null ? other$before == null : this$before.equals(other$before)) {
            Object this$after = this.getAfter();
            Object other$after = other.getAfter();
            if (this$after == null ? other$after == null : this$after.equals(other$after)) {
               Object this$description = this.getDescription();
               Object other$description = other.getDescription();
               return this$description == null ? other$description == null : this$description.equals(other$description);
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
      result = result * 59 + this.getType();
      Object $field = this.getField();
      result = result * 59 + ($field == null ? 43 : $field.hashCode());
      Object $before = this.getBefore();
      result = result * 59 + ($before == null ? 43 : $before.hashCode());
      Object $after = this.getAfter();
      result = result * 59 + ($after == null ? 43 : $after.hashCode());
      Object $description = this.getDescription();
      return result * 59 + ($description == null ? 43 : $description.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeInfo(field="
         + this.getField()
         + ", before="
         + this.getBefore()
         + ", after="
         + this.getAfter()
         + ", type="
         + this.getType()
         + ", description="
         + this.getDescription()
         + ")";
   }

   public ChangeInfo() {
   }

   public ChangeInfo(final String field, final String before, final String after, final int type, final String description) {
      this.field = field;
      this.before = before;
      this.after = after;
      this.type = type;
      this.description = description;
   }

   public static class ChangeInfoBuilder {
      private String field;
      private String before;
      private String after;
      private int type;
      private String description;

      ChangeInfoBuilder() {
      }

      public ChangeInfo.ChangeInfoBuilder field(final String field) {
         this.field = field;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder before(final String before) {
         this.before = before;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder after(final String after) {
         this.after = after;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder type(final int type) {
         this.type = type;
         return this;
      }

      public ChangeInfo.ChangeInfoBuilder description(final String description) {
         this.description = description;
         return this;
      }

      public ChangeInfo build() {
         return new ChangeInfo(this.field, this.before, this.after, this.type, this.description);
      }

      @Override
      public String toString() {
         return "ChangeInfo.ChangeInfoBuilder(field="
            + this.field
            + ", before="
            + this.before
            + ", after="
            + this.after
            + ", type="
            + this.type
            + ", description="
            + this.description
            + ")";
      }
   }
}
