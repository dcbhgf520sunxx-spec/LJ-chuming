package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import java.math.BigDecimal;

public class BatchSchedulingOutboundDetailDTOParam {
   private Long id;
   private String taskOrderNumber;
   private BigDecimal quantity;
   private String outboundUnit;
   private Integer outboundUnitType;
   private Long workshopId;
   private String remark;
   private Long taskOrderId;
   private Long returnableId;
   private BigDecimal inputMete;
   private BigDecimal sellUnitPrice;
   private BigDecimal sellAmount;
   private Integer weightMeasurementMode;
   private Long schedulingId;

   public static BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder builder() {
      return new BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getOutboundUnit() {
      return this.outboundUnit;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getReturnableId() {
      return this.returnableId;
   }

   public BigDecimal getInputMete() {
      return this.inputMete;
   }

   public BigDecimal getSellUnitPrice() {
      return this.sellUnitPrice;
   }

   public BigDecimal getSellAmount() {
      return this.sellAmount;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setOutboundUnit(final String outboundUnit) {
      this.outboundUnit = outboundUnit;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setReturnableId(final Long returnableId) {
      this.returnableId = returnableId;
   }

   public void setInputMete(final BigDecimal inputMete) {
      this.inputMete = inputMete;
   }

   public void setSellUnitPrice(final BigDecimal sellUnitPrice) {
      this.sellUnitPrice = sellUnitPrice;
   }

   public void setSellAmount(final BigDecimal sellAmount) {
      this.sellAmount = sellAmount;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchSchedulingOutboundDetailDTOParam)) {
         return false;
      }

      BatchSchedulingOutboundDetailDTOParam other = (BatchSchedulingOutboundDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundUnitType = this.getOutboundUnitType();
         Object other$outboundUnitType = other.getOutboundUnitType();
         if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$taskOrderId = this.getTaskOrderId();
               Object other$taskOrderId = other.getTaskOrderId();
               if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                  Object this$returnableId = this.getReturnableId();
                  Object other$returnableId = other.getReturnableId();
                  if (this$returnableId == null ? other$returnableId == null : this$returnableId.equals(other$returnableId)) {
                     Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                     Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                     if (this$weightMeasurementMode == null
                        ? other$weightMeasurementMode == null
                        : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                        Object this$schedulingId = this.getSchedulingId();
                        Object other$schedulingId = other.getSchedulingId();
                        if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                           Object this$taskOrderNumber = this.getTaskOrderNumber();
                           Object other$taskOrderNumber = other.getTaskOrderNumber();
                           if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$outboundUnit = this.getOutboundUnit();
                                 Object other$outboundUnit = other.getOutboundUnit();
                                 if (this$outboundUnit == null ? other$outboundUnit == null : this$outboundUnit.equals(other$outboundUnit)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$inputMete = this.getInputMete();
                                       Object other$inputMete = other.getInputMete();
                                       if (this$inputMete == null ? other$inputMete == null : this$inputMete.equals(other$inputMete)) {
                                          Object this$sellUnitPrice = this.getSellUnitPrice();
                                          Object other$sellUnitPrice = other.getSellUnitPrice();
                                          if (this$sellUnitPrice == null ? other$sellUnitPrice == null : this$sellUnitPrice.equals(other$sellUnitPrice)) {
                                             Object this$sellAmount = this.getSellAmount();
                                             Object other$sellAmount = other.getSellAmount();
                                             return this$sellAmount == null ? other$sellAmount == null : this$sellAmount.equals(other$sellAmount);
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
      return other instanceof BatchSchedulingOutboundDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $returnableId = this.getReturnableId();
      result = result * 59 + ($returnableId == null ? 43 : $returnableId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundUnit = this.getOutboundUnit();
      result = result * 59 + ($outboundUnit == null ? 43 : $outboundUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inputMete = this.getInputMete();
      result = result * 59 + ($inputMete == null ? 43 : $inputMete.hashCode());
      Object $sellUnitPrice = this.getSellUnitPrice();
      result = result * 59 + ($sellUnitPrice == null ? 43 : $sellUnitPrice.hashCode());
      Object $sellAmount = this.getSellAmount();
      return result * 59 + ($sellAmount == null ? 43 : $sellAmount.hashCode());
   }

   @Override
   public String toString() {
      return "BatchSchedulingOutboundDetailDTOParam(id="
         + this.getId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", quantity="
         + this.getQuantity()
         + ", outboundUnit="
         + this.getOutboundUnit()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", remark="
         + this.getRemark()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", returnableId="
         + this.getReturnableId()
         + ", inputMete="
         + this.getInputMete()
         + ", sellUnitPrice="
         + this.getSellUnitPrice()
         + ", sellAmount="
         + this.getSellAmount()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", schedulingId="
         + this.getSchedulingId()
         + ")";
   }

   public BatchSchedulingOutboundDetailDTOParam(
      final Long id,
      final String taskOrderNumber,
      final BigDecimal quantity,
      final String outboundUnit,
      final Integer outboundUnitType,
      final Long workshopId,
      final String remark,
      final Long taskOrderId,
      final Long returnableId,
      final BigDecimal inputMete,
      final BigDecimal sellUnitPrice,
      final BigDecimal sellAmount,
      final Integer weightMeasurementMode,
      final Long schedulingId
   ) {
      this.id = id;
      this.taskOrderNumber = taskOrderNumber;
      this.quantity = quantity;
      this.outboundUnit = outboundUnit;
      this.outboundUnitType = outboundUnitType;
      this.workshopId = workshopId;
      this.remark = remark;
      this.taskOrderId = taskOrderId;
      this.returnableId = returnableId;
      this.inputMete = inputMete;
      this.sellUnitPrice = sellUnitPrice;
      this.sellAmount = sellAmount;
      this.weightMeasurementMode = weightMeasurementMode;
      this.schedulingId = schedulingId;
   }

   public BatchSchedulingOutboundDetailDTOParam() {
   }

   public static class BatchSchedulingOutboundDetailDTOParamBuilder {
      private Long id;
      private String taskOrderNumber;
      private BigDecimal quantity;
      private String outboundUnit;
      private Integer outboundUnitType;
      private Long workshopId;
      private String remark;
      private Long taskOrderId;
      private Long returnableId;
      private BigDecimal inputMete;
      private BigDecimal sellUnitPrice;
      private BigDecimal sellAmount;
      private Integer weightMeasurementMode;
      private Long schedulingId;

      BatchSchedulingOutboundDetailDTOParamBuilder() {
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder outboundUnit(final String outboundUnit) {
         this.outboundUnit = outboundUnit;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder returnableId(final Long returnableId) {
         this.returnableId = returnableId;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder inputMete(final BigDecimal inputMete) {
         this.inputMete = inputMete;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder sellUnitPrice(final BigDecimal sellUnitPrice) {
         this.sellUnitPrice = sellUnitPrice;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder sellAmount(final BigDecimal sellAmount) {
         this.sellAmount = sellAmount;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      public BatchSchedulingOutboundDetailDTOParam build() {
         return new BatchSchedulingOutboundDetailDTOParam(
            this.id,
            this.taskOrderNumber,
            this.quantity,
            this.outboundUnit,
            this.outboundUnitType,
            this.workshopId,
            this.remark,
            this.taskOrderId,
            this.returnableId,
            this.inputMete,
            this.sellUnitPrice,
            this.sellAmount,
            this.weightMeasurementMode,
            this.schedulingId
         );
      }

      @Override
      public String toString() {
         return "BatchSchedulingOutboundDetailDTOParam.BatchSchedulingOutboundDetailDTOParamBuilder(id="
            + this.id
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", quantity="
            + this.quantity
            + ", outboundUnit="
            + this.outboundUnit
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", workshopId="
            + this.workshopId
            + ", remark="
            + this.remark
            + ", taskOrderId="
            + this.taskOrderId
            + ", returnableId="
            + this.returnableId
            + ", inputMete="
            + this.inputMete
            + ", sellUnitPrice="
            + this.sellUnitPrice
            + ", sellAmount="
            + this.sellAmount
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", schedulingId="
            + this.schedulingId
            + ")";
      }
   }
}
