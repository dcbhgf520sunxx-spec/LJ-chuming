package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "套料报告单第二部分", description = "套料报告单第二部分")
public class TotalInfoNestingDTO {
   private List<PlateInfoDetailNestingDTO> plate_info_detail;
   private List<PlateInfoNestingDTO> plate_info;
   private List<PartInfoNestingDTO> part_info;

   public static TotalInfoNestingDTO.TotalInfoNestingDTOBuilder builder() {
      return new TotalInfoNestingDTO.TotalInfoNestingDTOBuilder();
   }

   public TotalInfoNestingDTO(
      final List<PlateInfoDetailNestingDTO> plate_info_detail, final List<PlateInfoNestingDTO> plate_info, final List<PartInfoNestingDTO> part_info
   ) {
      this.plate_info_detail = plate_info_detail;
      this.plate_info = plate_info;
      this.part_info = part_info;
   }

   public TotalInfoNestingDTO() {
   }

   public List<PlateInfoDetailNestingDTO> getPlate_info_detail() {
      return this.plate_info_detail;
   }

   public List<PlateInfoNestingDTO> getPlate_info() {
      return this.plate_info;
   }

   public List<PartInfoNestingDTO> getPart_info() {
      return this.part_info;
   }

   public TotalInfoNestingDTO setPlate_info_detail(final List<PlateInfoDetailNestingDTO> plate_info_detail) {
      this.plate_info_detail = plate_info_detail;
      return this;
   }

   public TotalInfoNestingDTO setPlate_info(final List<PlateInfoNestingDTO> plate_info) {
      this.plate_info = plate_info;
      return this;
   }

   public TotalInfoNestingDTO setPart_info(final List<PartInfoNestingDTO> part_info) {
      this.part_info = part_info;
      return this;
   }

   @Override
   public String toString() {
      return "TotalInfoNestingDTO(plate_info_detail="
         + this.getPlate_info_detail()
         + ", plate_info="
         + this.getPlate_info()
         + ", part_info="
         + this.getPart_info()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TotalInfoNestingDTO)) {
         return false;
      }

      TotalInfoNestingDTO other = (TotalInfoNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$plate_info_detail = this.getPlate_info_detail();
      Object other$plate_info_detail = other.getPlate_info_detail();
      if (this$plate_info_detail == null ? other$plate_info_detail == null : this$plate_info_detail.equals(other$plate_info_detail)) {
         Object this$plate_info = this.getPlate_info();
         Object other$plate_info = other.getPlate_info();
         if (this$plate_info == null ? other$plate_info == null : this$plate_info.equals(other$plate_info)) {
            Object this$part_info = this.getPart_info();
            Object other$part_info = other.getPart_info();
            return this$part_info == null ? other$part_info == null : this$part_info.equals(other$part_info);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TotalInfoNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $plate_info_detail = this.getPlate_info_detail();
      result = result * 59 + ($plate_info_detail == null ? 43 : $plate_info_detail.hashCode());
      Object $plate_info = this.getPlate_info();
      result = result * 59 + ($plate_info == null ? 43 : $plate_info.hashCode());
      Object $part_info = this.getPart_info();
      return result * 59 + ($part_info == null ? 43 : $part_info.hashCode());
   }

   public static class TotalInfoNestingDTOBuilder {
      private List<PlateInfoDetailNestingDTO> plate_info_detail;
      private List<PlateInfoNestingDTO> plate_info;
      private List<PartInfoNestingDTO> part_info;

      TotalInfoNestingDTOBuilder() {
      }

      public TotalInfoNestingDTO.TotalInfoNestingDTOBuilder plate_info_detail(final List<PlateInfoDetailNestingDTO> plate_info_detail) {
         this.plate_info_detail = plate_info_detail;
         return this;
      }

      public TotalInfoNestingDTO.TotalInfoNestingDTOBuilder plate_info(final List<PlateInfoNestingDTO> plate_info) {
         this.plate_info = plate_info;
         return this;
      }

      public TotalInfoNestingDTO.TotalInfoNestingDTOBuilder part_info(final List<PartInfoNestingDTO> part_info) {
         this.part_info = part_info;
         return this;
      }

      public TotalInfoNestingDTO build() {
         return new TotalInfoNestingDTO(this.plate_info_detail, this.plate_info, this.part_info);
      }

      @Override
      public String toString() {
         return "TotalInfoNestingDTO.TotalInfoNestingDTOBuilder(plate_info_detail="
            + this.plate_info_detail
            + ", plate_info="
            + this.plate_info
            + ", part_info="
            + this.part_info
            + ")";
      }
   }
}
