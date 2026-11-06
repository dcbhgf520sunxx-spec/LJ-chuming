package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import org.apache.commons.lang3.RandomStringUtils;

public class FormComponentPropInfo {
   private String id;
   private String label;
   private String actionName;

   public FormComponentPropInfo(String label) {
      this.id = "TextField-" + RandomStringUtils.randomAlphanumeric(7);
      this.label = label;
   }

   public FormComponentPropInfo(String idPrefix, String label) {
      this.id = idPrefix + "-" + RandomStringUtils.randomAlphanumeric(7);
      this.label = label;
   }

   public FormComponentPropInfo(String idPrefix, String label, String actionName) {
      this.id = idPrefix + "-" + RandomStringUtils.randomAlphanumeric(7);
      this.label = label;
      this.actionName = actionName;
   }

   public String getId() {
      return this.id;
   }

   public String getLabel() {
      return this.label;
   }

   public String getActionName() {
      return this.actionName;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setActionName(final String actionName) {
      this.actionName = actionName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormComponentPropInfo)) {
         return false;
      }

      FormComponentPropInfo other = (FormComponentPropInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$label = this.getLabel();
         Object other$label = other.getLabel();
         if (this$label == null ? other$label == null : this$label.equals(other$label)) {
            Object this$actionName = this.getActionName();
            Object other$actionName = other.getActionName();
            return this$actionName == null ? other$actionName == null : this$actionName.equals(other$actionName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FormComponentPropInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $actionName = this.getActionName();
      return result * 59 + ($actionName == null ? 43 : $actionName.hashCode());
   }

   @Override
   public String toString() {
      return "FormComponentPropInfo(id=" + this.getId() + ", label=" + this.getLabel() + ", actionName=" + this.getActionName() + ")";
   }
}
