package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "套料报告单总", description = "套料报告单总")
public class MachinePartNestingPdfDTO {
   private TotalInfoNestingDTO total_info;
   private List<ResultInfoNestingDTO> result_info;

   public static MachinePartNestingPdfDTO.MachinePartNestingPdfDTOBuilder builder() {
      return new MachinePartNestingPdfDTO.MachinePartNestingPdfDTOBuilder();
   }

   public MachinePartNestingPdfDTO(final TotalInfoNestingDTO total_info, final List<ResultInfoNestingDTO> result_info) {
      this.total_info = total_info;
      this.result_info = result_info;
   }

   public MachinePartNestingPdfDTO() {
   }

   public TotalInfoNestingDTO getTotal_info() {
      return this.total_info;
   }

   public List<ResultInfoNestingDTO> getResult_info() {
      return this.result_info;
   }

   public MachinePartNestingPdfDTO setTotal_info(final TotalInfoNestingDTO total_info) {
      this.total_info = total_info;
      return this;
   }

   public MachinePartNestingPdfDTO setResult_info(final List<ResultInfoNestingDTO> result_info) {
      this.result_info = result_info;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingPdfDTO(total_info=" + this.getTotal_info() + ", result_info=" + this.getResult_info() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MachinePartNestingPdfDTO)) {
         return false;
      } else {
         MachinePartNestingPdfDTO other = (MachinePartNestingPdfDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$total_info = this.getTotal_info();
            Object other$total_info = other.getTotal_info();
            if (this$total_info == null ? other$total_info == null : this$total_info.equals(other$total_info)) {
               Object this$result_info = this.getResult_info();
               Object other$result_info = other.getResult_info();
               return this$result_info == null ? other$result_info == null : this$result_info.equals(other$result_info);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartNestingPdfDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $total_info = this.getTotal_info();
      result = result * 59 + ($total_info == null ? 43 : $total_info.hashCode());
      Object $result_info = this.getResult_info();
      return result * 59 + ($result_info == null ? 43 : $result_info.hashCode());
   }

   public static class MachinePartNestingPdfDTOBuilder {
      private TotalInfoNestingDTO total_info;
      private List<ResultInfoNestingDTO> result_info;

      MachinePartNestingPdfDTOBuilder() {
      }

      public MachinePartNestingPdfDTO.MachinePartNestingPdfDTOBuilder total_info(final TotalInfoNestingDTO total_info) {
         this.total_info = total_info;
         return this;
      }

      public MachinePartNestingPdfDTO.MachinePartNestingPdfDTOBuilder result_info(final List<ResultInfoNestingDTO> result_info) {
         this.result_info = result_info;
         return this;
      }

      public MachinePartNestingPdfDTO build() {
         return new MachinePartNestingPdfDTO(this.total_info, this.result_info);
      }

      @Override
      public String toString() {
         return "MachinePartNestingPdfDTO.MachinePartNestingPdfDTOBuilder(total_info=" + this.total_info + ", result_info=" + this.result_info + ")";
      }
   }
}
