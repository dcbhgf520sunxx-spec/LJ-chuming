package com.hzchum.scim.iot.core.api.pojo.dto.equipment.plc;

public class PlcData {
   private String constructcode;
   private int deviceid;
   private String equipmentname;
   private String mainorcurrentroutine;
   private String modcode;
   private int num;
   private String processfileurl;
   private String starttime;

   public static PlcData.PlcDataBuilder builder() {
      return new PlcData.PlcDataBuilder();
   }

   public String getConstructcode() {
      return this.constructcode;
   }

   public int getDeviceid() {
      return this.deviceid;
   }

   public String getEquipmentname() {
      return this.equipmentname;
   }

   public String getMainorcurrentroutine() {
      return this.mainorcurrentroutine;
   }

   public String getModcode() {
      return this.modcode;
   }

   public int getNum() {
      return this.num;
   }

   public String getProcessfileurl() {
      return this.processfileurl;
   }

   public String getStarttime() {
      return this.starttime;
   }

   public void setConstructcode(final String constructcode) {
      this.constructcode = constructcode;
   }

   public void setDeviceid(final int deviceid) {
      this.deviceid = deviceid;
   }

   public void setEquipmentname(final String equipmentname) {
      this.equipmentname = equipmentname;
   }

   public void setMainorcurrentroutine(final String mainorcurrentroutine) {
      this.mainorcurrentroutine = mainorcurrentroutine;
   }

   public void setModcode(final String modcode) {
      this.modcode = modcode;
   }

   public void setNum(final int num) {
      this.num = num;
   }

   public void setProcessfileurl(final String processfileurl) {
      this.processfileurl = processfileurl;
   }

   public void setStarttime(final String starttime) {
      this.starttime = starttime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlcData)) {
         return false;
      }

      PlcData other = (PlcData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getDeviceid() != other.getDeviceid()) {
         return false;
      }

      if (this.getNum() != other.getNum()) {
         return false;
      }

      Object this$constructcode = this.getConstructcode();
      Object other$constructcode = other.getConstructcode();
      if (this$constructcode == null ? other$constructcode == null : this$constructcode.equals(other$constructcode)) {
         Object this$equipmentname = this.getEquipmentname();
         Object other$equipmentname = other.getEquipmentname();
         if (this$equipmentname == null ? other$equipmentname == null : this$equipmentname.equals(other$equipmentname)) {
            Object this$mainorcurrentroutine = this.getMainorcurrentroutine();
            Object other$mainorcurrentroutine = other.getMainorcurrentroutine();
            if (this$mainorcurrentroutine == null ? other$mainorcurrentroutine == null : this$mainorcurrentroutine.equals(other$mainorcurrentroutine)) {
               Object this$modcode = this.getModcode();
               Object other$modcode = other.getModcode();
               if (this$modcode == null ? other$modcode == null : this$modcode.equals(other$modcode)) {
                  Object this$processfileurl = this.getProcessfileurl();
                  Object other$processfileurl = other.getProcessfileurl();
                  if (this$processfileurl == null ? other$processfileurl == null : this$processfileurl.equals(other$processfileurl)) {
                     Object this$starttime = this.getStarttime();
                     Object other$starttime = other.getStarttime();
                     return this$starttime == null ? other$starttime == null : this$starttime.equals(other$starttime);
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
      return other instanceof PlcData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getDeviceid();
      result = result * 59 + this.getNum();
      Object $constructcode = this.getConstructcode();
      result = result * 59 + ($constructcode == null ? 43 : $constructcode.hashCode());
      Object $equipmentname = this.getEquipmentname();
      result = result * 59 + ($equipmentname == null ? 43 : $equipmentname.hashCode());
      Object $mainorcurrentroutine = this.getMainorcurrentroutine();
      result = result * 59 + ($mainorcurrentroutine == null ? 43 : $mainorcurrentroutine.hashCode());
      Object $modcode = this.getModcode();
      result = result * 59 + ($modcode == null ? 43 : $modcode.hashCode());
      Object $processfileurl = this.getProcessfileurl();
      result = result * 59 + ($processfileurl == null ? 43 : $processfileurl.hashCode());
      Object $starttime = this.getStarttime();
      return result * 59 + ($starttime == null ? 43 : $starttime.hashCode());
   }

   @Override
   public String toString() {
      return "PlcData(constructcode="
         + this.getConstructcode()
         + ", deviceid="
         + this.getDeviceid()
         + ", equipmentname="
         + this.getEquipmentname()
         + ", mainorcurrentroutine="
         + this.getMainorcurrentroutine()
         + ", modcode="
         + this.getModcode()
         + ", num="
         + this.getNum()
         + ", processfileurl="
         + this.getProcessfileurl()
         + ", starttime="
         + this.getStarttime()
         + ")";
   }

   public PlcData(
      final String constructcode,
      final int deviceid,
      final String equipmentname,
      final String mainorcurrentroutine,
      final String modcode,
      final int num,
      final String processfileurl,
      final String starttime
   ) {
      this.constructcode = constructcode;
      this.deviceid = deviceid;
      this.equipmentname = equipmentname;
      this.mainorcurrentroutine = mainorcurrentroutine;
      this.modcode = modcode;
      this.num = num;
      this.processfileurl = processfileurl;
      this.starttime = starttime;
   }

   public PlcData() {
   }

   public static class PlcDataBuilder {
      private String constructcode;
      private int deviceid;
      private String equipmentname;
      private String mainorcurrentroutine;
      private String modcode;
      private int num;
      private String processfileurl;
      private String starttime;

      PlcDataBuilder() {
      }

      public PlcData.PlcDataBuilder constructcode(final String constructcode) {
         this.constructcode = constructcode;
         return this;
      }

      public PlcData.PlcDataBuilder deviceid(final int deviceid) {
         this.deviceid = deviceid;
         return this;
      }

      public PlcData.PlcDataBuilder equipmentname(final String equipmentname) {
         this.equipmentname = equipmentname;
         return this;
      }

      public PlcData.PlcDataBuilder mainorcurrentroutine(final String mainorcurrentroutine) {
         this.mainorcurrentroutine = mainorcurrentroutine;
         return this;
      }

      public PlcData.PlcDataBuilder modcode(final String modcode) {
         this.modcode = modcode;
         return this;
      }

      public PlcData.PlcDataBuilder num(final int num) {
         this.num = num;
         return this;
      }

      public PlcData.PlcDataBuilder processfileurl(final String processfileurl) {
         this.processfileurl = processfileurl;
         return this;
      }

      public PlcData.PlcDataBuilder starttime(final String starttime) {
         this.starttime = starttime;
         return this;
      }

      public PlcData build() {
         return new PlcData(
            this.constructcode, this.deviceid, this.equipmentname, this.mainorcurrentroutine, this.modcode, this.num, this.processfileurl, this.starttime
         );
      }

      @Override
      public String toString() {
         return "PlcData.PlcDataBuilder(constructcode="
            + this.constructcode
            + ", deviceid="
            + this.deviceid
            + ", equipmentname="
            + this.equipmentname
            + ", mainorcurrentroutine="
            + this.mainorcurrentroutine
            + ", modcode="
            + this.modcode
            + ", num="
            + this.num
            + ", processfileurl="
            + this.processfileurl
            + ", starttime="
            + this.starttime
            + ")";
      }
   }
}
