package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechCappCraftCardStorehouseTemperatureLink对象", description = "焊接板厚对应温度信息配置")
@Entity
@TableName("tech_capp_craft_card_storehouse_temperature_link")
@Table(name = "tech_capp_craft_card_storehouse_temperature_link")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_storehouse_temperature_link", comment = "焊接板厚对应温度信息配置")
public class TechCappCraftCardStorehouseTemperatureLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "焊接温度信息", notes = "焊接温度信息")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "thickness", value = "板厚", notes = "板厚")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "varchar(255)  COMMENT '板厚'", nullable = true)
   private String thickness;
   @ApiModelProperty(name = "preheatingTemperature", value = "预热温度", notes = "预热温度")
   @TableField("preheating_temperature")
   @Column(name = "preheating_temperature", columnDefinition = "varchar(255)  COMMENT '预热温度'", nullable = true)
   private String preheatingTemperature;
   @ApiModelProperty(name = "roadTemperature", value = "道间温度", notes = "道间温度")
   @TableField("road_temperature")
   @Column(name = "road_temperature", columnDefinition = "varchar(255)  COMMENT '道间温度'", nullable = true)
   private String roadTemperature;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺主表id", notes = "焊接工艺主表id")
   @TableField("tech_capp_craft_card_storehouse_id")
   @Column(name = "tech_capp_craft_card_storehouse_id", columnDefinition = "bigint(20)  COMMENT '焊接工艺主表id'", nullable = false)
   private Long techCappCraftCardStorehouseId;

   public static TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder builder() {
      return new TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder();
   }

   public TechCappCraftCardStorehouseTemperatureLink() {
   }

   public TechCappCraftCardStorehouseTemperatureLink(
      final Long id, final String thickness, final String preheatingTemperature, final String roadTemperature, final Long techCappCraftCardStorehouseId
   ) {
      this.id = id;
      this.thickness = thickness;
      this.preheatingTemperature = preheatingTemperature;
      this.roadTemperature = roadTemperature;
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public Long getId() {
      return this.id;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getPreheatingTemperature() {
      return this.preheatingTemperature;
   }

   public String getRoadTemperature() {
      return this.roadTemperature;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public TechCappCraftCardStorehouseTemperatureLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardStorehouseTemperatureLink setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public TechCappCraftCardStorehouseTemperatureLink setPreheatingTemperature(final String preheatingTemperature) {
      this.preheatingTemperature = preheatingTemperature;
      return this;
   }

   public TechCappCraftCardStorehouseTemperatureLink setRoadTemperature(final String roadTemperature) {
      this.roadTemperature = roadTemperature;
      return this;
   }

   public TechCappCraftCardStorehouseTemperatureLink setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardStorehouseTemperatureLink(id="
         + this.getId()
         + ", thickness="
         + this.getThickness()
         + ", preheatingTemperature="
         + this.getPreheatingTemperature()
         + ", roadTemperature="
         + this.getRoadTemperature()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardStorehouseTemperatureLink)) {
         return false;
      }

      TechCappCraftCardStorehouseTemperatureLink other = (TechCappCraftCardStorehouseTemperatureLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
         Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
         if (this$techCappCraftCardStorehouseId == null
            ? other$techCappCraftCardStorehouseId == null
            : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
            Object this$thickness = this.getThickness();
            Object other$thickness = other.getThickness();
            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
               Object this$preheatingTemperature = this.getPreheatingTemperature();
               Object other$preheatingTemperature = other.getPreheatingTemperature();
               if (this$preheatingTemperature == null ? other$preheatingTemperature == null : this$preheatingTemperature.equals(other$preheatingTemperature)) {
                  Object this$roadTemperature = this.getRoadTemperature();
                  Object other$roadTemperature = other.getRoadTemperature();
                  return this$roadTemperature == null ? other$roadTemperature == null : this$roadTemperature.equals(other$roadTemperature);
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
      return other instanceof TechCappCraftCardStorehouseTemperatureLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $preheatingTemperature = this.getPreheatingTemperature();
      result = result * 59 + ($preheatingTemperature == null ? 43 : $preheatingTemperature.hashCode());
      Object $roadTemperature = this.getRoadTemperature();
      return result * 59 + ($roadTemperature == null ? 43 : $roadTemperature.hashCode());
   }

   public static class TechCappCraftCardStorehouseTemperatureLinkBuilder {
      private Long id;
      private String thickness;
      private String preheatingTemperature;
      private String roadTemperature;
      private Long techCappCraftCardStorehouseId;

      TechCappCraftCardStorehouseTemperatureLinkBuilder() {
      }

      public TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder preheatingTemperature(
         final String preheatingTemperature
      ) {
         this.preheatingTemperature = preheatingTemperature;
         return this;
      }

      public TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder roadTemperature(final String roadTemperature) {
         this.roadTemperature = roadTemperature;
         return this;
      }

      public TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder techCappCraftCardStorehouseId(
         final Long techCappCraftCardStorehouseId
      ) {
         this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
         return this;
      }

      public TechCappCraftCardStorehouseTemperatureLink build() {
         return new TechCappCraftCardStorehouseTemperatureLink(
            this.id, this.thickness, this.preheatingTemperature, this.roadTemperature, this.techCappCraftCardStorehouseId
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardStorehouseTemperatureLink.TechCappCraftCardStorehouseTemperatureLinkBuilder(id="
            + this.id
            + ", thickness="
            + this.thickness
            + ", preheatingTemperature="
            + this.preheatingTemperature
            + ", roadTemperature="
            + this.roadTemperature
            + ", techCappCraftCardStorehouseId="
            + this.techCappCraftCardStorehouseId
            + ")";
      }
   }
}
