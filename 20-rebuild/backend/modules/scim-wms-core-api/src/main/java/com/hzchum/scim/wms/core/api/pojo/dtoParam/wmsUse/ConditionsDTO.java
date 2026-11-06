package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.util.List;

public class ConditionsDTO {
   private List<String> specificationList;
   private List<BigDecimal> thicknessList;

   public static ConditionsDTO.ConditionsDTOBuilder builder() {
      return new ConditionsDTO.ConditionsDTOBuilder();
   }

   public List<String> getSpecificationList() {
      return this.specificationList;
   }

   public List<BigDecimal> getThicknessList() {
      return this.thicknessList;
   }

   public void setSpecificationList(final List<String> specificationList) {
      this.specificationList = specificationList;
   }

   public void setThicknessList(final List<BigDecimal> thicknessList) {
      this.thicknessList = thicknessList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ConditionsDTO)) {
         return false;
      } else {
         ConditionsDTO other = (ConditionsDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$specificationList = this.getSpecificationList();
            Object other$specificationList = other.getSpecificationList();
            if (this$specificationList == null ? other$specificationList == null : this$specificationList.equals(other$specificationList)) {
               Object this$thicknessList = this.getThicknessList();
               Object other$thicknessList = other.getThicknessList();
               return this$thicknessList == null ? other$thicknessList == null : this$thicknessList.equals(other$thicknessList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConditionsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specificationList = this.getSpecificationList();
      result = result * 59 + ($specificationList == null ? 43 : $specificationList.hashCode());
      Object $thicknessList = this.getThicknessList();
      return result * 59 + ($thicknessList == null ? 43 : $thicknessList.hashCode());
   }

   @Override
   public String toString() {
      return "ConditionsDTO(specificationList=" + this.getSpecificationList() + ", thicknessList=" + this.getThicknessList() + ")";
   }

   public ConditionsDTO(final List<String> specificationList, final List<BigDecimal> thicknessList) {
      this.specificationList = specificationList;
      this.thicknessList = thicknessList;
   }

   public ConditionsDTO() {
   }

   public static class ConditionsDTOBuilder {
      private List<String> specificationList;
      private List<BigDecimal> thicknessList;

      ConditionsDTOBuilder() {
      }

      public ConditionsDTO.ConditionsDTOBuilder specificationList(final List<String> specificationList) {
         this.specificationList = specificationList;
         return this;
      }

      public ConditionsDTO.ConditionsDTOBuilder thicknessList(final List<BigDecimal> thicknessList) {
         this.thicknessList = thicknessList;
         return this;
      }

      public ConditionsDTO build() {
         return new ConditionsDTO(this.specificationList, this.thicknessList);
      }

      @Override
      public String toString() {
         return "ConditionsDTO.ConditionsDTOBuilder(specificationList=" + this.specificationList + ", thicknessList=" + this.thicknessList + ")";
      }
   }
}
