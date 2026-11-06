package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class DeviceOutboundDTOParam {
   private Long id;
   private BigDecimal mete;
   private String outboundUnit;
   private Integer outboundUnitType;
   private Long workshopId;
   private String remark;
   private Long receiveDetailId;
   private Long recipientId;
   private String recipientName;

   public static DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder builder() {
      return new DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getMete() {
      return this.mete;
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

   public Long getReceiveDetailId() {
      return this.receiveDetailId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
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

   public void setReceiveDetailId(final Long receiveDetailId) {
      this.receiveDetailId = receiveDetailId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceOutboundDTOParam)) {
         return false;
      }

      DeviceOutboundDTOParam other = (DeviceOutboundDTOParam)o;
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
               Object this$receiveDetailId = this.getReceiveDetailId();
               Object other$receiveDetailId = other.getReceiveDetailId();
               if (this$receiveDetailId == null ? other$receiveDetailId == null : this$receiveDetailId.equals(other$receiveDetailId)) {
                  Object this$recipientId = this.getRecipientId();
                  Object other$recipientId = other.getRecipientId();
                  if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$outboundUnit = this.getOutboundUnit();
                        Object other$outboundUnit = other.getOutboundUnit();
                        if (this$outboundUnit == null ? other$outboundUnit == null : this$outboundUnit.equals(other$outboundUnit)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$recipientName = this.getRecipientName();
                              Object other$recipientName = other.getRecipientName();
                              return this$recipientName == null ? other$recipientName == null : this$recipientName.equals(other$recipientName);
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
      return other instanceof DeviceOutboundDTOParam;
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
      Object $receiveDetailId = this.getReceiveDetailId();
      result = result * 59 + ($receiveDetailId == null ? 43 : $receiveDetailId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $outboundUnit = this.getOutboundUnit();
      result = result * 59 + ($outboundUnit == null ? 43 : $outboundUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $recipientName = this.getRecipientName();
      return result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceOutboundDTOParam(id="
         + this.getId()
         + ", mete="
         + this.getMete()
         + ", outboundUnit="
         + this.getOutboundUnit()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", remark="
         + this.getRemark()
         + ", receiveDetailId="
         + this.getReceiveDetailId()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ")";
   }

   public DeviceOutboundDTOParam(
      final Long id,
      final BigDecimal mete,
      final String outboundUnit,
      final Integer outboundUnitType,
      final Long workshopId,
      final String remark,
      final Long receiveDetailId,
      final Long recipientId,
      final String recipientName
   ) {
      this.id = id;
      this.mete = mete;
      this.outboundUnit = outboundUnit;
      this.outboundUnitType = outboundUnitType;
      this.workshopId = workshopId;
      this.remark = remark;
      this.receiveDetailId = receiveDetailId;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
   }

   public DeviceOutboundDTOParam() {
   }

   public static class DeviceOutboundDTOParamBuilder {
      private Long id;
      private BigDecimal mete;
      private String outboundUnit;
      private Integer outboundUnitType;
      private Long workshopId;
      private String remark;
      private Long receiveDetailId;
      private Long recipientId;
      private String recipientName;

      DeviceOutboundDTOParamBuilder() {
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder outboundUnit(final String outboundUnit) {
         this.outboundUnit = outboundUnit;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder receiveDetailId(final Long receiveDetailId) {
         this.receiveDetailId = receiveDetailId;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public DeviceOutboundDTOParam build() {
         return new DeviceOutboundDTOParam(
            this.id,
            this.mete,
            this.outboundUnit,
            this.outboundUnitType,
            this.workshopId,
            this.remark,
            this.receiveDetailId,
            this.recipientId,
            this.recipientName
         );
      }

      @Override
      public String toString() {
         return "DeviceOutboundDTOParam.DeviceOutboundDTOParamBuilder(id="
            + this.id
            + ", mete="
            + this.mete
            + ", outboundUnit="
            + this.outboundUnit
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", workshopId="
            + this.workshopId
            + ", remark="
            + this.remark
            + ", receiveDetailId="
            + this.receiveDetailId
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ")";
      }
   }
}
