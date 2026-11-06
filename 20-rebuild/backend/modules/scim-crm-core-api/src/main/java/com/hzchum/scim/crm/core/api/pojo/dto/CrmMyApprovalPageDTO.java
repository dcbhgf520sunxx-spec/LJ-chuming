package com.hzchum.scim.crm.core.api.pojo.dto;

public class CrmMyApprovalPageDTO {
   private Long id;

   public static CrmMyApprovalPageDTO.CrmMyApprovalPageDTOBuilder builder() {
      return new CrmMyApprovalPageDTO.CrmMyApprovalPageDTOBuilder();
   }

   public CrmMyApprovalPageDTO() {
   }

   public CrmMyApprovalPageDTO(final Long id) {
      this.id = id;
   }

   public Long getId() {
      return this.id;
   }

   public CrmMyApprovalPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "CrmMyApprovalPageDTO(id=" + this.getId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmMyApprovalPageDTO)) {
         return false;
      }

      CrmMyApprovalPageDTO other = (CrmMyApprovalPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmMyApprovalPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   public static class CrmMyApprovalPageDTOBuilder {
      private Long id;

      CrmMyApprovalPageDTOBuilder() {
      }

      public CrmMyApprovalPageDTO.CrmMyApprovalPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmMyApprovalPageDTO build() {
         return new CrmMyApprovalPageDTO(this.id);
      }

      @Override
      public String toString() {
         return "CrmMyApprovalPageDTO.CrmMyApprovalPageDTOBuilder(id=" + this.id + ")";
      }
   }
}
