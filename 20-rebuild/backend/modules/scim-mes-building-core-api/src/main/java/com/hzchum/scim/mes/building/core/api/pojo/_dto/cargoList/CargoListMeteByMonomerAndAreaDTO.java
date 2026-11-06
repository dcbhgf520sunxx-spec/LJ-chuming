package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运信息汇总")
public class CargoListMeteByMonomerAndAreaDTO {
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名", notes = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "quantity", value = "清单数", notes = "清单数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "清单量", notes = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "cargoQuantity", value = "发运数", notes = "发运数")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "cargoNetWeight", value = "发运量", notes = "发运量")
   @JsonProperty("cargoNetWeight")
   @JSONField(name = "cargoNetWeight")
   private BigDecimal cargoNetWeight;
   @ApiModelProperty(name = "unCargoQuantity", value = "未发运数", notes = "未发运数")
   @JsonProperty("unCargoQuantity")
   @JSONField(name = "unCargoQuantity")
   private Integer unCargoQuantity;
   @ApiModelProperty(name = "unCargoNetWeight", value = "未发运量", notes = "未发运量")
   @JsonProperty("unCargoNetWeight")
   @JSONField(name = "unCargoNetWeight")
   private BigDecimal unCargoNetWeight;

   public static CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder builder() {
      return new CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder();
   }

   public CargoListMeteByMonomerAndAreaDTO(
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final Integer cargoQuantity,
      final BigDecimal cargoNetWeight,
      final Integer unCargoQuantity,
      final BigDecimal unCargoNetWeight
   ) {
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.cargoQuantity = cargoQuantity;
      this.cargoNetWeight = cargoNetWeight;
      this.unCargoQuantity = unCargoQuantity;
      this.unCargoNetWeight = unCargoNetWeight;
   }

   public CargoListMeteByMonomerAndAreaDTO() {
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public BigDecimal getCargoNetWeight() {
      return this.cargoNetWeight;
   }

   public Integer getUnCargoQuantity() {
      return this.unCargoQuantity;
   }

   public BigDecimal getUnCargoNetWeight() {
      return this.unCargoNetWeight;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("monomerName")
   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("areaName")
   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("cargoQuantity")
   public void setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
   }

   @JsonProperty("cargoNetWeight")
   public void setCargoNetWeight(final BigDecimal cargoNetWeight) {
      this.cargoNetWeight = cargoNetWeight;
   }

   @JsonProperty("unCargoQuantity")
   public void setUnCargoQuantity(final Integer unCargoQuantity) {
      this.unCargoQuantity = unCargoQuantity;
   }

   @JsonProperty("unCargoNetWeight")
   public void setUnCargoNetWeight(final BigDecimal unCargoNetWeight) {
      this.unCargoNetWeight = unCargoNetWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListMeteByMonomerAndAreaDTO)) {
         return false;
      }

      CargoListMeteByMonomerAndAreaDTO other = (CargoListMeteByMonomerAndAreaDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$cargoQuantity = this.getCargoQuantity();
               Object other$cargoQuantity = other.getCargoQuantity();
               if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                  Object this$unCargoQuantity = this.getUnCargoQuantity();
                  Object other$unCargoQuantity = other.getUnCargoQuantity();
                  if (this$unCargoQuantity == null ? other$unCargoQuantity == null : this$unCargoQuantity.equals(other$unCargoQuantity)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$totalNetWeight = this.getTotalNetWeight();
                           Object other$totalNetWeight = other.getTotalNetWeight();
                           if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                              Object this$cargoNetWeight = this.getCargoNetWeight();
                              Object other$cargoNetWeight = other.getCargoNetWeight();
                              if (this$cargoNetWeight == null ? other$cargoNetWeight == null : this$cargoNetWeight.equals(other$cargoNetWeight)) {
                                 Object this$unCargoNetWeight = this.getUnCargoNetWeight();
                                 Object other$unCargoNetWeight = other.getUnCargoNetWeight();
                                 return this$unCargoNetWeight == null ? other$unCargoNetWeight == null : this$unCargoNetWeight.equals(other$unCargoNetWeight);
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
      return other instanceof CargoListMeteByMonomerAndAreaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $unCargoQuantity = this.getUnCargoQuantity();
      result = result * 59 + ($unCargoQuantity == null ? 43 : $unCargoQuantity.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $cargoNetWeight = this.getCargoNetWeight();
      result = result * 59 + ($cargoNetWeight == null ? 43 : $cargoNetWeight.hashCode());
      Object $unCargoNetWeight = this.getUnCargoNetWeight();
      return result * 59 + ($unCargoNetWeight == null ? 43 : $unCargoNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListMeteByMonomerAndAreaDTO(monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", cargoNetWeight="
         + this.getCargoNetWeight()
         + ", unCargoQuantity="
         + this.getUnCargoQuantity()
         + ", unCargoNetWeight="
         + this.getUnCargoNetWeight()
         + ")";
   }

   public static class CargoListMeteByMonomerAndAreaDTOBuilder {
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private Integer cargoQuantity;
      private BigDecimal cargoNetWeight;
      private Integer unCargoQuantity;
      private BigDecimal unCargoNetWeight;

      CargoListMeteByMonomerAndAreaDTOBuilder() {
      }

      @JsonProperty("monomerId")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("monomerName")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaId")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("quantity")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("cargoNetWeight")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder cargoNetWeight(final BigDecimal cargoNetWeight) {
         this.cargoNetWeight = cargoNetWeight;
         return this;
      }

      @JsonProperty("unCargoQuantity")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder unCargoQuantity(final Integer unCargoQuantity) {
         this.unCargoQuantity = unCargoQuantity;
         return this;
      }

      @JsonProperty("unCargoNetWeight")
      public CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder unCargoNetWeight(final BigDecimal unCargoNetWeight) {
         this.unCargoNetWeight = unCargoNetWeight;
         return this;
      }

      public CargoListMeteByMonomerAndAreaDTO build() {
         return new CargoListMeteByMonomerAndAreaDTO(
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.quantity,
            this.totalNetWeight,
            this.cargoQuantity,
            this.cargoNetWeight,
            this.unCargoQuantity,
            this.unCargoNetWeight
         );
      }

      @Override
      public String toString() {
         return "CargoListMeteByMonomerAndAreaDTO.CargoListMeteByMonomerAndAreaDTOBuilder(monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", cargoNetWeight="
            + this.cargoNetWeight
            + ", unCargoQuantity="
            + this.unCargoQuantity
            + ", unCargoNetWeight="
            + this.unCargoNetWeight
            + ")";
      }
   }
}
