package com.hzchum.scim.contract.core.api.pojo.dto;

import java.util.List;

public class ContractQuarterPooledAnalysisDTO {
   List<ContractPooledAnalysisDTO> listOne;
   List<ContractPooledAnalysisDTO> listTwo;

   ContractQuarterPooledAnalysisDTO(final List<ContractPooledAnalysisDTO> listOne, final List<ContractPooledAnalysisDTO> listTwo) {
      this.listOne = listOne;
      this.listTwo = listTwo;
   }

   public static ContractQuarterPooledAnalysisDTO.ContractQuarterPooledAnalysisDTOBuilder builder() {
      return new ContractQuarterPooledAnalysisDTO.ContractQuarterPooledAnalysisDTOBuilder();
   }

   public List<ContractPooledAnalysisDTO> getListOne() {
      return this.listOne;
   }

   public List<ContractPooledAnalysisDTO> getListTwo() {
      return this.listTwo;
   }

   public void setListOne(final List<ContractPooledAnalysisDTO> listOne) {
      this.listOne = listOne;
   }

   public void setListTwo(final List<ContractPooledAnalysisDTO> listTwo) {
      this.listTwo = listTwo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContractQuarterPooledAnalysisDTO)) {
         return false;
      } else {
         ContractQuarterPooledAnalysisDTO other = (ContractQuarterPooledAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$listOne = this.getListOne();
            Object other$listOne = other.getListOne();
            if (this$listOne == null ? other$listOne == null : this$listOne.equals(other$listOne)) {
               Object this$listTwo = this.getListTwo();
               Object other$listTwo = other.getListTwo();
               return this$listTwo == null ? other$listTwo == null : this$listTwo.equals(other$listTwo);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractQuarterPooledAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $listOne = this.getListOne();
      result = result * 59 + ($listOne == null ? 43 : $listOne.hashCode());
      Object $listTwo = this.getListTwo();
      return result * 59 + ($listTwo == null ? 43 : $listTwo.hashCode());
   }

   @Override
   public String toString() {
      return "ContractQuarterPooledAnalysisDTO(listOne=" + this.getListOne() + ", listTwo=" + this.getListTwo() + ")";
   }

   public static class ContractQuarterPooledAnalysisDTOBuilder {
      private List<ContractPooledAnalysisDTO> listOne;
      private List<ContractPooledAnalysisDTO> listTwo;

      ContractQuarterPooledAnalysisDTOBuilder() {
      }

      public ContractQuarterPooledAnalysisDTO.ContractQuarterPooledAnalysisDTOBuilder listOne(final List<ContractPooledAnalysisDTO> listOne) {
         this.listOne = listOne;
         return this;
      }

      public ContractQuarterPooledAnalysisDTO.ContractQuarterPooledAnalysisDTOBuilder listTwo(final List<ContractPooledAnalysisDTO> listTwo) {
         this.listTwo = listTwo;
         return this;
      }

      public ContractQuarterPooledAnalysisDTO build() {
         return new ContractQuarterPooledAnalysisDTO(this.listOne, this.listTwo);
      }

      @Override
      public String toString() {
         return "ContractQuarterPooledAnalysisDTO.ContractQuarterPooledAnalysisDTOBuilder(listOne=" + this.listOne + ", listTwo=" + this.listTwo + ")";
      }
   }
}
