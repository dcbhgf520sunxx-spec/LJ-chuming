package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;

@ApiModel(value = "MesEnclosureAssembleLinkVO", description = "MES部件-组铆焊配置DTO")
public class MesEnclosureAssembleLinkDTO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "sysAssembleId", value = "部件类型id")
   private Long sysAssembleId;
   @ApiModelProperty(name = "minNumerical", value = "最小数值范围")
   @Min(0L)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "最大数值范围")
   @Min(0L)
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "sysAssembleName", value = "部件类型名称")
   private String sysAssembleName;
   @ApiModelProperty(name = "crossSectionPrefix", value = "截面前缀列表")
   private List<String> crossSectionPrefix;
   @ApiModelProperty(name = "structureProcessPriceList", value = "组铆焊单价关联表VO")
   private List<MesEnclosureStructureProcessPriceDTO> structureProcessPriceList;

   public static MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder builder() {
      return new MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder();
   }

   public MesEnclosureAssembleLinkDTO() {
   }

   public MesEnclosureAssembleLinkDTO(
      final Long id,
      final Long sysAssembleId,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final String sysAssembleName,
      final List<String> crossSectionPrefix,
      final List<MesEnclosureStructureProcessPriceDTO> structureProcessPriceList
   ) {
      this.id = id;
      this.sysAssembleId = sysAssembleId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.sysAssembleName = sysAssembleName;
      this.crossSectionPrefix = crossSectionPrefix;
      this.structureProcessPriceList = structureProcessPriceList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSysAssembleId() {
      return this.sysAssembleId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   public String getSysAssembleName() {
      return this.sysAssembleName;
   }

   public List<String> getCrossSectionPrefix() {
      return this.crossSectionPrefix;
   }

   public List<MesEnclosureStructureProcessPriceDTO> getStructureProcessPriceList() {
      return this.structureProcessPriceList;
   }

   public MesEnclosureAssembleLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureAssembleLinkDTO setSysAssembleId(final Long sysAssembleId) {
      this.sysAssembleId = sysAssembleId;
      return this;
   }

   public MesEnclosureAssembleLinkDTO setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   public MesEnclosureAssembleLinkDTO setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   public MesEnclosureAssembleLinkDTO setSysAssembleName(final String sysAssembleName) {
      this.sysAssembleName = sysAssembleName;
      return this;
   }

   public MesEnclosureAssembleLinkDTO setCrossSectionPrefix(final List<String> crossSectionPrefix) {
      this.crossSectionPrefix = crossSectionPrefix;
      return this;
   }

   public MesEnclosureAssembleLinkDTO setStructureProcessPriceList(final List<MesEnclosureStructureProcessPriceDTO> structureProcessPriceList) {
      this.structureProcessPriceList = structureProcessPriceList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAssembleLinkDTO(id="
         + this.getId()
         + ", sysAssembleId="
         + this.getSysAssembleId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", sysAssembleName="
         + this.getSysAssembleName()
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

      if (!(o instanceof MesEnclosureAssembleLinkDTO)) {
         return false;
      }

      MesEnclosureAssembleLinkDTO other = (MesEnclosureAssembleLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysAssembleId = this.getSysAssembleId();
         Object other$sysAssembleId = other.getSysAssembleId();
         if (this$sysAssembleId == null ? other$sysAssembleId == null : this$sysAssembleId.equals(other$sysAssembleId)) {
            Object this$minNumerical = this.getMinNumerical();
            Object other$minNumerical = other.getMinNumerical();
            if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
               Object this$maxNumerical = this.getMaxNumerical();
               Object other$maxNumerical = other.getMaxNumerical();
               if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                  Object this$sysAssembleName = this.getSysAssembleName();
                  Object other$sysAssembleName = other.getSysAssembleName();
                  if (this$sysAssembleName == null ? other$sysAssembleName == null : this$sysAssembleName.equals(other$sysAssembleName)) {
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
      return other instanceof MesEnclosureAssembleLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysAssembleId = this.getSysAssembleId();
      result = result * 59 + ($sysAssembleId == null ? 43 : $sysAssembleId.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $sysAssembleName = this.getSysAssembleName();
      result = result * 59 + ($sysAssembleName == null ? 43 : $sysAssembleName.hashCode());
      Object $crossSectionPrefix = this.getCrossSectionPrefix();
      result = result * 59 + ($crossSectionPrefix == null ? 43 : $crossSectionPrefix.hashCode());
      Object $structureProcessPriceList = this.getStructureProcessPriceList();
      return result * 59 + ($structureProcessPriceList == null ? 43 : $structureProcessPriceList.hashCode());
   }

   public static class MesEnclosureAssembleLinkDTOBuilder {
      private Long id;
      private Long sysAssembleId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private String sysAssembleName;
      private List<String> crossSectionPrefix;
      private List<MesEnclosureStructureProcessPriceDTO> structureProcessPriceList;

      MesEnclosureAssembleLinkDTOBuilder() {
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder sysAssembleId(final Long sysAssembleId) {
         this.sysAssembleId = sysAssembleId;
         return this;
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder sysAssembleName(final String sysAssembleName) {
         this.sysAssembleName = sysAssembleName;
         return this;
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder crossSectionPrefix(final List<String> crossSectionPrefix) {
         this.crossSectionPrefix = crossSectionPrefix;
         return this;
      }

      public MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder structureProcessPriceList(
         final List<MesEnclosureStructureProcessPriceDTO> structureProcessPriceList
      ) {
         this.structureProcessPriceList = structureProcessPriceList;
         return this;
      }

      public MesEnclosureAssembleLinkDTO build() {
         return new MesEnclosureAssembleLinkDTO(
            this.id, this.sysAssembleId, this.minNumerical, this.maxNumerical, this.sysAssembleName, this.crossSectionPrefix, this.structureProcessPriceList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureAssembleLinkDTO.MesEnclosureAssembleLinkDTOBuilder(id="
            + this.id
            + ", sysAssembleId="
            + this.sysAssembleId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", sysAssembleName="
            + this.sysAssembleName
            + ", crossSectionPrefix="
            + this.crossSectionPrefix
            + ", structureProcessPriceList="
            + this.structureProcessPriceList
            + ")";
      }
   }
}
