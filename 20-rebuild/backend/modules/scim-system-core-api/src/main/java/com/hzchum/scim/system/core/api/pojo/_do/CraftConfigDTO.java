package com.hzchum.scim.system.core.api.pojo._do;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("构件、部件特征定义配置")
public class CraftConfigDTO {
   @ApiModelProperty("工艺类型 true 不设定工艺 false 工艺未设定，不能排产)")
   @NotNull(message = "参数不能为空")
   private Boolean craftType;

   public static CraftConfigDTO.CraftConfigDTOBuilder builder() {
      return new CraftConfigDTO.CraftConfigDTOBuilder();
   }

   public Boolean getCraftType() {
      return this.craftType;
   }

   public void setCraftType(final Boolean craftType) {
      this.craftType = craftType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftConfigDTO)) {
         return false;
      }

      CraftConfigDTO other = (CraftConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$craftType = this.getCraftType();
      Object other$craftType = other.getCraftType();
      return this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CraftConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $craftType = this.getCraftType();
      return result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
   }

   @Override
   public String toString() {
      return "CraftConfigDTO(craftType=" + this.getCraftType() + ")";
   }

   public CraftConfigDTO() {
   }

   public CraftConfigDTO(final Boolean craftType) {
      this.craftType = craftType;
   }

   public static class CraftConfigDTOBuilder {
      private Boolean craftType;

      CraftConfigDTOBuilder() {
      }

      public CraftConfigDTO.CraftConfigDTOBuilder craftType(final Boolean craftType) {
         this.craftType = craftType;
         return this;
      }

      public CraftConfigDTO build() {
         return new CraftConfigDTO(this.craftType);
      }

      @Override
      public String toString() {
         return "CraftConfigDTO.CraftConfigDTOBuilder(craftType=" + this.craftType + ")";
      }
   }
}
