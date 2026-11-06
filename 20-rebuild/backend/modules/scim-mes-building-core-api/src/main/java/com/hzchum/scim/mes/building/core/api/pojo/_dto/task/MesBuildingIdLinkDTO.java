package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingIdLinkDTO", description = "id关联关系")
public class MesBuildingIdLinkDTO {
   private Long baseId;
   private Long linkId;

   public static MesBuildingIdLinkDTO.MesBuildingIdLinkDTOBuilder builder() {
      return new MesBuildingIdLinkDTO.MesBuildingIdLinkDTOBuilder();
   }

   public MesBuildingIdLinkDTO() {
   }

   public MesBuildingIdLinkDTO(final Long baseId, final Long linkId) {
      this.baseId = baseId;
      this.linkId = linkId;
   }

   public Long getBaseId() {
      return this.baseId;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public MesBuildingIdLinkDTO setBaseId(final Long baseId) {
      this.baseId = baseId;
      return this;
   }

   public MesBuildingIdLinkDTO setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingIdLinkDTO)) {
         return false;
      } else {
         MesBuildingIdLinkDTO other = (MesBuildingIdLinkDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$baseId = this.getBaseId();
            Object other$baseId = other.getBaseId();
            if (this$baseId == null ? other$baseId == null : this$baseId.equals(other$baseId)) {
               Object this$linkId = this.getLinkId();
               Object other$linkId = other.getLinkId();
               return this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingIdLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $baseId = this.getBaseId();
      result = result * 59 + ($baseId == null ? 43 : $baseId.hashCode());
      Object $linkId = this.getLinkId();
      return result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingIdLinkDTO(baseId=" + this.getBaseId() + ", linkId=" + this.getLinkId() + ")";
   }

   public static class MesBuildingIdLinkDTOBuilder {
      private Long baseId;
      private Long linkId;

      MesBuildingIdLinkDTOBuilder() {
      }

      public MesBuildingIdLinkDTO.MesBuildingIdLinkDTOBuilder baseId(final Long baseId) {
         this.baseId = baseId;
         return this;
      }

      public MesBuildingIdLinkDTO.MesBuildingIdLinkDTOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public MesBuildingIdLinkDTO build() {
         return new MesBuildingIdLinkDTO(this.baseId, this.linkId);
      }

      @Override
      public String toString() {
         return "MesBuildingIdLinkDTO.MesBuildingIdLinkDTOBuilder(baseId=" + this.baseId + ", linkId=" + this.linkId + ")";
      }
   }
}
