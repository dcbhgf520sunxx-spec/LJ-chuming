package com.hzchum.scim.cut.core.api.pojo._do;

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

@ApiModel(value = "WmsNestMaterial对象", description = "薄楚初鸣材质对照表")
@Entity
@TableName("wms_nest_material")
@Table(name = "wms_nest_material")
@org.hibernate.annotations.Table(appliesTo = "wms_nest_material")
public class WmsNestMaterial extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialId")
   @JsonProperty("materialId")
   @JSONField(name = "materialId")
   @TableField("material_id")
   @Column(name = "material_id", columnDefinition = "bigint  COMMENT '柏楚材质id'", nullable = true)
   private Long materialId;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '柏楚材质名和初鸣材质名相同，如:Q355B 通过该属性对照初鸣和套料软件的材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "density")
   @JsonProperty("density")
   @JSONField(name = "density")
   @TableField("density")
   @Column(name = "density", columnDefinition = "varchar(255)  COMMENT '密度'", nullable = true)
   private String density;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   @TableField("team_code")
   @Column(name = "team_code", columnDefinition = "varchar(255)  COMMENT '团队码'", nullable = false)
   private String teamCode;

   public static WmsNestMaterial.WmsNestMaterialBuilder builder() {
      return new WmsNestMaterial.WmsNestMaterialBuilder();
   }

   public WmsNestMaterial() {
   }

   public WmsNestMaterial(final Long id, final Long materialId, final String material, final String density, final String teamCode) {
      this.id = id;
      this.materialId = materialId;
      this.material = material;
      this.density = density;
      this.teamCode = teamCode;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getDensity() {
      return this.density;
   }

   public String getTeamCode() {
      return this.teamCode;
   }

   public WmsNestMaterial setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialId")
   public WmsNestMaterial setMaterialId(final Long materialId) {
      this.materialId = materialId;
      return this;
   }

   @JsonProperty("material")
   public WmsNestMaterial setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("density")
   public WmsNestMaterial setDensity(final String density) {
      this.density = density;
      return this;
   }

   public WmsNestMaterial setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
      return this;
   }

   @Override
   public String toString() {
      return "WmsNestMaterial(id="
         + this.getId()
         + ", materialId="
         + this.getMaterialId()
         + ", material="
         + this.getMaterial()
         + ", density="
         + this.getDensity()
         + ", teamCode="
         + this.getTeamCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsNestMaterial)) {
         return false;
      }

      WmsNestMaterial other = (WmsNestMaterial)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialId = this.getMaterialId();
         Object other$materialId = other.getMaterialId();
         if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$density = this.getDensity();
               Object other$density = other.getDensity();
               if (this$density == null ? other$density == null : this$density.equals(other$density)) {
                  Object this$teamCode = this.getTeamCode();
                  Object other$teamCode = other.getTeamCode();
                  return this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode);
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
      return other instanceof WmsNestMaterial;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $density = this.getDensity();
      result = result * 59 + ($density == null ? 43 : $density.hashCode());
      Object $teamCode = this.getTeamCode();
      return result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
   }

   public static class WmsNestMaterialBuilder {
      private Long id;
      private Long materialId;
      private String material;
      private String density;
      private String teamCode;

      WmsNestMaterialBuilder() {
      }

      public WmsNestMaterial.WmsNestMaterialBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialId")
      public WmsNestMaterial.WmsNestMaterialBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      @JsonProperty("material")
      public WmsNestMaterial.WmsNestMaterialBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("density")
      public WmsNestMaterial.WmsNestMaterialBuilder density(final String density) {
         this.density = density;
         return this;
      }

      public WmsNestMaterial.WmsNestMaterialBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public WmsNestMaterial build() {
         return new WmsNestMaterial(this.id, this.materialId, this.material, this.density, this.teamCode);
      }

      @Override
      public String toString() {
         return "WmsNestMaterial.WmsNestMaterialBuilder(id="
            + this.id
            + ", materialId="
            + this.materialId
            + ", material="
            + this.material
            + ", density="
            + this.density
            + ", teamCode="
            + this.teamCode
            + ")";
      }
   }
}
