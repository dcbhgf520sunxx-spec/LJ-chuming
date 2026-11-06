package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

public class ArtifactImportSummaryDTO {
   @ApiModelProperty("新增构件列表")
   private List<TechArtifact> newArtifactList;
   @ApiModelProperty("新增零件列表")
   private List<TechMachinePart> newMachinePartList;
   @ApiModelProperty("构件和零件数量比例")
   private Map<TechArtifact, Map<TechMachinePart, Integer>> newArtifactMachinePartQuantityRateMap;
   @ApiModelProperty("构件下零件备注")
   private Map<String, Map<String, String>> artifactMachinePartRemarkMap;
   @ApiModelProperty("原构件零件关联表")
   private List<TechArtifactMachinePartLink> oldArtifactMachinePartLinkList;
   @ApiModelProperty("深化记录")
   private List<TechDeepenRecord> deepenRecords;
   @ApiModelProperty("部件-零件数量比例")
   Map<TechMachinePart, Map<TechMachinePart, Integer>> assemblePartRateMap;

   public static ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder builder() {
      return new ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder();
   }

   public ArtifactImportSummaryDTO(
      final List<TechArtifact> newArtifactList,
      final List<TechMachinePart> newMachinePartList,
      final Map<TechArtifact, Map<TechMachinePart, Integer>> newArtifactMachinePartQuantityRateMap,
      final Map<String, Map<String, String>> artifactMachinePartRemarkMap,
      final List<TechArtifactMachinePartLink> oldArtifactMachinePartLinkList,
      final List<TechDeepenRecord> deepenRecords,
      final Map<TechMachinePart, Map<TechMachinePart, Integer>> assemblePartRateMap
   ) {
      this.newArtifactList = newArtifactList;
      this.newMachinePartList = newMachinePartList;
      this.newArtifactMachinePartQuantityRateMap = newArtifactMachinePartQuantityRateMap;
      this.artifactMachinePartRemarkMap = artifactMachinePartRemarkMap;
      this.oldArtifactMachinePartLinkList = oldArtifactMachinePartLinkList;
      this.deepenRecords = deepenRecords;
      this.assemblePartRateMap = assemblePartRateMap;
   }

   public ArtifactImportSummaryDTO() {
   }

   public List<TechArtifact> getNewArtifactList() {
      return this.newArtifactList;
   }

   public List<TechMachinePart> getNewMachinePartList() {
      return this.newMachinePartList;
   }

   public Map<TechArtifact, Map<TechMachinePart, Integer>> getNewArtifactMachinePartQuantityRateMap() {
      return this.newArtifactMachinePartQuantityRateMap;
   }

   public Map<String, Map<String, String>> getArtifactMachinePartRemarkMap() {
      return this.artifactMachinePartRemarkMap;
   }

   public List<TechArtifactMachinePartLink> getOldArtifactMachinePartLinkList() {
      return this.oldArtifactMachinePartLinkList;
   }

   public List<TechDeepenRecord> getDeepenRecords() {
      return this.deepenRecords;
   }

   public Map<TechMachinePart, Map<TechMachinePart, Integer>> getAssemblePartRateMap() {
      return this.assemblePartRateMap;
   }

   public void setNewArtifactList(final List<TechArtifact> newArtifactList) {
      this.newArtifactList = newArtifactList;
   }

   public void setNewMachinePartList(final List<TechMachinePart> newMachinePartList) {
      this.newMachinePartList = newMachinePartList;
   }

   public void setNewArtifactMachinePartQuantityRateMap(final Map<TechArtifact, Map<TechMachinePart, Integer>> newArtifactMachinePartQuantityRateMap) {
      this.newArtifactMachinePartQuantityRateMap = newArtifactMachinePartQuantityRateMap;
   }

   public void setArtifactMachinePartRemarkMap(final Map<String, Map<String, String>> artifactMachinePartRemarkMap) {
      this.artifactMachinePartRemarkMap = artifactMachinePartRemarkMap;
   }

   public void setOldArtifactMachinePartLinkList(final List<TechArtifactMachinePartLink> oldArtifactMachinePartLinkList) {
      this.oldArtifactMachinePartLinkList = oldArtifactMachinePartLinkList;
   }

   public void setDeepenRecords(final List<TechDeepenRecord> deepenRecords) {
      this.deepenRecords = deepenRecords;
   }

   public void setAssemblePartRateMap(final Map<TechMachinePart, Map<TechMachinePart, Integer>> assemblePartRateMap) {
      this.assemblePartRateMap = assemblePartRateMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactImportSummaryDTO)) {
         return false;
      }

      ArtifactImportSummaryDTO other = (ArtifactImportSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$newArtifactList = this.getNewArtifactList();
      Object other$newArtifactList = other.getNewArtifactList();
      if (this$newArtifactList == null ? other$newArtifactList == null : this$newArtifactList.equals(other$newArtifactList)) {
         Object this$newMachinePartList = this.getNewMachinePartList();
         Object other$newMachinePartList = other.getNewMachinePartList();
         if (this$newMachinePartList == null ? other$newMachinePartList == null : this$newMachinePartList.equals(other$newMachinePartList)) {
            Object this$newArtifactMachinePartQuantityRateMap = this.getNewArtifactMachinePartQuantityRateMap();
            Object other$newArtifactMachinePartQuantityRateMap = other.getNewArtifactMachinePartQuantityRateMap();
            if (this$newArtifactMachinePartQuantityRateMap == null
               ? other$newArtifactMachinePartQuantityRateMap == null
               : this$newArtifactMachinePartQuantityRateMap.equals(other$newArtifactMachinePartQuantityRateMap)) {
               Object this$artifactMachinePartRemarkMap = this.getArtifactMachinePartRemarkMap();
               Object other$artifactMachinePartRemarkMap = other.getArtifactMachinePartRemarkMap();
               if (this$artifactMachinePartRemarkMap == null
                  ? other$artifactMachinePartRemarkMap == null
                  : this$artifactMachinePartRemarkMap.equals(other$artifactMachinePartRemarkMap)) {
                  Object this$oldArtifactMachinePartLinkList = this.getOldArtifactMachinePartLinkList();
                  Object other$oldArtifactMachinePartLinkList = other.getOldArtifactMachinePartLinkList();
                  if (this$oldArtifactMachinePartLinkList == null
                     ? other$oldArtifactMachinePartLinkList == null
                     : this$oldArtifactMachinePartLinkList.equals(other$oldArtifactMachinePartLinkList)) {
                     Object this$deepenRecords = this.getDeepenRecords();
                     Object other$deepenRecords = other.getDeepenRecords();
                     if (this$deepenRecords == null ? other$deepenRecords == null : this$deepenRecords.equals(other$deepenRecords)) {
                        Object this$assemblePartRateMap = this.getAssemblePartRateMap();
                        Object other$assemblePartRateMap = other.getAssemblePartRateMap();
                        return this$assemblePartRateMap == null
                           ? other$assemblePartRateMap == null
                           : this$assemblePartRateMap.equals(other$assemblePartRateMap);
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
      return other instanceof ArtifactImportSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $newArtifactList = this.getNewArtifactList();
      result = result * 59 + ($newArtifactList == null ? 43 : $newArtifactList.hashCode());
      Object $newMachinePartList = this.getNewMachinePartList();
      result = result * 59 + ($newMachinePartList == null ? 43 : $newMachinePartList.hashCode());
      Object $newArtifactMachinePartQuantityRateMap = this.getNewArtifactMachinePartQuantityRateMap();
      result = result * 59 + ($newArtifactMachinePartQuantityRateMap == null ? 43 : $newArtifactMachinePartQuantityRateMap.hashCode());
      Object $artifactMachinePartRemarkMap = this.getArtifactMachinePartRemarkMap();
      result = result * 59 + ($artifactMachinePartRemarkMap == null ? 43 : $artifactMachinePartRemarkMap.hashCode());
      Object $oldArtifactMachinePartLinkList = this.getOldArtifactMachinePartLinkList();
      result = result * 59 + ($oldArtifactMachinePartLinkList == null ? 43 : $oldArtifactMachinePartLinkList.hashCode());
      Object $deepenRecords = this.getDeepenRecords();
      result = result * 59 + ($deepenRecords == null ? 43 : $deepenRecords.hashCode());
      Object $assemblePartRateMap = this.getAssemblePartRateMap();
      return result * 59 + ($assemblePartRateMap == null ? 43 : $assemblePartRateMap.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactImportSummaryDTO(newArtifactList="
         + this.getNewArtifactList()
         + ", newMachinePartList="
         + this.getNewMachinePartList()
         + ", newArtifactMachinePartQuantityRateMap="
         + this.getNewArtifactMachinePartQuantityRateMap()
         + ", artifactMachinePartRemarkMap="
         + this.getArtifactMachinePartRemarkMap()
         + ", oldArtifactMachinePartLinkList="
         + this.getOldArtifactMachinePartLinkList()
         + ", deepenRecords="
         + this.getDeepenRecords()
         + ", assemblePartRateMap="
         + this.getAssemblePartRateMap()
         + ")";
   }

   public static class ArtifactImportSummaryDTOBuilder {
      private List<TechArtifact> newArtifactList;
      private List<TechMachinePart> newMachinePartList;
      private Map<TechArtifact, Map<TechMachinePart, Integer>> newArtifactMachinePartQuantityRateMap;
      private Map<String, Map<String, String>> artifactMachinePartRemarkMap;
      private List<TechArtifactMachinePartLink> oldArtifactMachinePartLinkList;
      private List<TechDeepenRecord> deepenRecords;
      private Map<TechMachinePart, Map<TechMachinePart, Integer>> assemblePartRateMap;

      ArtifactImportSummaryDTOBuilder() {
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder newArtifactList(final List<TechArtifact> newArtifactList) {
         this.newArtifactList = newArtifactList;
         return this;
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder newMachinePartList(final List<TechMachinePart> newMachinePartList) {
         this.newMachinePartList = newMachinePartList;
         return this;
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder newArtifactMachinePartQuantityRateMap(
         final Map<TechArtifact, Map<TechMachinePart, Integer>> newArtifactMachinePartQuantityRateMap
      ) {
         this.newArtifactMachinePartQuantityRateMap = newArtifactMachinePartQuantityRateMap;
         return this;
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder artifactMachinePartRemarkMap(
         final Map<String, Map<String, String>> artifactMachinePartRemarkMap
      ) {
         this.artifactMachinePartRemarkMap = artifactMachinePartRemarkMap;
         return this;
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder oldArtifactMachinePartLinkList(
         final List<TechArtifactMachinePartLink> oldArtifactMachinePartLinkList
      ) {
         this.oldArtifactMachinePartLinkList = oldArtifactMachinePartLinkList;
         return this;
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder deepenRecords(final List<TechDeepenRecord> deepenRecords) {
         this.deepenRecords = deepenRecords;
         return this;
      }

      public ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder assemblePartRateMap(
         final Map<TechMachinePart, Map<TechMachinePart, Integer>> assemblePartRateMap
      ) {
         this.assemblePartRateMap = assemblePartRateMap;
         return this;
      }

      public ArtifactImportSummaryDTO build() {
         return new ArtifactImportSummaryDTO(
            this.newArtifactList,
            this.newMachinePartList,
            this.newArtifactMachinePartQuantityRateMap,
            this.artifactMachinePartRemarkMap,
            this.oldArtifactMachinePartLinkList,
            this.deepenRecords,
            this.assemblePartRateMap
         );
      }

      @Override
      public String toString() {
         return "ArtifactImportSummaryDTO.ArtifactImportSummaryDTOBuilder(newArtifactList="
            + this.newArtifactList
            + ", newMachinePartList="
            + this.newMachinePartList
            + ", newArtifactMachinePartQuantityRateMap="
            + this.newArtifactMachinePartQuantityRateMap
            + ", artifactMachinePartRemarkMap="
            + this.artifactMachinePartRemarkMap
            + ", oldArtifactMachinePartLinkList="
            + this.oldArtifactMachinePartLinkList
            + ", deepenRecords="
            + this.deepenRecords
            + ", assemblePartRateMap="
            + this.assemblePartRateMap
            + ")";
      }
   }
}
