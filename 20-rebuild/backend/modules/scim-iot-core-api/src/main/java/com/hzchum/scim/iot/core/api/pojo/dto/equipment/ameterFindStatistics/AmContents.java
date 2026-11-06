package com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics;

import java.util.List;

public class AmContents {
   private int id;
   private int mid;
   private String ammeterCode;
   private double totalPowerExpend;
   private String equipmentId;
   private String equipmentName;
   private int prodLineId;
   private String prodLineName;
   private int workshopId;
   private String workshopName;
   private int type;
   private long lastTime;
   private List<Integer> deviceMids;

   public static AmContents.AmContentsBuilder builder() {
      return new AmContents.AmContentsBuilder();
   }

   public int getId() {
      return this.id;
   }

   public int getMid() {
      return this.mid;
   }

   public String getAmmeterCode() {
      return this.ammeterCode;
   }

   public double getTotalPowerExpend() {
      return this.totalPowerExpend;
   }

   public String getEquipmentId() {
      return this.equipmentId;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public int getProdLineId() {
      return this.prodLineId;
   }

   public String getProdLineName() {
      return this.prodLineName;
   }

   public int getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public int getType() {
      return this.type;
   }

   public long getLastTime() {
      return this.lastTime;
   }

   public List<Integer> getDeviceMids() {
      return this.deviceMids;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public void setMid(final int mid) {
      this.mid = mid;
   }

   public void setAmmeterCode(final String ammeterCode) {
      this.ammeterCode = ammeterCode;
   }

   public void setTotalPowerExpend(final double totalPowerExpend) {
      this.totalPowerExpend = totalPowerExpend;
   }

   public void setEquipmentId(final String equipmentId) {
      this.equipmentId = equipmentId;
   }

   public void setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
   }

   public void setProdLineId(final int prodLineId) {
      this.prodLineId = prodLineId;
   }

   public void setProdLineName(final String prodLineName) {
      this.prodLineName = prodLineName;
   }

   public void setWorkshopId(final int workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setType(final int type) {
      this.type = type;
   }

   public void setLastTime(final long lastTime) {
      this.lastTime = lastTime;
   }

   public void setDeviceMids(final List<Integer> deviceMids) {
      this.deviceMids = deviceMids;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AmContents)) {
         return false;
      }

      AmContents other = (AmContents)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getId() != other.getId()) {
         return false;
      }

      if (this.getMid() != other.getMid()) {
         return false;
      }

      if (Double.compare(this.getTotalPowerExpend(), other.getTotalPowerExpend()) != 0) {
         return false;
      }

      if (this.getProdLineId() != other.getProdLineId()) {
         return false;
      }

      if (this.getWorkshopId() != other.getWorkshopId()) {
         return false;
      }

      if (this.getType() != other.getType()) {
         return false;
      }

      if (this.getLastTime() != other.getLastTime()) {
         return false;
      }

      Object this$ammeterCode = this.getAmmeterCode();
      Object other$ammeterCode = other.getAmmeterCode();
      if (this$ammeterCode == null ? other$ammeterCode == null : this$ammeterCode.equals(other$ammeterCode)) {
         Object this$equipmentId = this.getEquipmentId();
         Object other$equipmentId = other.getEquipmentId();
         if (this$equipmentId == null ? other$equipmentId == null : this$equipmentId.equals(other$equipmentId)) {
            Object this$equipmentName = this.getEquipmentName();
            Object other$equipmentName = other.getEquipmentName();
            if (this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName)) {
               Object this$prodLineName = this.getProdLineName();
               Object other$prodLineName = other.getProdLineName();
               if (this$prodLineName == null ? other$prodLineName == null : this$prodLineName.equals(other$prodLineName)) {
                  Object this$workshopName = this.getWorkshopName();
                  Object other$workshopName = other.getWorkshopName();
                  if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                     Object this$deviceMids = this.getDeviceMids();
                     Object other$deviceMids = other.getDeviceMids();
                     return this$deviceMids == null ? other$deviceMids == null : this$deviceMids.equals(other$deviceMids);
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
      return other instanceof AmContents;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getId();
      result = result * 59 + this.getMid();
      long $totalPowerExpend = Double.doubleToLongBits(this.getTotalPowerExpend());
      result = result * 59 + (int)($totalPowerExpend >>> 32 ^ $totalPowerExpend);
      result = result * 59 + this.getProdLineId();
      result = result * 59 + this.getWorkshopId();
      result = result * 59 + this.getType();
      long $lastTime = this.getLastTime();
      result = result * 59 + (int)($lastTime >>> 32 ^ $lastTime);
      Object $ammeterCode = this.getAmmeterCode();
      result = result * 59 + ($ammeterCode == null ? 43 : $ammeterCode.hashCode());
      Object $equipmentId = this.getEquipmentId();
      result = result * 59 + ($equipmentId == null ? 43 : $equipmentId.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $prodLineName = this.getProdLineName();
      result = result * 59 + ($prodLineName == null ? 43 : $prodLineName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $deviceMids = this.getDeviceMids();
      return result * 59 + ($deviceMids == null ? 43 : $deviceMids.hashCode());
   }

   @Override
   public String toString() {
      return "AmContents(id="
         + this.getId()
         + ", mid="
         + this.getMid()
         + ", ammeterCode="
         + this.getAmmeterCode()
         + ", totalPowerExpend="
         + this.getTotalPowerExpend()
         + ", equipmentId="
         + this.getEquipmentId()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", prodLineId="
         + this.getProdLineId()
         + ", prodLineName="
         + this.getProdLineName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", type="
         + this.getType()
         + ", lastTime="
         + this.getLastTime()
         + ", deviceMids="
         + this.getDeviceMids()
         + ")";
   }

   public AmContents(
      final int id,
      final int mid,
      final String ammeterCode,
      final double totalPowerExpend,
      final String equipmentId,
      final String equipmentName,
      final int prodLineId,
      final String prodLineName,
      final int workshopId,
      final String workshopName,
      final int type,
      final long lastTime,
      final List<Integer> deviceMids
   ) {
      this.id = id;
      this.mid = mid;
      this.ammeterCode = ammeterCode;
      this.totalPowerExpend = totalPowerExpend;
      this.equipmentId = equipmentId;
      this.equipmentName = equipmentName;
      this.prodLineId = prodLineId;
      this.prodLineName = prodLineName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.type = type;
      this.lastTime = lastTime;
      this.deviceMids = deviceMids;
   }

   public AmContents() {
   }

   public static class AmContentsBuilder {
      private int id;
      private int mid;
      private String ammeterCode;
      private double totalPowerExpend;
      private String equipmentId;
      private String equipmentName;
      private int prodLineId;
      private String prodLineName;
      private int workshopId;
      private String workshopName;
      private int type;
      private long lastTime;
      private List<Integer> deviceMids;

      AmContentsBuilder() {
      }

      public AmContents.AmContentsBuilder id(final int id) {
         this.id = id;
         return this;
      }

      public AmContents.AmContentsBuilder mid(final int mid) {
         this.mid = mid;
         return this;
      }

      public AmContents.AmContentsBuilder ammeterCode(final String ammeterCode) {
         this.ammeterCode = ammeterCode;
         return this;
      }

      public AmContents.AmContentsBuilder totalPowerExpend(final double totalPowerExpend) {
         this.totalPowerExpend = totalPowerExpend;
         return this;
      }

      public AmContents.AmContentsBuilder equipmentId(final String equipmentId) {
         this.equipmentId = equipmentId;
         return this;
      }

      public AmContents.AmContentsBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public AmContents.AmContentsBuilder prodLineId(final int prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public AmContents.AmContentsBuilder prodLineName(final String prodLineName) {
         this.prodLineName = prodLineName;
         return this;
      }

      public AmContents.AmContentsBuilder workshopId(final int workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public AmContents.AmContentsBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public AmContents.AmContentsBuilder type(final int type) {
         this.type = type;
         return this;
      }

      public AmContents.AmContentsBuilder lastTime(final long lastTime) {
         this.lastTime = lastTime;
         return this;
      }

      public AmContents.AmContentsBuilder deviceMids(final List<Integer> deviceMids) {
         this.deviceMids = deviceMids;
         return this;
      }

      public AmContents build() {
         return new AmContents(
            this.id,
            this.mid,
            this.ammeterCode,
            this.totalPowerExpend,
            this.equipmentId,
            this.equipmentName,
            this.prodLineId,
            this.prodLineName,
            this.workshopId,
            this.workshopName,
            this.type,
            this.lastTime,
            this.deviceMids
         );
      }

      @Override
      public String toString() {
         return "AmContents.AmContentsBuilder(id="
            + this.id
            + ", mid="
            + this.mid
            + ", ammeterCode="
            + this.ammeterCode
            + ", totalPowerExpend="
            + this.totalPowerExpend
            + ", equipmentId="
            + this.equipmentId
            + ", equipmentName="
            + this.equipmentName
            + ", prodLineId="
            + this.prodLineId
            + ", prodLineName="
            + this.prodLineName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", type="
            + this.type
            + ", lastTime="
            + this.lastTime
            + ", deviceMids="
            + this.deviceMids
            + ")";
      }
   }
}
