package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingCutConfigDO", description = "车间 ")
public class MesBuildingCutConfigDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "切割类型", notes = "切割类型")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "thickness", value = "钢板厚度", notes = "钢板厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private Integer thickness;
   @ApiModelProperty(name = "boolDrillEnum", value = "是否钻孔 [0 禁用, 1 启用]", notes = "是否钻孔 [0 禁用, 1 启用]")
   @JsonProperty("boolDrillEnum")
   @JSONField(name = "boolDrillEnum")
   private Boolean boolDrillEnum;

   public static MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder builder() {
      return new MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder();
   }

   public MesBuildingCutConfigDO() {
   }

   public MesBuildingCutConfigDO(final Long id, final String name, final Integer thickness, final Boolean boolDrillEnum) {
      this.id = id;
      this.name = name;
      this.thickness = thickness;
      this.boolDrillEnum = boolDrillEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public Boolean getBoolDrillEnum() {
      return this.boolDrillEnum;
   }

   @JsonProperty("id")
   public MesBuildingCutConfigDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingCutConfigDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingCutConfigDO setThickness(final Integer thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("boolDrillEnum")
   public MesBuildingCutConfigDO setBoolDrillEnum(final Boolean boolDrillEnum) {
      this.boolDrillEnum = boolDrillEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCutConfigDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", thickness="
         + this.getThickness()
         + ", boolDrillEnum="
         + this.getBoolDrillEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCutConfigDO)) {
         return false;
      }

      MesBuildingCutConfigDO other = (MesBuildingCutConfigDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$thickness = this.getThickness();
         Object other$thickness = other.getThickness();
         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
            Object this$boolDrillEnum = this.getBoolDrillEnum();
            Object other$boolDrillEnum = other.getBoolDrillEnum();
            if (this$boolDrillEnum == null ? other$boolDrillEnum == null : this$boolDrillEnum.equals(other$boolDrillEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesBuildingCutConfigDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $boolDrillEnum = this.getBoolDrillEnum();
      result = result * 59 + ($boolDrillEnum == null ? 43 : $boolDrillEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingCutConfigDOBuilder {
      private Long id;
      private String name;
      private Integer thickness;
      private Boolean boolDrillEnum;

      MesBuildingCutConfigDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("boolDrillEnum")
      public MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder boolDrillEnum(final Boolean boolDrillEnum) {
         this.boolDrillEnum = boolDrillEnum;
         return this;
      }

      public MesBuildingCutConfigDO build() {
         return new MesBuildingCutConfigDO(this.id, this.name, this.thickness, this.boolDrillEnum);
      }

      @Override
      public String toString() {
         return "MesBuildingCutConfigDO.MesBuildingCutConfigDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", thickness="
            + this.thickness
            + ", boolDrillEnum="
            + this.boolDrillEnum
            + ")";
      }
   }
}
