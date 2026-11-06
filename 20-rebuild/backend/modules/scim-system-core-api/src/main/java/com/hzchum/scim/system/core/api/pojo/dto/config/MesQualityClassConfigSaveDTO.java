package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MesQualityClassConfigSaveDTO implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "factoryOrConstructionSite", notes = "工厂或工地[0工厂，1工地]")
   @NotNull(message = "请选择工厂或工地")
   private Integer factoryOrConstructionSite;
   @ApiModelProperty(name = "pid", value = "父类id", notes = "父类id")
   @NotNull(message = "Pid不能为空")
   private Long pid;
   @ApiModelProperty(name = "质检问题数据", notes = "质检问题数据")
   @NotNull(message = "分类数据不能为空")
   @Size(min = 1, message = "分类数据至少包含一个元素")
   private List<MesQualityClassConfigDTO> classConfigs;

   public static MesQualityClassConfigSaveDTO.MesQualityClassConfigSaveDTOBuilder builder() {
      return new MesQualityClassConfigSaveDTO.MesQualityClassConfigSaveDTOBuilder();
   }

   public MesQualityClassConfigSaveDTO() {
   }

   public MesQualityClassConfigSaveDTO(final Integer factoryOrConstructionSite, final Long pid, final List<MesQualityClassConfigDTO> classConfigs) {
      this.factoryOrConstructionSite = factoryOrConstructionSite;
      this.pid = pid;
      this.classConfigs = classConfigs;
   }

   public Integer getFactoryOrConstructionSite() {
      return this.factoryOrConstructionSite;
   }

   public Long getPid() {
      return this.pid;
   }

   public List<MesQualityClassConfigDTO> getClassConfigs() {
      return this.classConfigs;
   }

   public void setFactoryOrConstructionSite(final Integer factoryOrConstructionSite) {
      this.factoryOrConstructionSite = factoryOrConstructionSite;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setClassConfigs(final List<MesQualityClassConfigDTO> classConfigs) {
      this.classConfigs = classConfigs;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQualityClassConfigSaveDTO)) {
         return false;
      }

      MesQualityClassConfigSaveDTO other = (MesQualityClassConfigSaveDTO)o;
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
            Object this$classConfigs = this.getClassConfigs();
            Object other$classConfigs = other.getClassConfigs();
            return this$classConfigs == null ? other$classConfigs == null : this$classConfigs.equals(other$classConfigs);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesQualityClassConfigSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryOrConstructionSite = this.getFactoryOrConstructionSite();
      result = result * 59 + ($factoryOrConstructionSite == null ? 43 : $factoryOrConstructionSite.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $classConfigs = this.getClassConfigs();
      return result * 59 + ($classConfigs == null ? 43 : $classConfigs.hashCode());
   }

   @Override
   public String toString() {
      return "MesQualityClassConfigSaveDTO(factoryOrConstructionSite="
         + this.getFactoryOrConstructionSite()
         + ", pid="
         + this.getPid()
         + ", classConfigs="
         + this.getClassConfigs()
         + ")";
   }

   public static class MesQualityClassConfigSaveDTOBuilder {
      private Integer factoryOrConstructionSite;
      private Long pid;
      private List<MesQualityClassConfigDTO> classConfigs;

      MesQualityClassConfigSaveDTOBuilder() {
      }

      public MesQualityClassConfigSaveDTO.MesQualityClassConfigSaveDTOBuilder factoryOrConstructionSite(final Integer factoryOrConstructionSite) {
         this.factoryOrConstructionSite = factoryOrConstructionSite;
         return this;
      }

      public MesQualityClassConfigSaveDTO.MesQualityClassConfigSaveDTOBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public MesQualityClassConfigSaveDTO.MesQualityClassConfigSaveDTOBuilder classConfigs(final List<MesQualityClassConfigDTO> classConfigs) {
         this.classConfigs = classConfigs;
         return this;
      }

      public MesQualityClassConfigSaveDTO build() {
         return new MesQualityClassConfigSaveDTO(this.factoryOrConstructionSite, this.pid, this.classConfigs);
      }

      @Override
      public String toString() {
         return "MesQualityClassConfigSaveDTO.MesQualityClassConfigSaveDTOBuilder(factoryOrConstructionSite="
            + this.factoryOrConstructionSite
            + ", pid="
            + this.pid
            + ", classConfigs="
            + this.classConfigs
            + ")";
      }
   }
}
