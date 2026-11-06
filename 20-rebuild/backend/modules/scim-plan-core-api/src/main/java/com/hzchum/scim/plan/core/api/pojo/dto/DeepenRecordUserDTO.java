package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("用户深化量")
public class DeepenRecordUserDTO {
   @ApiModelProperty("用户id")
   private Long userId;
   @ApiModelProperty("用户名")
   private String userName;
   @ApiModelProperty("总量")
   private BigDecimal mete;

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeepenRecordUserDTO)) {
         return false;
      }

      DeepenRecordUserDTO other = (DeepenRecordUserDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$userName = this.getUserName();
         Object other$userName = other.getUserName();
         if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeepenRecordUserDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "DeepenRecordUserDTO(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", mete=" + this.getMete() + ")";
   }

   public DeepenRecordUserDTO() {
   }

   public DeepenRecordUserDTO(final Long userId, final String userName, final BigDecimal mete) {
      this.userId = userId;
      this.userName = userName;
      this.mete = mete;
   }
}
