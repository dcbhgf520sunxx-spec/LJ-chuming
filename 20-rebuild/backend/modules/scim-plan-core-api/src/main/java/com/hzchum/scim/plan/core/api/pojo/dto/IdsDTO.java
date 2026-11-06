package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;

@ApiModel("id")
public class IdsDTO {
   @ApiModelProperty(name = "id", value = "图纸id/焊缝id/焊缝地图")
   private Set<Long> ids;

   public static IdsDTO.IdsDTOBuilder builder() {
      return new IdsDTO.IdsDTOBuilder();
   }

   public Set<Long> getIds() {
      return this.ids;
   }

   public void setIds(final Set<Long> ids) {
      this.ids = ids;
   }

   @Override
   public String toString() {
      return "IdsDTO(ids=" + this.getIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IdsDTO)) {
         return false;
      }

      IdsDTO other = (IdsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ids = this.getIds();
      Object other$ids = other.getIds();
      return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IdsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   public IdsDTO(final Set<Long> ids) {
      this.ids = ids;
   }

   public IdsDTO() {
   }

   public static class IdsDTOBuilder {
      private Set<Long> ids;

      IdsDTOBuilder() {
      }

      public IdsDTO.IdsDTOBuilder ids(final Set<Long> ids) {
         this.ids = ids;
         return this;
      }

      public IdsDTO build() {
         return new IdsDTO(this.ids);
      }

      @Override
      public String toString() {
         return "IdsDTO.IdsDTOBuilder(ids=" + this.ids + ")";
      }
   }
}
