package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

public class ReceiveDateDTO {
   @JsonInclude(Include.NON_NULL)
   private List<ReceiveOutboundDetailDTO> plantOutboundDetailList;
   @JsonInclude(Include.NON_NULL)
   private List<ReceiveReturnDetailDTO> plantReturnDetailList;
   @JsonInclude(Include.NON_NULL)
   private List<ReceiveOutboundDetailDTO> sectionOutboundDetailList;
   @JsonInclude(Include.NON_NULL)
   private List<ReceiveReturnDetailDTO> sectionReturnDetailList;

   public static ReceiveDateDTO.ReceiveDateDTOBuilder builder() {
      return new ReceiveDateDTO.ReceiveDateDTOBuilder();
   }

   public List<ReceiveOutboundDetailDTO> getPlantOutboundDetailList() {
      return this.plantOutboundDetailList;
   }

   public List<ReceiveReturnDetailDTO> getPlantReturnDetailList() {
      return this.plantReturnDetailList;
   }

   public List<ReceiveOutboundDetailDTO> getSectionOutboundDetailList() {
      return this.sectionOutboundDetailList;
   }

   public List<ReceiveReturnDetailDTO> getSectionReturnDetailList() {
      return this.sectionReturnDetailList;
   }

   public void setPlantOutboundDetailList(final List<ReceiveOutboundDetailDTO> plantOutboundDetailList) {
      this.plantOutboundDetailList = plantOutboundDetailList;
   }

   public void setPlantReturnDetailList(final List<ReceiveReturnDetailDTO> plantReturnDetailList) {
      this.plantReturnDetailList = plantReturnDetailList;
   }

   public void setSectionOutboundDetailList(final List<ReceiveOutboundDetailDTO> sectionOutboundDetailList) {
      this.sectionOutboundDetailList = sectionOutboundDetailList;
   }

   public void setSectionReturnDetailList(final List<ReceiveReturnDetailDTO> sectionReturnDetailList) {
      this.sectionReturnDetailList = sectionReturnDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceiveDateDTO)) {
         return false;
      }

      ReceiveDateDTO other = (ReceiveDateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$plantOutboundDetailList = this.getPlantOutboundDetailList();
      Object other$plantOutboundDetailList = other.getPlantOutboundDetailList();
      if (this$plantOutboundDetailList == null ? other$plantOutboundDetailList == null : this$plantOutboundDetailList.equals(other$plantOutboundDetailList)) {
         Object this$plantReturnDetailList = this.getPlantReturnDetailList();
         Object other$plantReturnDetailList = other.getPlantReturnDetailList();
         if (this$plantReturnDetailList == null ? other$plantReturnDetailList == null : this$plantReturnDetailList.equals(other$plantReturnDetailList)) {
            Object this$sectionOutboundDetailList = this.getSectionOutboundDetailList();
            Object other$sectionOutboundDetailList = other.getSectionOutboundDetailList();
            if (this$sectionOutboundDetailList == null
               ? other$sectionOutboundDetailList == null
               : this$sectionOutboundDetailList.equals(other$sectionOutboundDetailList)) {
               Object this$sectionReturnDetailList = this.getSectionReturnDetailList();
               Object other$sectionReturnDetailList = other.getSectionReturnDetailList();
               return this$sectionReturnDetailList == null
                  ? other$sectionReturnDetailList == null
                  : this$sectionReturnDetailList.equals(other$sectionReturnDetailList);
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
      return other instanceof ReceiveDateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $plantOutboundDetailList = this.getPlantOutboundDetailList();
      result = result * 59 + ($plantOutboundDetailList == null ? 43 : $plantOutboundDetailList.hashCode());
      Object $plantReturnDetailList = this.getPlantReturnDetailList();
      result = result * 59 + ($plantReturnDetailList == null ? 43 : $plantReturnDetailList.hashCode());
      Object $sectionOutboundDetailList = this.getSectionOutboundDetailList();
      result = result * 59 + ($sectionOutboundDetailList == null ? 43 : $sectionOutboundDetailList.hashCode());
      Object $sectionReturnDetailList = this.getSectionReturnDetailList();
      return result * 59 + ($sectionReturnDetailList == null ? 43 : $sectionReturnDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "ReceiveDateDTO(plantOutboundDetailList="
         + this.getPlantOutboundDetailList()
         + ", plantReturnDetailList="
         + this.getPlantReturnDetailList()
         + ", sectionOutboundDetailList="
         + this.getSectionOutboundDetailList()
         + ", sectionReturnDetailList="
         + this.getSectionReturnDetailList()
         + ")";
   }

   public ReceiveDateDTO(
      final List<ReceiveOutboundDetailDTO> plantOutboundDetailList,
      final List<ReceiveReturnDetailDTO> plantReturnDetailList,
      final List<ReceiveOutboundDetailDTO> sectionOutboundDetailList,
      final List<ReceiveReturnDetailDTO> sectionReturnDetailList
   ) {
      this.plantOutboundDetailList = plantOutboundDetailList;
      this.plantReturnDetailList = plantReturnDetailList;
      this.sectionOutboundDetailList = sectionOutboundDetailList;
      this.sectionReturnDetailList = sectionReturnDetailList;
   }

   public ReceiveDateDTO() {
   }

   public static class ReceiveDateDTOBuilder {
      private List<ReceiveOutboundDetailDTO> plantOutboundDetailList;
      private List<ReceiveReturnDetailDTO> plantReturnDetailList;
      private List<ReceiveOutboundDetailDTO> sectionOutboundDetailList;
      private List<ReceiveReturnDetailDTO> sectionReturnDetailList;

      ReceiveDateDTOBuilder() {
      }

      public ReceiveDateDTO.ReceiveDateDTOBuilder plantOutboundDetailList(final List<ReceiveOutboundDetailDTO> plantOutboundDetailList) {
         this.plantOutboundDetailList = plantOutboundDetailList;
         return this;
      }

      public ReceiveDateDTO.ReceiveDateDTOBuilder plantReturnDetailList(final List<ReceiveReturnDetailDTO> plantReturnDetailList) {
         this.plantReturnDetailList = plantReturnDetailList;
         return this;
      }

      public ReceiveDateDTO.ReceiveDateDTOBuilder sectionOutboundDetailList(final List<ReceiveOutboundDetailDTO> sectionOutboundDetailList) {
         this.sectionOutboundDetailList = sectionOutboundDetailList;
         return this;
      }

      public ReceiveDateDTO.ReceiveDateDTOBuilder sectionReturnDetailList(final List<ReceiveReturnDetailDTO> sectionReturnDetailList) {
         this.sectionReturnDetailList = sectionReturnDetailList;
         return this;
      }

      public ReceiveDateDTO build() {
         return new ReceiveDateDTO(this.plantOutboundDetailList, this.plantReturnDetailList, this.sectionOutboundDetailList, this.sectionReturnDetailList);
      }

      @Override
      public String toString() {
         return "ReceiveDateDTO.ReceiveDateDTOBuilder(plantOutboundDetailList="
            + this.plantOutboundDetailList
            + ", plantReturnDetailList="
            + this.plantReturnDetailList
            + ", sectionOutboundDetailList="
            + this.sectionOutboundDetailList
            + ", sectionReturnDetailList="
            + this.sectionReturnDetailList
            + ")";
      }
   }
}
