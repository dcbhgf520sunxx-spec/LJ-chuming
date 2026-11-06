package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("打印配置")
public class PrintConfigurationDTO {
   @ApiModelProperty("是否仅打印入库数据")
   @NotNull(message = "参数不能为空")
   private Boolean boolPrintWarehousing;

   public static PrintConfigurationDTO.PrintConfigurationDTOBuilder builder() {
      return new PrintConfigurationDTO.PrintConfigurationDTOBuilder();
   }

   public Boolean getBoolPrintWarehousing() {
      return this.boolPrintWarehousing;
   }

   public void setBoolPrintWarehousing(final Boolean boolPrintWarehousing) {
      this.boolPrintWarehousing = boolPrintWarehousing;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintConfigurationDTO)) {
         return false;
      }

      PrintConfigurationDTO other = (PrintConfigurationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolPrintWarehousing = this.getBoolPrintWarehousing();
      Object other$boolPrintWarehousing = other.getBoolPrintWarehousing();
      return this$boolPrintWarehousing == null ? other$boolPrintWarehousing == null : this$boolPrintWarehousing.equals(other$boolPrintWarehousing);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PrintConfigurationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolPrintWarehousing = this.getBoolPrintWarehousing();
      return result * 59 + ($boolPrintWarehousing == null ? 43 : $boolPrintWarehousing.hashCode());
   }

   @Override
   public String toString() {
      return "PrintConfigurationDTO(boolPrintWarehousing=" + this.getBoolPrintWarehousing() + ")";
   }

   public PrintConfigurationDTO() {
   }

   public PrintConfigurationDTO(final Boolean boolPrintWarehousing) {
      this.boolPrintWarehousing = boolPrintWarehousing;
   }

   public static class PrintConfigurationDTOBuilder {
      private Boolean boolPrintWarehousing;

      PrintConfigurationDTOBuilder() {
      }

      public PrintConfigurationDTO.PrintConfigurationDTOBuilder boolPrintWarehousing(final Boolean boolPrintWarehousing) {
         this.boolPrintWarehousing = boolPrintWarehousing;
         return this;
      }

      public PrintConfigurationDTO build() {
         return new PrintConfigurationDTO(this.boolPrintWarehousing);
      }

      @Override
      public String toString() {
         return "PrintConfigurationDTO.PrintConfigurationDTOBuilder(boolPrintWarehousing=" + this.boolPrintWarehousing + ")";
      }
   }
}
