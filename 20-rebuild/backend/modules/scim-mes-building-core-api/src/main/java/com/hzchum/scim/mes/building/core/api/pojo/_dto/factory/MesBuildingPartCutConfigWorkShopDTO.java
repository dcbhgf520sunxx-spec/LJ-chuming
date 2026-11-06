package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "MesBuildingPartCutConfigWorkShopDTO", description = "")
public class MesBuildingPartCutConfigWorkShopDTO {
   private Long workshopId;
   private String workshopName;
   private List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList;

   public MesBuildingPartCutConfigWorkShopDTO(Long workshopId, String workshopName) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.mesBuildingPartCutConfigLineDTOList = new ArrayList<>();
   }

   public void addProductionLine(MesBuildingPartCutConfigLineDTO productionLine) {
      this.mesBuildingPartCutConfigLineDTOList.add(productionLine);
   }

   public MesBuildingPartCutConfigLineDTO findProductionLine(Long productionLineId) {
      if (this.mesBuildingPartCutConfigLineDTOList == null) {
         return null;
      }

      for (MesBuildingPartCutConfigLineDTO productionLine : this.mesBuildingPartCutConfigLineDTOList) {
         if (productionLine.getProductionLineId().equals(productionLineId)) {
            return productionLine;
         }
      }

      return null;
   }

   public static MesBuildingPartCutConfigWorkShopDTO.MesBuildingPartCutConfigWorkShopDTOBuilder builder() {
      return new MesBuildingPartCutConfigWorkShopDTO.MesBuildingPartCutConfigWorkShopDTOBuilder();
   }

   public MesBuildingPartCutConfigWorkShopDTO() {
   }

   public MesBuildingPartCutConfigWorkShopDTO(
      final Long workshopId, final String workshopName, final List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList
   ) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.mesBuildingPartCutConfigLineDTOList = mesBuildingPartCutConfigLineDTOList;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public List<MesBuildingPartCutConfigLineDTO> getMesBuildingPartCutConfigLineDTOList() {
      return this.mesBuildingPartCutConfigLineDTOList;
   }

   public MesBuildingPartCutConfigWorkShopDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesBuildingPartCutConfigWorkShopDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public MesBuildingPartCutConfigWorkShopDTO setMesBuildingPartCutConfigLineDTOList(
      final List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList
   ) {
      this.mesBuildingPartCutConfigLineDTOList = mesBuildingPartCutConfigLineDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPartCutConfigWorkShopDTO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", mesBuildingPartCutConfigLineDTOList="
         + this.getMesBuildingPartCutConfigLineDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCutConfigWorkShopDTO)) {
         return false;
      }

      MesBuildingPartCutConfigWorkShopDTO other = (MesBuildingPartCutConfigWorkShopDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$workshopName = this.getWorkshopName();
         Object other$workshopName = other.getWorkshopName();
         if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
            Object this$mesBuildingPartCutConfigLineDTOList = this.getMesBuildingPartCutConfigLineDTOList();
            Object other$mesBuildingPartCutConfigLineDTOList = other.getMesBuildingPartCutConfigLineDTOList();
            return this$mesBuildingPartCutConfigLineDTOList == null
               ? other$mesBuildingPartCutConfigLineDTOList == null
               : this$mesBuildingPartCutConfigLineDTOList.equals(other$mesBuildingPartCutConfigLineDTOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPartCutConfigWorkShopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $mesBuildingPartCutConfigLineDTOList = this.getMesBuildingPartCutConfigLineDTOList();
      return result * 59 + ($mesBuildingPartCutConfigLineDTOList == null ? 43 : $mesBuildingPartCutConfigLineDTOList.hashCode());
   }

   public static class MesBuildingPartCutConfigWorkShopDTOBuilder {
      private Long workshopId;
      private String workshopName;
      private List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList;

      MesBuildingPartCutConfigWorkShopDTOBuilder() {
      }

      public MesBuildingPartCutConfigWorkShopDTO.MesBuildingPartCutConfigWorkShopDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingPartCutConfigWorkShopDTO.MesBuildingPartCutConfigWorkShopDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public MesBuildingPartCutConfigWorkShopDTO.MesBuildingPartCutConfigWorkShopDTOBuilder mesBuildingPartCutConfigLineDTOList(
         final List<MesBuildingPartCutConfigLineDTO> mesBuildingPartCutConfigLineDTOList
      ) {
         this.mesBuildingPartCutConfigLineDTOList = mesBuildingPartCutConfigLineDTOList;
         return this;
      }

      public MesBuildingPartCutConfigWorkShopDTO build() {
         return new MesBuildingPartCutConfigWorkShopDTO(this.workshopId, this.workshopName, this.mesBuildingPartCutConfigLineDTOList);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCutConfigWorkShopDTO.MesBuildingPartCutConfigWorkShopDTOBuilder(workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", mesBuildingPartCutConfigLineDTOList="
            + this.mesBuildingPartCutConfigLineDTOList
            + ")";
      }
   }
}
