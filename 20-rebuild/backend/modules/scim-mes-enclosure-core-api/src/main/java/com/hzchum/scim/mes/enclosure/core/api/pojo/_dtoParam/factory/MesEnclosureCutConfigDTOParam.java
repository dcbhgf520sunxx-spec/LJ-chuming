package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureCutConfigDTOParam", description = "切割配置 ")
public class MesEnclosureCutConfigDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   private Long cutConfigId;
   @ApiModelProperty(name = "name", value = "切割类型名称", notes = "切割类型名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否套料", notes = "是否套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "thickness", value = "钢板厚度范围(≤)", notes = "钢板厚度范围")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private String thickness;
   @ApiModelProperty(name = "cuttingHolesJoint", value = "切孔联割半径范围(≥)", notes = "切孔联割半径范围(≥)")
   @JsonProperty("cuttingHolesJoint")
   @JSONField(name = "cuttingHolesJoint")
   private BigDecimal cuttingHolesJoint;

   public static MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder builder() {
      return new MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder();
   }

   public MesEnclosureCutConfigDTOParam() {
   }

   public MesEnclosureCutConfigDTOParam(
      final Long id, final Long cutConfigId, final String name, final Boolean boolNestCutEnum, final String thickness, final BigDecimal cuttingHolesJoint
   ) {
      this.id = id;
      this.cutConfigId = cutConfigId;
      this.name = name;
      this.boolNestCutEnum = boolNestCutEnum;
      this.thickness = thickness;
      this.cuttingHolesJoint = cuttingHolesJoint;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public String getThickness() {
      return this.thickness;
   }

   public BigDecimal getCuttingHolesJoint() {
      return this.cuttingHolesJoint;
   }

   @JsonProperty("id")
   public MesEnclosureCutConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureCutConfigDTOParam setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureCutConfigDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesEnclosureCutConfigDTOParam setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("thickness")
   public MesEnclosureCutConfigDTOParam setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("cuttingHolesJoint")
   public MesEnclosureCutConfigDTOParam setCuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
      this.cuttingHolesJoint = cuttingHolesJoint;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureCutConfigDTOParam(id="
         + this.getId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", name="
         + this.getName()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", thickness="
         + this.getThickness()
         + ", cuttingHolesJoint="
         + this.getCuttingHolesJoint()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCutConfigDTOParam)) {
         return false;
      }

      MesEnclosureCutConfigDTOParam other = (MesEnclosureCutConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$boolNestCutEnum = this.getBoolNestCutEnum();
            Object other$boolNestCutEnum = other.getBoolNestCutEnum();
            if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$cuttingHolesJoint = this.getCuttingHolesJoint();
                     Object other$cuttingHolesJoint = other.getCuttingHolesJoint();
                     return this$cuttingHolesJoint == null ? other$cuttingHolesJoint == null : this$cuttingHolesJoint.equals(other$cuttingHolesJoint);
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
      return other instanceof MesEnclosureCutConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $cuttingHolesJoint = this.getCuttingHolesJoint();
      return result * 59 + ($cuttingHolesJoint == null ? 43 : $cuttingHolesJoint.hashCode());
   }

   public static class MesEnclosureCutConfigDTOParamBuilder {
      private Long id;
      private Long cutConfigId;
      private String name;
      private Boolean boolNestCutEnum;
      private String thickness;
      private BigDecimal cuttingHolesJoint;

      MesEnclosureCutConfigDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("thickness")
      public MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("cuttingHolesJoint")
      public MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder cuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
         this.cuttingHolesJoint = cuttingHolesJoint;
         return this;
      }

      public MesEnclosureCutConfigDTOParam build() {
         return new MesEnclosureCutConfigDTOParam(this.id, this.cutConfigId, this.name, this.boolNestCutEnum, this.thickness, this.cuttingHolesJoint);
      }

      @Override
      public String toString() {
         return "MesEnclosureCutConfigDTOParam.MesEnclosureCutConfigDTOParamBuilder(id="
            + this.id
            + ", cutConfigId="
            + this.cutConfigId
            + ", name="
            + this.name
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", thickness="
            + this.thickness
            + ", cuttingHolesJoint="
            + this.cuttingHolesJoint
            + ")";
      }
   }
}
