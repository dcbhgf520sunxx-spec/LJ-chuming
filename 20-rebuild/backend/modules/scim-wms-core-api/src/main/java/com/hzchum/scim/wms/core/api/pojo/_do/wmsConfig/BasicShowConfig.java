package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import io.swagger.annotations.ApiModelProperty;

public class BasicShowConfig {
   @ApiModelProperty(name = "steelsSpeShowConfig", value = "钢材规格展示方式配置", notes = "1： 其他 * 规格 2: 规格 * 其他")
   private Integer steelsSpeShowConfig;

   public static BasicShowConfig.BasicShowConfigBuilder builder() {
      return new BasicShowConfig.BasicShowConfigBuilder();
   }

   public Integer getSteelsSpeShowConfig() {
      return this.steelsSpeShowConfig;
   }

   public void setSteelsSpeShowConfig(final Integer steelsSpeShowConfig) {
      this.steelsSpeShowConfig = steelsSpeShowConfig;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicShowConfig)) {
         return false;
      }

      BasicShowConfig other = (BasicShowConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelsSpeShowConfig = this.getSteelsSpeShowConfig();
      Object other$steelsSpeShowConfig = other.getSteelsSpeShowConfig();
      return this$steelsSpeShowConfig == null ? other$steelsSpeShowConfig == null : this$steelsSpeShowConfig.equals(other$steelsSpeShowConfig);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BasicShowConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelsSpeShowConfig = this.getSteelsSpeShowConfig();
      return result * 59 + ($steelsSpeShowConfig == null ? 43 : $steelsSpeShowConfig.hashCode());
   }

   @Override
   public String toString() {
      return "BasicShowConfig(steelsSpeShowConfig=" + this.getSteelsSpeShowConfig() + ")";
   }

   public BasicShowConfig(final Integer steelsSpeShowConfig) {
      this.steelsSpeShowConfig = steelsSpeShowConfig;
   }

   public BasicShowConfig() {
   }

   public static class BasicShowConfigBuilder {
      private Integer steelsSpeShowConfig;

      BasicShowConfigBuilder() {
      }

      public BasicShowConfig.BasicShowConfigBuilder steelsSpeShowConfig(final Integer steelsSpeShowConfig) {
         this.steelsSpeShowConfig = steelsSpeShowConfig;
         return this;
      }

      public BasicShowConfig build() {
         return new BasicShowConfig(this.steelsSpeShowConfig);
      }

      @Override
      public String toString() {
         return "BasicShowConfig.BasicShowConfigBuilder(steelsSpeShowConfig=" + this.steelsSpeShowConfig + ")";
      }
   }
}
