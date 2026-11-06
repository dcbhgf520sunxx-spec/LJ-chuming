package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TablePrintTemplateRequestDTOParam {
   @NotBlank(message = "表格名称不能为空")
   private String name;
   @NotNull(message = "表格类型不能为空")
   private String type;
   private Boolean isDefault;
   private Boolean enabled;
   @NotBlank(message = "配置不能为空")
   private String config;
   private String remark;

   public String getName() {
      return this.name;
   }

   public String getType() {
      return this.type;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public String getConfig() {
      return this.config;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setConfig(final String config) {
      this.config = config;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TablePrintTemplateRequestDTOParam)) {
         return false;
      }

      TablePrintTemplateRequestDTOParam other = (TablePrintTemplateRequestDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isDefault = this.getIsDefault();
      Object other$isDefault = other.getIsDefault();
      if (this$isDefault == null ? other$isDefault == null : this$isDefault.equals(other$isDefault)) {
         Object this$enabled = this.getEnabled();
         Object other$enabled = other.getEnabled();
         if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$config = this.getConfig();
                  Object other$config = other.getConfig();
                  if (this$config == null ? other$config == null : this$config.equals(other$config)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TablePrintTemplateRequestDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $config = this.getConfig();
      result = result * 59 + ($config == null ? 43 : $config.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TablePrintTemplateRequestDTOParam(name="
         + this.getName()
         + ", type="
         + this.getType()
         + ", isDefault="
         + this.getIsDefault()
         + ", enabled="
         + this.getEnabled()
         + ", config="
         + this.getConfig()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
