package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysUnitSetting对象", description = "")
@Entity
@TableName("sys_unit_setting")
@Table(name = "sys_unit_setting")
public class SysUnitSetting extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "lengthRetain")
   @JsonProperty("lengthRetain")
   @JSONField(name = "lengthRetain")
   @TableField("length_retain")
   @Column(name = "length_retain")
   private Integer lengthRetain;
   @ApiModelProperty(name = "lengthUnit")
   @JsonProperty("lengthUnit")
   @JSONField(name = "lengthUnit")
   @TableField("length_unit")
   @Column(name = "length_unit")
   private String lengthUnit;
   @ApiModelProperty(name = "thicknessRetain")
   @JsonProperty("thicknessRetain")
   @JSONField(name = "thicknessRetain")
   @TableField("thickness_retain")
   @Column(name = "thickness_retain")
   private Integer thicknessRetain;
   @ApiModelProperty(name = "weightRetain")
   @JsonProperty("weightRetain")
   @JSONField(name = "weightRetain")
   @TableField("weight_retain")
   @Column(name = "weight_retain")
   private Integer weightRetain;
   @ApiModelProperty(name = "weightUnit")
   @JsonProperty("weightUnit")
   @JSONField(name = "weightUnit")
   @TableField("weight_unit")
   @Column(name = "weight_unit")
   private String weightUnit;

   public static SysUnitSetting.SysUnitSettingBuilder builder() {
      return new SysUnitSetting.SysUnitSettingBuilder();
   }

   public SysUnitSetting() {
   }

   public SysUnitSetting(
      final Long id,
      final Integer basicClass,
      final Integer lengthRetain,
      final String lengthUnit,
      final Integer thicknessRetain,
      final Integer weightRetain,
      final String weightUnit
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.lengthRetain = lengthRetain;
      this.lengthUnit = lengthUnit;
      this.thicknessRetain = thicknessRetain;
      this.weightRetain = weightRetain;
      this.weightUnit = weightUnit;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getLengthRetain() {
      return this.lengthRetain;
   }

   public String getLengthUnit() {
      return this.lengthUnit;
   }

   public Integer getThicknessRetain() {
      return this.thicknessRetain;
   }

   public Integer getWeightRetain() {
      return this.weightRetain;
   }

   public String getWeightUnit() {
      return this.weightUnit;
   }

   @JsonProperty("id")
   public SysUnitSetting setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public SysUnitSetting setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("lengthRetain")
   public SysUnitSetting setLengthRetain(final Integer lengthRetain) {
      this.lengthRetain = lengthRetain;
      return this;
   }

   @JsonProperty("lengthUnit")
   public SysUnitSetting setLengthUnit(final String lengthUnit) {
      this.lengthUnit = lengthUnit;
      return this;
   }

   @JsonProperty("thicknessRetain")
   public SysUnitSetting setThicknessRetain(final Integer thicknessRetain) {
      this.thicknessRetain = thicknessRetain;
      return this;
   }

   @JsonProperty("weightRetain")
   public SysUnitSetting setWeightRetain(final Integer weightRetain) {
      this.weightRetain = weightRetain;
      return this;
   }

   @JsonProperty("weightUnit")
   public SysUnitSetting setWeightUnit(final String weightUnit) {
      this.weightUnit = weightUnit;
      return this;
   }

   @Override
   public String toString() {
      return "SysUnitSetting(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", lengthRetain="
         + this.getLengthRetain()
         + ", lengthUnit="
         + this.getLengthUnit()
         + ", thicknessRetain="
         + this.getThicknessRetain()
         + ", weightRetain="
         + this.getWeightRetain()
         + ", weightUnit="
         + this.getWeightUnit()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysUnitSetting)) {
         return false;
      }

      SysUnitSetting other = (SysUnitSetting)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$lengthRetain = this.getLengthRetain();
            Object other$lengthRetain = other.getLengthRetain();
            if (this$lengthRetain == null ? other$lengthRetain == null : this$lengthRetain.equals(other$lengthRetain)) {
               Object this$thicknessRetain = this.getThicknessRetain();
               Object other$thicknessRetain = other.getThicknessRetain();
               if (this$thicknessRetain == null ? other$thicknessRetain == null : this$thicknessRetain.equals(other$thicknessRetain)) {
                  Object this$weightRetain = this.getWeightRetain();
                  Object other$weightRetain = other.getWeightRetain();
                  if (this$weightRetain == null ? other$weightRetain == null : this$weightRetain.equals(other$weightRetain)) {
                     Object this$lengthUnit = this.getLengthUnit();
                     Object other$lengthUnit = other.getLengthUnit();
                     if (this$lengthUnit == null ? other$lengthUnit == null : this$lengthUnit.equals(other$lengthUnit)) {
                        Object this$weightUnit = this.getWeightUnit();
                        Object other$weightUnit = other.getWeightUnit();
                        return this$weightUnit == null ? other$weightUnit == null : this$weightUnit.equals(other$weightUnit);
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
      return other instanceof SysUnitSetting;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $lengthRetain = this.getLengthRetain();
      result = result * 59 + ($lengthRetain == null ? 43 : $lengthRetain.hashCode());
      Object $thicknessRetain = this.getThicknessRetain();
      result = result * 59 + ($thicknessRetain == null ? 43 : $thicknessRetain.hashCode());
      Object $weightRetain = this.getWeightRetain();
      result = result * 59 + ($weightRetain == null ? 43 : $weightRetain.hashCode());
      Object $lengthUnit = this.getLengthUnit();
      result = result * 59 + ($lengthUnit == null ? 43 : $lengthUnit.hashCode());
      Object $weightUnit = this.getWeightUnit();
      return result * 59 + ($weightUnit == null ? 43 : $weightUnit.hashCode());
   }

   public static class SysUnitSettingBuilder {
      private Long id;
      private Integer basicClass;
      private Integer lengthRetain;
      private String lengthUnit;
      private Integer thicknessRetain;
      private Integer weightRetain;
      private String weightUnit;

      SysUnitSettingBuilder() {
      }

      @JsonProperty("id")
      public SysUnitSetting.SysUnitSettingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public SysUnitSetting.SysUnitSettingBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("lengthRetain")
      public SysUnitSetting.SysUnitSettingBuilder lengthRetain(final Integer lengthRetain) {
         this.lengthRetain = lengthRetain;
         return this;
      }

      @JsonProperty("lengthUnit")
      public SysUnitSetting.SysUnitSettingBuilder lengthUnit(final String lengthUnit) {
         this.lengthUnit = lengthUnit;
         return this;
      }

      @JsonProperty("thicknessRetain")
      public SysUnitSetting.SysUnitSettingBuilder thicknessRetain(final Integer thicknessRetain) {
         this.thicknessRetain = thicknessRetain;
         return this;
      }

      @JsonProperty("weightRetain")
      public SysUnitSetting.SysUnitSettingBuilder weightRetain(final Integer weightRetain) {
         this.weightRetain = weightRetain;
         return this;
      }

      @JsonProperty("weightUnit")
      public SysUnitSetting.SysUnitSettingBuilder weightUnit(final String weightUnit) {
         this.weightUnit = weightUnit;
         return this;
      }

      public SysUnitSetting build() {
         return new SysUnitSetting(this.id, this.basicClass, this.lengthRetain, this.lengthUnit, this.thicknessRetain, this.weightRetain, this.weightUnit);
      }

      @Override
      public String toString() {
         return "SysUnitSetting.SysUnitSettingBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", lengthRetain="
            + this.lengthRetain
            + ", lengthUnit="
            + this.lengthUnit
            + ", thicknessRetain="
            + this.thicknessRetain
            + ", weightRetain="
            + this.weightRetain
            + ", weightUnit="
            + this.weightUnit
            + ")";
      }
   }
}
