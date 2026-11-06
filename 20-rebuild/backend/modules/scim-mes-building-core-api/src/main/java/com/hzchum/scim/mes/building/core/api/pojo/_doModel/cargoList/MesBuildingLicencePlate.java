package com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList;

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

@ApiModel(value = "MesBuildingLicencePlate对象", description = "发运车牌(个人)")
@Entity
@TableName("mes_building_licence_plate")
@Table(name = "mes_building_licence_plate")
public class MesBuildingLicencePlate extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   @TableField("license_plate")
   @Column(name = "license_plate", columnDefinition = "varchar(64)  COMMENT '车牌号'", nullable = false)
   private String licensePlate;

   public static MesBuildingLicencePlate.MesBuildingLicencePlateBuilder builder() {
      return new MesBuildingLicencePlate.MesBuildingLicencePlateBuilder();
   }

   public MesBuildingLicencePlate() {
   }

   public MesBuildingLicencePlate(final Long id, final String licensePlate) {
      this.id = id;
      this.licensePlate = licensePlate;
   }

   public Long getId() {
      return this.id;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   @JsonProperty("id")
   public MesBuildingLicencePlate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("licensePlate")
   public MesBuildingLicencePlate setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingLicencePlate(id=" + this.getId() + ", licensePlate=" + this.getLicensePlate() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingLicencePlate)) {
         return false;
      } else {
         MesBuildingLicencePlate other = (MesBuildingLicencePlate)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$licensePlate = this.getLicensePlate();
               Object other$licensePlate = other.getLicensePlate();
               return this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingLicencePlate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $licensePlate = this.getLicensePlate();
      return result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
   }

   public static class MesBuildingLicencePlateBuilder {
      private Long id;
      private String licensePlate;

      MesBuildingLicencePlateBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingLicencePlate.MesBuildingLicencePlateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("licensePlate")
      public MesBuildingLicencePlate.MesBuildingLicencePlateBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public MesBuildingLicencePlate build() {
         return new MesBuildingLicencePlate(this.id, this.licensePlate);
      }

      @Override
      public String toString() {
         return "MesBuildingLicencePlate.MesBuildingLicencePlateBuilder(id=" + this.id + ", licensePlate=" + this.licensePlate + ")";
      }
   }
}
