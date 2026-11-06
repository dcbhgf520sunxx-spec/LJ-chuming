package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureLayingOffConfig对象", description = "MES零件-下料配置")
public class MesEnclosureLayingOffConfigDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "零件规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "name", value = "下料方式名称", notes = "下料方式名称")
   private String name;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   private Long cutConfigId;
   @ApiModelProperty(name = "minNumerical", value = "数值范围(最小)")
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "数值范围(最大)")
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式 [1 重量, 2 长度，4 面积, 8 数量]")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "unitPrice", value = "单价(元)")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否套料", notes = "是否套料")
   private Boolean boolNestCutEnum;

   public static MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder builder() {
      return new MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder();
   }

   public MesEnclosureLayingOffConfigDTO() {
   }

   public MesEnclosureLayingOffConfigDTO(
      final Long id,
      final String specPrefix,
      final String name,
      final Long cutConfigId,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final Integer wageQuotaType,
      final BigDecimal unitPrice,
      final Boolean boolNestCutEnum
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.name = name;
      this.cutConfigId = cutConfigId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.wageQuotaType = wageQuotaType;
      this.unitPrice = unitPrice;
      this.boolNestCutEnum = boolNestCutEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getName() {
      return this.name;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
   }

   public void setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
   }

   public void setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
   }

   @Override
   public String toString() {
      return "MesEnclosureLayingOffConfigDTO(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", name="
         + this.getName()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureLayingOffConfigDTO)) {
         return false;
      }

      MesEnclosureLayingOffConfigDTO other = (MesEnclosureLayingOffConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$boolNestCutEnum = this.getBoolNestCutEnum();
               Object other$boolNestCutEnum = other.getBoolNestCutEnum();
               if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                  Object this$specPrefix = this.getSpecPrefix();
                  Object other$specPrefix = other.getSpecPrefix();
                  if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$minNumerical = this.getMinNumerical();
                        Object other$minNumerical = other.getMinNumerical();
                        if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
                           Object this$maxNumerical = this.getMaxNumerical();
                           Object other$maxNumerical = other.getMaxNumerical();
                           if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                              Object this$unitPrice = this.getUnitPrice();
                              Object other$unitPrice = other.getUnitPrice();
                              return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof MesEnclosureLayingOffConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesEnclosureLayingOffConfigDTOBuilder {
      private Long id;
      private String specPrefix;
      private String name;
      private Long cutConfigId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private Integer wageQuotaType;
      private BigDecimal unitPrice;
      private Boolean boolNestCutEnum;

      MesEnclosureLayingOffConfigDTOBuilder() {
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      public MesEnclosureLayingOffConfigDTO build() {
         return new MesEnclosureLayingOffConfigDTO(
            this.id,
            this.specPrefix,
            this.name,
            this.cutConfigId,
            this.minNumerical,
            this.maxNumerical,
            this.wageQuotaType,
            this.unitPrice,
            this.boolNestCutEnum
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureLayingOffConfigDTO.MesEnclosureLayingOffConfigDTOBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", name="
            + this.name
            + ", cutConfigId="
            + this.cutConfigId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", unitPrice="
            + this.unitPrice
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ")";
      }
   }
}
