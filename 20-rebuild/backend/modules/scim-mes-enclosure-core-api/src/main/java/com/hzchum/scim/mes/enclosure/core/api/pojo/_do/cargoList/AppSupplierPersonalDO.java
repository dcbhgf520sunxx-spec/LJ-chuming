package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "app物流供应商和车牌号")
public class AppSupplierPersonalDO {
   @ApiModelProperty(notes = "物流配置id")
   private Long id;
   @ApiModelProperty(notes = "供应商名称/车牌号名称")
   private String name;
   @ApiModelProperty(name = "boolPersonalEnum", value = "是否个人  ", notes = "是否个人 ")
   private Boolean boolPersonalEnum;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolPersonalEnum(final Boolean boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppSupplierPersonalDO)) {
         return false;
      }

      AppSupplierPersonalDO other = (AppSupplierPersonalDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPersonalEnum = this.getBoolPersonalEnum();
         Object other$boolPersonalEnum = other.getBoolPersonalEnum();
         if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppSupplierPersonalDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "AppSupplierPersonalDO(id=" + this.getId() + ", name=" + this.getName() + ", boolPersonalEnum=" + this.getBoolPersonalEnum() + ")";
   }
}
