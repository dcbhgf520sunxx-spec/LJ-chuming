package com.hzchum.scim.iot.core.api.pojo.dto.screen;

public class IOTProducterDTO {
   private Integer debugQuantity;
   private Integer deviceQuantity;
   private Integer freeQuantity;
   private Integer offLineQuantity;
   private Integer onLineQuantity;
   private Integer runQuantity;
   private Integer warningQuantity;

   public static IOTProducterDTO.IOTProducterDTOBuilder builder() {
      return new IOTProducterDTO.IOTProducterDTOBuilder();
   }

   public Integer getDebugQuantity() {
      return this.debugQuantity;
   }

   public Integer getDeviceQuantity() {
      return this.deviceQuantity;
   }

   public Integer getFreeQuantity() {
      return this.freeQuantity;
   }

   public Integer getOffLineQuantity() {
      return this.offLineQuantity;
   }

   public Integer getOnLineQuantity() {
      return this.onLineQuantity;
   }

   public Integer getRunQuantity() {
      return this.runQuantity;
   }

   public Integer getWarningQuantity() {
      return this.warningQuantity;
   }

   public void setDebugQuantity(final Integer debugQuantity) {
      this.debugQuantity = debugQuantity;
   }

   public void setDeviceQuantity(final Integer deviceQuantity) {
      this.deviceQuantity = deviceQuantity;
   }

   public void setFreeQuantity(final Integer freeQuantity) {
      this.freeQuantity = freeQuantity;
   }

   public void setOffLineQuantity(final Integer offLineQuantity) {
      this.offLineQuantity = offLineQuantity;
   }

   public void setOnLineQuantity(final Integer onLineQuantity) {
      this.onLineQuantity = onLineQuantity;
   }

   public void setRunQuantity(final Integer runQuantity) {
      this.runQuantity = runQuantity;
   }

   public void setWarningQuantity(final Integer warningQuantity) {
      this.warningQuantity = warningQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IOTProducterDTO)) {
         return false;
      }

      IOTProducterDTO other = (IOTProducterDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$debugQuantity = this.getDebugQuantity();
      Object other$debugQuantity = other.getDebugQuantity();
      if (this$debugQuantity == null ? other$debugQuantity == null : this$debugQuantity.equals(other$debugQuantity)) {
         Object this$deviceQuantity = this.getDeviceQuantity();
         Object other$deviceQuantity = other.getDeviceQuantity();
         if (this$deviceQuantity == null ? other$deviceQuantity == null : this$deviceQuantity.equals(other$deviceQuantity)) {
            Object this$freeQuantity = this.getFreeQuantity();
            Object other$freeQuantity = other.getFreeQuantity();
            if (this$freeQuantity == null ? other$freeQuantity == null : this$freeQuantity.equals(other$freeQuantity)) {
               Object this$offLineQuantity = this.getOffLineQuantity();
               Object other$offLineQuantity = other.getOffLineQuantity();
               if (this$offLineQuantity == null ? other$offLineQuantity == null : this$offLineQuantity.equals(other$offLineQuantity)) {
                  Object this$onLineQuantity = this.getOnLineQuantity();
                  Object other$onLineQuantity = other.getOnLineQuantity();
                  if (this$onLineQuantity == null ? other$onLineQuantity == null : this$onLineQuantity.equals(other$onLineQuantity)) {
                     Object this$runQuantity = this.getRunQuantity();
                     Object other$runQuantity = other.getRunQuantity();
                     if (this$runQuantity == null ? other$runQuantity == null : this$runQuantity.equals(other$runQuantity)) {
                        Object this$warningQuantity = this.getWarningQuantity();
                        Object other$warningQuantity = other.getWarningQuantity();
                        return this$warningQuantity == null ? other$warningQuantity == null : this$warningQuantity.equals(other$warningQuantity);
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
      return other instanceof IOTProducterDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $debugQuantity = this.getDebugQuantity();
      result = result * 59 + ($debugQuantity == null ? 43 : $debugQuantity.hashCode());
      Object $deviceQuantity = this.getDeviceQuantity();
      result = result * 59 + ($deviceQuantity == null ? 43 : $deviceQuantity.hashCode());
      Object $freeQuantity = this.getFreeQuantity();
      result = result * 59 + ($freeQuantity == null ? 43 : $freeQuantity.hashCode());
      Object $offLineQuantity = this.getOffLineQuantity();
      result = result * 59 + ($offLineQuantity == null ? 43 : $offLineQuantity.hashCode());
      Object $onLineQuantity = this.getOnLineQuantity();
      result = result * 59 + ($onLineQuantity == null ? 43 : $onLineQuantity.hashCode());
      Object $runQuantity = this.getRunQuantity();
      result = result * 59 + ($runQuantity == null ? 43 : $runQuantity.hashCode());
      Object $warningQuantity = this.getWarningQuantity();
      return result * 59 + ($warningQuantity == null ? 43 : $warningQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "IOTProducterDTO(debugQuantity="
         + this.getDebugQuantity()
         + ", deviceQuantity="
         + this.getDeviceQuantity()
         + ", freeQuantity="
         + this.getFreeQuantity()
         + ", offLineQuantity="
         + this.getOffLineQuantity()
         + ", onLineQuantity="
         + this.getOnLineQuantity()
         + ", runQuantity="
         + this.getRunQuantity()
         + ", warningQuantity="
         + this.getWarningQuantity()
         + ")";
   }

   public IOTProducterDTO(
      final Integer debugQuantity,
      final Integer deviceQuantity,
      final Integer freeQuantity,
      final Integer offLineQuantity,
      final Integer onLineQuantity,
      final Integer runQuantity,
      final Integer warningQuantity
   ) {
      this.debugQuantity = debugQuantity;
      this.deviceQuantity = deviceQuantity;
      this.freeQuantity = freeQuantity;
      this.offLineQuantity = offLineQuantity;
      this.onLineQuantity = onLineQuantity;
      this.runQuantity = runQuantity;
      this.warningQuantity = warningQuantity;
   }

   public IOTProducterDTO() {
   }

   public static class IOTProducterDTOBuilder {
      private Integer debugQuantity;
      private Integer deviceQuantity;
      private Integer freeQuantity;
      private Integer offLineQuantity;
      private Integer onLineQuantity;
      private Integer runQuantity;
      private Integer warningQuantity;

      IOTProducterDTOBuilder() {
      }

      public IOTProducterDTO.IOTProducterDTOBuilder debugQuantity(final Integer debugQuantity) {
         this.debugQuantity = debugQuantity;
         return this;
      }

      public IOTProducterDTO.IOTProducterDTOBuilder deviceQuantity(final Integer deviceQuantity) {
         this.deviceQuantity = deviceQuantity;
         return this;
      }

      public IOTProducterDTO.IOTProducterDTOBuilder freeQuantity(final Integer freeQuantity) {
         this.freeQuantity = freeQuantity;
         return this;
      }

      public IOTProducterDTO.IOTProducterDTOBuilder offLineQuantity(final Integer offLineQuantity) {
         this.offLineQuantity = offLineQuantity;
         return this;
      }

      public IOTProducterDTO.IOTProducterDTOBuilder onLineQuantity(final Integer onLineQuantity) {
         this.onLineQuantity = onLineQuantity;
         return this;
      }

      public IOTProducterDTO.IOTProducterDTOBuilder runQuantity(final Integer runQuantity) {
         this.runQuantity = runQuantity;
         return this;
      }

      public IOTProducterDTO.IOTProducterDTOBuilder warningQuantity(final Integer warningQuantity) {
         this.warningQuantity = warningQuantity;
         return this;
      }

      public IOTProducterDTO build() {
         return new IOTProducterDTO(
            this.debugQuantity, this.deviceQuantity, this.freeQuantity, this.offLineQuantity, this.onLineQuantity, this.runQuantity, this.warningQuantity
         );
      }

      @Override
      public String toString() {
         return "IOTProducterDTO.IOTProducterDTOBuilder(debugQuantity="
            + this.debugQuantity
            + ", deviceQuantity="
            + this.deviceQuantity
            + ", freeQuantity="
            + this.freeQuantity
            + ", offLineQuantity="
            + this.offLineQuantity
            + ", onLineQuantity="
            + this.onLineQuantity
            + ", runQuantity="
            + this.runQuantity
            + ", warningQuantity="
            + this.warningQuantity
            + ")";
      }
   }
}
