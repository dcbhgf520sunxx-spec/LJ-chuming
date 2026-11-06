package com.hzchum.scim.mes.building.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingBoreholeConfigLinkDTO", description = "钻孔配置关联DTO ")
public class MesBuildingBoreholeConfigLinkDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "boreholeConfigId", value = "钻孔配置id")
   private Long boreholeConfigId;
   @ApiModelProperty(name = "minBoreDiameter", value = "最小孔径(毫米)")
   private BigDecimal minBoreDiameter;
   @ApiModelProperty(name = "maxBoreDiameter", value = "最大孔径(毫米)")
   private BigDecimal maxBoreDiameter;
   @ApiModelProperty(name = "unitPrice", value = "单价(元/个)")
   private BigDecimal unitPrice;

   public static MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder builder() {
      return new MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder();
   }

   public MesBuildingBoreholeConfigLinkDTO() {
   }

   public MesBuildingBoreholeConfigLinkDTO(
      final Long id, final Long boreholeConfigId, final BigDecimal minBoreDiameter, final BigDecimal maxBoreDiameter, final BigDecimal unitPrice
   ) {
      this.id = id;
      this.boreholeConfigId = boreholeConfigId;
      this.minBoreDiameter = minBoreDiameter;
      this.maxBoreDiameter = maxBoreDiameter;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
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

   public MesBuildingBoreholeConfigLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingBoreholeConfigLinkDTO setBoreholeConfigId(final Long boreholeConfigId) {
      this.boreholeConfigId = boreholeConfigId;
      return this;
   }

   public MesBuildingBoreholeConfigLinkDTO setMinBoreDiameter(final BigDecimal minBoreDiameter) {
      this.minBoreDiameter = minBoreDiameter;
      return this;
   }

   public MesBuildingBoreholeConfigLinkDTO setMaxBoreDiameter(final BigDecimal maxBoreDiameter) {
      this.maxBoreDiameter = maxBoreDiameter;
      return this;
   }

   public MesBuildingBoreholeConfigLinkDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoreholeConfigLinkDTO(id="
         + this.getId()
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

      if (!(o instanceof MesBuildingBoreholeConfigLinkDTO)) {
         return false;
      }

      MesBuildingBoreholeConfigLinkDTO other = (MesBuildingBoreholeConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingBoreholeConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boreholeConfigId = this.getBoreholeConfigId();
      result = result * 59 + ($boreholeConfigId == null ? 43 : $boreholeConfigId.hashCode());
      Object $minBoreDiameter = this.getMinBoreDiameter();
      result = result * 59 + ($minBoreDiameter == null ? 43 : $minBoreDiameter.hashCode());
      Object $maxBoreDiameter = this.getMaxBoreDiameter();
      result = result * 59 + ($maxBoreDiameter == null ? 43 : $maxBoreDiameter.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesBuildingBoreholeConfigLinkDTOBuilder {
      private Long id;
      private Long boreholeConfigId;
      private BigDecimal minBoreDiameter;
      private BigDecimal maxBoreDiameter;
      private BigDecimal unitPrice;

      MesBuildingBoreholeConfigLinkDTOBuilder() {
      }

      public MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder boreholeConfigId(final Long boreholeConfigId) {
         this.boreholeConfigId = boreholeConfigId;
         return this;
      }

      public MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder minBoreDiameter(final BigDecimal minBoreDiameter) {
         this.minBoreDiameter = minBoreDiameter;
         return this;
      }

      public MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder maxBoreDiameter(final BigDecimal maxBoreDiameter) {
         this.maxBoreDiameter = maxBoreDiameter;
         return this;
      }

      public MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingBoreholeConfigLinkDTO build() {
         return new MesBuildingBoreholeConfigLinkDTO(this.id, this.boreholeConfigId, this.minBoreDiameter, this.maxBoreDiameter, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesBuildingBoreholeConfigLinkDTO.MesBuildingBoreholeConfigLinkDTOBuilder(id="
            + this.id
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
