package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class PurchaseOrderBranchCompanyDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "name")
   private String name;

   PurchaseOrderBranchCompanyDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public static PurchaseOrderBranchCompanyDTO.PurchaseOrderBranchCompanyDTOBuilder builder() {
      return new PurchaseOrderBranchCompanyDTO.PurchaseOrderBranchCompanyDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PurchaseOrderBranchCompanyDTO)) {
         return false;
      } else {
         PurchaseOrderBranchCompanyDTO other = (PurchaseOrderBranchCompanyDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseOrderBranchCompanyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderBranchCompanyDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class PurchaseOrderBranchCompanyDTOBuilder {
      private Long id;
      private String name;

      PurchaseOrderBranchCompanyDTOBuilder() {
      }

      public PurchaseOrderBranchCompanyDTO.PurchaseOrderBranchCompanyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PurchaseOrderBranchCompanyDTO.PurchaseOrderBranchCompanyDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PurchaseOrderBranchCompanyDTO build() {
         return new PurchaseOrderBranchCompanyDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "PurchaseOrderBranchCompanyDTO.PurchaseOrderBranchCompanyDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
