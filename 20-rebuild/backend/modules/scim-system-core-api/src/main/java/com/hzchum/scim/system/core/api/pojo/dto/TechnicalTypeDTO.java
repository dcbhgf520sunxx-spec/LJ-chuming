package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("设置是否关联技术交底类")
public class TechnicalTypeDTO {
   @ApiModelProperty("是否关联技术交底 true关联 false不关联)")
   @NotNull(message = "参数不能为空")
   private Boolean TechnicalType;

   public static TechnicalTypeDTO.TechnicalTypeDTOBuilder builder() {
      return new TechnicalTypeDTO.TechnicalTypeDTOBuilder();
   }

   public Boolean getTechnicalType() {
      return this.TechnicalType;
   }

   public void setTechnicalType(final Boolean TechnicalType) {
      this.TechnicalType = TechnicalType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechnicalTypeDTO)) {
         return false;
      }

      TechnicalTypeDTO other = (TechnicalTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$TechnicalType = this.getTechnicalType();
      Object other$TechnicalType = other.getTechnicalType();
      return this$TechnicalType == null ? other$TechnicalType == null : this$TechnicalType.equals(other$TechnicalType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechnicalTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $TechnicalType = this.getTechnicalType();
      return result * 59 + ($TechnicalType == null ? 43 : $TechnicalType.hashCode());
   }

   @Override
   public String toString() {
      return "TechnicalTypeDTO(TechnicalType=" + this.getTechnicalType() + ")";
   }

   public TechnicalTypeDTO() {
   }

   public TechnicalTypeDTO(final Boolean TechnicalType) {
      this.TechnicalType = TechnicalType;
   }

   public static class TechnicalTypeDTOBuilder {
      private Boolean TechnicalType;

      TechnicalTypeDTOBuilder() {
      }

      public TechnicalTypeDTO.TechnicalTypeDTOBuilder TechnicalType(final Boolean TechnicalType) {
         this.TechnicalType = TechnicalType;
         return this;
      }

      public TechnicalTypeDTO build() {
         return new TechnicalTypeDTO(this.TechnicalType);
      }

      @Override
      public String toString() {
         return "TechnicalTypeDTO.TechnicalTypeDTOBuilder(TechnicalType=" + this.TechnicalType + ")";
      }
   }
}
