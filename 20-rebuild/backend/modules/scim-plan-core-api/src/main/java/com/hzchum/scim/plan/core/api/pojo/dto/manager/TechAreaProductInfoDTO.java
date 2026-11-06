package com.hzchum.scim.plan.core.api.pojo.dto.manager;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

@ApiModel("区域内已有产品信息")
public class TechAreaProductInfoDTO {
   @ApiModelProperty("构件列表")
   private List<TechArtifact> artifactList;
   @ApiModelProperty("部件/单元件列表")
   private List<TechAssemble> assembleList;
   @ApiModelProperty("零件件列表")
   private List<TechMachinePart> machinePartList;
   @ApiModelProperty("配套件列表")
   private List<TechStandardPart> standardPartList;
   @ApiModelProperty("构件Map(key:构件编号)")
   private Map<String, TechArtifact> artifactSnMap;
   @ApiModelProperty("部件/单元件Map(key:部件/单元件id)")
   private Map<Long, TechAssemble> assembleIdMap;
   @ApiModelProperty("部件/单元件Map(key:部件/单元件编号)")
   private Map<String, List<TechAssemble>> assembleSnGroupMap;
   @ApiModelProperty("零件Map(key:零件id")
   private Map<Long, TechMachinePart> machinePartIdMap;
   @ApiModelProperty("零件Map(key:零件编号")
   private Map<String, List<TechMachinePart>> machinePartSnGroupMap;
   @ApiModelProperty("构件零件关联表Map(key:构件id)")
   private Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkGroupMap;
   @ApiModelProperty("构件部件关联表Map(key:构件id)")
   private Map<Long, List<TechAssembleDetail>> assembleDetailGroupMap;
   @ApiModelProperty("构件配套件关联表Map(key:构件id)")
   private Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkGroupMap;
   @ApiModelProperty("部件零件关联Map(key:部件id)")
   private Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkGroupMap;
   @ApiModelProperty("部件零件关联Map(key:部件编号+零件编号)")
   private Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkSerialNumberMap;
   @ApiModelProperty("单体构件Map(key:构件编号)")
   private Map<String, List<TechArtifact>> monomerArtifactSnMap;

   public static TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder builder() {
      return new TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder();
   }

   public List<TechArtifact> getArtifactList() {
      return this.artifactList;
   }

   public List<TechAssemble> getAssembleList() {
      return this.assembleList;
   }

   public List<TechMachinePart> getMachinePartList() {
      return this.machinePartList;
   }

   public List<TechStandardPart> getStandardPartList() {
      return this.standardPartList;
   }

   public Map<String, TechArtifact> getArtifactSnMap() {
      return this.artifactSnMap;
   }

   public Map<Long, TechAssemble> getAssembleIdMap() {
      return this.assembleIdMap;
   }

   public Map<String, List<TechAssemble>> getAssembleSnGroupMap() {
      return this.assembleSnGroupMap;
   }

   public Map<Long, TechMachinePart> getMachinePartIdMap() {
      return this.machinePartIdMap;
   }

   public Map<String, List<TechMachinePart>> getMachinePartSnGroupMap() {
      return this.machinePartSnGroupMap;
   }

   public Map<Long, List<TechArtifactMachinePartLink>> getArtifactMachinePartLinkGroupMap() {
      return this.artifactMachinePartLinkGroupMap;
   }

   public Map<Long, List<TechAssembleDetail>> getAssembleDetailGroupMap() {
      return this.assembleDetailGroupMap;
   }

   public Map<Long, List<TechArtifactStandardPartLink>> getArtifactStandardPartLinkGroupMap() {
      return this.artifactStandardPartLinkGroupMap;
   }

   public Map<Long, List<TechAssembleMachinePartLink>> getAssembleMachinePartLinkGroupMap() {
      return this.assembleMachinePartLinkGroupMap;
   }

   public Map<String, TechAssembleMachinePartLink> getAssembleMachinePartLinkSerialNumberMap() {
      return this.assembleMachinePartLinkSerialNumberMap;
   }

   public Map<String, List<TechArtifact>> getMonomerArtifactSnMap() {
      return this.monomerArtifactSnMap;
   }

   public void setArtifactList(final List<TechArtifact> artifactList) {
      this.artifactList = artifactList;
   }

   public void setAssembleList(final List<TechAssemble> assembleList) {
      this.assembleList = assembleList;
   }

   public void setMachinePartList(final List<TechMachinePart> machinePartList) {
      this.machinePartList = machinePartList;
   }

   public void setStandardPartList(final List<TechStandardPart> standardPartList) {
      this.standardPartList = standardPartList;
   }

   public void setArtifactSnMap(final Map<String, TechArtifact> artifactSnMap) {
      this.artifactSnMap = artifactSnMap;
   }

   public void setAssembleIdMap(final Map<Long, TechAssemble> assembleIdMap) {
      this.assembleIdMap = assembleIdMap;
   }

   public void setAssembleSnGroupMap(final Map<String, List<TechAssemble>> assembleSnGroupMap) {
      this.assembleSnGroupMap = assembleSnGroupMap;
   }

   public void setMachinePartIdMap(final Map<Long, TechMachinePart> machinePartIdMap) {
      this.machinePartIdMap = machinePartIdMap;
   }

   public void setMachinePartSnGroupMap(final Map<String, List<TechMachinePart>> machinePartSnGroupMap) {
      this.machinePartSnGroupMap = machinePartSnGroupMap;
   }

   public void setArtifactMachinePartLinkGroupMap(final Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkGroupMap) {
      this.artifactMachinePartLinkGroupMap = artifactMachinePartLinkGroupMap;
   }

   public void setAssembleDetailGroupMap(final Map<Long, List<TechAssembleDetail>> assembleDetailGroupMap) {
      this.assembleDetailGroupMap = assembleDetailGroupMap;
   }

   public void setArtifactStandardPartLinkGroupMap(final Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkGroupMap) {
      this.artifactStandardPartLinkGroupMap = artifactStandardPartLinkGroupMap;
   }

   public void setAssembleMachinePartLinkGroupMap(final Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkGroupMap) {
      this.assembleMachinePartLinkGroupMap = assembleMachinePartLinkGroupMap;
   }

   public void setAssembleMachinePartLinkSerialNumberMap(final Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkSerialNumberMap) {
      this.assembleMachinePartLinkSerialNumberMap = assembleMachinePartLinkSerialNumberMap;
   }

   public void setMonomerArtifactSnMap(final Map<String, List<TechArtifact>> monomerArtifactSnMap) {
      this.monomerArtifactSnMap = monomerArtifactSnMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAreaProductInfoDTO)) {
         return false;
      }

      TechAreaProductInfoDTO other = (TechAreaProductInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactList = this.getArtifactList();
      Object other$artifactList = other.getArtifactList();
      if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
         Object this$assembleList = this.getAssembleList();
         Object other$assembleList = other.getAssembleList();
         if (this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList)) {
            Object this$machinePartList = this.getMachinePartList();
            Object other$machinePartList = other.getMachinePartList();
            if (this$machinePartList == null ? other$machinePartList == null : this$machinePartList.equals(other$machinePartList)) {
               Object this$standardPartList = this.getStandardPartList();
               Object other$standardPartList = other.getStandardPartList();
               if (this$standardPartList == null ? other$standardPartList == null : this$standardPartList.equals(other$standardPartList)) {
                  Object this$artifactSnMap = this.getArtifactSnMap();
                  Object other$artifactSnMap = other.getArtifactSnMap();
                  if (this$artifactSnMap == null ? other$artifactSnMap == null : this$artifactSnMap.equals(other$artifactSnMap)) {
                     Object this$assembleIdMap = this.getAssembleIdMap();
                     Object other$assembleIdMap = other.getAssembleIdMap();
                     if (this$assembleIdMap == null ? other$assembleIdMap == null : this$assembleIdMap.equals(other$assembleIdMap)) {
                        Object this$assembleSnGroupMap = this.getAssembleSnGroupMap();
                        Object other$assembleSnGroupMap = other.getAssembleSnGroupMap();
                        if (this$assembleSnGroupMap == null ? other$assembleSnGroupMap == null : this$assembleSnGroupMap.equals(other$assembleSnGroupMap)) {
                           Object this$machinePartIdMap = this.getMachinePartIdMap();
                           Object other$machinePartIdMap = other.getMachinePartIdMap();
                           if (this$machinePartIdMap == null ? other$machinePartIdMap == null : this$machinePartIdMap.equals(other$machinePartIdMap)) {
                              Object this$machinePartSnGroupMap = this.getMachinePartSnGroupMap();
                              Object other$machinePartSnGroupMap = other.getMachinePartSnGroupMap();
                              if (this$machinePartSnGroupMap == null
                                 ? other$machinePartSnGroupMap == null
                                 : this$machinePartSnGroupMap.equals(other$machinePartSnGroupMap)) {
                                 Object this$artifactMachinePartLinkGroupMap = this.getArtifactMachinePartLinkGroupMap();
                                 Object other$artifactMachinePartLinkGroupMap = other.getArtifactMachinePartLinkGroupMap();
                                 if (this$artifactMachinePartLinkGroupMap == null
                                    ? other$artifactMachinePartLinkGroupMap == null
                                    : this$artifactMachinePartLinkGroupMap.equals(other$artifactMachinePartLinkGroupMap)) {
                                    Object this$assembleDetailGroupMap = this.getAssembleDetailGroupMap();
                                    Object other$assembleDetailGroupMap = other.getAssembleDetailGroupMap();
                                    if (this$assembleDetailGroupMap == null
                                       ? other$assembleDetailGroupMap == null
                                       : this$assembleDetailGroupMap.equals(other$assembleDetailGroupMap)) {
                                       Object this$artifactStandardPartLinkGroupMap = this.getArtifactStandardPartLinkGroupMap();
                                       Object other$artifactStandardPartLinkGroupMap = other.getArtifactStandardPartLinkGroupMap();
                                       if (this$artifactStandardPartLinkGroupMap == null
                                          ? other$artifactStandardPartLinkGroupMap == null
                                          : this$artifactStandardPartLinkGroupMap.equals(other$artifactStandardPartLinkGroupMap)) {
                                          Object this$assembleMachinePartLinkGroupMap = this.getAssembleMachinePartLinkGroupMap();
                                          Object other$assembleMachinePartLinkGroupMap = other.getAssembleMachinePartLinkGroupMap();
                                          if (this$assembleMachinePartLinkGroupMap == null
                                             ? other$assembleMachinePartLinkGroupMap == null
                                             : this$assembleMachinePartLinkGroupMap.equals(other$assembleMachinePartLinkGroupMap)) {
                                             Object this$assembleMachinePartLinkSerialNumberMap = this.getAssembleMachinePartLinkSerialNumberMap();
                                             Object other$assembleMachinePartLinkSerialNumberMap = other.getAssembleMachinePartLinkSerialNumberMap();
                                             if (this$assembleMachinePartLinkSerialNumberMap == null
                                                ? other$assembleMachinePartLinkSerialNumberMap == null
                                                : this$assembleMachinePartLinkSerialNumberMap.equals(other$assembleMachinePartLinkSerialNumberMap)) {
                                                Object this$monomerArtifactSnMap = this.getMonomerArtifactSnMap();
                                                Object other$monomerArtifactSnMap = other.getMonomerArtifactSnMap();
                                                return this$monomerArtifactSnMap == null
                                                   ? other$monomerArtifactSnMap == null
                                                   : this$monomerArtifactSnMap.equals(other$monomerArtifactSnMap);
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
      return other instanceof TechAreaProductInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $assembleList = this.getAssembleList();
      result = result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
      Object $machinePartList = this.getMachinePartList();
      result = result * 59 + ($machinePartList == null ? 43 : $machinePartList.hashCode());
      Object $standardPartList = this.getStandardPartList();
      result = result * 59 + ($standardPartList == null ? 43 : $standardPartList.hashCode());
      Object $artifactSnMap = this.getArtifactSnMap();
      result = result * 59 + ($artifactSnMap == null ? 43 : $artifactSnMap.hashCode());
      Object $assembleIdMap = this.getAssembleIdMap();
      result = result * 59 + ($assembleIdMap == null ? 43 : $assembleIdMap.hashCode());
      Object $assembleSnGroupMap = this.getAssembleSnGroupMap();
      result = result * 59 + ($assembleSnGroupMap == null ? 43 : $assembleSnGroupMap.hashCode());
      Object $machinePartIdMap = this.getMachinePartIdMap();
      result = result * 59 + ($machinePartIdMap == null ? 43 : $machinePartIdMap.hashCode());
      Object $machinePartSnGroupMap = this.getMachinePartSnGroupMap();
      result = result * 59 + ($machinePartSnGroupMap == null ? 43 : $machinePartSnGroupMap.hashCode());
      Object $artifactMachinePartLinkGroupMap = this.getArtifactMachinePartLinkGroupMap();
      result = result * 59 + ($artifactMachinePartLinkGroupMap == null ? 43 : $artifactMachinePartLinkGroupMap.hashCode());
      Object $assembleDetailGroupMap = this.getAssembleDetailGroupMap();
      result = result * 59 + ($assembleDetailGroupMap == null ? 43 : $assembleDetailGroupMap.hashCode());
      Object $artifactStandardPartLinkGroupMap = this.getArtifactStandardPartLinkGroupMap();
      result = result * 59 + ($artifactStandardPartLinkGroupMap == null ? 43 : $artifactStandardPartLinkGroupMap.hashCode());
      Object $assembleMachinePartLinkGroupMap = this.getAssembleMachinePartLinkGroupMap();
      result = result * 59 + ($assembleMachinePartLinkGroupMap == null ? 43 : $assembleMachinePartLinkGroupMap.hashCode());
      Object $assembleMachinePartLinkSerialNumberMap = this.getAssembleMachinePartLinkSerialNumberMap();
      result = result * 59 + ($assembleMachinePartLinkSerialNumberMap == null ? 43 : $assembleMachinePartLinkSerialNumberMap.hashCode());
      Object $monomerArtifactSnMap = this.getMonomerArtifactSnMap();
      return result * 59 + ($monomerArtifactSnMap == null ? 43 : $monomerArtifactSnMap.hashCode());
   }

   @Override
   public String toString() {
      return "TechAreaProductInfoDTO(artifactList="
         + this.getArtifactList()
         + ", assembleList="
         + this.getAssembleList()
         + ", machinePartList="
         + this.getMachinePartList()
         + ", standardPartList="
         + this.getStandardPartList()
         + ", artifactSnMap="
         + this.getArtifactSnMap()
         + ", assembleIdMap="
         + this.getAssembleIdMap()
         + ", assembleSnGroupMap="
         + this.getAssembleSnGroupMap()
         + ", machinePartIdMap="
         + this.getMachinePartIdMap()
         + ", machinePartSnGroupMap="
         + this.getMachinePartSnGroupMap()
         + ", artifactMachinePartLinkGroupMap="
         + this.getArtifactMachinePartLinkGroupMap()
         + ", assembleDetailGroupMap="
         + this.getAssembleDetailGroupMap()
         + ", artifactStandardPartLinkGroupMap="
         + this.getArtifactStandardPartLinkGroupMap()
         + ", assembleMachinePartLinkGroupMap="
         + this.getAssembleMachinePartLinkGroupMap()
         + ", assembleMachinePartLinkSerialNumberMap="
         + this.getAssembleMachinePartLinkSerialNumberMap()
         + ", monomerArtifactSnMap="
         + this.getMonomerArtifactSnMap()
         + ")";
   }

   public TechAreaProductInfoDTO(
      final List<TechArtifact> artifactList,
      final List<TechAssemble> assembleList,
      final List<TechMachinePart> machinePartList,
      final List<TechStandardPart> standardPartList,
      final Map<String, TechArtifact> artifactSnMap,
      final Map<Long, TechAssemble> assembleIdMap,
      final Map<String, List<TechAssemble>> assembleSnGroupMap,
      final Map<Long, TechMachinePart> machinePartIdMap,
      final Map<String, List<TechMachinePart>> machinePartSnGroupMap,
      final Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkGroupMap,
      final Map<Long, List<TechAssembleDetail>> assembleDetailGroupMap,
      final Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkGroupMap,
      final Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkGroupMap,
      final Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkSerialNumberMap,
      final Map<String, List<TechArtifact>> monomerArtifactSnMap
   ) {
      this.artifactList = artifactList;
      this.assembleList = assembleList;
      this.machinePartList = machinePartList;
      this.standardPartList = standardPartList;
      this.artifactSnMap = artifactSnMap;
      this.assembleIdMap = assembleIdMap;
      this.assembleSnGroupMap = assembleSnGroupMap;
      this.machinePartIdMap = machinePartIdMap;
      this.machinePartSnGroupMap = machinePartSnGroupMap;
      this.artifactMachinePartLinkGroupMap = artifactMachinePartLinkGroupMap;
      this.assembleDetailGroupMap = assembleDetailGroupMap;
      this.artifactStandardPartLinkGroupMap = artifactStandardPartLinkGroupMap;
      this.assembleMachinePartLinkGroupMap = assembleMachinePartLinkGroupMap;
      this.assembleMachinePartLinkSerialNumberMap = assembleMachinePartLinkSerialNumberMap;
      this.monomerArtifactSnMap = monomerArtifactSnMap;
   }

   public TechAreaProductInfoDTO() {
   }

   public static class TechAreaProductInfoDTOBuilder {
      private List<TechArtifact> artifactList;
      private List<TechAssemble> assembleList;
      private List<TechMachinePart> machinePartList;
      private List<TechStandardPart> standardPartList;
      private Map<String, TechArtifact> artifactSnMap;
      private Map<Long, TechAssemble> assembleIdMap;
      private Map<String, List<TechAssemble>> assembleSnGroupMap;
      private Map<Long, TechMachinePart> machinePartIdMap;
      private Map<String, List<TechMachinePart>> machinePartSnGroupMap;
      private Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkGroupMap;
      private Map<Long, List<TechAssembleDetail>> assembleDetailGroupMap;
      private Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkGroupMap;
      private Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkGroupMap;
      private Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkSerialNumberMap;
      private Map<String, List<TechArtifact>> monomerArtifactSnMap;

      TechAreaProductInfoDTOBuilder() {
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder artifactList(final List<TechArtifact> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder assembleList(final List<TechAssemble> assembleList) {
         this.assembleList = assembleList;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder machinePartList(final List<TechMachinePart> machinePartList) {
         this.machinePartList = machinePartList;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder standardPartList(final List<TechStandardPart> standardPartList) {
         this.standardPartList = standardPartList;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder artifactSnMap(final Map<String, TechArtifact> artifactSnMap) {
         this.artifactSnMap = artifactSnMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder assembleIdMap(final Map<Long, TechAssemble> assembleIdMap) {
         this.assembleIdMap = assembleIdMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder assembleSnGroupMap(final Map<String, List<TechAssemble>> assembleSnGroupMap) {
         this.assembleSnGroupMap = assembleSnGroupMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder machinePartIdMap(final Map<Long, TechMachinePart> machinePartIdMap) {
         this.machinePartIdMap = machinePartIdMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder machinePartSnGroupMap(final Map<String, List<TechMachinePart>> machinePartSnGroupMap) {
         this.machinePartSnGroupMap = machinePartSnGroupMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder artifactMachinePartLinkGroupMap(
         final Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkGroupMap
      ) {
         this.artifactMachinePartLinkGroupMap = artifactMachinePartLinkGroupMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder assembleDetailGroupMap(final Map<Long, List<TechAssembleDetail>> assembleDetailGroupMap) {
         this.assembleDetailGroupMap = assembleDetailGroupMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder artifactStandardPartLinkGroupMap(
         final Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkGroupMap
      ) {
         this.artifactStandardPartLinkGroupMap = artifactStandardPartLinkGroupMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder assembleMachinePartLinkGroupMap(
         final Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkGroupMap
      ) {
         this.assembleMachinePartLinkGroupMap = assembleMachinePartLinkGroupMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder assembleMachinePartLinkSerialNumberMap(
         final Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkSerialNumberMap
      ) {
         this.assembleMachinePartLinkSerialNumberMap = assembleMachinePartLinkSerialNumberMap;
         return this;
      }

      public TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder monomerArtifactSnMap(final Map<String, List<TechArtifact>> monomerArtifactSnMap) {
         this.monomerArtifactSnMap = monomerArtifactSnMap;
         return this;
      }

      public TechAreaProductInfoDTO build() {
         return new TechAreaProductInfoDTO(
            this.artifactList,
            this.assembleList,
            this.machinePartList,
            this.standardPartList,
            this.artifactSnMap,
            this.assembleIdMap,
            this.assembleSnGroupMap,
            this.machinePartIdMap,
            this.machinePartSnGroupMap,
            this.artifactMachinePartLinkGroupMap,
            this.assembleDetailGroupMap,
            this.artifactStandardPartLinkGroupMap,
            this.assembleMachinePartLinkGroupMap,
            this.assembleMachinePartLinkSerialNumberMap,
            this.monomerArtifactSnMap
         );
      }

      @Override
      public String toString() {
         return "TechAreaProductInfoDTO.TechAreaProductInfoDTOBuilder(artifactList="
            + this.artifactList
            + ", assembleList="
            + this.assembleList
            + ", machinePartList="
            + this.machinePartList
            + ", standardPartList="
            + this.standardPartList
            + ", artifactSnMap="
            + this.artifactSnMap
            + ", assembleIdMap="
            + this.assembleIdMap
            + ", assembleSnGroupMap="
            + this.assembleSnGroupMap
            + ", machinePartIdMap="
            + this.machinePartIdMap
            + ", machinePartSnGroupMap="
            + this.machinePartSnGroupMap
            + ", artifactMachinePartLinkGroupMap="
            + this.artifactMachinePartLinkGroupMap
            + ", assembleDetailGroupMap="
            + this.assembleDetailGroupMap
            + ", artifactStandardPartLinkGroupMap="
            + this.artifactStandardPartLinkGroupMap
            + ", assembleMachinePartLinkGroupMap="
            + this.assembleMachinePartLinkGroupMap
            + ", assembleMachinePartLinkSerialNumberMap="
            + this.assembleMachinePartLinkSerialNumberMap
            + ", monomerArtifactSnMap="
            + this.monomerArtifactSnMap
            + ")";
      }
   }
}
