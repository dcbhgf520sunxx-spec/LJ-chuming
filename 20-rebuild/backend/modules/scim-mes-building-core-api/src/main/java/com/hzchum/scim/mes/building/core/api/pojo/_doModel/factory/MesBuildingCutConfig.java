package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingCutConfig对象", description = "切割配置 ")
@Entity
@TableName("mes_building_cut_config")
@Table(name = "mes_building_cut_config")
public class MesBuildingCutConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "切割方式名称", notes = "切割方式名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(32)  COMMENT '切割方式'", nullable = false)
   private String name;
   @ApiModelProperty(name = "thickness", value = "钢板厚度范围(≤)", notes = "钢板厚度范围(≤)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "varchar(128)  COMMENT '钢板厚度范围(≤)'", nullable = true)
   private String thickness;
   @ApiModelProperty(name = "minThickness", value = "钢板厚度范围(≤)", notes = "钢板厚度范围(≤)")
   @JsonProperty("minThickness")
   @JSONField(name = "minThickness")
   @TableField("min_thickness")
   @Column(name = "min_thickness", columnDefinition = "varchar(128)  COMMENT '钢板厚度范围(≤)'", nullable = false)
   private String minThickness;
   @ApiModelProperty(name = "maxThickness", value = "钢板厚度范围(>=)", notes = "钢板厚度范围(>=)")
   @JsonProperty("maxThickness")
   @JSONField(name = "maxThickness")
   @TableField("max_thickness")
   @Column(name = "max_thickness", columnDefinition = "varchar(128)  COMMENT '钢板厚度范围(>=)'", nullable = false)
   private String maxThickness;
   @ApiModelProperty(name = "cuttingHolesJoint", value = "切孔联割直径范围(≥)", notes = "切孔联割直径范围(≥)")
   @JsonProperty("cuttingHolesJoint")
   @JSONField(name = "cuttingHolesJoint")
   @TableField("cutting_holes_joint")
   @Column(name = "cutting_holes_joint", columnDefinition = "decimal(32,8)  COMMENT '切孔联割直径范围(≥)'", nullable = true)
   private BigDecimal cuttingHolesJoint;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否套料", notes = "是否套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   @TableField("bool_nest_cut_enum")
   @Column(name = "bool_nest_cut_enum", columnDefinition = "tinyint(1) default 0  COMMENT '是否套料'", nullable = false)
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "boolDrillHole", value = "是否板孔联割", notes = "是否板孔联割")
   @JsonProperty("boolDrillHole")
   @JSONField(name = "boolDrillHole")
   @TableField("bool_drill_hole")
   @Column(name = "bool_drill_hole", columnDefinition = "int(11) default 0 COMMENT '是否板孔联割'", nullable = false)
   private Integer boolDrillHole;

   public static MesBuildingCutConfig.MesBuildingCutConfigBuilder builder() {
      return new MesBuildingCutConfig.MesBuildingCutConfigBuilder();
   }

   public MesBuildingCutConfig() {
   }

   public MesBuildingCutConfig(
      final Long id,
      final String name,
      final String thickness,
      final String minThickness,
      final String maxThickness,
      final BigDecimal cuttingHolesJoint,
      final Boolean boolNestCutEnum,
      final Integer boolDrillHole
   ) {
      this.id = id;
      this.name = name;
      this.thickness = thickness;
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

   public String getThickness() {
      return this.thickness;
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
   public MesBuildingCutConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingCutConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingCutConfig setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("minThickness")
   public MesBuildingCutConfig setMinThickness(final String minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   @JsonProperty("maxThickness")
   public MesBuildingCutConfig setMaxThickness(final String maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   @JsonProperty("cuttingHolesJoint")
   public MesBuildingCutConfig setCuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
      this.cuttingHolesJoint = cuttingHolesJoint;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingCutConfig setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("boolDrillHole")
   public MesBuildingCutConfig setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCutConfig(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", thickness="
         + this.getThickness()
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

      if (!(o instanceof MesBuildingCutConfig)) {
         return false;
      }

      MesBuildingCutConfig other = (MesBuildingCutConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCutConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $boolDrillHole = this.getBoolDrillHole();
      result = result * 59 + ($boolDrillHole == null ? 43 : $boolDrillHole.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      result = result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
      Object $cuttingHolesJoint = this.getCuttingHolesJoint();
      return result * 59 + ($cuttingHolesJoint == null ? 43 : $cuttingHolesJoint.hashCode());
   }

   public static class MesBuildingCutConfigBuilder {
      private Long id;
      private String name;
      private String thickness;
      private String minThickness;
      private String maxThickness;
      private BigDecimal cuttingHolesJoint;
      private Boolean boolNestCutEnum;
      private Integer boolDrillHole;

      MesBuildingCutConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("minThickness")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder minThickness(final String minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      @JsonProperty("maxThickness")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder maxThickness(final String maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      @JsonProperty("cuttingHolesJoint")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder cuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
         this.cuttingHolesJoint = cuttingHolesJoint;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("boolDrillHole")
      public MesBuildingCutConfig.MesBuildingCutConfigBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      public MesBuildingCutConfig build() {
         return new MesBuildingCutConfig(
            this.id, this.name, this.thickness, this.minThickness, this.maxThickness, this.cuttingHolesJoint, this.boolNestCutEnum, this.boolDrillHole
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCutConfig.MesBuildingCutConfigBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", thickness="
            + this.thickness
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
