package com.hzchum.scim.bim.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.bim.core.api.enums.BimImportModeEnum;
import com.hzchum.scim.bim.core.api.enums.BimTeklaEditionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("bim导入模式配置类DTO")
public class BimModelConfigurationDTO {
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "importMode", value = "导入模式")
   @NotNull(message = "导入模式不能为空")
   @EnumValidator(value = BimImportModeEnum.class, message = "导入模式不存在")
   private Integer importMode;
   @ApiModelProperty(name = "edition", value = "Tekla版本")
   @NotNull(message = "Tekla版本不能为空")
   @EnumValidator(value = BimTeklaEditionEnum.class, message = "Tekla版本不存在")
   private Integer edition;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getImportMode() {
      return this.importMode;
   }

   public Integer getEdition() {
      return this.edition;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setImportMode(final Integer importMode) {
      this.importMode = importMode;
   }

   public void setEdition(final Integer edition) {
      this.edition = edition;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelConfigurationDTO)) {
         return false;
      }

      BimModelConfigurationDTO other = (BimModelConfigurationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$importMode = this.getImportMode();
         Object other$importMode = other.getImportMode();
         if (this$importMode == null ? other$importMode == null : this$importMode.equals(other$importMode)) {
            Object this$edition = this.getEdition();
            Object other$edition = other.getEdition();
            return this$edition == null ? other$edition == null : this$edition.equals(other$edition);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BimModelConfigurationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $importMode = this.getImportMode();
      result = result * 59 + ($importMode == null ? 43 : $importMode.hashCode());
      Object $edition = this.getEdition();
      return result * 59 + ($edition == null ? 43 : $edition.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelConfigurationDTO(monomerId=" + this.getMonomerId() + ", importMode=" + this.getImportMode() + ", edition=" + this.getEdition() + ")";
   }
}
