package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingCutConfigDTOParam", description = "切割配置 ")
public class MesBuildingCutConfigDTOParam {
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
   @ApiModelProperty(name = "boolDrillHole", value = "是否板孔联割", notes = "是否板孔联割")
   @JsonProperty("boolDrillHole")
   @JSONField(name = "boolDrillHole")
   private Integer boolDrillHole;
   @ApiModelProperty(name = "minThickness", value = "钢板厚度范围最小值(≤)", notes = "钢板厚度范围最小值(≤)")
   @JsonProperty("minThickness")
   @JSONField(name = "minThickness")
   private String minThickness;
   @ApiModelProperty(name = "maxThickness", value = "钢板厚度范围最大值(≥)", notes = "钢板厚度范围最大值(≥)")
   @JsonProperty("maxThickness")
   @JSONField(name = "maxThickness")
   private String maxThickness;
   @ApiModelProperty(name = "cuttingHolesJoint", value = "切孔联割半径范围(≥)", notes = "切孔联割半径范围(≥)")
   @JsonProperty("cuttingHolesJoint")
   @JSONField(name = "cuttingHolesJoint")
   private BigDecimal cuttingHolesJoint;

   public static MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder builder() {
      return new MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder();
   }

   public MesBuildingCutConfigDTOParam() {
   }

   public MesBuildingCutConfigDTOParam(
      final Long id,
      final Long cutConfigId,
      final String name,
      final Boolean boolNestCutEnum,
      final Integer boolDrillHole,
      final String minThickness,
      final String maxThickness,
      final BigDecimal cuttingHolesJoint
   ) {
      this.id = id;
      this.cutConfigId = cutConfigId;
      this.name = name;
      this.boolNestCutEnum = boolNestCutEnum;
      this.boolDrillHole = boolDrillHole;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
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

   public Integer getBoolDrillHole() {
      return this.boolDrillHole;
   }

   public String getMinThickness() {
      return this.minThickness;
   }

   public String getMaxThickness() {
      return this.maxThickness;
   }

   public BigDecimal getCuttingHolesJoint() {
      return this.cuttingHolesJoint;
   }

   @JsonProperty("id")
   public MesBuildingCutConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingCutConfigDTOParam setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingCutConfigDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingCutConfigDTOParam setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("boolDrillHole")
   public MesBuildingCutConfigDTOParam setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
      return this;
   }

   @JsonProperty("minThickness")
   public MesBuildingCutConfigDTOParam setMinThickness(final String minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   @JsonProperty("maxThickness")
   public MesBuildingCutConfigDTOParam setMaxThickness(final String maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   @JsonProperty("cuttingHolesJoint")
   public MesBuildingCutConfigDTOParam setCuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
      this.cuttingHolesJoint = cuttingHolesJoint;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCutConfigDTOParam(id="
         + this.getId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", name="
         + this.getName()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", boolDrillHole="
         + this.getBoolDrillHole()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", cuttingHolesJoint="
         + this.getCuttingHolesJoint()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCutConfigDTOParam)) {
         return false;
      }

      MesBuildingCutConfigDTOParam other = (MesBuildingCutConfigDTOParam)o;
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
               Object this$boolDrillHole = this.getBoolDrillHole();
               Object other$boolDrillHole = other.getBoolDrillHole();
               if (this$boolDrillHole == null ? other$boolDrillHole == null : this$boolDrillHole.equals(other$boolDrillHole)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$minThickness = this.getMinThickness();
                     Object other$minThickness = other.getMinThickness();
                     if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
                        Object this$maxThickness = this.getMaxThickness();
                        Object other$maxThickness = other.getMaxThickness();
                        if (this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCutConfigDTOParam;
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
      Object $boolDrillHole = this.getBoolDrillHole();
      result = result * 59 + ($boolDrillHole == null ? 43 : $boolDrillHole.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      result = result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
      Object $cuttingHolesJoint = this.getCuttingHolesJoint();
      return result * 59 + ($cuttingHolesJoint == null ? 43 : $cuttingHolesJoint.hashCode());
   }

   public static class MesBuildingCutConfigDTOParamBuilder {
      private Long id;
      private Long cutConfigId;
      private String name;
      private Boolean boolNestCutEnum;
      private Integer boolDrillHole;
      private String minThickness;
      private String maxThickness;
      private BigDecimal cuttingHolesJoint;

      MesBuildingCutConfigDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("boolDrillHole")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      @JsonProperty("minThickness")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder minThickness(final String minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      @JsonProperty("maxThickness")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder maxThickness(final String maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      @JsonProperty("cuttingHolesJoint")
      public MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder cuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
         this.cuttingHolesJoint = cuttingHolesJoint;
         return this;
      }

      public MesBuildingCutConfigDTOParam build() {
         return new MesBuildingCutConfigDTOParam(
            this.id, this.cutConfigId, this.name, this.boolNestCutEnum, this.boolDrillHole, this.minThickness, this.maxThickness, this.cuttingHolesJoint
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCutConfigDTOParam.MesBuildingCutConfigDTOParamBuilder(id="
            + this.id
            + ", cutConfigId="
            + this.cutConfigId
            + ", name="
            + this.name
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", boolDrillHole="
            + this.boolDrillHole
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", cuttingHolesJoint="
            + this.cuttingHolesJoint
            + ")";
      }
   }
}
