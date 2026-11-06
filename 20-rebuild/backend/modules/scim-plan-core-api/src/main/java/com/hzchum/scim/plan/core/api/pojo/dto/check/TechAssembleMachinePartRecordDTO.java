package com.hzchum.scim.plan.core.api.pojo.dto.check;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel("零件和部件导入记录DTO")
public class TechAssembleMachinePartRecordDTO {
   private List<TechMachinePartRecordDTO> techAssembleRecordDTO;
   private List<TechMachinePartRecordDTO> techAssembleRecordNewDTO;
   private List<TechAssembleRecordDTO> techMachinePartRecordDTO;

   public List<TechMachinePartRecordDTO> getTechAssembleRecordDTO() {
      return this.techAssembleRecordDTO;
   }

   public List<TechMachinePartRecordDTO> getTechAssembleRecordNewDTO() {
      return this.techAssembleRecordNewDTO;
   }

   public List<TechAssembleRecordDTO> getTechMachinePartRecordDTO() {
      return this.techMachinePartRecordDTO;
   }

   public void setTechAssembleRecordDTO(final List<TechMachinePartRecordDTO> techAssembleRecordDTO) {
      this.techAssembleRecordDTO = techAssembleRecordDTO;
   }

   public void setTechAssembleRecordNewDTO(final List<TechMachinePartRecordDTO> techAssembleRecordNewDTO) {
      this.techAssembleRecordNewDTO = techAssembleRecordNewDTO;
   }

   public void setTechMachinePartRecordDTO(final List<TechAssembleRecordDTO> techMachinePartRecordDTO) {
      this.techMachinePartRecordDTO = techMachinePartRecordDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleMachinePartRecordDTO)) {
         return false;
      }

      TechAssembleMachinePartRecordDTO other = (TechAssembleMachinePartRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$techAssembleRecordDTO = this.getTechAssembleRecordDTO();
      Object other$techAssembleRecordDTO = other.getTechAssembleRecordDTO();
      if (this$techAssembleRecordDTO == null ? other$techAssembleRecordDTO == null : this$techAssembleRecordDTO.equals(other$techAssembleRecordDTO)) {
         Object this$techAssembleRecordNewDTO = this.getTechAssembleRecordNewDTO();
         Object other$techAssembleRecordNewDTO = other.getTechAssembleRecordNewDTO();
         if (this$techAssembleRecordNewDTO == null
            ? other$techAssembleRecordNewDTO == null
            : this$techAssembleRecordNewDTO.equals(other$techAssembleRecordNewDTO)) {
            Object this$techMachinePartRecordDTO = this.getTechMachinePartRecordDTO();
            Object other$techMachinePartRecordDTO = other.getTechMachinePartRecordDTO();
            return this$techMachinePartRecordDTO == null
               ? other$techMachinePartRecordDTO == null
               : this$techMachinePartRecordDTO.equals(other$techMachinePartRecordDTO);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechAssembleMachinePartRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $techAssembleRecordDTO = this.getTechAssembleRecordDTO();
      result = result * 59 + ($techAssembleRecordDTO == null ? 43 : $techAssembleRecordDTO.hashCode());
      Object $techAssembleRecordNewDTO = this.getTechAssembleRecordNewDTO();
      result = result * 59 + ($techAssembleRecordNewDTO == null ? 43 : $techAssembleRecordNewDTO.hashCode());
      Object $techMachinePartRecordDTO = this.getTechMachinePartRecordDTO();
      return result * 59 + ($techMachinePartRecordDTO == null ? 43 : $techMachinePartRecordDTO.hashCode());
   }

   @Override
   public String toString() {
      return "TechAssembleMachinePartRecordDTO(techAssembleRecordDTO="
         + this.getTechAssembleRecordDTO()
         + ", techAssembleRecordNewDTO="
         + this.getTechAssembleRecordNewDTO()
         + ", techMachinePartRecordDTO="
         + this.getTechMachinePartRecordDTO()
         + ")";
   }
}
