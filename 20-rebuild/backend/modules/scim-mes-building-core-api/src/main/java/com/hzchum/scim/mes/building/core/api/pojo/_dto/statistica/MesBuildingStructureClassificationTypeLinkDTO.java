package com.hzchum.scim.mes.building.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingArtifactTypeConfigVO", description = "MES构件-组铆焊配置DTO ")
public class MesBuildingStructureClassificationTypeLinkDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "artifactTypeId", value = "构件种类id")
   private Long artifactTypeId;
   @ApiModelProperty(name = "classificationId", value = "构件类型id")
   private Long classificationId;
   @ApiModelProperty(name = "classificationName", value = "构件类型名称")
   private String classificationName;
   @ApiModelProperty(name = "minNumerical", value = "数值范围(开始)")
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "数值范围(结束)")
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "crossSectionPrefix", value = "截面前缀列表")
   private List<String> crossSectionPrefix;
   @ApiModelProperty(name = "structureProcessPriceDTOS", value = "构件类型与工序单价关联表DTO")
   private List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList;

   public static MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder builder() {
      return new MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder();
   }

   public MesBuildingStructureClassificationTypeLinkDTO() {
   }

   public MesBuildingStructureClassificationTypeLinkDTO(
      final Long id,
      final Long artifactTypeId,
      final Long classificationId,
      final String classificationName,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final List<String> crossSectionPrefix,
      final List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList
   ) {
      this.id = id;
      this.artifactTypeId = artifactTypeId;
      this.classificationId = classificationId;
      this.classificationName = classificationName;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.crossSectionPrefix = crossSectionPrefix;
      this.structureProcessPriceList = structureProcessPriceList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactTypeId() {
      return this.artifactTypeId;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   public List<String> getCrossSectionPrefix() {
      return this.crossSectionPrefix;
   }

   public List<MesBuildingStructureProcessPriceDTO> getStructureProcessPriceList() {
      return this.structureProcessPriceList;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setArtifactTypeId(final Long artifactTypeId) {
      this.artifactTypeId = artifactTypeId;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setCrossSectionPrefix(final List<String> crossSectionPrefix) {
      this.crossSectionPrefix = crossSectionPrefix;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkDTO setStructureProcessPriceList(final List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList) {
      this.structureProcessPriceList = structureProcessPriceList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingStructureClassificationTypeLinkDTO(id="
         + this.getId()
         + ", artifactTypeId="
         + this.getArtifactTypeId()
         + ", classificationId="
         + this.getClassificationId()
         + ", classificationName="
         + this.getClassificationName()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", crossSectionPrefix="
         + this.getCrossSectionPrefix()
         + ", structureProcessPriceList="
         + this.getStructureProcessPriceList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingStructureClassificationTypeLinkDTO)) {
         return false;
      }

      MesBuildingStructureClassificationTypeLinkDTO other = (MesBuildingStructureClassificationTypeLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactTypeId = this.getArtifactTypeId();
         Object other$artifactTypeId = other.getArtifactTypeId();
         if (this$artifactTypeId == null ? other$artifactTypeId == null : this$artifactTypeId.equals(other$artifactTypeId)) {
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
               Object this$classificationName = this.getClassificationName();
               Object other$classificationName = other.getClassificationName();
               if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
                  Object this$minNumerical = this.getMinNumerical();
                  Object other$minNumerical = other.getMinNumerical();
                  if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
                     Object this$maxNumerical = this.getMaxNumerical();
                     Object other$maxNumerical = other.getMaxNumerical();
                     if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                        Object this$crossSectionPrefix = this.getCrossSectionPrefix();
                        Object other$crossSectionPrefix = other.getCrossSectionPrefix();
                        if (this$crossSectionPrefix == null ? other$crossSectionPrefix == null : this$crossSectionPrefix.equals(other$crossSectionPrefix)) {
                           Object this$structureProcessPriceList = this.getStructureProcessPriceList();
                           Object other$structureProcessPriceList = other.getStructureProcessPriceList();
                           return this$structureProcessPriceList == null
                              ? other$structureProcessPriceList == null
                              : this$structureProcessPriceList.equals(other$structureProcessPriceList);
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
      return other instanceof MesBuildingStructureClassificationTypeLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactTypeId = this.getArtifactTypeId();
      result = result * 59 + ($artifactTypeId == null ? 43 : $artifactTypeId.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $crossSectionPrefix = this.getCrossSectionPrefix();
      result = result * 59 + ($crossSectionPrefix == null ? 43 : $crossSectionPrefix.hashCode());
      Object $structureProcessPriceList = this.getStructureProcessPriceList();
      return result * 59 + ($structureProcessPriceList == null ? 43 : $structureProcessPriceList.hashCode());
   }

   public static class MesBuildingStructureClassificationTypeLinkDTOBuilder {
      private Long id;
      private Long artifactTypeId;
      private Long classificationId;
      private String classificationName;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private List<String> crossSectionPrefix;
      private List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList;

      MesBuildingStructureClassificationTypeLinkDTOBuilder() {
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder artifactTypeId(final Long artifactTypeId) {
         this.artifactTypeId = artifactTypeId;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder classificationName(
         final String classificationName
      ) {
         this.classificationName = classificationName;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder crossSectionPrefix(
         final List<String> crossSectionPrefix
      ) {
         this.crossSectionPrefix = crossSectionPrefix;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder structureProcessPriceList(
         final List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList
      ) {
         this.structureProcessPriceList = structureProcessPriceList;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkDTO build() {
         return new MesBuildingStructureClassificationTypeLinkDTO(
            this.id,
            this.artifactTypeId,
            this.classificationId,
            this.classificationName,
            this.minNumerical,
            this.maxNumerical,
            this.crossSectionPrefix,
            this.structureProcessPriceList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingStructureClassificationTypeLinkDTO.MesBuildingStructureClassificationTypeLinkDTOBuilder(id="
            + this.id
            + ", artifactTypeId="
            + this.artifactTypeId
            + ", classificationId="
            + this.classificationId
            + ", classificationName="
            + this.classificationName
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", crossSectionPrefix="
            + this.crossSectionPrefix
            + ", structureProcessPriceList="
            + this.structureProcessPriceList
            + ")";
      }
   }
}
