package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("构件、部件特征定义配置")
public class ExpireUpdateDTO {
   @ApiModelProperty("系统服务过期时间,时间戳到年月日，例如2023-12-24 00:00:00 时间戳：1703347200000")
   @NotNull(message = "过期时间不能为空")
   private LocalDateTime expireDate;

   public LocalDateTime getExpireDate() {
      return this.expireDate;
   }

   public void setExpireDate(final LocalDateTime expireDate) {
      this.expireDate = expireDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExpireUpdateDTO)) {
         return false;
      }

      ExpireUpdateDTO other = (ExpireUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$expireDate = this.getExpireDate();
      Object other$expireDate = other.getExpireDate();
      return this$expireDate == null ? other$expireDate == null : this$expireDate.equals(other$expireDate);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ExpireUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $expireDate = this.getExpireDate();
      return result * 59 + ($expireDate == null ? 43 : $expireDate.hashCode());
   }

   @Override
   public String toString() {
      return "ExpireUpdateDTO(expireDate=" + this.getExpireDate() + ")";
   }
}
