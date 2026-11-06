package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TechChangeCheckDtoParam {
   @NotNull(message = "变更记录ID不可为空!")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @EnumValidator(value = CheckStatusEnum.class, message = "审核状态传值有误!")
   @Min(value = 2L, message = "审核状态传值有误!")
   @ApiModelProperty(name = "checkStatus", value = "审核状态", notes = "审核状态")
   private Integer checkStatus;

   public Long getId() {
      return this.id;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TechChangeCheckDtoParam)) {
         return false;
      } else {
         TechChangeCheckDtoParam other = (TechChangeCheckDtoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$checkStatus = this.getCheckStatus();
               Object other$checkStatus = other.getCheckStatus();
               return this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeCheckDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $checkStatus = this.getCheckStatus();
      return result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeCheckDtoParam(id=" + this.getId() + ", checkStatus=" + this.getCheckStatus() + ")";
   }
}
