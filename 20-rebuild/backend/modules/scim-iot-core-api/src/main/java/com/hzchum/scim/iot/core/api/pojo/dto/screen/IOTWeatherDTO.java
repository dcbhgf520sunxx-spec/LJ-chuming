package com.hzchum.scim.iot.core.api.pojo.dto.screen;

import java.util.List;

public class IOTWeatherDTO {
   private String status;
   private String count;
   private String info;
   private String infocode;
   private List<Lives> lives;

   public static IOTWeatherDTO.IOTWeatherDTOBuilder builder() {
      return new IOTWeatherDTO.IOTWeatherDTOBuilder();
   }

   public String getStatus() {
      return this.status;
   }

   public String getCount() {
      return this.count;
   }

   public String getInfo() {
      return this.info;
   }

   public String getInfocode() {
      return this.infocode;
   }

   public List<Lives> getLives() {
      return this.lives;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setCount(final String count) {
      this.count = count;
   }

   public void setInfo(final String info) {
      this.info = info;
   }

   public void setInfocode(final String infocode) {
      this.infocode = infocode;
   }

   public void setLives(final List<Lives> lives) {
      this.lives = lives;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IOTWeatherDTO)) {
         return false;
      }

      IOTWeatherDTO other = (IOTWeatherDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$count = this.getCount();
         Object other$count = other.getCount();
         if (this$count == null ? other$count == null : this$count.equals(other$count)) {
            Object this$info = this.getInfo();
            Object other$info = other.getInfo();
            if (this$info == null ? other$info == null : this$info.equals(other$info)) {
               Object this$infocode = this.getInfocode();
               Object other$infocode = other.getInfocode();
               if (this$infocode == null ? other$infocode == null : this$infocode.equals(other$infocode)) {
                  Object this$lives = this.getLives();
                  Object other$lives = other.getLives();
                  return this$lives == null ? other$lives == null : this$lives.equals(other$lives);
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
      return other instanceof IOTWeatherDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $count = this.getCount();
      result = result * 59 + ($count == null ? 43 : $count.hashCode());
      Object $info = this.getInfo();
      result = result * 59 + ($info == null ? 43 : $info.hashCode());
      Object $infocode = this.getInfocode();
      result = result * 59 + ($infocode == null ? 43 : $infocode.hashCode());
      Object $lives = this.getLives();
      return result * 59 + ($lives == null ? 43 : $lives.hashCode());
   }

   @Override
   public String toString() {
      return "IOTWeatherDTO(status="
         + this.getStatus()
         + ", count="
         + this.getCount()
         + ", info="
         + this.getInfo()
         + ", infocode="
         + this.getInfocode()
         + ", lives="
         + this.getLives()
         + ")";
   }

   public IOTWeatherDTO(final String status, final String count, final String info, final String infocode, final List<Lives> lives) {
      this.status = status;
      this.count = count;
      this.info = info;
      this.infocode = infocode;
      this.lives = lives;
   }

   public IOTWeatherDTO() {
   }

   public static class IOTWeatherDTOBuilder {
      private String status;
      private String count;
      private String info;
      private String infocode;
      private List<Lives> lives;

      IOTWeatherDTOBuilder() {
      }

      public IOTWeatherDTO.IOTWeatherDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public IOTWeatherDTO.IOTWeatherDTOBuilder count(final String count) {
         this.count = count;
         return this;
      }

      public IOTWeatherDTO.IOTWeatherDTOBuilder info(final String info) {
         this.info = info;
         return this;
      }

      public IOTWeatherDTO.IOTWeatherDTOBuilder infocode(final String infocode) {
         this.infocode = infocode;
         return this;
      }

      public IOTWeatherDTO.IOTWeatherDTOBuilder lives(final List<Lives> lives) {
         this.lives = lives;
         return this;
      }

      public IOTWeatherDTO build() {
         return new IOTWeatherDTO(this.status, this.count, this.info, this.infocode, this.lives);
      }

      @Override
      public String toString() {
         return "IOTWeatherDTO.IOTWeatherDTOBuilder(status="
            + this.status
            + ", count="
            + this.count
            + ", info="
            + this.info
            + ", infocode="
            + this.infocode
            + ", lives="
            + this.lives
            + ")";
      }
   }
}
