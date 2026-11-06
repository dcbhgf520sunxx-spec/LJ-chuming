package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class NumericalControlDrawingMatchRangeConfigVO {
   @ApiModelProperty("数控图纸匹配范围 1单体 2区域")
   @NotNull(message = "数控图纸匹配范围不能为空")
   @EnumValidator(value = SysMatchRangeEnum.class, message = "匹配范围不存在!")
   private Integer matchRangeEnum;

   public Integer getMatchRangeEnum() {
      return this.matchRangeEnum;
   }

   public void setMatchRangeEnum(final Integer matchRangeEnum) {
      this.matchRangeEnum = matchRangeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NumericalControlDrawingMatchRangeConfigVO)) {
         return false;
      }

      NumericalControlDrawingMatchRangeConfigVO other = (NumericalControlDrawingMatchRangeConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$matchRangeEnum = this.getMatchRangeEnum();
      Object other$matchRangeEnum = other.getMatchRangeEnum();
      return this$matchRangeEnum == null ? other$matchRangeEnum == null : this$matchRangeEnum.equals(other$matchRangeEnum);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NumericalControlDrawingMatchRangeConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $matchRangeEnum = this.getMatchRangeEnum();
      return result * 59 + ($matchRangeEnum == null ? 43 : $matchRangeEnum.hashCode());
   }

   @Override
   public String toString() {
      return "NumericalControlDrawingMatchRangeConfigVO(matchRangeEnum=" + this.getMatchRangeEnum() + ")";
   }
}
