package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureBoreholeConfigLinkDTO", description = "钻孔配置与零件孔径关联DTO ")
public class MesEnclosureBoreholeHoleRadiusLinkDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "钻孔关联配置id")
   private Long id;
   @ApiModelProperty(name = "holeRadiusLinkId", value = "零件孔径关联id", notes = "零件孔径关联id")
   private Long holeRadiusLinkId;
   @ApiModelProperty(name = "boreholeConfigId", value = "钻孔配置id")
   private Long boreholeConfigId;
   @ApiModelProperty(name = "minBoreDiameter", value = "最小孔径(毫米)")
   private BigDecimal minBoreDiameter;
   @ApiModelProperty(name = "maxBoreDiameter", value = "最大孔径(毫米)")
   private BigDecimal maxBoreDiameter;
   @ApiModelProperty(name = "unitPrice", value = "单价(元/个)")
   private BigDecimal unitPrice;

   public static MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder builder() {
      return new MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder();
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO() {
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO(
      final Long id,
      final Long holeRadiusLinkId,
      final Long boreholeConfigId,
      final BigDecimal minBoreDiameter,
      final BigDecimal maxBoreDiameter,
      final BigDecimal unitPrice
   ) {
      this.id = id;
      this.holeRadiusLinkId = holeRadiusLinkId;
      this.boreholeConfigId = boreholeConfigId;
      this.minBoreDiameter = minBoreDiameter;
      this.maxBoreDiameter = maxBoreDiameter;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getHoleRadiusLinkId() {
      return this.holeRadiusLinkId;
   }

   public Long getBoreholeConfigId() {
      return this.boreholeConfigId;
   }

   public BigDecimal getMinBoreDiameter() {
      return this.minBoreDiameter;
   }

   public BigDecimal getMaxBoreDiameter() {
      return this.maxBoreDiameter;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO setHoleRadiusLinkId(final Long holeRadiusLinkId) {
      this.holeRadiusLinkId = holeRadiusLinkId;
      return this;
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO setBoreholeConfigId(final Long boreholeConfigId) {
      this.boreholeConfigId = boreholeConfigId;
      return this;
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO setMinBoreDiameter(final BigDecimal minBoreDiameter) {
      this.minBoreDiameter = minBoreDiameter;
      return this;
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO setMaxBoreDiameter(final BigDecimal maxBoreDiameter) {
      this.maxBoreDiameter = maxBoreDiameter;
      return this;
   }

   public MesEnclosureBoreholeHoleRadiusLinkDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureBoreholeHoleRadiusLinkDTO(id="
         + this.getId()
         + ", holeRadiusLinkId="
         + this.getHoleRadiusLinkId()
         + ", boreholeConfigId="
         + this.getBoreholeConfigId()
         + ", minBoreDiameter="
         + this.getMinBoreDiameter()
         + ", maxBoreDiameter="
         + this.getMaxBoreDiameter()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureBoreholeHoleRadiusLinkDTO)) {
         return false;
      }

      MesEnclosureBoreholeHoleRadiusLinkDTO other = (MesEnclosureBoreholeHoleRadiusLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$holeRadiusLinkId = this.getHoleRadiusLinkId();
         Object other$holeRadiusLinkId = other.getHoleRadiusLinkId();
         if (this$holeRadiusLinkId == null ? other$holeRadiusLinkId == null : this$holeRadiusLinkId.equals(other$holeRadiusLinkId)) {
            Object this$boreholeConfigId = this.getBoreholeConfigId();
            Object other$boreholeConfigId = other.getBoreholeConfigId();
            if (this$boreholeConfigId == null ? other$boreholeConfigId == null : this$boreholeConfigId.equals(other$boreholeConfigId)) {
               Object this$minBoreDiameter = this.getMinBoreDiameter();
               Object other$minBoreDiameter = other.getMinBoreDiameter();
               if (this$minBoreDiameter == null ? other$minBoreDiameter == null : this$minBoreDiameter.equals(other$minBoreDiameter)) {
                  Object this$maxBoreDiameter = this.getMaxBoreDiameter();
                  Object other$maxBoreDiameter = other.getMaxBoreDiameter();
                  if (this$maxBoreDiameter == null ? other$maxBoreDiameter == null : this$maxBoreDiameter.equals(other$maxBoreDiameter)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureBoreholeHoleRadiusLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $holeRadiusLinkId = this.getHoleRadiusLinkId();
      result = result * 59 + ($holeRadiusLinkId == null ? 43 : $holeRadiusLinkId.hashCode());
      Object $boreholeConfigId = this.getBoreholeConfigId();
      result = result * 59 + ($boreholeConfigId == null ? 43 : $boreholeConfigId.hashCode());
      Object $minBoreDiameter = this.getMinBoreDiameter();
      result = result * 59 + ($minBoreDiameter == null ? 43 : $minBoreDiameter.hashCode());
      Object $maxBoreDiameter = this.getMaxBoreDiameter();
      result = result * 59 + ($maxBoreDiameter == null ? 43 : $maxBoreDiameter.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesEnclosureBoreholeHoleRadiusLinkDTOBuilder {
      private Long id;
      private Long holeRadiusLinkId;
      private Long boreholeConfigId;
      private BigDecimal minBoreDiameter;
      private BigDecimal maxBoreDiameter;
      private BigDecimal unitPrice;

      MesEnclosureBoreholeHoleRadiusLinkDTOBuilder() {
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder holeRadiusLinkId(final Long holeRadiusLinkId) {
         this.holeRadiusLinkId = holeRadiusLinkId;
         return this;
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder boreholeConfigId(final Long boreholeConfigId) {
         this.boreholeConfigId = boreholeConfigId;
         return this;
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder minBoreDiameter(final BigDecimal minBoreDiameter) {
         this.minBoreDiameter = minBoreDiameter;
         return this;
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder maxBoreDiameter(final BigDecimal maxBoreDiameter) {
         this.maxBoreDiameter = maxBoreDiameter;
         return this;
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesEnclosureBoreholeHoleRadiusLinkDTO build() {
         return new MesEnclosureBoreholeHoleRadiusLinkDTO(
            this.id, this.holeRadiusLinkId, this.boreholeConfigId, this.minBoreDiameter, this.maxBoreDiameter, this.unitPrice
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureBoreholeHoleRadiusLinkDTO.MesEnclosureBoreholeHoleRadiusLinkDTOBuilder(id="
            + this.id
            + ", holeRadiusLinkId="
            + this.holeRadiusLinkId
            + ", boreholeConfigId="
            + this.boreholeConfigId
            + ", minBoreDiameter="
            + this.minBoreDiameter
            + ", maxBoreDiameter="
            + this.maxBoreDiameter
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
