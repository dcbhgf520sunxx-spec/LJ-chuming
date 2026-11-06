package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "CutConfigSaveVO", description = "切割配置 ")
public class CutConfigSaveVO {
   @ApiModelProperty(name = "id", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "切割配置id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "name", value = "切割方式", notes = "切割方式")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "切割方式不能为空", groups = Add.class)
   private String name;
   @ApiModelProperty(name = "minThickness", value = "钢板厚度范围(≤)", notes = "钢板厚度(≤)")
   @JsonProperty("minThickness")
   @JSONField(name = "minThickness")
   private String minThickness;
   @ApiModelProperty(name = "maxThickness", value = "钢板厚度范围(≤)", notes = "钢板厚度(≤)")
   @JsonProperty("maxThickness")
   @JSONField(name = "maxThickness")
   private String maxThickness;
   @ApiModelProperty(name = "cuttingHolesJoint", value = "切孔联割半径范围(≥)", notes = "切孔联割半径范围(≥)")
   @JsonProperty("cuttingHolesJoint")
   @JSONField(name = "cuttingHolesJoint")
   private BigDecimal cuttingHolesJoint;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否套料", notes = "是否套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "boolDrillHole", value = "是否钻孔", notes = "是否钻孔")
   @JsonProperty("boolDrillHole")
   @JSONField(name = "boolDrillHole")
   private Integer boolDrillHole;

   public static CutConfigSaveVO.CutConfigSaveVOBuilder builder() {
      return new CutConfigSaveVO.CutConfigSaveVOBuilder();
   }

   public CutConfigSaveVO() {
   }

   public CutConfigSaveVO(
      final Long id,
      final String name,
      final String minThickness,
      final String maxThickness,
      final BigDecimal cuttingHolesJoint,
      final Boolean boolNestCutEnum,
      final Integer boolDrillHole
   ) {
      this.id = id;
      this.name = name;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
      this.cuttingHolesJoint = cuttingHolesJoint;
      this.boolNestCutEnum = boolNestCutEnum;
      this.boolDrillHole = boolDrillHole;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
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

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Integer getBoolDrillHole() {
      return this.boolDrillHole;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("minThickness")
   public void setMinThickness(final String minThickness) {
      this.minThickness = minThickness;
   }

   @JsonProperty("maxThickness")
   public void setMaxThickness(final String maxThickness) {
      this.maxThickness = maxThickness;
   }

   @JsonProperty("cuttingHolesJoint")
   public void setCuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
      this.cuttingHolesJoint = cuttingHolesJoint;
   }

   @JsonProperty("boolNestCutEnum")
   public void setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
   }

   @JsonProperty("boolDrillHole")
   public void setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
   }

   @Override
   public String toString() {
      return "CutConfigSaveVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", cuttingHolesJoint="
         + this.getCuttingHolesJoint()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", boolDrillHole="
         + this.getBoolDrillHole()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutConfigSaveVO)) {
         return false;
      }

      CutConfigSaveVO other = (CutConfigSaveVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CutConfigSaveVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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

   public static class CutConfigSaveVOBuilder {
      private Long id;
      private String name;
      private String minThickness;
      private String maxThickness;
      private BigDecimal cuttingHolesJoint;
      private Boolean boolNestCutEnum;
      private Integer boolDrillHole;

      CutConfigSaveVOBuilder() {
      }

      @JsonProperty("id")
      public CutConfigSaveVO.CutConfigSaveVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public CutConfigSaveVO.CutConfigSaveVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("minThickness")
      public CutConfigSaveVO.CutConfigSaveVOBuilder minThickness(final String minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      @JsonProperty("maxThickness")
      public CutConfigSaveVO.CutConfigSaveVOBuilder maxThickness(final String maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      @JsonProperty("cuttingHolesJoint")
      public CutConfigSaveVO.CutConfigSaveVOBuilder cuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
         this.cuttingHolesJoint = cuttingHolesJoint;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public CutConfigSaveVO.CutConfigSaveVOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("boolDrillHole")
      public CutConfigSaveVO.CutConfigSaveVOBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      public CutConfigSaveVO build() {
         return new CutConfigSaveVO(this.id, this.name, this.minThickness, this.maxThickness, this.cuttingHolesJoint, this.boolNestCutEnum, this.boolDrillHole);
      }

      @Override
      public String toString() {
         return "CutConfigSaveVO.CutConfigSaveVOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", cuttingHolesJoint="
            + this.cuttingHolesJoint
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", boolDrillHole="
            + this.boolDrillHole
            + ")";
      }
   }
}
