package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.math.BigDecimal;

public class BasicInbound {
   private Integer amountFillWay;
   private Integer saveInboundState;
   private Integer passedInboundState;
   private Integer length;
   private Integer width;
   private Integer thickness;
   private Integer mete;
   private Integer spec;
   private Integer quantity;
   private Integer steelDiffType;
   private BigDecimal steelDiff;
   private Integer trainsDiffType;
   private BigDecimal trainsDiff;
   private Boolean overDiffSubmittable;
   private BigDecimal procureMeteDiff;
   private Boolean procureMeteDiffState;
   private Boolean boolHaveDetail;
   private Integer freightShowScene;
   private Integer money;
   private Integer weight;
   private Integer LoadingFee;
   private Integer invoiceTax;
   private Integer logisticsUnit;
   private BigDecimal applyAndProcureMeteDiff;
   private Boolean applyAndProcureMeteDiffState;
   private BigDecimal applyAndProcureDetailMeteRatio;
   private Integer steelWeightCalculationType;
   private Integer settlementInventoryAmount;

   public static BasicInbound.BasicInboundBuilder builder() {
      return new BasicInbound.BasicInboundBuilder();
   }

   public Integer getAmountFillWay() {
      return this.amountFillWay;
   }

   public Integer getSaveInboundState() {
      return this.saveInboundState;
   }

   public Integer getPassedInboundState() {
      return this.passedInboundState;
   }

   public Integer getLength() {
      return this.length;
   }

   public Integer getWidth() {
      return this.width;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public Integer getMete() {
      return this.mete;
   }

   public Integer getSpec() {
      return this.spec;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSteelDiffType() {
      return this.steelDiffType;
   }

   public BigDecimal getSteelDiff() {
      return this.steelDiff;
   }

   public Integer getTrainsDiffType() {
      return this.trainsDiffType;
   }

   public BigDecimal getTrainsDiff() {
      return this.trainsDiff;
   }

   public Boolean getOverDiffSubmittable() {
      return this.overDiffSubmittable;
   }

   public BigDecimal getProcureMeteDiff() {
      return this.procureMeteDiff;
   }

   public Boolean getProcureMeteDiffState() {
      return this.procureMeteDiffState;
   }

   public Boolean getBoolHaveDetail() {
      return this.boolHaveDetail;
   }

   public Integer getFreightShowScene() {
      return this.freightShowScene;
   }

   public Integer getMoney() {
      return this.money;
   }

   public Integer getWeight() {
      return this.weight;
   }

   public Integer getLoadingFee() {
      return this.LoadingFee;
   }

   public Integer getInvoiceTax() {
      return this.invoiceTax;
   }

   public Integer getLogisticsUnit() {
      return this.logisticsUnit;
   }

   public BigDecimal getApplyAndProcureMeteDiff() {
      return this.applyAndProcureMeteDiff;
   }

   public Boolean getApplyAndProcureMeteDiffState() {
      return this.applyAndProcureMeteDiffState;
   }

   public BigDecimal getApplyAndProcureDetailMeteRatio() {
      return this.applyAndProcureDetailMeteRatio;
   }

   public Integer getSteelWeightCalculationType() {
      return this.steelWeightCalculationType;
   }

   public Integer getSettlementInventoryAmount() {
      return this.settlementInventoryAmount;
   }

   public void setAmountFillWay(final Integer amountFillWay) {
      this.amountFillWay = amountFillWay;
   }

   public void setSaveInboundState(final Integer saveInboundState) {
      this.saveInboundState = saveInboundState;
   }

   public void setPassedInboundState(final Integer passedInboundState) {
      this.passedInboundState = passedInboundState;
   }

   public void setLength(final Integer length) {
      this.length = length;
   }

   public void setWidth(final Integer width) {
      this.width = width;
   }

   public void setThickness(final Integer thickness) {
      this.thickness = thickness;
   }

   public void setMete(final Integer mete) {
      this.mete = mete;
   }

   public void setSpec(final Integer spec) {
      this.spec = spec;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setSteelDiffType(final Integer steelDiffType) {
      this.steelDiffType = steelDiffType;
   }

   public void setSteelDiff(final BigDecimal steelDiff) {
      this.steelDiff = steelDiff;
   }

   public void setTrainsDiffType(final Integer trainsDiffType) {
      this.trainsDiffType = trainsDiffType;
   }

   public void setTrainsDiff(final BigDecimal trainsDiff) {
      this.trainsDiff = trainsDiff;
   }

   public void setOverDiffSubmittable(final Boolean overDiffSubmittable) {
      this.overDiffSubmittable = overDiffSubmittable;
   }

   public void setProcureMeteDiff(final BigDecimal procureMeteDiff) {
      this.procureMeteDiff = procureMeteDiff;
   }

   public void setProcureMeteDiffState(final Boolean procureMeteDiffState) {
      this.procureMeteDiffState = procureMeteDiffState;
   }

   public void setBoolHaveDetail(final Boolean boolHaveDetail) {
      this.boolHaveDetail = boolHaveDetail;
   }

   public void setFreightShowScene(final Integer freightShowScene) {
      this.freightShowScene = freightShowScene;
   }

   public void setMoney(final Integer money) {
      this.money = money;
   }

   public void setWeight(final Integer weight) {
      this.weight = weight;
   }

   public void setLoadingFee(final Integer LoadingFee) {
      this.LoadingFee = LoadingFee;
   }

   public void setInvoiceTax(final Integer invoiceTax) {
      this.invoiceTax = invoiceTax;
   }

   public void setLogisticsUnit(final Integer logisticsUnit) {
      this.logisticsUnit = logisticsUnit;
   }

   public void setApplyAndProcureMeteDiff(final BigDecimal applyAndProcureMeteDiff) {
      this.applyAndProcureMeteDiff = applyAndProcureMeteDiff;
   }

   public void setApplyAndProcureMeteDiffState(final Boolean applyAndProcureMeteDiffState) {
      this.applyAndProcureMeteDiffState = applyAndProcureMeteDiffState;
   }

   public void setApplyAndProcureDetailMeteRatio(final BigDecimal applyAndProcureDetailMeteRatio) {
      this.applyAndProcureDetailMeteRatio = applyAndProcureDetailMeteRatio;
   }

   public void setSteelWeightCalculationType(final Integer steelWeightCalculationType) {
      this.steelWeightCalculationType = steelWeightCalculationType;
   }

   public void setSettlementInventoryAmount(final Integer settlementInventoryAmount) {
      this.settlementInventoryAmount = settlementInventoryAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicInbound)) {
         return false;
      }

      BasicInbound other = (BasicInbound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$amountFillWay = this.getAmountFillWay();
      Object other$amountFillWay = other.getAmountFillWay();
      if (this$amountFillWay == null ? other$amountFillWay == null : this$amountFillWay.equals(other$amountFillWay)) {
         Object this$saveInboundState = this.getSaveInboundState();
         Object other$saveInboundState = other.getSaveInboundState();
         if (this$saveInboundState == null ? other$saveInboundState == null : this$saveInboundState.equals(other$saveInboundState)) {
            Object this$passedInboundState = this.getPassedInboundState();
            Object other$passedInboundState = other.getPassedInboundState();
            if (this$passedInboundState == null ? other$passedInboundState == null : this$passedInboundState.equals(other$passedInboundState)) {
               Object this$length = this.getLength();
               Object other$length = other.getLength();
               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                  Object this$width = this.getWidth();
                  Object other$width = other.getWidth();
                  if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                           Object this$spec = this.getSpec();
                           Object other$spec = other.getSpec();
                           if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$steelDiffType = this.getSteelDiffType();
                                 Object other$steelDiffType = other.getSteelDiffType();
                                 if (this$steelDiffType == null ? other$steelDiffType == null : this$steelDiffType.equals(other$steelDiffType)) {
                                    Object this$trainsDiffType = this.getTrainsDiffType();
                                    Object other$trainsDiffType = other.getTrainsDiffType();
                                    if (this$trainsDiffType == null ? other$trainsDiffType == null : this$trainsDiffType.equals(other$trainsDiffType)) {
                                       Object this$overDiffSubmittable = this.getOverDiffSubmittable();
                                       Object other$overDiffSubmittable = other.getOverDiffSubmittable();
                                       if (this$overDiffSubmittable == null
                                          ? other$overDiffSubmittable == null
                                          : this$overDiffSubmittable.equals(other$overDiffSubmittable)) {
                                          Object this$procureMeteDiffState = this.getProcureMeteDiffState();
                                          Object other$procureMeteDiffState = other.getProcureMeteDiffState();
                                          if (this$procureMeteDiffState == null
                                             ? other$procureMeteDiffState == null
                                             : this$procureMeteDiffState.equals(other$procureMeteDiffState)) {
                                             Object this$boolHaveDetail = this.getBoolHaveDetail();
                                             Object other$boolHaveDetail = other.getBoolHaveDetail();
                                             if (this$boolHaveDetail == null ? other$boolHaveDetail == null : this$boolHaveDetail.equals(other$boolHaveDetail)) {
                                                Object this$freightShowScene = this.getFreightShowScene();
                                                Object other$freightShowScene = other.getFreightShowScene();
                                                if (this$freightShowScene == null
                                                   ? other$freightShowScene == null
                                                   : this$freightShowScene.equals(other$freightShowScene)) {
                                                   Object this$money = this.getMoney();
                                                   Object other$money = other.getMoney();
                                                   if (this$money == null ? other$money == null : this$money.equals(other$money)) {
                                                      Object this$weight = this.getWeight();
                                                      Object other$weight = other.getWeight();
                                                      if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                         Object this$LoadingFee = this.getLoadingFee();
                                                         Object other$LoadingFee = other.getLoadingFee();
                                                         if (this$LoadingFee == null ? other$LoadingFee == null : this$LoadingFee.equals(other$LoadingFee)) {
                                                            Object this$invoiceTax = this.getInvoiceTax();
                                                            Object other$invoiceTax = other.getInvoiceTax();
                                                            if (this$invoiceTax == null ? other$invoiceTax == null : this$invoiceTax.equals(other$invoiceTax)) {
                                                               Object this$logisticsUnit = this.getLogisticsUnit();
                                                               Object other$logisticsUnit = other.getLogisticsUnit();
                                                               if (this$logisticsUnit == null
                                                                  ? other$logisticsUnit == null
                                                                  : this$logisticsUnit.equals(other$logisticsUnit)) {
                                                                  Object this$applyAndProcureMeteDiffState = this.getApplyAndProcureMeteDiffState();
                                                                  Object other$applyAndProcureMeteDiffState = other.getApplyAndProcureMeteDiffState();
                                                                  if (this$applyAndProcureMeteDiffState == null
                                                                     ? other$applyAndProcureMeteDiffState == null
                                                                     : this$applyAndProcureMeteDiffState.equals(other$applyAndProcureMeteDiffState)) {
                                                                     Object this$steelWeightCalculationType = this.getSteelWeightCalculationType();
                                                                     Object other$steelWeightCalculationType = other.getSteelWeightCalculationType();
                                                                     if (this$steelWeightCalculationType == null
                                                                        ? other$steelWeightCalculationType == null
                                                                        : this$steelWeightCalculationType.equals(other$steelWeightCalculationType)) {
                                                                        Object this$settlementInventoryAmount = this.getSettlementInventoryAmount();
                                                                        Object other$settlementInventoryAmount = other.getSettlementInventoryAmount();
                                                                        if (this$settlementInventoryAmount == null
                                                                           ? other$settlementInventoryAmount == null
                                                                           : this$settlementInventoryAmount.equals(other$settlementInventoryAmount)) {
                                                                           Object this$steelDiff = this.getSteelDiff();
                                                                           Object other$steelDiff = other.getSteelDiff();
                                                                           if (this$steelDiff == null
                                                                              ? other$steelDiff == null
                                                                              : this$steelDiff.equals(other$steelDiff)) {
                                                                              Object this$trainsDiff = this.getTrainsDiff();
                                                                              Object other$trainsDiff = other.getTrainsDiff();
                                                                              if (this$trainsDiff == null
                                                                                 ? other$trainsDiff == null
                                                                                 : this$trainsDiff.equals(other$trainsDiff)) {
                                                                                 Object this$procureMeteDiff = this.getProcureMeteDiff();
                                                                                 Object other$procureMeteDiff = other.getProcureMeteDiff();
                                                                                 if (this$procureMeteDiff == null
                                                                                    ? other$procureMeteDiff == null
                                                                                    : this$procureMeteDiff.equals(other$procureMeteDiff)) {
                                                                                    Object this$applyAndProcureMeteDiff = this.getApplyAndProcureMeteDiff();
                                                                                    Object other$applyAndProcureMeteDiff = other.getApplyAndProcureMeteDiff();
                                                                                    if (this$applyAndProcureMeteDiff == null
                                                                                       ? other$applyAndProcureMeteDiff == null
                                                                                       : this$applyAndProcureMeteDiff.equals(other$applyAndProcureMeteDiff)) {
                                                                                       Object this$applyAndProcureDetailMeteRatio = this.getApplyAndProcureDetailMeteRatio();
                                                                                       Object other$applyAndProcureDetailMeteRatio = other.getApplyAndProcureDetailMeteRatio();
                                                                                       return this$applyAndProcureDetailMeteRatio == null
                                                                                          ? other$applyAndProcureDetailMeteRatio == null
                                                                                          : this$applyAndProcureDetailMeteRatio.equals(
                                                                                             other$applyAndProcureDetailMeteRatio
                                                                                          );
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
      return other instanceof BasicInbound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amountFillWay = this.getAmountFillWay();
      result = result * 59 + ($amountFillWay == null ? 43 : $amountFillWay.hashCode());
      Object $saveInboundState = this.getSaveInboundState();
      result = result * 59 + ($saveInboundState == null ? 43 : $saveInboundState.hashCode());
      Object $passedInboundState = this.getPassedInboundState();
      result = result * 59 + ($passedInboundState == null ? 43 : $passedInboundState.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $steelDiffType = this.getSteelDiffType();
      result = result * 59 + ($steelDiffType == null ? 43 : $steelDiffType.hashCode());
      Object $trainsDiffType = this.getTrainsDiffType();
      result = result * 59 + ($trainsDiffType == null ? 43 : $trainsDiffType.hashCode());
      Object $overDiffSubmittable = this.getOverDiffSubmittable();
      result = result * 59 + ($overDiffSubmittable == null ? 43 : $overDiffSubmittable.hashCode());
      Object $procureMeteDiffState = this.getProcureMeteDiffState();
      result = result * 59 + ($procureMeteDiffState == null ? 43 : $procureMeteDiffState.hashCode());
      Object $boolHaveDetail = this.getBoolHaveDetail();
      result = result * 59 + ($boolHaveDetail == null ? 43 : $boolHaveDetail.hashCode());
      Object $freightShowScene = this.getFreightShowScene();
      result = result * 59 + ($freightShowScene == null ? 43 : $freightShowScene.hashCode());
      Object $money = this.getMoney();
      result = result * 59 + ($money == null ? 43 : $money.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $LoadingFee = this.getLoadingFee();
      result = result * 59 + ($LoadingFee == null ? 43 : $LoadingFee.hashCode());
      Object $invoiceTax = this.getInvoiceTax();
      result = result * 59 + ($invoiceTax == null ? 43 : $invoiceTax.hashCode());
      Object $logisticsUnit = this.getLogisticsUnit();
      result = result * 59 + ($logisticsUnit == null ? 43 : $logisticsUnit.hashCode());
      Object $applyAndProcureMeteDiffState = this.getApplyAndProcureMeteDiffState();
      result = result * 59 + ($applyAndProcureMeteDiffState == null ? 43 : $applyAndProcureMeteDiffState.hashCode());
      Object $steelWeightCalculationType = this.getSteelWeightCalculationType();
      result = result * 59 + ($steelWeightCalculationType == null ? 43 : $steelWeightCalculationType.hashCode());
      Object $settlementInventoryAmount = this.getSettlementInventoryAmount();
      result = result * 59 + ($settlementInventoryAmount == null ? 43 : $settlementInventoryAmount.hashCode());
      Object $steelDiff = this.getSteelDiff();
      result = result * 59 + ($steelDiff == null ? 43 : $steelDiff.hashCode());
      Object $trainsDiff = this.getTrainsDiff();
      result = result * 59 + ($trainsDiff == null ? 43 : $trainsDiff.hashCode());
      Object $procureMeteDiff = this.getProcureMeteDiff();
      result = result * 59 + ($procureMeteDiff == null ? 43 : $procureMeteDiff.hashCode());
      Object $applyAndProcureMeteDiff = this.getApplyAndProcureMeteDiff();
      result = result * 59 + ($applyAndProcureMeteDiff == null ? 43 : $applyAndProcureMeteDiff.hashCode());
      Object $applyAndProcureDetailMeteRatio = this.getApplyAndProcureDetailMeteRatio();
      return result * 59 + ($applyAndProcureDetailMeteRatio == null ? 43 : $applyAndProcureDetailMeteRatio.hashCode());
   }

   @Override
   public String toString() {
      return "BasicInbound(amountFillWay="
         + this.getAmountFillWay()
         + ", saveInboundState="
         + this.getSaveInboundState()
         + ", passedInboundState="
         + this.getPassedInboundState()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", mete="
         + this.getMete()
         + ", spec="
         + this.getSpec()
         + ", quantity="
         + this.getQuantity()
         + ", steelDiffType="
         + this.getSteelDiffType()
         + ", steelDiff="
         + this.getSteelDiff()
         + ", trainsDiffType="
         + this.getTrainsDiffType()
         + ", trainsDiff="
         + this.getTrainsDiff()
         + ", overDiffSubmittable="
         + this.getOverDiffSubmittable()
         + ", procureMeteDiff="
         + this.getProcureMeteDiff()
         + ", procureMeteDiffState="
         + this.getProcureMeteDiffState()
         + ", boolHaveDetail="
         + this.getBoolHaveDetail()
         + ", freightShowScene="
         + this.getFreightShowScene()
         + ", money="
         + this.getMoney()
         + ", weight="
         + this.getWeight()
         + ", LoadingFee="
         + this.getLoadingFee()
         + ", invoiceTax="
         + this.getInvoiceTax()
         + ", logisticsUnit="
         + this.getLogisticsUnit()
         + ", applyAndProcureMeteDiff="
         + this.getApplyAndProcureMeteDiff()
         + ", applyAndProcureMeteDiffState="
         + this.getApplyAndProcureMeteDiffState()
         + ", applyAndProcureDetailMeteRatio="
         + this.getApplyAndProcureDetailMeteRatio()
         + ", steelWeightCalculationType="
         + this.getSteelWeightCalculationType()
         + ", settlementInventoryAmount="
         + this.getSettlementInventoryAmount()
         + ")";
   }

   public BasicInbound(
      final Integer amountFillWay,
      final Integer saveInboundState,
      final Integer passedInboundState,
      final Integer length,
      final Integer width,
      final Integer thickness,
      final Integer mete,
      final Integer spec,
      final Integer quantity,
      final Integer steelDiffType,
      final BigDecimal steelDiff,
      final Integer trainsDiffType,
      final BigDecimal trainsDiff,
      final Boolean overDiffSubmittable,
      final BigDecimal procureMeteDiff,
      final Boolean procureMeteDiffState,
      final Boolean boolHaveDetail,
      final Integer freightShowScene,
      final Integer money,
      final Integer weight,
      final Integer LoadingFee,
      final Integer invoiceTax,
      final Integer logisticsUnit,
      final BigDecimal applyAndProcureMeteDiff,
      final Boolean applyAndProcureMeteDiffState,
      final BigDecimal applyAndProcureDetailMeteRatio,
      final Integer steelWeightCalculationType,
      final Integer settlementInventoryAmount
   ) {
      this.amountFillWay = amountFillWay;
      this.saveInboundState = saveInboundState;
      this.passedInboundState = passedInboundState;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.mete = mete;
      this.spec = spec;
      this.quantity = quantity;
      this.steelDiffType = steelDiffType;
      this.steelDiff = steelDiff;
      this.trainsDiffType = trainsDiffType;
      this.trainsDiff = trainsDiff;
      this.overDiffSubmittable = overDiffSubmittable;
      this.procureMeteDiff = procureMeteDiff;
      this.procureMeteDiffState = procureMeteDiffState;
      this.boolHaveDetail = boolHaveDetail;
      this.freightShowScene = freightShowScene;
      this.money = money;
      this.weight = weight;
      this.LoadingFee = LoadingFee;
      this.invoiceTax = invoiceTax;
      this.logisticsUnit = logisticsUnit;
      this.applyAndProcureMeteDiff = applyAndProcureMeteDiff;
      this.applyAndProcureMeteDiffState = applyAndProcureMeteDiffState;
      this.applyAndProcureDetailMeteRatio = applyAndProcureDetailMeteRatio;
      this.steelWeightCalculationType = steelWeightCalculationType;
      this.settlementInventoryAmount = settlementInventoryAmount;
   }

   public BasicInbound() {
   }

   public static class BasicInboundBuilder {
      private Integer amountFillWay;
      private Integer saveInboundState;
      private Integer passedInboundState;
      private Integer length;
      private Integer width;
      private Integer thickness;
      private Integer mete;
      private Integer spec;
      private Integer quantity;
      private Integer steelDiffType;
      private BigDecimal steelDiff;
      private Integer trainsDiffType;
      private BigDecimal trainsDiff;
      private Boolean overDiffSubmittable;
      private BigDecimal procureMeteDiff;
      private Boolean procureMeteDiffState;
      private Boolean boolHaveDetail;
      private Integer freightShowScene;
      private Integer money;
      private Integer weight;
      private Integer LoadingFee;
      private Integer invoiceTax;
      private Integer logisticsUnit;
      private BigDecimal applyAndProcureMeteDiff;
      private Boolean applyAndProcureMeteDiffState;
      private BigDecimal applyAndProcureDetailMeteRatio;
      private Integer steelWeightCalculationType;
      private Integer settlementInventoryAmount;

      BasicInboundBuilder() {
      }

      public BasicInbound.BasicInboundBuilder amountFillWay(final Integer amountFillWay) {
         this.amountFillWay = amountFillWay;
         return this;
      }

      public BasicInbound.BasicInboundBuilder saveInboundState(final Integer saveInboundState) {
         this.saveInboundState = saveInboundState;
         return this;
      }

      public BasicInbound.BasicInboundBuilder passedInboundState(final Integer passedInboundState) {
         this.passedInboundState = passedInboundState;
         return this;
      }

      public BasicInbound.BasicInboundBuilder length(final Integer length) {
         this.length = length;
         return this;
      }

      public BasicInbound.BasicInboundBuilder width(final Integer width) {
         this.width = width;
         return this;
      }

      public BasicInbound.BasicInboundBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      public BasicInbound.BasicInboundBuilder mete(final Integer mete) {
         this.mete = mete;
         return this;
      }

      public BasicInbound.BasicInboundBuilder spec(final Integer spec) {
         this.spec = spec;
         return this;
      }

      public BasicInbound.BasicInboundBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BasicInbound.BasicInboundBuilder steelDiffType(final Integer steelDiffType) {
         this.steelDiffType = steelDiffType;
         return this;
      }

      public BasicInbound.BasicInboundBuilder steelDiff(final BigDecimal steelDiff) {
         this.steelDiff = steelDiff;
         return this;
      }

      public BasicInbound.BasicInboundBuilder trainsDiffType(final Integer trainsDiffType) {
         this.trainsDiffType = trainsDiffType;
         return this;
      }

      public BasicInbound.BasicInboundBuilder trainsDiff(final BigDecimal trainsDiff) {
         this.trainsDiff = trainsDiff;
         return this;
      }

      public BasicInbound.BasicInboundBuilder overDiffSubmittable(final Boolean overDiffSubmittable) {
         this.overDiffSubmittable = overDiffSubmittable;
         return this;
      }

      public BasicInbound.BasicInboundBuilder procureMeteDiff(final BigDecimal procureMeteDiff) {
         this.procureMeteDiff = procureMeteDiff;
         return this;
      }

      public BasicInbound.BasicInboundBuilder procureMeteDiffState(final Boolean procureMeteDiffState) {
         this.procureMeteDiffState = procureMeteDiffState;
         return this;
      }

      public BasicInbound.BasicInboundBuilder boolHaveDetail(final Boolean boolHaveDetail) {
         this.boolHaveDetail = boolHaveDetail;
         return this;
      }

      public BasicInbound.BasicInboundBuilder freightShowScene(final Integer freightShowScene) {
         this.freightShowScene = freightShowScene;
         return this;
      }

      public BasicInbound.BasicInboundBuilder money(final Integer money) {
         this.money = money;
         return this;
      }

      public BasicInbound.BasicInboundBuilder weight(final Integer weight) {
         this.weight = weight;
         return this;
      }

      public BasicInbound.BasicInboundBuilder LoadingFee(final Integer LoadingFee) {
         this.LoadingFee = LoadingFee;
         return this;
      }

      public BasicInbound.BasicInboundBuilder invoiceTax(final Integer invoiceTax) {
         this.invoiceTax = invoiceTax;
         return this;
      }

      public BasicInbound.BasicInboundBuilder logisticsUnit(final Integer logisticsUnit) {
         this.logisticsUnit = logisticsUnit;
         return this;
      }

      public BasicInbound.BasicInboundBuilder applyAndProcureMeteDiff(final BigDecimal applyAndProcureMeteDiff) {
         this.applyAndProcureMeteDiff = applyAndProcureMeteDiff;
         return this;
      }

      public BasicInbound.BasicInboundBuilder applyAndProcureMeteDiffState(final Boolean applyAndProcureMeteDiffState) {
         this.applyAndProcureMeteDiffState = applyAndProcureMeteDiffState;
         return this;
      }

      public BasicInbound.BasicInboundBuilder applyAndProcureDetailMeteRatio(final BigDecimal applyAndProcureDetailMeteRatio) {
         this.applyAndProcureDetailMeteRatio = applyAndProcureDetailMeteRatio;
         return this;
      }

      public BasicInbound.BasicInboundBuilder steelWeightCalculationType(final Integer steelWeightCalculationType) {
         this.steelWeightCalculationType = steelWeightCalculationType;
         return this;
      }

      public BasicInbound.BasicInboundBuilder settlementInventoryAmount(final Integer settlementInventoryAmount) {
         this.settlementInventoryAmount = settlementInventoryAmount;
         return this;
      }

      public BasicInbound build() {
         return new BasicInbound(
            this.amountFillWay,
            this.saveInboundState,
            this.passedInboundState,
            this.length,
            this.width,
            this.thickness,
            this.mete,
            this.spec,
            this.quantity,
            this.steelDiffType,
            this.steelDiff,
            this.trainsDiffType,
            this.trainsDiff,
            this.overDiffSubmittable,
            this.procureMeteDiff,
            this.procureMeteDiffState,
            this.boolHaveDetail,
            this.freightShowScene,
            this.money,
            this.weight,
            this.LoadingFee,
            this.invoiceTax,
            this.logisticsUnit,
            this.applyAndProcureMeteDiff,
            this.applyAndProcureMeteDiffState,
            this.applyAndProcureDetailMeteRatio,
            this.steelWeightCalculationType,
            this.settlementInventoryAmount
         );
      }

      @Override
      public String toString() {
         return "BasicInbound.BasicInboundBuilder(amountFillWay="
            + this.amountFillWay
            + ", saveInboundState="
            + this.saveInboundState
            + ", passedInboundState="
            + this.passedInboundState
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", mete="
            + this.mete
            + ", spec="
            + this.spec
            + ", quantity="
            + this.quantity
            + ", steelDiffType="
            + this.steelDiffType
            + ", steelDiff="
            + this.steelDiff
            + ", trainsDiffType="
            + this.trainsDiffType
            + ", trainsDiff="
            + this.trainsDiff
            + ", overDiffSubmittable="
            + this.overDiffSubmittable
            + ", procureMeteDiff="
            + this.procureMeteDiff
            + ", procureMeteDiffState="
            + this.procureMeteDiffState
            + ", boolHaveDetail="
            + this.boolHaveDetail
            + ", freightShowScene="
            + this.freightShowScene
            + ", money="
            + this.money
            + ", weight="
            + this.weight
            + ", LoadingFee="
            + this.LoadingFee
            + ", invoiceTax="
            + this.invoiceTax
            + ", logisticsUnit="
            + this.logisticsUnit
            + ", applyAndProcureMeteDiff="
            + this.applyAndProcureMeteDiff
            + ", applyAndProcureMeteDiffState="
            + this.applyAndProcureMeteDiffState
            + ", applyAndProcureDetailMeteRatio="
            + this.applyAndProcureDetailMeteRatio
            + ", steelWeightCalculationType="
            + this.steelWeightCalculationType
            + ", settlementInventoryAmount="
            + this.settlementInventoryAmount
            + ")";
      }
   }
}
