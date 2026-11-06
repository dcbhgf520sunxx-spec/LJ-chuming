package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.common.enums.SysDrawingRecognitionRulesEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("图纸识别规则DTO")
public class SysDrawingRecognitionRulesDTO {
   @ApiModelProperty(name = "type", notes = "规则类型")
   @NotNull(message = "规则类型不能为空", groups = Add.class)
   @EnumValidator(value = SysDrawingRecognitionRulesEnums.class, message = "规则类型错误", groups = Add.class)
   private Integer type;

   public static SysDrawingRecognitionRulesDTO.SysDrawingRecognitionRulesDTOBuilder builder() {
      return new SysDrawingRecognitionRulesDTO.SysDrawingRecognitionRulesDTOBuilder();
   }

   public SysDrawingRecognitionRulesDTO() {
   }

   public SysDrawingRecognitionRulesDTO(final Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysDrawingRecognitionRulesDTO)) {
         return false;
      }

      SysDrawingRecognitionRulesDTO other = (SysDrawingRecognitionRulesDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      return this$type == null ? other$type == null : this$type.equals(other$type);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysDrawingRecognitionRulesDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "SysDrawingRecognitionRulesDTO(type=" + this.getType() + ")";
   }

   public static class SysDrawingRecognitionRulesDTOBuilder {
      private Integer type;

      SysDrawingRecognitionRulesDTOBuilder() {
      }

      public SysDrawingRecognitionRulesDTO.SysDrawingRecognitionRulesDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SysDrawingRecognitionRulesDTO build() {
         return new SysDrawingRecognitionRulesDTO(this.type);
      }

      @Override
      public String toString() {
         return "SysDrawingRecognitionRulesDTO.SysDrawingRecognitionRulesDTOBuilder(type=" + this.type + ")";
      }
   }
}
