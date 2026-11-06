package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import java.util.List;
import java.util.stream.Collectors;

public class SaveProcessInfo {
   private Boolean disableFormEdit;
   private String name;
   private List<FormComponentInfo> formComponentList;

   public SaveProcessInfo(String name, List<String> infos) {
      this.name = name;
      this.disableFormEdit = false;
      this.formComponentList = infos.stream().map(FormComponentInfo::new).collect(Collectors.toList());
   }

   public SaveProcessInfo(String name, Boolean disableFormEdit) {
      this.name = name;
      this.disableFormEdit = disableFormEdit;
   }

   public Boolean getDisableFormEdit() {
      return this.disableFormEdit;
   }

   public String getName() {
      return this.name;
   }

   public List<FormComponentInfo> getFormComponentList() {
      return this.formComponentList;
   }

   public void setDisableFormEdit(final Boolean disableFormEdit) {
      this.disableFormEdit = disableFormEdit;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFormComponentList(final List<FormComponentInfo> formComponentList) {
      this.formComponentList = formComponentList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SaveProcessInfo)) {
         return false;
      }

      SaveProcessInfo other = (SaveProcessInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$disableFormEdit = this.getDisableFormEdit();
      Object other$disableFormEdit = other.getDisableFormEdit();
      if (this$disableFormEdit == null ? other$disableFormEdit == null : this$disableFormEdit.equals(other$disableFormEdit)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$formComponentList = this.getFormComponentList();
            Object other$formComponentList = other.getFormComponentList();
            return this$formComponentList == null ? other$formComponentList == null : this$formComponentList.equals(other$formComponentList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SaveProcessInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $disableFormEdit = this.getDisableFormEdit();
      result = result * 59 + ($disableFormEdit == null ? 43 : $disableFormEdit.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $formComponentList = this.getFormComponentList();
      return result * 59 + ($formComponentList == null ? 43 : $formComponentList.hashCode());
   }

   @Override
   public String toString() {
      return "SaveProcessInfo(disableFormEdit="
         + this.getDisableFormEdit()
         + ", name="
         + this.getName()
         + ", formComponentList="
         + this.getFormComponentList()
         + ")";
   }
}
