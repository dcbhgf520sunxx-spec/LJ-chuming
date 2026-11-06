package com.hzchum.scim.mes.enclosure.core.api.pojo._do.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesEnclosureArtifactTypeConfigVO", description = "MES组铆焊配置DO ")
public class MesEnclosureStructureClassificationTypeLinkDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
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
   private List<MesEnclosureStructureProcessPriceDO> structureProcessPriceList;

   public static MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder builder() {
      return new MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder();
   }

   public MesEnclosureStructureClassificationTypeLinkDO() {
   }

   public MesEnclosureStructureClassificationTypeLinkDO(
      final Long id,
      final Long classificationId,
      final String classificationName,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final List<String> crossSectionPrefix,
      final List<MesEnclosureStructureProcessPriceDO> structureProcessPriceList
   ) {
      this.id = id;
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

   public List<MesEnclosureStructureProcessPriceDO> getStructureProcessPriceList() {
      return this.structureProcessPriceList;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setCrossSectionPrefix(final List<String> crossSectionPrefix) {
      this.crossSectionPrefix = crossSectionPrefix;
      return this;
   }

   public MesEnclosureStructureClassificationTypeLinkDO setStructureProcessPriceList(final List<MesEnclosureStructureProcessPriceDO> structureProcessPriceList) {
      this.structureProcessPriceList = structureProcessPriceList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureStructureClassificationTypeLinkDO(id="
         + this.getId()
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

      if (!(o instanceof MesEnclosureStructureClassificationTypeLinkDO)) {
         return false;
      }

      MesEnclosureStructureClassificationTypeLinkDO other = (MesEnclosureStructureClassificationTypeLinkDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureStructureClassificationTypeLinkDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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

   public static class MesEnclosureStructureClassificationTypeLinkDOBuilder {
      private Long id;
      private Long classificationId;
      private String classificationName;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private List<String> crossSectionPrefix;
      private List<MesEnclosureStructureProcessPriceDO> structureProcessPriceList;

      MesEnclosureStructureClassificationTypeLinkDOBuilder() {
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder classificationName(
         final String classificationName
      ) {
         this.classificationName = classificationName;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder crossSectionPrefix(
         final List<String> crossSectionPrefix
      ) {
         this.crossSectionPrefix = crossSectionPrefix;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder structureProcessPriceList(
         final List<MesEnclosureStructureProcessPriceDO> structureProcessPriceList
      ) {
         this.structureProcessPriceList = structureProcessPriceList;
         return this;
      }

      public MesEnclosureStructureClassificationTypeLinkDO build() {
         return new MesEnclosureStructureClassificationTypeLinkDO(
            this.id,
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
         return "MesEnclosureStructureClassificationTypeLinkDO.MesEnclosureStructureClassificationTypeLinkDOBuilder(id="
            + this.id
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
