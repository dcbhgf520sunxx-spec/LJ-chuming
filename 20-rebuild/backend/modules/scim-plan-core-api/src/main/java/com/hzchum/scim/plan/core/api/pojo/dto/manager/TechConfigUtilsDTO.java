package com.hzchum.scim.plan.core.api.pojo.dto.manager;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Map;

@ApiModel("产品配置信息")
public class TechConfigUtilsDTO {
   private Map<String, Long> commonStructureSpecMap;
   private Map<String, Map<String, Long>> smallArtifactNameMap;
   private List<Long> purlinClassIds;
   private Map<String, Long> assembleSpecMap;
   private Map<String, Long> machinePartSpecMap;
   private Map<String, Long> sectionMachinePartSpecMap;
   private Map<Integer, Map<String, Long>> standardPartConfigMap;
   private Map<String, Map<String, Long>> steelClassSpecNameLinkMap;
   private List<Long> processAssembleClassIds;
   private List<String> matchingNameList;
   private List<Long> boolComposeAssembleClassIds;
   private List<String> mesArtifactClassNameList;

   public static TechConfigUtilsDTO.TechConfigUtilsDTOBuilder builder() {
      return new TechConfigUtilsDTO.TechConfigUtilsDTOBuilder();
   }

   public Map<String, Long> getCommonStructureSpecMap() {
      return this.commonStructureSpecMap;
   }

   public Map<String, Map<String, Long>> getSmallArtifactNameMap() {
      return this.smallArtifactNameMap;
   }

   public List<Long> getPurlinClassIds() {
      return this.purlinClassIds;
   }

   public Map<String, Long> getAssembleSpecMap() {
      return this.assembleSpecMap;
   }

   public Map<String, Long> getMachinePartSpecMap() {
      return this.machinePartSpecMap;
   }

   public Map<String, Long> getSectionMachinePartSpecMap() {
      return this.sectionMachinePartSpecMap;
   }

   public Map<Integer, Map<String, Long>> getStandardPartConfigMap() {
      return this.standardPartConfigMap;
   }

   public Map<String, Map<String, Long>> getSteelClassSpecNameLinkMap() {
      return this.steelClassSpecNameLinkMap;
   }

   public List<Long> getProcessAssembleClassIds() {
      return this.processAssembleClassIds;
   }

   public List<String> getMatchingNameList() {
      return this.matchingNameList;
   }

   public List<Long> getBoolComposeAssembleClassIds() {
      return this.boolComposeAssembleClassIds;
   }

   public List<String> getMesArtifactClassNameList() {
      return this.mesArtifactClassNameList;
   }

   public void setCommonStructureSpecMap(final Map<String, Long> commonStructureSpecMap) {
      this.commonStructureSpecMap = commonStructureSpecMap;
   }

   public void setSmallArtifactNameMap(final Map<String, Map<String, Long>> smallArtifactNameMap) {
      this.smallArtifactNameMap = smallArtifactNameMap;
   }

   public void setPurlinClassIds(final List<Long> purlinClassIds) {
      this.purlinClassIds = purlinClassIds;
   }

   public void setAssembleSpecMap(final Map<String, Long> assembleSpecMap) {
      this.assembleSpecMap = assembleSpecMap;
   }

   public void setMachinePartSpecMap(final Map<String, Long> machinePartSpecMap) {
      this.machinePartSpecMap = machinePartSpecMap;
   }

   public void setSectionMachinePartSpecMap(final Map<String, Long> sectionMachinePartSpecMap) {
      this.sectionMachinePartSpecMap = sectionMachinePartSpecMap;
   }

   public void setStandardPartConfigMap(final Map<Integer, Map<String, Long>> standardPartConfigMap) {
      this.standardPartConfigMap = standardPartConfigMap;
   }

   public void setSteelClassSpecNameLinkMap(final Map<String, Map<String, Long>> steelClassSpecNameLinkMap) {
      this.steelClassSpecNameLinkMap = steelClassSpecNameLinkMap;
   }

   public void setProcessAssembleClassIds(final List<Long> processAssembleClassIds) {
      this.processAssembleClassIds = processAssembleClassIds;
   }

   public void setMatchingNameList(final List<String> matchingNameList) {
      this.matchingNameList = matchingNameList;
   }

   public void setBoolComposeAssembleClassIds(final List<Long> boolComposeAssembleClassIds) {
      this.boolComposeAssembleClassIds = boolComposeAssembleClassIds;
   }

   public void setMesArtifactClassNameList(final List<String> mesArtifactClassNameList) {
      this.mesArtifactClassNameList = mesArtifactClassNameList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechConfigUtilsDTO)) {
         return false;
      }

      TechConfigUtilsDTO other = (TechConfigUtilsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$commonStructureSpecMap = this.getCommonStructureSpecMap();
      Object other$commonStructureSpecMap = other.getCommonStructureSpecMap();
      if (this$commonStructureSpecMap == null ? other$commonStructureSpecMap == null : this$commonStructureSpecMap.equals(other$commonStructureSpecMap)) {
         Object this$smallArtifactNameMap = this.getSmallArtifactNameMap();
         Object other$smallArtifactNameMap = other.getSmallArtifactNameMap();
         if (this$smallArtifactNameMap == null ? other$smallArtifactNameMap == null : this$smallArtifactNameMap.equals(other$smallArtifactNameMap)) {
            Object this$purlinClassIds = this.getPurlinClassIds();
            Object other$purlinClassIds = other.getPurlinClassIds();
            if (this$purlinClassIds == null ? other$purlinClassIds == null : this$purlinClassIds.equals(other$purlinClassIds)) {
               Object this$assembleSpecMap = this.getAssembleSpecMap();
               Object other$assembleSpecMap = other.getAssembleSpecMap();
               if (this$assembleSpecMap == null ? other$assembleSpecMap == null : this$assembleSpecMap.equals(other$assembleSpecMap)) {
                  Object this$machinePartSpecMap = this.getMachinePartSpecMap();
                  Object other$machinePartSpecMap = other.getMachinePartSpecMap();
                  if (this$machinePartSpecMap == null ? other$machinePartSpecMap == null : this$machinePartSpecMap.equals(other$machinePartSpecMap)) {
                     Object this$sectionMachinePartSpecMap = this.getSectionMachinePartSpecMap();
                     Object other$sectionMachinePartSpecMap = other.getSectionMachinePartSpecMap();
                     if (this$sectionMachinePartSpecMap == null
                        ? other$sectionMachinePartSpecMap == null
                        : this$sectionMachinePartSpecMap.equals(other$sectionMachinePartSpecMap)) {
                        Object this$standardPartConfigMap = this.getStandardPartConfigMap();
                        Object other$standardPartConfigMap = other.getStandardPartConfigMap();
                        if (this$standardPartConfigMap == null
                           ? other$standardPartConfigMap == null
                           : this$standardPartConfigMap.equals(other$standardPartConfigMap)) {
                           Object this$steelClassSpecNameLinkMap = this.getSteelClassSpecNameLinkMap();
                           Object other$steelClassSpecNameLinkMap = other.getSteelClassSpecNameLinkMap();
                           if (this$steelClassSpecNameLinkMap == null
                              ? other$steelClassSpecNameLinkMap == null
                              : this$steelClassSpecNameLinkMap.equals(other$steelClassSpecNameLinkMap)) {
                              Object this$processAssembleClassIds = this.getProcessAssembleClassIds();
                              Object other$processAssembleClassIds = other.getProcessAssembleClassIds();
                              if (this$processAssembleClassIds == null
                                 ? other$processAssembleClassIds == null
                                 : this$processAssembleClassIds.equals(other$processAssembleClassIds)) {
                                 Object this$matchingNameList = this.getMatchingNameList();
                                 Object other$matchingNameList = other.getMatchingNameList();
                                 if (this$matchingNameList == null ? other$matchingNameList == null : this$matchingNameList.equals(other$matchingNameList)) {
                                    Object this$boolComposeAssembleClassIds = this.getBoolComposeAssembleClassIds();
                                    Object other$boolComposeAssembleClassIds = other.getBoolComposeAssembleClassIds();
                                    if (this$boolComposeAssembleClassIds == null
                                       ? other$boolComposeAssembleClassIds == null
                                       : this$boolComposeAssembleClassIds.equals(other$boolComposeAssembleClassIds)) {
                                       Object this$mesArtifactClassNameList = this.getMesArtifactClassNameList();
                                       Object other$mesArtifactClassNameList = other.getMesArtifactClassNameList();
                                       return this$mesArtifactClassNameList == null
                                          ? other$mesArtifactClassNameList == null
                                          : this$mesArtifactClassNameList.equals(other$mesArtifactClassNameList);
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
      return other instanceof TechConfigUtilsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $commonStructureSpecMap = this.getCommonStructureSpecMap();
      result = result * 59 + ($commonStructureSpecMap == null ? 43 : $commonStructureSpecMap.hashCode());
      Object $smallArtifactNameMap = this.getSmallArtifactNameMap();
      result = result * 59 + ($smallArtifactNameMap == null ? 43 : $smallArtifactNameMap.hashCode());
      Object $purlinClassIds = this.getPurlinClassIds();
      result = result * 59 + ($purlinClassIds == null ? 43 : $purlinClassIds.hashCode());
      Object $assembleSpecMap = this.getAssembleSpecMap();
      result = result * 59 + ($assembleSpecMap == null ? 43 : $assembleSpecMap.hashCode());
      Object $machinePartSpecMap = this.getMachinePartSpecMap();
      result = result * 59 + ($machinePartSpecMap == null ? 43 : $machinePartSpecMap.hashCode());
      Object $sectionMachinePartSpecMap = this.getSectionMachinePartSpecMap();
      result = result * 59 + ($sectionMachinePartSpecMap == null ? 43 : $sectionMachinePartSpecMap.hashCode());
      Object $standardPartConfigMap = this.getStandardPartConfigMap();
      result = result * 59 + ($standardPartConfigMap == null ? 43 : $standardPartConfigMap.hashCode());
      Object $steelClassSpecNameLinkMap = this.getSteelClassSpecNameLinkMap();
      result = result * 59 + ($steelClassSpecNameLinkMap == null ? 43 : $steelClassSpecNameLinkMap.hashCode());
      Object $processAssembleClassIds = this.getProcessAssembleClassIds();
      result = result * 59 + ($processAssembleClassIds == null ? 43 : $processAssembleClassIds.hashCode());
      Object $matchingNameList = this.getMatchingNameList();
      result = result * 59 + ($matchingNameList == null ? 43 : $matchingNameList.hashCode());
      Object $boolComposeAssembleClassIds = this.getBoolComposeAssembleClassIds();
      result = result * 59 + ($boolComposeAssembleClassIds == null ? 43 : $boolComposeAssembleClassIds.hashCode());
      Object $mesArtifactClassNameList = this.getMesArtifactClassNameList();
      return result * 59 + ($mesArtifactClassNameList == null ? 43 : $mesArtifactClassNameList.hashCode());
   }

   @Override
   public String toString() {
      return "TechConfigUtilsDTO(commonStructureSpecMap="
         + this.getCommonStructureSpecMap()
         + ", smallArtifactNameMap="
         + this.getSmallArtifactNameMap()
         + ", purlinClassIds="
         + this.getPurlinClassIds()
         + ", assembleSpecMap="
         + this.getAssembleSpecMap()
         + ", machinePartSpecMap="
         + this.getMachinePartSpecMap()
         + ", sectionMachinePartSpecMap="
         + this.getSectionMachinePartSpecMap()
         + ", standardPartConfigMap="
         + this.getStandardPartConfigMap()
         + ", steelClassSpecNameLinkMap="
         + this.getSteelClassSpecNameLinkMap()
         + ", processAssembleClassIds="
         + this.getProcessAssembleClassIds()
         + ", matchingNameList="
         + this.getMatchingNameList()
         + ", boolComposeAssembleClassIds="
         + this.getBoolComposeAssembleClassIds()
         + ", mesArtifactClassNameList="
         + this.getMesArtifactClassNameList()
         + ")";
   }

   public TechConfigUtilsDTO(
      final Map<String, Long> commonStructureSpecMap,
      final Map<String, Map<String, Long>> smallArtifactNameMap,
      final List<Long> purlinClassIds,
      final Map<String, Long> assembleSpecMap,
      final Map<String, Long> machinePartSpecMap,
      final Map<String, Long> sectionMachinePartSpecMap,
      final Map<Integer, Map<String, Long>> standardPartConfigMap,
      final Map<String, Map<String, Long>> steelClassSpecNameLinkMap,
      final List<Long> processAssembleClassIds,
      final List<String> matchingNameList,
      final List<Long> boolComposeAssembleClassIds,
      final List<String> mesArtifactClassNameList
   ) {
      this.commonStructureSpecMap = commonStructureSpecMap;
      this.smallArtifactNameMap = smallArtifactNameMap;
      this.purlinClassIds = purlinClassIds;
      this.assembleSpecMap = assembleSpecMap;
      this.machinePartSpecMap = machinePartSpecMap;
      this.sectionMachinePartSpecMap = sectionMachinePartSpecMap;
      this.standardPartConfigMap = standardPartConfigMap;
      this.steelClassSpecNameLinkMap = steelClassSpecNameLinkMap;
      this.processAssembleClassIds = processAssembleClassIds;
      this.matchingNameList = matchingNameList;
      this.boolComposeAssembleClassIds = boolComposeAssembleClassIds;
      this.mesArtifactClassNameList = mesArtifactClassNameList;
   }

   public TechConfigUtilsDTO() {
   }

   public static class TechConfigUtilsDTOBuilder {
      private Map<String, Long> commonStructureSpecMap;
      private Map<String, Map<String, Long>> smallArtifactNameMap;
      private List<Long> purlinClassIds;
      private Map<String, Long> assembleSpecMap;
      private Map<String, Long> machinePartSpecMap;
      private Map<String, Long> sectionMachinePartSpecMap;
      private Map<Integer, Map<String, Long>> standardPartConfigMap;
      private Map<String, Map<String, Long>> steelClassSpecNameLinkMap;
      private List<Long> processAssembleClassIds;
      private List<String> matchingNameList;
      private List<Long> boolComposeAssembleClassIds;
      private List<String> mesArtifactClassNameList;

      TechConfigUtilsDTOBuilder() {
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder commonStructureSpecMap(final Map<String, Long> commonStructureSpecMap) {
         this.commonStructureSpecMap = commonStructureSpecMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder smallArtifactNameMap(final Map<String, Map<String, Long>> smallArtifactNameMap) {
         this.smallArtifactNameMap = smallArtifactNameMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder purlinClassIds(final List<Long> purlinClassIds) {
         this.purlinClassIds = purlinClassIds;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder assembleSpecMap(final Map<String, Long> assembleSpecMap) {
         this.assembleSpecMap = assembleSpecMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder machinePartSpecMap(final Map<String, Long> machinePartSpecMap) {
         this.machinePartSpecMap = machinePartSpecMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder sectionMachinePartSpecMap(final Map<String, Long> sectionMachinePartSpecMap) {
         this.sectionMachinePartSpecMap = sectionMachinePartSpecMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder standardPartConfigMap(final Map<Integer, Map<String, Long>> standardPartConfigMap) {
         this.standardPartConfigMap = standardPartConfigMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder steelClassSpecNameLinkMap(final Map<String, Map<String, Long>> steelClassSpecNameLinkMap) {
         this.steelClassSpecNameLinkMap = steelClassSpecNameLinkMap;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder processAssembleClassIds(final List<Long> processAssembleClassIds) {
         this.processAssembleClassIds = processAssembleClassIds;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder matchingNameList(final List<String> matchingNameList) {
         this.matchingNameList = matchingNameList;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder boolComposeAssembleClassIds(final List<Long> boolComposeAssembleClassIds) {
         this.boolComposeAssembleClassIds = boolComposeAssembleClassIds;
         return this;
      }

      public TechConfigUtilsDTO.TechConfigUtilsDTOBuilder mesArtifactClassNameList(final List<String> mesArtifactClassNameList) {
         this.mesArtifactClassNameList = mesArtifactClassNameList;
         return this;
      }

      public TechConfigUtilsDTO build() {
         return new TechConfigUtilsDTO(
            this.commonStructureSpecMap,
            this.smallArtifactNameMap,
            this.purlinClassIds,
            this.assembleSpecMap,
            this.machinePartSpecMap,
            this.sectionMachinePartSpecMap,
            this.standardPartConfigMap,
            this.steelClassSpecNameLinkMap,
            this.processAssembleClassIds,
            this.matchingNameList,
            this.boolComposeAssembleClassIds,
            this.mesArtifactClassNameList
         );
      }

      @Override
      public String toString() {
         return "TechConfigUtilsDTO.TechConfigUtilsDTOBuilder(commonStructureSpecMap="
            + this.commonStructureSpecMap
            + ", smallArtifactNameMap="
            + this.smallArtifactNameMap
            + ", purlinClassIds="
            + this.purlinClassIds
            + ", assembleSpecMap="
            + this.assembleSpecMap
            + ", machinePartSpecMap="
            + this.machinePartSpecMap
            + ", sectionMachinePartSpecMap="
            + this.sectionMachinePartSpecMap
            + ", standardPartConfigMap="
            + this.standardPartConfigMap
            + ", steelClassSpecNameLinkMap="
            + this.steelClassSpecNameLinkMap
            + ", processAssembleClassIds="
            + this.processAssembleClassIds
            + ", matchingNameList="
            + this.matchingNameList
            + ", boolComposeAssembleClassIds="
            + this.boolComposeAssembleClassIds
            + ", mesArtifactClassNameList="
            + this.mesArtifactClassNameList
            + ")";
      }
   }
}
