package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPushSocketUserIdDTO", description = "wocket")
public class SysPushSocketUserIdDTO {
   @ApiModelProperty(name = "id", value = "数据id", notes = "数据id")
   private Long id;
   @ApiModelProperty(name = "userId", notes = "用户id")
   private Long userId;

   public static SysPushSocketUserIdDTO.SysPushSocketUserIdDTOBuilder builder() {
      return new SysPushSocketUserIdDTO.SysPushSocketUserIdDTOBuilder();
   }

   public SysPushSocketUserIdDTO() {
   }

   public SysPushSocketUserIdDTO(final Long id, final Long userId) {
      this.id = id;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public SysPushSocketUserIdDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushSocketUserIdDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysPushSocketUserIdDTO)) {
         return false;
      } else {
         SysPushSocketUserIdDTO other = (SysPushSocketUserIdDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysPushSocketUserIdDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushSocketUserIdDTO(id=" + this.getId() + ", userId=" + this.getUserId() + ")";
   }

   public static class SysPushSocketUserIdDTOBuilder {
      private Long id;
      private Long userId;

      SysPushSocketUserIdDTOBuilder() {
      }

      public SysPushSocketUserIdDTO.SysPushSocketUserIdDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushSocketUserIdDTO.SysPushSocketUserIdDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysPushSocketUserIdDTO build() {
         return new SysPushSocketUserIdDTO(this.id, this.userId);
      }

      @Override
      public String toString() {
         return "SysPushSocketUserIdDTO.SysPushSocketUserIdDTOBuilder(id=" + this.id + ", userId=" + this.userId + ")";
      }
   }
}
