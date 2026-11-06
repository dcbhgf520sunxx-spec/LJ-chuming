package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "部件(单元件)DTO", description = "部件(单元件)DTO")
public class InventoryAssembleImportDTO extends ArtifactPartImportCommonDTO {
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "possessPlateWeb", value = "是否有零件")
   private Boolean boolPossessPlateWeb;
   @ApiModelProperty(name = "elementMachinePartList", value = "部件(单元件)使用的零件(板材/翼腹板)列表")
   private List<MachinePartImportDtoParam> assembleElementMachinePartList;

   public static InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder builder() {
      return new InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryAssembleImportDTO)) {
         return false;
      }

      InventoryAssembleImportDTO other = (InventoryAssembleImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$boolSendDirectly = this.getBoolSendDirectly();
      Object other$boolSendDirectly = other.getBoolSendDirectly();
      if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
         Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
         Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
         if (this$boolAllPartSendDirectly == null ? other$boolAllPartSendDirectly == null : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
            Object this$boolPossessPlateWeb = this.getBoolPossessPlateWeb();
            Object other$boolPossessPlateWeb = other.getBoolPossessPlateWeb();
            if (this$boolPossessPlateWeb == null ? other$boolPossessPlateWeb == null : this$boolPossessPlateWeb.equals(other$boolPossessPlateWeb)) {
               Object this$assembleElementMachinePartList = this.getAssembleElementMachinePartList();
               Object other$assembleElementMachinePartList = other.getAssembleElementMachinePartList();
               return this$assembleElementMachinePartList == null
                  ? other$assembleElementMachinePartList == null
                  : this$assembleElementMachinePartList.equals(other$assembleElementMachinePartList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof InventoryAssembleImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolPossessPlateWeb = this.getBoolPossessPlateWeb();
      result = result * 59 + ($boolPossessPlateWeb == null ? 43 : $boolPossessPlateWeb.hashCode());
      Object $assembleElementMachinePartList = this.getAssembleElementMachinePartList();
      return result * 59 + ($assembleElementMachinePartList == null ? 43 : $assembleElementMachinePartList.hashCode());
   }

   public InventoryAssembleImportDTO() {
   }

   public InventoryAssembleImportDTO(
      final Boolean boolSendDirectly,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolPossessPlateWeb,
      final List<MachinePartImportDtoParam> assembleElementMachinePartList
   ) {
      this.boolSendDirectly = boolSendDirectly;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolPossessPlateWeb = boolPossessPlateWeb;
      this.assembleElementMachinePartList = assembleElementMachinePartList;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolPossessPlateWeb() {
      return this.boolPossessPlateWeb;
   }

   public List<MachinePartImportDtoParam> getAssembleElementMachinePartList() {
      return this.assembleElementMachinePartList;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolPossessPlateWeb(final Boolean boolPossessPlateWeb) {
      this.boolPossessPlateWeb = boolPossessPlateWeb;
   }

   public void setAssembleElementMachinePartList(final List<MachinePartImportDtoParam> assembleElementMachinePartList) {
      this.assembleElementMachinePartList = assembleElementMachinePartList;
   }

   @Override
   public String toString() {
      return "InventoryAssembleImportDTO(boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolPossessPlateWeb="
         + this.getBoolPossessPlateWeb()
         + ", assembleElementMachinePartList="
         + this.getAssembleElementMachinePartList()
         + ")";
   }

   public static class InventoryAssembleImportDTOBuilder {
      private Boolean boolSendDirectly;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolPossessPlateWeb;
      private List<MachinePartImportDtoParam> assembleElementMachinePartList;

      InventoryAssembleImportDTOBuilder() {
      }

      public InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder boolPossessPlateWeb(final Boolean boolPossessPlateWeb) {
         this.boolPossessPlateWeb = boolPossessPlateWeb;
         return this;
      }

      public InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder assembleElementMachinePartList(
         final List<MachinePartImportDtoParam> assembleElementMachinePartList
      ) {
         this.assembleElementMachinePartList = assembleElementMachinePartList;
         return this;
      }

      public InventoryAssembleImportDTO build() {
         return new InventoryAssembleImportDTO(
            this.boolSendDirectly, this.boolAllPartSendDirectly, this.boolPossessPlateWeb, this.assembleElementMachinePartList
         );
      }

      @Override
      public String toString() {
         return "InventoryAssembleImportDTO.InventoryAssembleImportDTOBuilder(boolSendDirectly="
            + this.boolSendDirectly
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolPossessPlateWeb="
            + this.boolPossessPlateWeb
            + ", assembleElementMachinePartList="
            + this.assembleElementMachinePartList
            + ")";
      }
   }
}
