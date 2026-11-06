package com.hzchum.scim.mes.enclosure.core.api.pojo._do.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;

@ApiModel(value = "MesEnclosureAssembleLinkVO", description = "MES组立-组铆焊配置DO")
public class MesEnclosureAssembleLinkDO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "classificationId", value = "部件类型id")
   private Long sysAssembleId;
   @ApiModelProperty(name = "sysAssembleName", value = "部件类型名称")
   private String sysAssembleName;
   @ApiModelProperty(name = "minNumerical", value = "最小数值范围")
   @Min(0L)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "最大数值范围")
   @Min(0L)
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "crossSectionPrefix", value = "截面前缀列表")
   private List<String> crossSectionPrefix;
   @ApiModelProperty(name = "structureProcessPriceList", value = "组铆焊单价关联表DO")
   private List<MesEnclosureStructureProcessPriceDO> assembleProcessPriceList;

   public static MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder builder() {
      return new MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder();
   }

   public MesEnclosureAssembleLinkDO() {
   }

   public MesEnclosureAssembleLinkDO(
      final Long id,
      final Long sysAssembleId,
      final String sysAssembleName,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final List<String> crossSectionPrefix,
      final List<MesEnclosureStructureProcessPriceDO> assembleProcessPriceList
   ) {
      this.id = id;
      this.sysAssembleId = sysAssembleId;
      this.sysAssembleName = sysAssembleName;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.crossSectionPrefix = crossSectionPrefix;
      this.assembleProcessPriceList = assembleProcessPriceList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSysAssembleId() {
      return this.sysAssembleId;
   }

   public String getSysAssembleName() {
      return this.sysAssembleName;
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

   public List<MesEnclosureStructureProcessPriceDO> getAssembleProcessPriceList() {
      return this.assembleProcessPriceList;
   }

   public MesEnclosureAssembleLinkDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureAssembleLinkDO setSysAssembleId(final Long sysAssembleId) {
      this.sysAssembleId = sysAssembleId;
      return this;
   }

   public MesEnclosureAssembleLinkDO setSysAssembleName(final String sysAssembleName) {
      this.sysAssembleName = sysAssembleName;
      return this;
   }

   public MesEnclosureAssembleLinkDO setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   public MesEnclosureAssembleLinkDO setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   public MesEnclosureAssembleLinkDO setCrossSectionPrefix(final List<String> crossSectionPrefix) {
      this.crossSectionPrefix = crossSectionPrefix;
      return this;
   }

   public MesEnclosureAssembleLinkDO setAssembleProcessPriceList(final List<MesEnclosureStructureProcessPriceDO> assembleProcessPriceList) {
      this.assembleProcessPriceList = assembleProcessPriceList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAssembleLinkDO(id="
         + this.getId()
         + ", sysAssembleId="
         + this.getSysAssembleId()
         + ", sysAssembleName="
         + this.getSysAssembleName()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", crossSectionPrefix="
         + this.getCrossSectionPrefix()
         + ", assembleProcessPriceList="
         + this.getAssembleProcessPriceList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureAssembleLinkDO)) {
         return false;
      }

      MesEnclosureAssembleLinkDO other = (MesEnclosureAssembleLinkDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysAssembleId = this.getSysAssembleId();
         Object other$sysAssembleId = other.getSysAssembleId();
         if (this$sysAssembleId == null ? other$sysAssembleId == null : this$sysAssembleId.equals(other$sysAssembleId)) {
            Object this$sysAssembleName = this.getSysAssembleName();
            Object other$sysAssembleName = other.getSysAssembleName();
            if (this$sysAssembleName == null ? other$sysAssembleName == null : this$sysAssembleName.equals(other$sysAssembleName)) {
               Object this$minNumerical = this.getMinNumerical();
               Object other$minNumerical = other.getMinNumerical();
               if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
                  Object this$maxNumerical = this.getMaxNumerical();
                  Object other$maxNumerical = other.getMaxNumerical();
                  if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                     Object this$crossSectionPrefix = this.getCrossSectionPrefix();
                     Object other$crossSectionPrefix = other.getCrossSectionPrefix();
                     if (this$crossSectionPrefix == null ? other$crossSectionPrefix == null : this$crossSectionPrefix.equals(other$crossSectionPrefix)) {
                        Object this$assembleProcessPriceList = this.getAssembleProcessPriceList();
                        Object other$assembleProcessPriceList = other.getAssembleProcessPriceList();
                        return this$assembleProcessPriceList == null
                           ? other$assembleProcessPriceList == null
                           : this$assembleProcessPriceList.equals(other$assembleProcessPriceList);
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
      return other instanceof MesEnclosureAssembleLinkDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysAssembleId = this.getSysAssembleId();
      result = result * 59 + ($sysAssembleId == null ? 43 : $sysAssembleId.hashCode());
      Object $sysAssembleName = this.getSysAssembleName();
      result = result * 59 + ($sysAssembleName == null ? 43 : $sysAssembleName.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $crossSectionPrefix = this.getCrossSectionPrefix();
      result = result * 59 + ($crossSectionPrefix == null ? 43 : $crossSectionPrefix.hashCode());
      Object $assembleProcessPriceList = this.getAssembleProcessPriceList();
      return result * 59 + ($assembleProcessPriceList == null ? 43 : $assembleProcessPriceList.hashCode());
   }

   public static class MesEnclosureAssembleLinkDOBuilder {
      private Long id;
      private Long sysAssembleId;
      private String sysAssembleName;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private List<String> crossSectionPrefix;
      private List<MesEnclosureStructureProcessPriceDO> assembleProcessPriceList;

      MesEnclosureAssembleLinkDOBuilder() {
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder sysAssembleId(final Long sysAssembleId) {
         this.sysAssembleId = sysAssembleId;
         return this;
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder sysAssembleName(final String sysAssembleName) {
         this.sysAssembleName = sysAssembleName;
         return this;
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder crossSectionPrefix(final List<String> crossSectionPrefix) {
         this.crossSectionPrefix = crossSectionPrefix;
         return this;
      }

      public MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder assembleProcessPriceList(
         final List<MesEnclosureStructureProcessPriceDO> assembleProcessPriceList
      ) {
         this.assembleProcessPriceList = assembleProcessPriceList;
         return this;
      }

      public MesEnclosureAssembleLinkDO build() {
         return new MesEnclosureAssembleLinkDO(
            this.id, this.sysAssembleId, this.sysAssembleName, this.minNumerical, this.maxNumerical, this.crossSectionPrefix, this.assembleProcessPriceList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureAssembleLinkDO.MesEnclosureAssembleLinkDOBuilder(id="
            + this.id
            + ", sysAssembleId="
            + this.sysAssembleId
            + ", sysAssembleName="
            + this.sysAssembleName
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", crossSectionPrefix="
            + this.crossSectionPrefix
            + ", assembleProcessPriceList="
            + this.assembleProcessPriceList
            + ")";
      }
   }
}
