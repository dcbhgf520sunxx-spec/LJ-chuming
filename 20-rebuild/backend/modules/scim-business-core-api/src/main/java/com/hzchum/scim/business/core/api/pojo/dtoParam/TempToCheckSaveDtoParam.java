package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TempToCheckSaveDtoParam {
   @NotNull(message = "产品类型不能为空")
   @ApiModelProperty("产品类型")
   private Integer type;
   @NotEmpty(message = "保存记录列表不能为空!")
   @ApiModelProperty("临时保存表id列表")
   private Set<Long> priceTempIds;
   @Size(max = 250, message = "是由字数超过系统限制!")
   private String remark;

   public Integer getType() {
      return this.type;
   }

   public Set<Long> getPriceTempIds() {
      return this.priceTempIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPriceTempIds(final Set<Long> priceTempIds) {
      this.priceTempIds = priceTempIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TempToCheckSaveDtoParam)) {
         return false;
      }

      TempToCheckSaveDtoParam other = (TempToCheckSaveDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$priceTempIds = this.getPriceTempIds();
         Object other$priceTempIds = other.getPriceTempIds();
         if (this$priceTempIds == null ? other$priceTempIds == null : this$priceTempIds.equals(other$priceTempIds)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TempToCheckSaveDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $priceTempIds = this.getPriceTempIds();
      result = result * 59 + ($priceTempIds == null ? 43 : $priceTempIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TempToCheckSaveDtoParam(type=" + this.getType() + ", priceTempIds=" + this.getPriceTempIds() + ", remark=" + this.getRemark() + ")";
   }
}
