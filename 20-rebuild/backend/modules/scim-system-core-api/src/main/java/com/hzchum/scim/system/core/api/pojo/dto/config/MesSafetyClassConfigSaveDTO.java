package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class MesSafetyClassConfigSaveDTO {
   @ApiModelProperty(name = "factoryOrConstructionSite", notes = "工厂或工地[0工厂，1工地]")
   @NotNull(message = "请选择工厂或工地")
   private Integer factoryOrConstructionSite;
   @ApiModelProperty(name = "pid", value = "父类id", notes = "父类id")
   private Long pid;
   @ApiModelProperty(name = "type", value = "安环类型 (2 安全问题/4 环境问题)", notes = "安环类型(2 安全问题/4 环境问题)")
   private Integer type;
   @ApiModelProperty(name = "安环分类数据", notes = "安环分类数据")
   @NotNull(message = "安环分类数据不能为空")
   private List<MesSafetyClassConfigDTO> safetyConfigs;

   public static MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder builder() {
      return new MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder();
   }

   public MesSafetyClassConfigSaveDTO() {
   }

   public MesSafetyClassConfigSaveDTO(
      final Integer factoryOrConstructionSite, final Long pid, final Integer type, final List<MesSafetyClassConfigDTO> safetyConfigs
   ) {
      this.factoryOrConstructionSite = factoryOrConstructionSite;
      this.pid = pid;
      this.type = type;
      this.safetyConfigs = safetyConfigs;
   }

   public Integer getFactoryOrConstructionSite() {
      return this.factoryOrConstructionSite;
   }

   public Long getPid() {
      return this.pid;
   }

   public Integer getType() {
      return this.type;
   }

   public List<MesSafetyClassConfigDTO> getSafetyConfigs() {
      return this.safetyConfigs;
   }

   public void setFactoryOrConstructionSite(final Integer factoryOrConstructionSite) {
      this.factoryOrConstructionSite = factoryOrConstructionSite;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSafetyConfigs(final List<MesSafetyClassConfigDTO> safetyConfigs) {
      this.safetyConfigs = safetyConfigs;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSafetyClassConfigSaveDTO)) {
         return false;
      }

      MesSafetyClassConfigSaveDTO other = (MesSafetyClassConfigSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryOrConstructionSite = this.getFactoryOrConstructionSite();
      Object other$factoryOrConstructionSite = other.getFactoryOrConstructionSite();
      if (this$factoryOrConstructionSite == null
         ? other$factoryOrConstructionSite == null
         : this$factoryOrConstructionSite.equals(other$factoryOrConstructionSite)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$safetyConfigs = this.getSafetyConfigs();
               Object other$safetyConfigs = other.getSafetyConfigs();
               return this$safetyConfigs == null ? other$safetyConfigs == null : this$safetyConfigs.equals(other$safetyConfigs);
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
      return other instanceof MesSafetyClassConfigSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryOrConstructionSite = this.getFactoryOrConstructionSite();
      result = result * 59 + ($factoryOrConstructionSite == null ? 43 : $factoryOrConstructionSite.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $safetyConfigs = this.getSafetyConfigs();
      return result * 59 + ($safetyConfigs == null ? 43 : $safetyConfigs.hashCode());
   }

   @Override
   public String toString() {
      return "MesSafetyClassConfigSaveDTO(factoryOrConstructionSite="
         + this.getFactoryOrConstructionSite()
         + ", pid="
         + this.getPid()
         + ", type="
         + this.getType()
         + ", safetyConfigs="
         + this.getSafetyConfigs()
         + ")";
   }

   public static class MesSafetyClassConfigSaveDTOBuilder {
      private Integer factoryOrConstructionSite;
      private Long pid;
      private Integer type;
      private List<MesSafetyClassConfigDTO> safetyConfigs;

      MesSafetyClassConfigSaveDTOBuilder() {
      }

      public MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder factoryOrConstructionSite(final Integer factoryOrConstructionSite) {
         this.factoryOrConstructionSite = factoryOrConstructionSite;
         return this;
      }

      public MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder safetyConfigs(final List<MesSafetyClassConfigDTO> safetyConfigs) {
         this.safetyConfigs = safetyConfigs;
         return this;
      }

      public MesSafetyClassConfigSaveDTO build() {
         return new MesSafetyClassConfigSaveDTO(this.factoryOrConstructionSite, this.pid, this.type, this.safetyConfigs);
      }

      @Override
      public String toString() {
         return "MesSafetyClassConfigSaveDTO.MesSafetyClassConfigSaveDTOBuilder(factoryOrConstructionSite="
            + this.factoryOrConstructionSite
            + ", pid="
            + this.pid
            + ", type="
            + this.type
            + ", safetyConfigs="
            + this.safetyConfigs
            + ")";
      }
   }
}
