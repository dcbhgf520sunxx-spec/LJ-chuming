package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingCutDetailConfigDTO", description = "切割配置详情 ")
public class MesBuildingCutDetailConfigDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "thickness", value = "钢板厚度", notes = "钢板厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private Integer thickness;
   @ApiModelProperty(name = "boolDrillEnum", value = "是否钻孔 [0 禁用, 1 启用]", notes = "是否钻孔 [0 禁用, 1 启用]")
   @JsonProperty("boolDrillEnum")
   @JSONField(name = "boolDrillEnum")
   private Boolean boolDrillEnum;

   public static MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder builder() {
      return new MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder();
   }

   public MesBuildingCutDetailConfigDTO() {
   }

   public MesBuildingCutDetailConfigDTO(final Long id, final Long cutConfigId, final Integer thickness, final Boolean boolDrillEnum) {
      this.id = id;
      this.cutConfigId = cutConfigId;
      this.thickness = thickness;
      this.boolDrillEnum = boolDrillEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public Boolean getBoolDrillEnum() {
      return this.boolDrillEnum;
   }

   @JsonProperty("id")
   public MesBuildingCutDetailConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingCutDetailConfigDTO setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingCutDetailConfigDTO setThickness(final Integer thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("boolDrillEnum")
   public MesBuildingCutDetailConfigDTO setBoolDrillEnum(final Boolean boolDrillEnum) {
      this.boolDrillEnum = boolDrillEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCutDetailConfigDTO(id="
         + this.getId()
         + ", cutConfigId="
         + this.getCutConfigId()
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

      if (!(o instanceof MesBuildingCutDetailConfigDTO)) {
         return false;
      }

      MesBuildingCutDetailConfigDTO other = (MesBuildingCutDetailConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$thickness = this.getThickness();
            Object other$thickness = other.getThickness();
            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
               Object this$boolDrillEnum = this.getBoolDrillEnum();
               Object other$boolDrillEnum = other.getBoolDrillEnum();
               return this$boolDrillEnum == null ? other$boolDrillEnum == null : this$boolDrillEnum.equals(other$boolDrillEnum);
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
      return other instanceof MesBuildingCutDetailConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $boolDrillEnum = this.getBoolDrillEnum();
      return result * 59 + ($boolDrillEnum == null ? 43 : $boolDrillEnum.hashCode());
   }

   public static class MesBuildingCutDetailConfigDTOBuilder {
      private Long id;
      private Long cutConfigId;
      private Integer thickness;
      private Boolean boolDrillEnum;

      MesBuildingCutDetailConfigDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("boolDrillEnum")
      public MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder boolDrillEnum(final Boolean boolDrillEnum) {
         this.boolDrillEnum = boolDrillEnum;
         return this;
      }

      public MesBuildingCutDetailConfigDTO build() {
         return new MesBuildingCutDetailConfigDTO(this.id, this.cutConfigId, this.thickness, this.boolDrillEnum);
      }

      @Override
      public String toString() {
         return "MesBuildingCutDetailConfigDTO.MesBuildingCutDetailConfigDTOBuilder(id="
            + this.id
            + ", cutConfigId="
            + this.cutConfigId
            + ", thickness="
            + this.thickness
            + ", boolDrillEnum="
            + this.boolDrillEnum
            + ")";
      }
   }
}
