package com.hzchum.scim.iot.core.api.pojo.dto.screen;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lives {
   private String province;
   private String city;
   private String adcode;
   private String weather;
   private String temperature;
   private String winddirection;
   private String windpower;
   private String humidity;
   private String reporttime;
   @JsonProperty("temperature_float")
   private String temperatureFloat;
   @JsonProperty("humidity_float")
   private String humidityFloat;

   public static Lives.LivesBuilder builder() {
      return new Lives.LivesBuilder();
   }

   public String getProvince() {
      return this.province;
   }

   public String getCity() {
      return this.city;
   }

   public String getAdcode() {
      return this.adcode;
   }

   public String getWeather() {
      return this.weather;
   }

   public String getTemperature() {
      return this.temperature;
   }

   public String getWinddirection() {
      return this.winddirection;
   }

   public String getWindpower() {
      return this.windpower;
   }

   public String getHumidity() {
      return this.humidity;
   }

   public String getReporttime() {
      return this.reporttime;
   }

   public String getTemperatureFloat() {
      return this.temperatureFloat;
   }

   public String getHumidityFloat() {
      return this.humidityFloat;
   }

   public void setProvince(final String province) {
      this.province = province;
   }

   public void setCity(final String city) {
      this.city = city;
   }

   public void setAdcode(final String adcode) {
      this.adcode = adcode;
   }

   public void setWeather(final String weather) {
      this.weather = weather;
   }

   public void setTemperature(final String temperature) {
      this.temperature = temperature;
   }

   public void setWinddirection(final String winddirection) {
      this.winddirection = winddirection;
   }

   public void setWindpower(final String windpower) {
      this.windpower = windpower;
   }

   public void setHumidity(final String humidity) {
      this.humidity = humidity;
   }

   public void setReporttime(final String reporttime) {
      this.reporttime = reporttime;
   }

   @JsonProperty("temperature_float")
   public void setTemperatureFloat(final String temperatureFloat) {
      this.temperatureFloat = temperatureFloat;
   }

   @JsonProperty("humidity_float")
   public void setHumidityFloat(final String humidityFloat) {
      this.humidityFloat = humidityFloat;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Lives)) {
         return false;
      }

      Lives other = (Lives)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$province = this.getProvince();
      Object other$province = other.getProvince();
      if (this$province == null ? other$province == null : this$province.equals(other$province)) {
         Object this$city = this.getCity();
         Object other$city = other.getCity();
         if (this$city == null ? other$city == null : this$city.equals(other$city)) {
            Object this$adcode = this.getAdcode();
            Object other$adcode = other.getAdcode();
            if (this$adcode == null ? other$adcode == null : this$adcode.equals(other$adcode)) {
               Object this$weather = this.getWeather();
               Object other$weather = other.getWeather();
               if (this$weather == null ? other$weather == null : this$weather.equals(other$weather)) {
                  Object this$temperature = this.getTemperature();
                  Object other$temperature = other.getTemperature();
                  if (this$temperature == null ? other$temperature == null : this$temperature.equals(other$temperature)) {
                     Object this$winddirection = this.getWinddirection();
                     Object other$winddirection = other.getWinddirection();
                     if (this$winddirection == null ? other$winddirection == null : this$winddirection.equals(other$winddirection)) {
                        Object this$windpower = this.getWindpower();
                        Object other$windpower = other.getWindpower();
                        if (this$windpower == null ? other$windpower == null : this$windpower.equals(other$windpower)) {
                           Object this$humidity = this.getHumidity();
                           Object other$humidity = other.getHumidity();
                           if (this$humidity == null ? other$humidity == null : this$humidity.equals(other$humidity)) {
                              Object this$reporttime = this.getReporttime();
                              Object other$reporttime = other.getReporttime();
                              if (this$reporttime == null ? other$reporttime == null : this$reporttime.equals(other$reporttime)) {
                                 Object this$temperatureFloat = this.getTemperatureFloat();
                                 Object other$temperatureFloat = other.getTemperatureFloat();
                                 if (this$temperatureFloat == null ? other$temperatureFloat == null : this$temperatureFloat.equals(other$temperatureFloat)) {
                                    Object this$humidityFloat = this.getHumidityFloat();
                                    Object other$humidityFloat = other.getHumidityFloat();
                                    return this$humidityFloat == null ? other$humidityFloat == null : this$humidityFloat.equals(other$humidityFloat);
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
      return other instanceof Lives;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $province = this.getProvince();
      result = result * 59 + ($province == null ? 43 : $province.hashCode());
      Object $city = this.getCity();
      result = result * 59 + ($city == null ? 43 : $city.hashCode());
      Object $adcode = this.getAdcode();
      result = result * 59 + ($adcode == null ? 43 : $adcode.hashCode());
      Object $weather = this.getWeather();
      result = result * 59 + ($weather == null ? 43 : $weather.hashCode());
      Object $temperature = this.getTemperature();
      result = result * 59 + ($temperature == null ? 43 : $temperature.hashCode());
      Object $winddirection = this.getWinddirection();
      result = result * 59 + ($winddirection == null ? 43 : $winddirection.hashCode());
      Object $windpower = this.getWindpower();
      result = result * 59 + ($windpower == null ? 43 : $windpower.hashCode());
      Object $humidity = this.getHumidity();
      result = result * 59 + ($humidity == null ? 43 : $humidity.hashCode());
      Object $reporttime = this.getReporttime();
      result = result * 59 + ($reporttime == null ? 43 : $reporttime.hashCode());
      Object $temperatureFloat = this.getTemperatureFloat();
      result = result * 59 + ($temperatureFloat == null ? 43 : $temperatureFloat.hashCode());
      Object $humidityFloat = this.getHumidityFloat();
      return result * 59 + ($humidityFloat == null ? 43 : $humidityFloat.hashCode());
   }

   @Override
   public String toString() {
      return "Lives(province="
         + this.getProvince()
         + ", city="
         + this.getCity()
         + ", adcode="
         + this.getAdcode()
         + ", weather="
         + this.getWeather()
         + ", temperature="
         + this.getTemperature()
         + ", winddirection="
         + this.getWinddirection()
         + ", windpower="
         + this.getWindpower()
         + ", humidity="
         + this.getHumidity()
         + ", reporttime="
         + this.getReporttime()
         + ", temperatureFloat="
         + this.getTemperatureFloat()
         + ", humidityFloat="
         + this.getHumidityFloat()
         + ")";
   }

   public Lives(
      final String province,
      final String city,
      final String adcode,
      final String weather,
      final String temperature,
      final String winddirection,
      final String windpower,
      final String humidity,
      final String reporttime,
      final String temperatureFloat,
      final String humidityFloat
   ) {
      this.province = province;
      this.city = city;
      this.adcode = adcode;
      this.weather = weather;
      this.temperature = temperature;
      this.winddirection = winddirection;
      this.windpower = windpower;
      this.humidity = humidity;
      this.reporttime = reporttime;
      this.temperatureFloat = temperatureFloat;
      this.humidityFloat = humidityFloat;
   }

   public Lives() {
   }

   public static class LivesBuilder {
      private String province;
      private String city;
      private String adcode;
      private String weather;
      private String temperature;
      private String winddirection;
      private String windpower;
      private String humidity;
      private String reporttime;
      private String temperatureFloat;
      private String humidityFloat;

      LivesBuilder() {
      }

      public Lives.LivesBuilder province(final String province) {
         this.province = province;
         return this;
      }

      public Lives.LivesBuilder city(final String city) {
         this.city = city;
         return this;
      }

      public Lives.LivesBuilder adcode(final String adcode) {
         this.adcode = adcode;
         return this;
      }

      public Lives.LivesBuilder weather(final String weather) {
         this.weather = weather;
         return this;
      }

      public Lives.LivesBuilder temperature(final String temperature) {
         this.temperature = temperature;
         return this;
      }

      public Lives.LivesBuilder winddirection(final String winddirection) {
         this.winddirection = winddirection;
         return this;
      }

      public Lives.LivesBuilder windpower(final String windpower) {
         this.windpower = windpower;
         return this;
      }

      public Lives.LivesBuilder humidity(final String humidity) {
         this.humidity = humidity;
         return this;
      }

      public Lives.LivesBuilder reporttime(final String reporttime) {
         this.reporttime = reporttime;
         return this;
      }

      @JsonProperty("temperature_float")
      public Lives.LivesBuilder temperatureFloat(final String temperatureFloat) {
         this.temperatureFloat = temperatureFloat;
         return this;
      }

      @JsonProperty("humidity_float")
      public Lives.LivesBuilder humidityFloat(final String humidityFloat) {
         this.humidityFloat = humidityFloat;
         return this;
      }

      public Lives build() {
         return new Lives(
            this.province,
            this.city,
            this.adcode,
            this.weather,
            this.temperature,
            this.winddirection,
            this.windpower,
            this.humidity,
            this.reporttime,
            this.temperatureFloat,
            this.humidityFloat
         );
      }

      @Override
      public String toString() {
         return "Lives.LivesBuilder(province="
            + this.province
            + ", city="
            + this.city
            + ", adcode="
            + this.adcode
            + ", weather="
            + this.weather
            + ", temperature="
            + this.temperature
            + ", winddirection="
            + this.winddirection
            + ", windpower="
            + this.windpower
            + ", humidity="
            + this.humidity
            + ", reporttime="
            + this.reporttime
            + ", temperatureFloat="
            + this.temperatureFloat
            + ", humidityFloat="
            + this.humidityFloat
            + ")";
      }
   }
}
