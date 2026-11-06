package com.hzchum.scim.bim.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("bim构件状态信息")
@JsonInclude(Include.NON_NULL)
public class BimArtifactProductionVO {
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "areaId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "quantity", value = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "清单总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "清单总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "producedQuantity", value = "生产中、已出库、已安装数量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "producedTotalNetWeight", value = "生产中、已出库、已安装总净重")
   private BigDecimal producedTotalNetWeight;
   @ApiModelProperty(name = "producedTotalGrossWeight", value = "生产中、已出库、已安装总毛重")
   private BigDecimal producedTotalGrossWeight;
   @ApiModelProperty(name = "unProducedQuantity", value = "未生产、未入库、未收货数量")
   private Integer unProducedQuantity;
   @ApiModelProperty(name = "unProducedTotalNetWeight", value = "未生产、未入库、未收货总净重")
   private BigDecimal unProducedTotalNetWeight;
   @ApiModelProperty(name = "unProducedTotalGrossWeight", value = "未生产、未入库、未收货总毛重")
   private BigDecimal unProducedTotalGrossWeight;
   @ApiModelProperty(name = "storageQuantity", value = "生产完成、入库、收货数量")
   private Integer storageQuantity;
   @ApiModelProperty(name = "storageTotalNetWeight", value = "生产完成、入库、收货总净重")
   private BigDecimal storageTotalNetWeight;
   @ApiModelProperty(name = "storageTotalGrossWeight", value = "生产完成、入库、收货总毛重")
   private BigDecimal storageTotalGrossWeight;

   public static BimArtifactProductionVO.BimArtifactProductionVOBuilder builder() {
      return new BimArtifactProductionVO.BimArtifactProductionVOBuilder();
   }

   public BimArtifactProductionVO() {
   }

   public BimArtifactProductionVO(
      final Long areaId,
      final String areaName,
      final Long monomerId,
      final String monomerName,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer producedQuantity,
      final BigDecimal producedTotalNetWeight,
      final BigDecimal producedTotalGrossWeight,
      final Integer unProducedQuantity,
      final BigDecimal unProducedTotalNetWeight,
      final BigDecimal unProducedTotalGrossWeight,
      final Integer storageQuantity,
      final BigDecimal storageTotalNetWeight,
      final BigDecimal storageTotalGrossWeight
   ) {
      this.areaId = areaId;
      this.areaName = areaName;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.producedQuantity = producedQuantity;
      this.producedTotalNetWeight = producedTotalNetWeight;
      this.producedTotalGrossWeight = producedTotalGrossWeight;
      this.unProducedQuantity = unProducedQuantity;
      this.unProducedTotalNetWeight = unProducedTotalNetWeight;
      this.unProducedTotalGrossWeight = unProducedTotalGrossWeight;
      this.storageQuantity = storageQuantity;
      this.storageTotalNetWeight = storageTotalNetWeight;
      this.storageTotalGrossWeight = storageTotalGrossWeight;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public BigDecimal getProducedTotalNetWeight() {
      return this.producedTotalNetWeight;
   }

   public BigDecimal getProducedTotalGrossWeight() {
      return this.producedTotalGrossWeight;
   }

   public Integer getUnProducedQuantity() {
      return this.unProducedQuantity;
   }

   public BigDecimal getUnProducedTotalNetWeight() {
      return this.unProducedTotalNetWeight;
   }

   public BigDecimal getUnProducedTotalGrossWeight() {
      return this.unProducedTotalGrossWeight;
   }

   public Integer getStorageQuantity() {
      return this.storageQuantity;
   }

   public BigDecimal getStorageTotalNetWeight() {
      return this.storageTotalNetWeight;
   }

   public BigDecimal getStorageTotalGrossWeight() {
      return this.storageTotalGrossWeight;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setProducedTotalNetWeight(final BigDecimal producedTotalNetWeight) {
      this.producedTotalNetWeight = producedTotalNetWeight;
   }

   public void setProducedTotalGrossWeight(final BigDecimal producedTotalGrossWeight) {
      this.producedTotalGrossWeight = producedTotalGrossWeight;
   }

   public void setUnProducedQuantity(final Integer unProducedQuantity) {
      this.unProducedQuantity = unProducedQuantity;
   }

   public void setUnProducedTotalNetWeight(final BigDecimal unProducedTotalNetWeight) {
      this.unProducedTotalNetWeight = unProducedTotalNetWeight;
   }

   public void setUnProducedTotalGrossWeight(final BigDecimal unProducedTotalGrossWeight) {
      this.unProducedTotalGrossWeight = unProducedTotalGrossWeight;
   }

   public void setStorageQuantity(final Integer storageQuantity) {
      this.storageQuantity = storageQuantity;
   }

   public void setStorageTotalNetWeight(final BigDecimal storageTotalNetWeight) {
      this.storageTotalNetWeight = storageTotalNetWeight;
   }

   public void setStorageTotalGrossWeight(final BigDecimal storageTotalGrossWeight) {
      this.storageTotalGrossWeight = storageTotalGrossWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimArtifactProductionVO)) {
         return false;
      }

      BimArtifactProductionVO other = (BimArtifactProductionVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$producedQuantity = this.getProducedQuantity();
               Object other$producedQuantity = other.getProducedQuantity();
               if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                  Object this$unProducedQuantity = this.getUnProducedQuantity();
                  Object other$unProducedQuantity = other.getUnProducedQuantity();
                  if (this$unProducedQuantity == null ? other$unProducedQuantity == null : this$unProducedQuantity.equals(other$unProducedQuantity)) {
                     Object this$storageQuantity = this.getStorageQuantity();
                     Object other$storageQuantity = other.getStorageQuantity();
                     if (this$storageQuantity == null ? other$storageQuantity == null : this$storageQuantity.equals(other$storageQuantity)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$monomerName = this.getMonomerName();
                           Object other$monomerName = other.getMonomerName();
                           if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                              Object this$totalNetWeight = this.getTotalNetWeight();
                              Object other$totalNetWeight = other.getTotalNetWeight();
                              if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                 Object this$totalGrossWeight = this.getTotalGrossWeight();
                                 Object other$totalGrossWeight = other.getTotalGrossWeight();
                                 if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                    Object this$producedTotalNetWeight = this.getProducedTotalNetWeight();
                                    Object other$producedTotalNetWeight = other.getProducedTotalNetWeight();
                                    if (this$producedTotalNetWeight == null
                                       ? other$producedTotalNetWeight == null
                                       : this$producedTotalNetWeight.equals(other$producedTotalNetWeight)) {
                                       Object this$producedTotalGrossWeight = this.getProducedTotalGrossWeight();
                                       Object other$producedTotalGrossWeight = other.getProducedTotalGrossWeight();
                                       if (this$producedTotalGrossWeight == null
                                          ? other$producedTotalGrossWeight == null
                                          : this$producedTotalGrossWeight.equals(other$producedTotalGrossWeight)) {
                                          Object this$unProducedTotalNetWeight = this.getUnProducedTotalNetWeight();
                                          Object other$unProducedTotalNetWeight = other.getUnProducedTotalNetWeight();
                                          if (this$unProducedTotalNetWeight == null
                                             ? other$unProducedTotalNetWeight == null
                                             : this$unProducedTotalNetWeight.equals(other$unProducedTotalNetWeight)) {
                                             Object this$unProducedTotalGrossWeight = this.getUnProducedTotalGrossWeight();
                                             Object other$unProducedTotalGrossWeight = other.getUnProducedTotalGrossWeight();
                                             if (this$unProducedTotalGrossWeight == null
                                                ? other$unProducedTotalGrossWeight == null
                                                : this$unProducedTotalGrossWeight.equals(other$unProducedTotalGrossWeight)) {
                                                Object this$storageTotalNetWeight = this.getStorageTotalNetWeight();
                                                Object other$storageTotalNetWeight = other.getStorageTotalNetWeight();
                                                if (this$storageTotalNetWeight == null
                                                   ? other$storageTotalNetWeight == null
                                                   : this$storageTotalNetWeight.equals(other$storageTotalNetWeight)) {
                                                   Object this$storageTotalGrossWeight = this.getStorageTotalGrossWeight();
                                                   Object other$storageTotalGrossWeight = other.getStorageTotalGrossWeight();
                                                   return this$storageTotalGrossWeight == null
                                                      ? other$storageTotalGrossWeight == null
                                                      : this$storageTotalGrossWeight.equals(other$storageTotalGrossWeight);
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
      return other instanceof BimArtifactProductionVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $unProducedQuantity = this.getUnProducedQuantity();
      result = result * 59 + ($unProducedQuantity == null ? 43 : $unProducedQuantity.hashCode());
      Object $storageQuantity = this.getStorageQuantity();
      result = result * 59 + ($storageQuantity == null ? 43 : $storageQuantity.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $producedTotalNetWeight = this.getProducedTotalNetWeight();
      result = result * 59 + ($producedTotalNetWeight == null ? 43 : $producedTotalNetWeight.hashCode());
      Object $producedTotalGrossWeight = this.getProducedTotalGrossWeight();
      result = result * 59 + ($producedTotalGrossWeight == null ? 43 : $producedTotalGrossWeight.hashCode());
      Object $unProducedTotalNetWeight = this.getUnProducedTotalNetWeight();
      result = result * 59 + ($unProducedTotalNetWeight == null ? 43 : $unProducedTotalNetWeight.hashCode());
      Object $unProducedTotalGrossWeight = this.getUnProducedTotalGrossWeight();
      result = result * 59 + ($unProducedTotalGrossWeight == null ? 43 : $unProducedTotalGrossWeight.hashCode());
      Object $storageTotalNetWeight = this.getStorageTotalNetWeight();
      result = result * 59 + ($storageTotalNetWeight == null ? 43 : $storageTotalNetWeight.hashCode());
      Object $storageTotalGrossWeight = this.getStorageTotalGrossWeight();
      return result * 59 + ($storageTotalGrossWeight == null ? 43 : $storageTotalGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "BimArtifactProductionVO(areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", producedTotalNetWeight="
         + this.getProducedTotalNetWeight()
         + ", producedTotalGrossWeight="
         + this.getProducedTotalGrossWeight()
         + ", unProducedQuantity="
         + this.getUnProducedQuantity()
         + ", unProducedTotalNetWeight="
         + this.getUnProducedTotalNetWeight()
         + ", unProducedTotalGrossWeight="
         + this.getUnProducedTotalGrossWeight()
         + ", storageQuantity="
         + this.getStorageQuantity()
         + ", storageTotalNetWeight="
         + this.getStorageTotalNetWeight()
         + ", storageTotalGrossWeight="
         + this.getStorageTotalGrossWeight()
         + ")";
   }

   public static class BimArtifactProductionVOBuilder {
      private Long areaId;
      private String areaName;
      private Long monomerId;
      private String monomerName;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer producedQuantity;
      private BigDecimal producedTotalNetWeight;
      private BigDecimal producedTotalGrossWeight;
      private Integer unProducedQuantity;
      private BigDecimal unProducedTotalNetWeight;
      private BigDecimal unProducedTotalGrossWeight;
      private Integer storageQuantity;
      private BigDecimal storageTotalNetWeight;
      private BigDecimal storageTotalGrossWeight;

      BimArtifactProductionVOBuilder() {
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder producedTotalNetWeight(final BigDecimal producedTotalNetWeight) {
         this.producedTotalNetWeight = producedTotalNetWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder producedTotalGrossWeight(final BigDecimal producedTotalGrossWeight) {
         this.producedTotalGrossWeight = producedTotalGrossWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder unProducedQuantity(final Integer unProducedQuantity) {
         this.unProducedQuantity = unProducedQuantity;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder unProducedTotalNetWeight(final BigDecimal unProducedTotalNetWeight) {
         this.unProducedTotalNetWeight = unProducedTotalNetWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder unProducedTotalGrossWeight(final BigDecimal unProducedTotalGrossWeight) {
         this.unProducedTotalGrossWeight = unProducedTotalGrossWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder storageQuantity(final Integer storageQuantity) {
         this.storageQuantity = storageQuantity;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder storageTotalNetWeight(final BigDecimal storageTotalNetWeight) {
         this.storageTotalNetWeight = storageTotalNetWeight;
         return this;
      }

      public BimArtifactProductionVO.BimArtifactProductionVOBuilder storageTotalGrossWeight(final BigDecimal storageTotalGrossWeight) {
         this.storageTotalGrossWeight = storageTotalGrossWeight;
         return this;
      }

      public BimArtifactProductionVO build() {
         return new BimArtifactProductionVO(
            this.areaId,
            this.areaName,
            this.monomerId,
            this.monomerName,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.producedQuantity,
            this.producedTotalNetWeight,
            this.producedTotalGrossWeight,
            this.unProducedQuantity,
            this.unProducedTotalNetWeight,
            this.unProducedTotalGrossWeight,
            this.storageQuantity,
            this.storageTotalNetWeight,
            this.storageTotalGrossWeight
         );
      }

      @Override
      public String toString() {
         return "BimArtifactProductionVO.BimArtifactProductionVOBuilder(areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", producedQuantity="
            + this.producedQuantity
            + ", producedTotalNetWeight="
            + this.producedTotalNetWeight
            + ", producedTotalGrossWeight="
            + this.producedTotalGrossWeight
            + ", unProducedQuantity="
            + this.unProducedQuantity
            + ", unProducedTotalNetWeight="
            + this.unProducedTotalNetWeight
            + ", unProducedTotalGrossWeight="
            + this.unProducedTotalGrossWeight
            + ", storageQuantity="
            + this.storageQuantity
            + ", storageTotalNetWeight="
            + this.storageTotalNetWeight
            + ", storageTotalGrossWeight="
            + this.storageTotalGrossWeight
            + ")";
      }
   }
}
