package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmBiddingCenterProjectListDTO {
   @ApiModelProperty(name = "id")
   private Long id;

   public static CrmBiddingCenterProjectListDTO.CrmBiddingCenterProjectListDTOBuilder builder() {
      return new CrmBiddingCenterProjectListDTO.CrmBiddingCenterProjectListDTOBuilder();
   }

   public CrmBiddingCenterProjectListDTO() {
   }

   public CrmBiddingCenterProjectListDTO(final Long id) {
      this.id = id;
   }

   public Long getId() {
      return this.id;
   }

   public CrmBiddingCenterProjectListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingCenterProjectListDTO(id=" + this.getId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingCenterProjectListDTO)) {
         return false;
      }

      CrmBiddingCenterProjectListDTO other = (CrmBiddingCenterProjectListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmBiddingCenterProjectListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   public static class CrmBiddingCenterProjectListDTOBuilder {
      private Long id;

      CrmBiddingCenterProjectListDTOBuilder() {
      }

      public CrmBiddingCenterProjectListDTO.CrmBiddingCenterProjectListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBiddingCenterProjectListDTO build() {
         return new CrmBiddingCenterProjectListDTO(this.id);
      }

      @Override
      public String toString() {
         return "CrmBiddingCenterProjectListDTO.CrmBiddingCenterProjectListDTOBuilder(id=" + this.id + ")";
      }
   }
}
