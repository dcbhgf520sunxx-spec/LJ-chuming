package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

import java.util.List;

public class GasContents {
   private String batteryType;
   private int equipmentId;
   private List<String> equipmentMids;
   private String equipmentName;
   private Integer gasMeterType;
   private Integer id;
   private String lastTime;
   private String meterCode;
   private Integer mid;
   private Integer prodLineId;
   private String prodLineName;
   private Integer totalFlow;
   private Integer type;
   private Integer workshopId;
   private String workshopName;

   public static GasContents.GasContentsBuilder builder() {
      return new GasContents.GasContentsBuilder();
   }

   public String getBatteryType() {
      return this.batteryType;
   }

   public int getEquipmentId() {
      return this.equipmentId;
   }

   public List<String> getEquipmentMids() {
      return this.equipmentMids;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public Integer getGasMeterType() {
      return this.gasMeterType;
   }

   public Integer getId() {
      return this.id;
   }

   public String getLastTime() {
      return this.lastTime;
   }

   public String getMeterCode() {
      return this.meterCode;
   }

   public Integer getMid() {
      return this.mid;
   }

   public Integer getProdLineId() {
      return this.prodLineId;
   }

   public String getProdLineName() {
      return this.prodLineName;
   }

   public Integer getTotalFlow() {
      return this.totalFlow;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public void setBatteryType(final String batteryType) {
      this.batteryType = batteryType;
   }

   public void setEquipmentId(final int equipmentId) {
      this.equipmentId = equipmentId;
   }

   public void setEquipmentMids(final List<String> equipmentMids) {
      this.equipmentMids = equipmentMids;
   }

   public void setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
   }

   public void setGasMeterType(final Integer gasMeterType) {
      this.gasMeterType = gasMeterType;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setLastTime(final String lastTime) {
      this.lastTime = lastTime;
   }

   public void setMeterCode(final String meterCode) {
      this.meterCode = meterCode;
   }

   public void setMid(final Integer mid) {
      this.mid = mid;
   }

   public void setProdLineId(final Integer prodLineId) {
      this.prodLineId = prodLineId;
   }

   public void setProdLineName(final String prodLineName) {
      this.prodLineName = prodLineName;
   }

   public void setTotalFlow(final Integer totalFlow) {
      this.totalFlow = totalFlow;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setWorkshopId(final Integer workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GasContents)) {
         return false;
      }

      GasContents other = (GasContents)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getEquipmentId() != other.getEquipmentId()) {
         return false;
      }

      Object this$gasMeterType = this.getGasMeterType();
      Object other$gasMeterType = other.getGasMeterType();
      if (this$gasMeterType == null ? other$gasMeterType == null : this$gasMeterType.equals(other$gasMeterType)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$mid = this.getMid();
            Object other$mid = other.getMid();
            if (this$mid == null ? other$mid == null : this$mid.equals(other$mid)) {
               Object this$prodLineId = this.getProdLineId();
               Object other$prodLineId = other.getProdLineId();
               if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                  Object this$totalFlow = this.getTotalFlow();
                  Object other$totalFlow = other.getTotalFlow();
                  if (this$totalFlow == null ? other$totalFlow == null : this$totalFlow.equals(other$totalFlow)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$batteryType = this.getBatteryType();
                           Object other$batteryType = other.getBatteryType();
                           if (this$batteryType == null ? other$batteryType == null : this$batteryType.equals(other$batteryType)) {
                              Object this$equipmentMids = this.getEquipmentMids();
                              Object other$equipmentMids = other.getEquipmentMids();
                              if (this$equipmentMids == null ? other$equipmentMids == null : this$equipmentMids.equals(other$equipmentMids)) {
                                 Object this$equipmentName = this.getEquipmentName();
                                 Object other$equipmentName = other.getEquipmentName();
                                 if (this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName)) {
                                    Object this$lastTime = this.getLastTime();
                                    Object other$lastTime = other.getLastTime();
                                    if (this$lastTime == null ? other$lastTime == null : this$lastTime.equals(other$lastTime)) {
                                       Object this$meterCode = this.getMeterCode();
                                       Object other$meterCode = other.getMeterCode();
                                       if (this$meterCode == null ? other$meterCode == null : this$meterCode.equals(other$meterCode)) {
                                          Object this$prodLineName = this.getProdLineName();
                                          Object other$prodLineName = other.getProdLineName();
                                          if (this$prodLineName == null ? other$prodLineName == null : this$prodLineName.equals(other$prodLineName)) {
                                             Object this$workshopName = this.getWorkshopName();
                                             Object other$workshopName = other.getWorkshopName();
                                             return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
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
      return other instanceof GasContents;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getEquipmentId();
      Object $gasMeterType = this.getGasMeterType();
      result = result * 59 + ($gasMeterType == null ? 43 : $gasMeterType.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $totalFlow = this.getTotalFlow();
      result = result * 59 + ($totalFlow == null ? 43 : $totalFlow.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $batteryType = this.getBatteryType();
      result = result * 59 + ($batteryType == null ? 43 : $batteryType.hashCode());
      Object $equipmentMids = this.getEquipmentMids();
      result = result * 59 + ($equipmentMids == null ? 43 : $equipmentMids.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $lastTime = this.getLastTime();
      result = result * 59 + ($lastTime == null ? 43 : $lastTime.hashCode());
      Object $meterCode = this.getMeterCode();
      result = result * 59 + ($meterCode == null ? 43 : $meterCode.hashCode());
      Object $prodLineName = this.getProdLineName();
      result = result * 59 + ($prodLineName == null ? 43 : $prodLineName.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   @Override
   public String toString() {
      return "GasContents(batteryType="
         + this.getBatteryType()
         + ", equipmentId="
         + this.getEquipmentId()
         + ", equipmentMids="
         + this.getEquipmentMids()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", gasMeterType="
         + this.getGasMeterType()
         + ", id="
         + this.getId()
         + ", lastTime="
         + this.getLastTime()
         + ", meterCode="
         + this.getMeterCode()
         + ", mid="
         + this.getMid()
         + ", prodLineId="
         + this.getProdLineId()
         + ", prodLineName="
         + this.getProdLineName()
         + ", totalFlow="
         + this.getTotalFlow()
         + ", type="
         + this.getType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ")";
   }

   public GasContents(
      final String batteryType,
      final int equipmentId,
      final List<String> equipmentMids,
      final String equipmentName,
      final Integer gasMeterType,
      final Integer id,
      final String lastTime,
      final String meterCode,
      final Integer mid,
      final Integer prodLineId,
      final String prodLineName,
      final Integer totalFlow,
      final Integer type,
      final Integer workshopId,
      final String workshopName
   ) {
      this.batteryType = batteryType;
      this.equipmentId = equipmentId;
      this.equipmentMids = equipmentMids;
      this.equipmentName = equipmentName;
      this.gasMeterType = gasMeterType;
      this.id = id;
      this.lastTime = lastTime;
      this.meterCode = meterCode;
      this.mid = mid;
      this.prodLineId = prodLineId;
      this.prodLineName = prodLineName;
      this.totalFlow = totalFlow;
      this.type = type;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
   }

   public GasContents() {
   }

   public static class GasContentsBuilder {
      private String batteryType;
      private int equipmentId;
      private List<String> equipmentMids;
      private String equipmentName;
      private Integer gasMeterType;
      private Integer id;
      private String lastTime;
      private String meterCode;
      private Integer mid;
      private Integer prodLineId;
      private String prodLineName;
      private Integer totalFlow;
      private Integer type;
      private Integer workshopId;
      private String workshopName;

      GasContentsBuilder() {
      }

      public GasContents.GasContentsBuilder batteryType(final String batteryType) {
         this.batteryType = batteryType;
         return this;
      }

      public GasContents.GasContentsBuilder equipmentId(final int equipmentId) {
         this.equipmentId = equipmentId;
         return this;
      }

      public GasContents.GasContentsBuilder equipmentMids(final List<String> equipmentMids) {
         this.equipmentMids = equipmentMids;
         return this;
      }

      public GasContents.GasContentsBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public GasContents.GasContentsBuilder gasMeterType(final Integer gasMeterType) {
         this.gasMeterType = gasMeterType;
         return this;
      }

      public GasContents.GasContentsBuilder id(final Integer id) {
         this.id = id;
         return this;
      }

      public GasContents.GasContentsBuilder lastTime(final String lastTime) {
         this.lastTime = lastTime;
         return this;
      }

      public GasContents.GasContentsBuilder meterCode(final String meterCode) {
         this.meterCode = meterCode;
         return this;
      }

      public GasContents.GasContentsBuilder mid(final Integer mid) {
         this.mid = mid;
         return this;
      }

      public GasContents.GasContentsBuilder prodLineId(final Integer prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public GasContents.GasContentsBuilder prodLineName(final String prodLineName) {
         this.prodLineName = prodLineName;
         return this;
      }

      public GasContents.GasContentsBuilder totalFlow(final Integer totalFlow) {
         this.totalFlow = totalFlow;
         return this;
      }

      public GasContents.GasContentsBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public GasContents.GasContentsBuilder workshopId(final Integer workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public GasContents.GasContentsBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public GasContents build() {
         return new GasContents(
            this.batteryType,
            this.equipmentId,
            this.equipmentMids,
            this.equipmentName,
            this.gasMeterType,
            this.id,
            this.lastTime,
            this.meterCode,
            this.mid,
            this.prodLineId,
            this.prodLineName,
            this.totalFlow,
            this.type,
            this.workshopId,
            this.workshopName
         );
      }

      @Override
      public String toString() {
         return "GasContents.GasContentsBuilder(batteryType="
            + this.batteryType
            + ", equipmentId="
            + this.equipmentId
            + ", equipmentMids="
            + this.equipmentMids
            + ", equipmentName="
            + this.equipmentName
            + ", gasMeterType="
            + this.gasMeterType
            + ", id="
            + this.id
            + ", lastTime="
            + this.lastTime
            + ", meterCode="
            + this.meterCode
            + ", mid="
            + this.mid
            + ", prodLineId="
            + this.prodLineId
            + ", prodLineName="
            + this.prodLineName
            + ", totalFlow="
            + this.totalFlow
            + ", type="
            + this.type
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ")";
      }
   }
}
