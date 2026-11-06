package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.OldCheckStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class OldCheckDTOParam {
   @ApiModelProperty(notes = "发运id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(notes = "发运审核状态 1通过 2不通过")
   @EnumValidator(value = OldCheckStatusEnum.class, message = "审核状态类型不正确")
   @NotNull(message = "审核状态类型不支持")
   private Integer status;

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OldCheckDTOParam)) {
         return false;
      } else {
         OldCheckDTOParam other = (OldCheckDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               return this$status == null ? other$status == null : this$status.equals(other$status);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OldCheckDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "OldCheckDTOParam(id=" + this.getId() + ", status=" + this.getStatus() + ")";
   }
}
