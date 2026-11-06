package com.hzchum.scim.plan.core.api.pojo.dto.manager;

import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ApiModel("单体内图纸信息类")
public class TechMonomerDrawInfoDTO {
   private Set<String> monomerAssembleSnDrawSet;
   private Map<String, List<TechDrawing>> monomerPartDrawingMap;
   private Map<String, Long> holeNumberMap;

   public static TechMonomerDrawInfoDTO.TechMonomerDrawInfoDTOBuilder builder() {
      return new TechMonomerDrawInfoDTO.TechMonomerDrawInfoDTOBuilder();
   }

   public TechMonomerDrawInfoDTO(
      final Set<String> monomerAssembleSnDrawSet, final Map<String, List<TechDrawing>> monomerPartDrawingMap, final Map<String, Long> holeNumberMap
   ) {
      this.monomerAssembleSnDrawSet = monomerAssembleSnDrawSet;
      this.monomerPartDrawingMap = monomerPartDrawingMap;
      this.holeNumberMap = holeNumberMap;
   }

   public TechMonomerDrawInfoDTO() {
   }

   public Set<String> getMonomerAssembleSnDrawSet() {
      return this.monomerAssembleSnDrawSet;
   }

   public Map<String, List<TechDrawing>> getMonomerPartDrawingMap() {
      return this.monomerPartDrawingMap;
   }

   public Map<String, Long> getHoleNumberMap() {
      return this.holeNumberMap;
   }

   public void setMonomerAssembleSnDrawSet(final Set<String> monomerAssembleSnDrawSet) {
      this.monomerAssembleSnDrawSet = monomerAssembleSnDrawSet;
   }

   public void setMonomerPartDrawingMap(final Map<String, List<TechDrawing>> monomerPartDrawingMap) {
      this.monomerPartDrawingMap = monomerPartDrawingMap;
   }

   public void setHoleNumberMap(final Map<String, Long> holeNumberMap) {
      this.holeNumberMap = holeNumberMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMonomerDrawInfoDTO)) {
         return false;
      }

      TechMonomerDrawInfoDTO other = (TechMonomerDrawInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerAssembleSnDrawSet = this.getMonomerAssembleSnDrawSet();
      Object other$monomerAssembleSnDrawSet = other.getMonomerAssembleSnDrawSet();
      if (this$monomerAssembleSnDrawSet == null ? other$monomerAssembleSnDrawSet == null : this$monomerAssembleSnDrawSet.equals(other$monomerAssembleSnDrawSet)
         )
       {
         Object this$monomerPartDrawingMap = this.getMonomerPartDrawingMap();
         Object other$monomerPartDrawingMap = other.getMonomerPartDrawingMap();
         if (this$monomerPartDrawingMap == null ? other$monomerPartDrawingMap == null : this$monomerPartDrawingMap.equals(other$monomerPartDrawingMap)) {
            Object this$holeNumberMap = this.getHoleNumberMap();
            Object other$holeNumberMap = other.getHoleNumberMap();
            return this$holeNumberMap == null ? other$holeNumberMap == null : this$holeNumberMap.equals(other$holeNumberMap);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechMonomerDrawInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerAssembleSnDrawSet = this.getMonomerAssembleSnDrawSet();
      result = result * 59 + ($monomerAssembleSnDrawSet == null ? 43 : $monomerAssembleSnDrawSet.hashCode());
      Object $monomerPartDrawingMap = this.getMonomerPartDrawingMap();
      result = result * 59 + ($monomerPartDrawingMap == null ? 43 : $monomerPartDrawingMap.hashCode());
      Object $holeNumberMap = this.getHoleNumberMap();
      return result * 59 + ($holeNumberMap == null ? 43 : $holeNumberMap.hashCode());
   }

   @Override
   public String toString() {
      return "TechMonomerDrawInfoDTO(monomerAssembleSnDrawSet="
         + this.getMonomerAssembleSnDrawSet()
         + ", monomerPartDrawingMap="
         + this.getMonomerPartDrawingMap()
         + ", holeNumberMap="
         + this.getHoleNumberMap()
         + ")";
   }

   public static class TechMonomerDrawInfoDTOBuilder {
      private Set<String> monomerAssembleSnDrawSet;
      private Map<String, List<TechDrawing>> monomerPartDrawingMap;
      private Map<String, Long> holeNumberMap;

      TechMonomerDrawInfoDTOBuilder() {
      }

      public TechMonomerDrawInfoDTO.TechMonomerDrawInfoDTOBuilder monomerAssembleSnDrawSet(final Set<String> monomerAssembleSnDrawSet) {
         this.monomerAssembleSnDrawSet = monomerAssembleSnDrawSet;
         return this;
      }

      public TechMonomerDrawInfoDTO.TechMonomerDrawInfoDTOBuilder monomerPartDrawingMap(final Map<String, List<TechDrawing>> monomerPartDrawingMap) {
         this.monomerPartDrawingMap = monomerPartDrawingMap;
         return this;
      }

      public TechMonomerDrawInfoDTO.TechMonomerDrawInfoDTOBuilder holeNumberMap(final Map<String, Long> holeNumberMap) {
         this.holeNumberMap = holeNumberMap;
         return this;
      }

      public TechMonomerDrawInfoDTO build() {
         return new TechMonomerDrawInfoDTO(this.monomerAssembleSnDrawSet, this.monomerPartDrawingMap, this.holeNumberMap);
      }

      @Override
      public String toString() {
         return "TechMonomerDrawInfoDTO.TechMonomerDrawInfoDTOBuilder(monomerAssembleSnDrawSet="
            + this.monomerAssembleSnDrawSet
            + ", monomerPartDrawingMap="
            + this.monomerPartDrawingMap
            + ", holeNumberMap="
            + this.holeNumberMap
            + ")";
      }
   }
}
