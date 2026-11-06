package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import java.util.List;

public class FormComponentInfo {
   private List<FormComponentInfo> children;
   private String componentName;
   private FormComponentPropInfo props;

   public FormComponentInfo(String label) {
      this.componentName = "TextField";
      this.props = new FormComponentPropInfo(label);
   }

   public FormComponentInfo(String componentName, String label) {
      this.componentName = componentName;
      this.props = new FormComponentPropInfo(componentName, label);
   }

   public FormComponentInfo(String componentName, String label, String actionName, List<FormComponentInfo> children) {
      this.componentName = componentName;
      this.props = new FormComponentPropInfo(componentName, label, actionName);
      this.children = children;
   }

   public List<FormComponentInfo> getChildren() {
      return this.children;
   }

   public String getComponentName() {
      return this.componentName;
   }

   public FormComponentPropInfo getProps() {
      return this.props;
   }

   public void setChildren(final List<FormComponentInfo> children) {
      this.children = children;
   }

   public void setComponentName(final String componentName) {
      this.componentName = componentName;
   }

   public void setProps(final FormComponentPropInfo props) {
      this.props = props;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormComponentInfo)) {
         return false;
      }

      FormComponentInfo other = (FormComponentInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$children = this.getChildren();
      Object other$children = other.getChildren();
      if (this$children == null ? other$children == null : this$children.equals(other$children)) {
         Object this$componentName = this.getComponentName();
         Object other$componentName = other.getComponentName();
         if (this$componentName == null ? other$componentName == null : this$componentName.equals(other$componentName)) {
            Object this$props = this.getProps();
            Object other$props = other.getProps();
            return this$props == null ? other$props == null : this$props.equals(other$props);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FormComponentInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $children = this.getChildren();
      result = result * 59 + ($children == null ? 43 : $children.hashCode());
      Object $componentName = this.getComponentName();
      result = result * 59 + ($componentName == null ? 43 : $componentName.hashCode());
      Object $props = this.getProps();
      return result * 59 + ($props == null ? 43 : $props.hashCode());
   }

   @Override
   public String toString() {
      return "FormComponentInfo(children=" + this.getChildren() + ", componentName=" + this.getComponentName() + ", props=" + this.getProps() + ")";
   }
}
