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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProductionLineLink对象", description = "")
@Entity
@TableName("mes_building_production_line_link")
@Table(name = "mes_building_production_line_link")
public class MesBuildingProductionLineLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "linkId", value = "可生产类型id 根据生产线可生产产品类型不同，关联表不同", notes = "可生产类型id 根据生产线可生产产品类型不同，关联表不同")
   @JsonProperty("linkId")
   @JSONField(name = "linkId")
   @TableField("link_id")
   @Column(name = "link_id", columnDefinition = "bigint(20)  COMMENT '可生产类型id 根据生产线可生产产品类型不同，关联表不同'", nullable = false)
   private Long linkId;

   public static MesBuildingProductionLineLink.MesBuildingProductionLineLinkBuilder builder() {
      return new MesBuildingProductionLineLink.MesBuildingProductionLineLinkBuilder();
   }

   public MesBuildingProductionLineLink() {
   }

   public MesBuildingProductionLineLink(final Long id, final Long productionLineId, final Long linkId) {
      this.id = id;
      this.productionLineId = productionLineId;
      this.linkId = linkId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   @JsonProperty("id")
   public MesBuildingProductionLineLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingProductionLineLink setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("linkId")
   public MesBuildingProductionLineLink setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineLink(id=" + this.getId() + ", productionLineId=" + this.getProductionLineId() + ", linkId=" + this.getLinkId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineLink)) {
         return false;
      }

      MesBuildingProductionLineLink other = (MesBuildingProductionLineLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$linkId = this.getLinkId();
            Object other$linkId = other.getLinkId();
            return this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductionLineLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $linkId = this.getLinkId();
      return result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
   }

   public static class MesBuildingProductionLineLinkBuilder {
      private Long id;
      private Long productionLineId;
      private Long linkId;

      MesBuildingProductionLineLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductionLineLink.MesBuildingProductionLineLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingProductionLineLink.MesBuildingProductionLineLinkBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("linkId")
      public MesBuildingProductionLineLink.MesBuildingProductionLineLinkBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public MesBuildingProductionLineLink build() {
         return new MesBuildingProductionLineLink(this.id, this.productionLineId, this.linkId);
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineLink.MesBuildingProductionLineLinkBuilder(id="
            + this.id
            + ", productionLineId="
            + this.productionLineId
            + ", linkId="
            + this.linkId
            + ")";
      }
   }
}
