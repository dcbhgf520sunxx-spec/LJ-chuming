package com.hzchum.scim.contract.core.api.pojo.dto.response;

import java.util.List;

public class DictionaryResponseDTO {
   private String name;
   private String remark;
   private List<DictionaryDetailResponseDTO> dictDetails;

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<DictionaryDetailResponseDTO> getDictDetails() {
      return this.dictDetails;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDictDetails(final List<DictionaryDetailResponseDTO> dictDetails) {
      this.dictDetails = dictDetails;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DictionaryResponseDTO)) {
         return false;
      }

      DictionaryResponseDTO other = (DictionaryResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$dictDetails = this.getDictDetails();
            Object other$dictDetails = other.getDictDetails();
            return this$dictDetails == null ? other$dictDetails == null : this$dictDetails.equals(other$dictDetails);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DictionaryResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $dictDetails = this.getDictDetails();
      return result * 59 + ($dictDetails == null ? 43 : $dictDetails.hashCode());
   }

   @Override
   public String toString() {
      return "DictionaryResponseDTO(name=" + this.getName() + ", remark=" + this.getRemark() + ", dictDetails=" + this.getDictDetails() + ")";
   }
}
