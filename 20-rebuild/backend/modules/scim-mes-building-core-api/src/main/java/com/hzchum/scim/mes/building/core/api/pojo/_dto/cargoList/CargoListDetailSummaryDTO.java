package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.TechStandardPartShipDO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CargoListDetailSummaryDTO {
   @ApiModelProperty("构件列表")
   private List<ArtifactShipDO> artifactList;
   @ApiModelProperty("直发件列表")
   private List<PartShipDO> partList;
   @ApiModelProperty("围护列表")
   private List<EnclosureShipDO> enclosureList;
   @ApiModelProperty("辅材列表")
   private List<TechStandardPartShipDO> auxiliaryMaterialList;
   @ApiModelProperty("全部产品列表")
   private List<CargoListDetailsCommonDTO> detailsList;

   public static CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder builder() {
      return new CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder();
   }

   public CargoListDetailSummaryDTO() {
   }

   public CargoListDetailSummaryDTO(
      final List<ArtifactShipDO> artifactList,
      final List<PartShipDO> partList,
      final List<EnclosureShipDO> enclosureList,
      final List<TechStandardPartShipDO> auxiliaryMaterialList,
      final List<CargoListDetailsCommonDTO> detailsList
   ) {
      this.artifactList = artifactList;
      this.partList = partList;
      this.enclosureList = enclosureList;
      this.auxiliaryMaterialList = auxiliaryMaterialList;
      this.detailsList = detailsList;
   }

   public List<ArtifactShipDO> getArtifactList() {
      return this.artifactList;
   }

   public List<PartShipDO> getPartList() {
      return this.partList;
   }

   public List<EnclosureShipDO> getEnclosureList() {
      return this.enclosureList;
   }

   public List<TechStandardPartShipDO> getAuxiliaryMaterialList() {
      return this.auxiliaryMaterialList;
   }

   public List<CargoListDetailsCommonDTO> getDetailsList() {
      return this.detailsList;
   }

   public void setArtifactList(final List<ArtifactShipDO> artifactList) {
      this.artifactList = artifactList;
   }

   public void setPartList(final List<PartShipDO> partList) {
      this.partList = partList;
   }

   public void setEnclosureList(final List<EnclosureShipDO> enclosureList) {
      this.enclosureList = enclosureList;
   }

   public void setAuxiliaryMaterialList(final List<TechStandardPartShipDO> auxiliaryMaterialList) {
      this.auxiliaryMaterialList = auxiliaryMaterialList;
   }

   public void setDetailsList(final List<CargoListDetailsCommonDTO> detailsList) {
      this.detailsList = detailsList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListDetailSummaryDTO)) {
         return false;
      }

      CargoListDetailSummaryDTO other = (CargoListDetailSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactList = this.getArtifactList();
      Object other$artifactList = other.getArtifactList();
      if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
         Object this$partList = this.getPartList();
         Object other$partList = other.getPartList();
         if (this$partList == null ? other$partList == null : this$partList.equals(other$partList)) {
            Object this$enclosureList = this.getEnclosureList();
            Object other$enclosureList = other.getEnclosureList();
            if (this$enclosureList == null ? other$enclosureList == null : this$enclosureList.equals(other$enclosureList)) {
               Object this$auxiliaryMaterialList = this.getAuxiliaryMaterialList();
               Object other$auxiliaryMaterialList = other.getAuxiliaryMaterialList();
               if (this$auxiliaryMaterialList == null ? other$auxiliaryMaterialList == null : this$auxiliaryMaterialList.equals(other$auxiliaryMaterialList)) {
                  Object this$detailsList = this.getDetailsList();
                  Object other$detailsList = other.getDetailsList();
                  return this$detailsList == null ? other$detailsList == null : this$detailsList.equals(other$detailsList);
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
      return other instanceof CargoListDetailSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $partList = this.getPartList();
      result = result * 59 + ($partList == null ? 43 : $partList.hashCode());
      Object $enclosureList = this.getEnclosureList();
      result = result * 59 + ($enclosureList == null ? 43 : $enclosureList.hashCode());
      Object $auxiliaryMaterialList = this.getAuxiliaryMaterialList();
      result = result * 59 + ($auxiliaryMaterialList == null ? 43 : $auxiliaryMaterialList.hashCode());
      Object $detailsList = this.getDetailsList();
      return result * 59 + ($detailsList == null ? 43 : $detailsList.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListDetailSummaryDTO(artifactList="
         + this.getArtifactList()
         + ", partList="
         + this.getPartList()
         + ", enclosureList="
         + this.getEnclosureList()
         + ", auxiliaryMaterialList="
         + this.getAuxiliaryMaterialList()
         + ", detailsList="
         + this.getDetailsList()
         + ")";
   }

   public static class CargoListDetailSummaryDTOBuilder {
      private List<ArtifactShipDO> artifactList;
      private List<PartShipDO> partList;
      private List<EnclosureShipDO> enclosureList;
      private List<TechStandardPartShipDO> auxiliaryMaterialList;
      private List<CargoListDetailsCommonDTO> detailsList;

      CargoListDetailSummaryDTOBuilder() {
      }

      public CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder artifactList(final List<ArtifactShipDO> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      public CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder partList(final List<PartShipDO> partList) {
         this.partList = partList;
         return this;
      }

      public CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder enclosureList(final List<EnclosureShipDO> enclosureList) {
         this.enclosureList = enclosureList;
         return this;
      }

      public CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder auxiliaryMaterialList(final List<TechStandardPartShipDO> auxiliaryMaterialList) {
         this.auxiliaryMaterialList = auxiliaryMaterialList;
         return this;
      }

      public CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder detailsList(final List<CargoListDetailsCommonDTO> detailsList) {
         this.detailsList = detailsList;
         return this;
      }

      public CargoListDetailSummaryDTO build() {
         return new CargoListDetailSummaryDTO(this.artifactList, this.partList, this.enclosureList, this.auxiliaryMaterialList, this.detailsList);
      }

      @Override
      public String toString() {
         return "CargoListDetailSummaryDTO.CargoListDetailSummaryDTOBuilder(artifactList="
            + this.artifactList
            + ", partList="
            + this.partList
            + ", enclosureList="
            + this.enclosureList
            + ", auxiliaryMaterialList="
            + this.auxiliaryMaterialList
            + ", detailsList="
            + this.detailsList
            + ")";
      }
   }
}
