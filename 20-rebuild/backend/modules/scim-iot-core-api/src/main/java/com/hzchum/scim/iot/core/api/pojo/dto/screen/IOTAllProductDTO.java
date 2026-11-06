package com.hzchum.scim.iot.core.api.pojo.dto.screen;

public class IOTAllProductDTO {
   private double debugNum;
   private double deviceNum;
   private double freeNum;
   private double offlineNum;
   private double onlineNum;
   private IOTLineIDNameDTO productionLine;
   private double runNum;
   private double warnNum;

   public static IOTAllProductDTO.IOTAllProductDTOBuilder builder() {
      return new IOTAllProductDTO.IOTAllProductDTOBuilder();
   }

   public double getDebugNum() {
      return this.debugNum;
   }

   public double getDeviceNum() {
      return this.deviceNum;
   }

   public double getFreeNum() {
      return this.freeNum;
   }

   public double getOfflineNum() {
      return this.offlineNum;
   }

   public double getOnlineNum() {
      return this.onlineNum;
   }

   public IOTLineIDNameDTO getProductionLine() {
      return this.productionLine;
   }

   public double getRunNum() {
      return this.runNum;
   }

   public double getWarnNum() {
      return this.warnNum;
   }

   public void setDebugNum(final double debugNum) {
      this.debugNum = debugNum;
   }

   public void setDeviceNum(final double deviceNum) {
      this.deviceNum = deviceNum;
   }

   public void setFreeNum(final double freeNum) {
      this.freeNum = freeNum;
   }

   public void setOfflineNum(final double offlineNum) {
      this.offlineNum = offlineNum;
   }

   public void setOnlineNum(final double onlineNum) {
      this.onlineNum = onlineNum;
   }

   public void setProductionLine(final IOTLineIDNameDTO productionLine) {
      this.productionLine = productionLine;
   }

   public void setRunNum(final double runNum) {
      this.runNum = runNum;
   }

   public void setWarnNum(final double warnNum) {
      this.warnNum = warnNum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IOTAllProductDTO)) {
         return false;
      }

      IOTAllProductDTO other = (IOTAllProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getDebugNum(), other.getDebugNum()) != 0) {
         return false;
      }

      if (Double.compare(this.getDeviceNum(), other.getDeviceNum()) != 0) {
         return false;
      }

      if (Double.compare(this.getFreeNum(), other.getFreeNum()) != 0) {
         return false;
      }

      if (Double.compare(this.getOfflineNum(), other.getOfflineNum()) != 0) {
         return false;
      }

      if (Double.compare(this.getOnlineNum(), other.getOnlineNum()) != 0) {
         return false;
      }

      if (Double.compare(this.getRunNum(), other.getRunNum()) != 0) {
         return false;
      }

      if (Double.compare(this.getWarnNum(), other.getWarnNum()) != 0) {
         return false;
      }

      Object this$productionLine = this.getProductionLine();
      Object other$productionLine = other.getProductionLine();
      return this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IOTAllProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $debugNum = Double.doubleToLongBits(this.getDebugNum());
      result = result * 59 + (int)($debugNum >>> 32 ^ $debugNum);
      long $deviceNum = Double.doubleToLongBits(this.getDeviceNum());
      result = result * 59 + (int)($deviceNum >>> 32 ^ $deviceNum);
      long $freeNum = Double.doubleToLongBits(this.getFreeNum());
      result = result * 59 + (int)($freeNum >>> 32 ^ $freeNum);
      long $offlineNum = Double.doubleToLongBits(this.getOfflineNum());
      result = result * 59 + (int)($offlineNum >>> 32 ^ $offlineNum);
      long $onlineNum = Double.doubleToLongBits(this.getOnlineNum());
      result = result * 59 + (int)($onlineNum >>> 32 ^ $onlineNum);
      long $runNum = Double.doubleToLongBits(this.getRunNum());
      result = result * 59 + (int)($runNum >>> 32 ^ $runNum);
      long $warnNum = Double.doubleToLongBits(this.getWarnNum());
      result = result * 59 + (int)($warnNum >>> 32 ^ $warnNum);
      Object $productionLine = this.getProductionLine();
      return result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
   }

   @Override
   public String toString() {
      return "IOTAllProductDTO(debugNum="
         + this.getDebugNum()
         + ", deviceNum="
         + this.getDeviceNum()
         + ", freeNum="
         + this.getFreeNum()
         + ", offlineNum="
         + this.getOfflineNum()
         + ", onlineNum="
         + this.getOnlineNum()
         + ", productionLine="
         + this.getProductionLine()
         + ", runNum="
         + this.getRunNum()
         + ", warnNum="
         + this.getWarnNum()
         + ")";
   }

   public IOTAllProductDTO(
      final double debugNum,
      final double deviceNum,
      final double freeNum,
      final double offlineNum,
      final double onlineNum,
      final IOTLineIDNameDTO productionLine,
      final double runNum,
      final double warnNum
   ) {
      this.debugNum = debugNum;
      this.deviceNum = deviceNum;
      this.freeNum = freeNum;
      this.offlineNum = offlineNum;
      this.onlineNum = onlineNum;
      this.productionLine = productionLine;
      this.runNum = runNum;
      this.warnNum = warnNum;
   }

   public IOTAllProductDTO() {
   }

   public static class IOTAllProductDTOBuilder {
      private double debugNum;
      private double deviceNum;
      private double freeNum;
      private double offlineNum;
      private double onlineNum;
      private IOTLineIDNameDTO productionLine;
      private double runNum;
      private double warnNum;

      IOTAllProductDTOBuilder() {
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder debugNum(final double debugNum) {
         this.debugNum = debugNum;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder deviceNum(final double deviceNum) {
         this.deviceNum = deviceNum;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder freeNum(final double freeNum) {
         this.freeNum = freeNum;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder offlineNum(final double offlineNum) {
         this.offlineNum = offlineNum;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder onlineNum(final double onlineNum) {
         this.onlineNum = onlineNum;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder productionLine(final IOTLineIDNameDTO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder runNum(final double runNum) {
         this.runNum = runNum;
         return this;
      }

      public IOTAllProductDTO.IOTAllProductDTOBuilder warnNum(final double warnNum) {
         this.warnNum = warnNum;
         return this;
      }

      public IOTAllProductDTO build() {
         return new IOTAllProductDTO(
            this.debugNum, this.deviceNum, this.freeNum, this.offlineNum, this.onlineNum, this.productionLine, this.runNum, this.warnNum
         );
      }

      @Override
      public String toString() {
         return "IOTAllProductDTO.IOTAllProductDTOBuilder(debugNum="
            + this.debugNum
            + ", deviceNum="
            + this.deviceNum
            + ", freeNum="
            + this.freeNum
            + ", offlineNum="
            + this.offlineNum
            + ", onlineNum="
            + this.onlineNum
            + ", productionLine="
            + this.productionLine
            + ", runNum="
            + this.runNum
            + ", warnNum="
            + this.warnNum
            + ")";
      }
   }
}
