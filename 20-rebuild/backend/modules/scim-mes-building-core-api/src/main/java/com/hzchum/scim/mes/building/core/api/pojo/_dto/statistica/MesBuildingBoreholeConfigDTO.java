package com.hzchum.scim.mes.building.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingBoreholeConfigDTO", description = "钻孔配置DTO ")
public class MesBuildingBoreholeConfigDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "零件规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "minThickness", value = "最小板厚(毫米)")
   private BigDecimal minThickness;
   @ApiModelProperty(name = "maxThickness", value = "最大板厚(毫米)")
   private BigDecimal maxThickness;
   @ApiModelProperty(name = "configLinkDTOS", value = "钻孔配置关联DTO")
   private List<MesBuildingBoreholeConfigLinkDTO> configLinkDTOS;

   public static MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder builder() {
      return new MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder();
   }

   public MesBuildingBoreholeConfigDTO() {
   }

   public MesBuildingBoreholeConfigDTO(
      final Long id,
      final String specPrefix,
      final BigDecimal minThickness,
      final BigDecimal maxThickness,
      final List<MesBuildingBoreholeConfigLinkDTO> configLinkDTOS
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
      this.configLinkDTOS = configLinkDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   public List<MesBuildingBoreholeConfigLinkDTO> getConfigLinkDTOS() {
      return this.configLinkDTOS;
   }

   public MesBuildingBoreholeConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingBoreholeConfigDTO setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public MesBuildingBoreholeConfigDTO setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   public MesBuildingBoreholeConfigDTO setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   public MesBuildingBoreholeConfigDTO setConfigLinkDTOS(final List<MesBuildingBoreholeConfigLinkDTO> configLinkDTOS) {
      this.configLinkDTOS = configLinkDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoreholeConfigDTO(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", configLinkDTOS="
         + this.getConfigLinkDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoreholeConfigDTO)) {
         return false;
      }

      MesBuildingBoreholeConfigDTO other = (MesBuildingBoreholeConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specPrefix = this.getSpecPrefix();
         Object other$specPrefix = other.getSpecPrefix();
         if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
            Object this$minThickness = this.getMinThickness();
            Object other$minThickness = other.getMinThickness();
            if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
               Object this$maxThickness = this.getMaxThickness();
               Object other$maxThickness = other.getMaxThickness();
               if (this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness)) {
                  Object this$configLinkDTOS = this.getConfigLinkDTOS();
                  Object other$configLinkDTOS = other.getConfigLinkDTOS();
                  return this$configLinkDTOS == null ? other$configLinkDTOS == null : this$configLinkDTOS.equals(other$configLinkDTOS);
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
      return other instanceof MesBuildingBoreholeConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      result = result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
      Object $configLinkDTOS = this.getConfigLinkDTOS();
      return result * 59 + ($configLinkDTOS == null ? 43 : $configLinkDTOS.hashCode());
   }

   public static class MesBuildingBoreholeConfigDTOBuilder {
      private Long id;
      private String specPrefix;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;
      private List<MesBuildingBoreholeConfigLinkDTO> configLinkDTOS;

      MesBuildingBoreholeConfigDTOBuilder() {
      }

      public MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      public MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      public MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder configLinkDTOS(final List<MesBuildingBoreholeConfigLinkDTO> configLinkDTOS) {
         this.configLinkDTOS = configLinkDTOS;
         return this;
      }

      public MesBuildingBoreholeConfigDTO build() {
         return new MesBuildingBoreholeConfigDTO(this.id, this.specPrefix, this.minThickness, this.maxThickness, this.configLinkDTOS);
      }

      @Override
      public String toString() {
         return "MesBuildingBoreholeConfigDTO.MesBuildingBoreholeConfigDTOBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", configLinkDTOS="
            + this.configLinkDTOS
            + ")";
      }
   }
}
