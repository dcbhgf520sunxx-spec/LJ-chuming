package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "标准件(配套件)DTO", description = "标准件(配套件)DTO")
public class StandardPartImportDTOParam extends ArtifactPartImportCommonDTO {
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂 AuxiliaryUsePropertyEnum", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StandardPartImportDTOParam)) {
         return false;
      }

      StandardPartImportDTOParam other = (StandardPartImportDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$useProperty = this.getUseProperty();
      Object other$useProperty = other.getUseProperty();
      return this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof StandardPartImportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $useProperty = this.getUseProperty();
      return result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   @Override
   public String toString() {
      return "StandardPartImportDTOParam(useProperty=" + this.getUseProperty() + ")";
   }
}
