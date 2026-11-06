package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferDTOParam {
   private Long workshopId;
   private Long materialId;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private BigDecimal quantity;
   @EnumValidator(value = TransferTypeEnum.class, message = "调拨类型错误")
   private Integer transferType;
   private Long warehouseId;
   private String outboundUnit;
   private Integer outboundUnitPrecision;
   private String remark;
   private Boolean boolPassed;
   private LocalDateTime realTime;

   public static TransferDTOParam.TransferDTOParamBuilder builder() {
      return new TransferDTOParam.TransferDTOParamBuilder();
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getOutboundUnit() {
      return this.outboundUnit;
   }

   public Integer getOutboundUnitPrecision() {
      return this.outboundUnitPrecision;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolPassed() {
      return this.boolPassed;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setTransferType(final Integer transferType) {
      this.transferType = transferType;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setOutboundUnit(final String outboundUnit) {
      this.outboundUnit = outboundUnit;
   }

   public void setOutboundUnitPrecision(final Integer outboundUnitPrecision) {
      this.outboundUnitPrecision = outboundUnitPrecision;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolPassed(final Boolean boolPassed) {
      this.boolPassed = boolPassed;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDTOParam)) {
         return false;
      }

      TransferDTOParam other = (TransferDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$materialId = this.getMaterialId();
         Object other$materialId = other.getMaterialId();
         if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$transferType = this.getTransferType();
                     Object other$transferType = other.getTransferType();
                     if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                        Object this$warehouseId = this.getWarehouseId();
                        Object other$warehouseId = other.getWarehouseId();
                        if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                           Object this$outboundUnitPrecision = this.getOutboundUnitPrecision();
                           Object other$outboundUnitPrecision = other.getOutboundUnitPrecision();
                           if (this$outboundUnitPrecision == null
                              ? other$outboundUnitPrecision == null
                              : this$outboundUnitPrecision.equals(other$outboundUnitPrecision)) {
                              Object this$boolPassed = this.getBoolPassed();
                              Object other$boolPassed = other.getBoolPassed();
                              if (this$boolPassed == null ? other$boolPassed == null : this$boolPassed.equals(other$boolPassed)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$outboundUnit = this.getOutboundUnit();
                                    Object other$outboundUnit = other.getOutboundUnit();
                                    if (this$outboundUnit == null ? other$outboundUnit == null : this$outboundUnit.equals(other$outboundUnit)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$realTime = this.getRealTime();
                                          Object other$realTime = other.getRealTime();
                                          return this$realTime == null ? other$realTime == null : this$realTime.equals(other$realTime);
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
      return other instanceof TransferDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $outboundUnitPrecision = this.getOutboundUnitPrecision();
      result = result * 59 + ($outboundUnitPrecision == null ? 43 : $outboundUnitPrecision.hashCode());
      Object $boolPassed = this.getBoolPassed();
      result = result * 59 + ($boolPassed == null ? 43 : $boolPassed.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundUnit = this.getOutboundUnit();
      result = result * 59 + ($outboundUnit == null ? 43 : $outboundUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDTOParam(workshopId="
         + this.getWorkshopId()
         + ", materialId="
         + this.getMaterialId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", quantity="
         + this.getQuantity()
         + ", transferType="
         + this.getTransferType()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", outboundUnit="
         + this.getOutboundUnit()
         + ", outboundUnitPrecision="
         + this.getOutboundUnitPrecision()
         + ", remark="
         + this.getRemark()
         + ", boolPassed="
         + this.getBoolPassed()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public TransferDTOParam(
      final Long workshopId,
      final Long materialId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final BigDecimal quantity,
      final Integer transferType,
      final Long warehouseId,
      final String outboundUnit,
      final Integer outboundUnitPrecision,
      final String remark,
      final Boolean boolPassed,
      final LocalDateTime realTime
   ) {
      this.workshopId = workshopId;
      this.materialId = materialId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.quantity = quantity;
      this.transferType = transferType;
      this.warehouseId = warehouseId;
      this.outboundUnit = outboundUnit;
      this.outboundUnitPrecision = outboundUnitPrecision;
      this.remark = remark;
      this.boolPassed = boolPassed;
      this.realTime = realTime;
   }

   public TransferDTOParam() {
   }

   public static class TransferDTOParamBuilder {
      private Long workshopId;
      private Long materialId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private BigDecimal quantity;
      private Integer transferType;
      private Long warehouseId;
      private String outboundUnit;
      private Integer outboundUnitPrecision;
      private String remark;
      private Boolean boolPassed;
      private LocalDateTime realTime;

      TransferDTOParamBuilder() {
      }

      public TransferDTOParam.TransferDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder outboundUnit(final String outboundUnit) {
         this.outboundUnit = outboundUnit;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder outboundUnitPrecision(final Integer outboundUnitPrecision) {
         this.outboundUnitPrecision = outboundUnitPrecision;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder boolPassed(final Boolean boolPassed) {
         this.boolPassed = boolPassed;
         return this;
      }

      public TransferDTOParam.TransferDTOParamBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public TransferDTOParam build() {
         return new TransferDTOParam(
            this.workshopId,
            this.materialId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.quantity,
            this.transferType,
            this.warehouseId,
            this.outboundUnit,
            this.outboundUnitPrecision,
            this.remark,
            this.boolPassed,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "TransferDTOParam.TransferDTOParamBuilder(workshopId="
            + this.workshopId
            + ", materialId="
            + this.materialId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", quantity="
            + this.quantity
            + ", transferType="
            + this.transferType
            + ", warehouseId="
            + this.warehouseId
            + ", outboundUnit="
            + this.outboundUnit
            + ", outboundUnitPrecision="
            + this.outboundUnitPrecision
            + ", remark="
            + this.remark
            + ", boolPassed="
            + this.boolPassed
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
