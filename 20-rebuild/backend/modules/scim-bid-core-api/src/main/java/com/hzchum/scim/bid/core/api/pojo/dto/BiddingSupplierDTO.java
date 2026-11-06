package com.hzchum.scim.bid.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.Add;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BiddingSupplierDTO {
   @NotNull(message = "供应商id不能为空", groups = Add.class)
   private Long supplierId;
   @NotBlank(message = "主营业务ids不能为空", groups = Add.class)
   private String subjectIds;
   @NotBlank(message = "可服务区域ids不能为空", groups = Add.class)
   private String regionIds;

   public static BiddingSupplierDTO.BiddingSupplierDTOBuilder builder() {
      return new BiddingSupplierDTO.BiddingSupplierDTOBuilder();
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSubjectIds() {
      return this.subjectIds;
   }

   public String getRegionIds() {
      return this.regionIds;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSubjectIds(final String subjectIds) {
      this.subjectIds = subjectIds;
   }

   public void setRegionIds(final String regionIds) {
      this.regionIds = regionIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiddingSupplierDTO)) {
         return false;
      }

      BiddingSupplierDTO other = (BiddingSupplierDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$subjectIds = this.getSubjectIds();
         Object other$subjectIds = other.getSubjectIds();
         if (this$subjectIds == null ? other$subjectIds == null : this$subjectIds.equals(other$subjectIds)) {
            Object this$regionIds = this.getRegionIds();
            Object other$regionIds = other.getRegionIds();
            return this$regionIds == null ? other$regionIds == null : this$regionIds.equals(other$regionIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BiddingSupplierDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subjectIds = this.getSubjectIds();
      result = result * 59 + ($subjectIds == null ? 43 : $subjectIds.hashCode());
      Object $regionIds = this.getRegionIds();
      return result * 59 + ($regionIds == null ? 43 : $regionIds.hashCode());
   }

   @Override
   public String toString() {
      return "BiddingSupplierDTO(supplierId=" + this.getSupplierId() + ", subjectIds=" + this.getSubjectIds() + ", regionIds=" + this.getRegionIds() + ")";
   }

   public BiddingSupplierDTO() {
   }

   public BiddingSupplierDTO(final Long supplierId, final String subjectIds, final String regionIds) {
      this.supplierId = supplierId;
      this.subjectIds = subjectIds;
      this.regionIds = regionIds;
   }

   public static class BiddingSupplierDTOBuilder {
      private Long supplierId;
      private String subjectIds;
      private String regionIds;

      BiddingSupplierDTOBuilder() {
      }

      public BiddingSupplierDTO.BiddingSupplierDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public BiddingSupplierDTO.BiddingSupplierDTOBuilder subjectIds(final String subjectIds) {
         this.subjectIds = subjectIds;
         return this;
      }

      public BiddingSupplierDTO.BiddingSupplierDTOBuilder regionIds(final String regionIds) {
         this.regionIds = regionIds;
         return this;
      }

      public BiddingSupplierDTO build() {
         return new BiddingSupplierDTO(this.supplierId, this.subjectIds, this.regionIds);
      }

      @Override
      public String toString() {
         return "BiddingSupplierDTO.BiddingSupplierDTOBuilder(supplierId="
            + this.supplierId
            + ", subjectIds="
            + this.subjectIds
            + ", regionIds="
            + this.regionIds
            + ")";
      }
   }
}
