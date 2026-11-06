package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "零件排产明细", description = "零件排产明细")
public class MachinePartNestingGuidDetailDTO {
   private String guid;
   private String result_name;
   private Integer amount;
   private Integer part_amount;
   private Integer in_cut_amount;
   private Integer finish_cut_amount;
   private Double part_in_cut_amount;
   private Double part_finish_cut_amount;
   private String plate_guid;
   private String plate_name;
   private Integer plate_idx;
   private Double utilization;
   private PlateDTO plate_library;
   private List<NestPartDTO> parts;
   private List<AbnorPlateLibraryDTO> abnor_plate_library;

   public static MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder builder() {
      return new MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder();
   }

   public MachinePartNestingGuidDetailDTO(
      final String guid,
      final String result_name,
      final Integer amount,
      final Integer part_amount,
      final Integer in_cut_amount,
      final Integer finish_cut_amount,
      final Double part_in_cut_amount,
      final Double part_finish_cut_amount,
      final String plate_guid,
      final String plate_name,
      final Integer plate_idx,
      final Double utilization,
      final PlateDTO plate_library,
      final List<NestPartDTO> parts,
      final List<AbnorPlateLibraryDTO> abnor_plate_library
   ) {
      this.guid = guid;
      this.result_name = result_name;
      this.amount = amount;
      this.part_amount = part_amount;
      this.in_cut_amount = in_cut_amount;
      this.finish_cut_amount = finish_cut_amount;
      this.part_in_cut_amount = part_in_cut_amount;
      this.part_finish_cut_amount = part_finish_cut_amount;
      this.plate_guid = plate_guid;
      this.plate_name = plate_name;
      this.plate_idx = plate_idx;
      this.utilization = utilization;
      this.plate_library = plate_library;
      this.parts = parts;
      this.abnor_plate_library = abnor_plate_library;
   }

   public MachinePartNestingGuidDetailDTO() {
   }

   public String getGuid() {
      return this.guid;
   }

   public String getResult_name() {
      return this.result_name;
   }

   public Integer getAmount() {
      return this.amount;
   }

   public Integer getPart_amount() {
      return this.part_amount;
   }

   public Integer getIn_cut_amount() {
      return this.in_cut_amount;
   }

   public Integer getFinish_cut_amount() {
      return this.finish_cut_amount;
   }

   public Double getPart_in_cut_amount() {
      return this.part_in_cut_amount;
   }

   public Double getPart_finish_cut_amount() {
      return this.part_finish_cut_amount;
   }

   public String getPlate_guid() {
      return this.plate_guid;
   }

   public String getPlate_name() {
      return this.plate_name;
   }

   public Integer getPlate_idx() {
      return this.plate_idx;
   }

   public Double getUtilization() {
      return this.utilization;
   }

   public PlateDTO getPlate_library() {
      return this.plate_library;
   }

   public List<NestPartDTO> getParts() {
      return this.parts;
   }

   public List<AbnorPlateLibraryDTO> getAbnor_plate_library() {
      return this.abnor_plate_library;
   }

   public MachinePartNestingGuidDetailDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setResult_name(final String result_name) {
      this.result_name = result_name;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setAmount(final Integer amount) {
      this.amount = amount;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPart_amount(final Integer part_amount) {
      this.part_amount = part_amount;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setIn_cut_amount(final Integer in_cut_amount) {
      this.in_cut_amount = in_cut_amount;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setFinish_cut_amount(final Integer finish_cut_amount) {
      this.finish_cut_amount = finish_cut_amount;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPart_in_cut_amount(final Double part_in_cut_amount) {
      this.part_in_cut_amount = part_in_cut_amount;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPart_finish_cut_amount(final Double part_finish_cut_amount) {
      this.part_finish_cut_amount = part_finish_cut_amount;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPlate_guid(final String plate_guid) {
      this.plate_guid = plate_guid;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPlate_name(final String plate_name) {
      this.plate_name = plate_name;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPlate_idx(final Integer plate_idx) {
      this.plate_idx = plate_idx;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setUtilization(final Double utilization) {
      this.utilization = utilization;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setPlate_library(final PlateDTO plate_library) {
      this.plate_library = plate_library;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setParts(final List<NestPartDTO> parts) {
      this.parts = parts;
      return this;
   }

   public MachinePartNestingGuidDetailDTO setAbnor_plate_library(final List<AbnorPlateLibraryDTO> abnor_plate_library) {
      this.abnor_plate_library = abnor_plate_library;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingGuidDetailDTO(guid="
         + this.getGuid()
         + ", result_name="
         + this.getResult_name()
         + ", amount="
         + this.getAmount()
         + ", part_amount="
         + this.getPart_amount()
         + ", in_cut_amount="
         + this.getIn_cut_amount()
         + ", finish_cut_amount="
         + this.getFinish_cut_amount()
         + ", part_in_cut_amount="
         + this.getPart_in_cut_amount()
         + ", part_finish_cut_amount="
         + this.getPart_finish_cut_amount()
         + ", plate_guid="
         + this.getPlate_guid()
         + ", plate_name="
         + this.getPlate_name()
         + ", plate_idx="
         + this.getPlate_idx()
         + ", utilization="
         + this.getUtilization()
         + ", plate_library="
         + this.getPlate_library()
         + ", parts="
         + this.getParts()
         + ", abnor_plate_library="
         + this.getAbnor_plate_library()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingGuidDetailDTO)) {
         return false;
      }

      MachinePartNestingGuidDetailDTO other = (MachinePartNestingGuidDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$amount = this.getAmount();
      Object other$amount = other.getAmount();
      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
         Object this$part_amount = this.getPart_amount();
         Object other$part_amount = other.getPart_amount();
         if (this$part_amount == null ? other$part_amount == null : this$part_amount.equals(other$part_amount)) {
            Object this$in_cut_amount = this.getIn_cut_amount();
            Object other$in_cut_amount = other.getIn_cut_amount();
            if (this$in_cut_amount == null ? other$in_cut_amount == null : this$in_cut_amount.equals(other$in_cut_amount)) {
               Object this$finish_cut_amount = this.getFinish_cut_amount();
               Object other$finish_cut_amount = other.getFinish_cut_amount();
               if (this$finish_cut_amount == null ? other$finish_cut_amount == null : this$finish_cut_amount.equals(other$finish_cut_amount)) {
                  Object this$part_in_cut_amount = this.getPart_in_cut_amount();
                  Object other$part_in_cut_amount = other.getPart_in_cut_amount();
                  if (this$part_in_cut_amount == null ? other$part_in_cut_amount == null : this$part_in_cut_amount.equals(other$part_in_cut_amount)) {
                     Object this$part_finish_cut_amount = this.getPart_finish_cut_amount();
                     Object other$part_finish_cut_amount = other.getPart_finish_cut_amount();
                     if (this$part_finish_cut_amount == null
                        ? other$part_finish_cut_amount == null
                        : this$part_finish_cut_amount.equals(other$part_finish_cut_amount)) {
                        Object this$plate_idx = this.getPlate_idx();
                        Object other$plate_idx = other.getPlate_idx();
                        if (this$plate_idx == null ? other$plate_idx == null : this$plate_idx.equals(other$plate_idx)) {
                           Object this$utilization = this.getUtilization();
                           Object other$utilization = other.getUtilization();
                           if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                              Object this$guid = this.getGuid();
                              Object other$guid = other.getGuid();
                              if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                                 Object this$result_name = this.getResult_name();
                                 Object other$result_name = other.getResult_name();
                                 if (this$result_name == null ? other$result_name == null : this$result_name.equals(other$result_name)) {
                                    Object this$plate_guid = this.getPlate_guid();
                                    Object other$plate_guid = other.getPlate_guid();
                                    if (this$plate_guid == null ? other$plate_guid == null : this$plate_guid.equals(other$plate_guid)) {
                                       Object this$plate_name = this.getPlate_name();
                                       Object other$plate_name = other.getPlate_name();
                                       if (this$plate_name == null ? other$plate_name == null : this$plate_name.equals(other$plate_name)) {
                                          Object this$plate_library = this.getPlate_library();
                                          Object other$plate_library = other.getPlate_library();
                                          if (this$plate_library == null ? other$plate_library == null : this$plate_library.equals(other$plate_library)) {
                                             Object this$parts = this.getParts();
                                             Object other$parts = other.getParts();
                                             if (this$parts == null ? other$parts == null : this$parts.equals(other$parts)) {
                                                Object this$abnor_plate_library = this.getAbnor_plate_library();
                                                Object other$abnor_plate_library = other.getAbnor_plate_library();
                                                return this$abnor_plate_library == null
                                                   ? other$abnor_plate_library == null
                                                   : this$abnor_plate_library.equals(other$abnor_plate_library);
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartNestingGuidDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $part_amount = this.getPart_amount();
      result = result * 59 + ($part_amount == null ? 43 : $part_amount.hashCode());
      Object $in_cut_amount = this.getIn_cut_amount();
      result = result * 59 + ($in_cut_amount == null ? 43 : $in_cut_amount.hashCode());
      Object $finish_cut_amount = this.getFinish_cut_amount();
      result = result * 59 + ($finish_cut_amount == null ? 43 : $finish_cut_amount.hashCode());
      Object $part_in_cut_amount = this.getPart_in_cut_amount();
      result = result * 59 + ($part_in_cut_amount == null ? 43 : $part_in_cut_amount.hashCode());
      Object $part_finish_cut_amount = this.getPart_finish_cut_amount();
      result = result * 59 + ($part_finish_cut_amount == null ? 43 : $part_finish_cut_amount.hashCode());
      Object $plate_idx = this.getPlate_idx();
      result = result * 59 + ($plate_idx == null ? 43 : $plate_idx.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $result_name = this.getResult_name();
      result = result * 59 + ($result_name == null ? 43 : $result_name.hashCode());
      Object $plate_guid = this.getPlate_guid();
      result = result * 59 + ($plate_guid == null ? 43 : $plate_guid.hashCode());
      Object $plate_name = this.getPlate_name();
      result = result * 59 + ($plate_name == null ? 43 : $plate_name.hashCode());
      Object $plate_library = this.getPlate_library();
      result = result * 59 + ($plate_library == null ? 43 : $plate_library.hashCode());
      Object $parts = this.getParts();
      result = result * 59 + ($parts == null ? 43 : $parts.hashCode());
      Object $abnor_plate_library = this.getAbnor_plate_library();
      return result * 59 + ($abnor_plate_library == null ? 43 : $abnor_plate_library.hashCode());
   }

   public static class MachinePartNestingGuidDetailDTOBuilder {
      private String guid;
      private String result_name;
      private Integer amount;
      private Integer part_amount;
      private Integer in_cut_amount;
      private Integer finish_cut_amount;
      private Double part_in_cut_amount;
      private Double part_finish_cut_amount;
      private String plate_guid;
      private String plate_name;
      private Integer plate_idx;
      private Double utilization;
      private PlateDTO plate_library;
      private List<NestPartDTO> parts;
      private List<AbnorPlateLibraryDTO> abnor_plate_library;

      MachinePartNestingGuidDetailDTOBuilder() {
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder result_name(final String result_name) {
         this.result_name = result_name;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder amount(final Integer amount) {
         this.amount = amount;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder part_amount(final Integer part_amount) {
         this.part_amount = part_amount;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder in_cut_amount(final Integer in_cut_amount) {
         this.in_cut_amount = in_cut_amount;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder finish_cut_amount(final Integer finish_cut_amount) {
         this.finish_cut_amount = finish_cut_amount;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder part_in_cut_amount(final Double part_in_cut_amount) {
         this.part_in_cut_amount = part_in_cut_amount;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder part_finish_cut_amount(final Double part_finish_cut_amount) {
         this.part_finish_cut_amount = part_finish_cut_amount;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder plate_guid(final String plate_guid) {
         this.plate_guid = plate_guid;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder plate_name(final String plate_name) {
         this.plate_name = plate_name;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder plate_idx(final Integer plate_idx) {
         this.plate_idx = plate_idx;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder utilization(final Double utilization) {
         this.utilization = utilization;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder plate_library(final PlateDTO plate_library) {
         this.plate_library = plate_library;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder parts(final List<NestPartDTO> parts) {
         this.parts = parts;
         return this;
      }

      public MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder abnor_plate_library(final List<AbnorPlateLibraryDTO> abnor_plate_library) {
         this.abnor_plate_library = abnor_plate_library;
         return this;
      }

      public MachinePartNestingGuidDetailDTO build() {
         return new MachinePartNestingGuidDetailDTO(
            this.guid,
            this.result_name,
            this.amount,
            this.part_amount,
            this.in_cut_amount,
            this.finish_cut_amount,
            this.part_in_cut_amount,
            this.part_finish_cut_amount,
            this.plate_guid,
            this.plate_name,
            this.plate_idx,
            this.utilization,
            this.plate_library,
            this.parts,
            this.abnor_plate_library
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingGuidDetailDTO.MachinePartNestingGuidDetailDTOBuilder(guid="
            + this.guid
            + ", result_name="
            + this.result_name
            + ", amount="
            + this.amount
            + ", part_amount="
            + this.part_amount
            + ", in_cut_amount="
            + this.in_cut_amount
            + ", finish_cut_amount="
            + this.finish_cut_amount
            + ", part_in_cut_amount="
            + this.part_in_cut_amount
            + ", part_finish_cut_amount="
            + this.part_finish_cut_amount
            + ", plate_guid="
            + this.plate_guid
            + ", plate_name="
            + this.plate_name
            + ", plate_idx="
            + this.plate_idx
            + ", utilization="
            + this.utilization
            + ", plate_library="
            + this.plate_library
            + ", parts="
            + this.parts
            + ", abnor_plate_library="
            + this.abnor_plate_library
            + ")";
      }
   }
}
