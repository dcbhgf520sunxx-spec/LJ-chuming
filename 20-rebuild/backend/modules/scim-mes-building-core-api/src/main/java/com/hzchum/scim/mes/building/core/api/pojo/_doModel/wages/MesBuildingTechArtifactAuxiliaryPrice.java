package com.hzchum.scim.mes.building.core.api.pojo._doModel.wages;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingTechArtifactAuxiliaryPrice对象", description = "构件配套件价格表 ")
@Entity
@TableName("mes_building_tech_artifact_auxiliary_price")
@Table(name = "mes_building_tech_artifact_auxiliary_price")
@org.hibernate.annotations.Table(appliesTo = "mes_building_tech_artifact_auxiliary_price", comment = "构件配套件价格表 ")
public class MesBuildingTechArtifactAuxiliaryPrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "构件ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "auxiliaryPartId", value = "配套件ID", notes = "配套件ID")
   @TableField("auxiliary_part_id")
   @Column(name = "auxiliary_part_id", columnDefinition = "bigint(20)  COMMENT '配套件ID'", nullable = false)
   private Long auxiliaryPartId;
   @ApiModelProperty(name = "completeId", value = "完成表ID", notes = "完成表ID")
   @TableField("complete_id")
   @Column(name = "complete_id", columnDefinition = "bigint(20)  COMMENT '完成表ID'", nullable = false)
   private Long completeId;
   @ApiModelProperty(name = "completeTime", value = "构件完成时间", notes = "构件完成时间")
   @TableField("complete_time")
   @Column(name = "complete_time", columnDefinition = "datetime  COMMENT '构件完成时间'", nullable = false)
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "quantity", value = "配套件数比构件数 (数量比)", notes = "配套件数比构件数 (数量比)")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '配套件数比构件数 (数量比)'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "price", value = "单价", notes = "单价")
   @TableField("price")
   @Column(name = "price", columnDefinition = "bigint(20)   COMMENT '单价'", nullable = false)
   private BigDecimal price;
   @ApiModelProperty(name = "wages", value = "总价", notes = "总价")
   @TableField("wages")
   @Column(name = "wages", columnDefinition = "bigint(20)   COMMENT '总价'", nullable = false)
   private BigDecimal wages;

   public static MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder builder() {
      return new MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder();
   }

   public MesBuildingTechArtifactAuxiliaryPrice() {
   }

   public MesBuildingTechArtifactAuxiliaryPrice(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long artifactId,
      final Long auxiliaryPartId,
      final Long completeId,
      final LocalDateTime completeTime,
      final Integer quantity,
      final BigDecimal price,
      final BigDecimal wages
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.artifactId = artifactId;
      this.auxiliaryPartId = auxiliaryPartId;
      this.completeId = completeId;
      this.completeTime = completeTime;
      this.quantity = quantity;
      this.price = price;
      this.wages = wages;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getAuxiliaryPartId() {
      return this.auxiliaryPartId;
   }

   public Long getCompleteId() {
      return this.completeId;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getWages() {
      return this.wages;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setAuxiliaryPartId(final Long auxiliaryPartId) {
      this.auxiliaryPartId = auxiliaryPartId;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setCompleteId(final Long completeId) {
      this.completeId = completeId;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesBuildingTechArtifactAuxiliaryPrice setWages(final BigDecimal wages) {
      this.wages = wages;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTechArtifactAuxiliaryPrice(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", artifactId="
         + this.getArtifactId()
         + ", auxiliaryPartId="
         + this.getAuxiliaryPartId()
         + ", completeId="
         + this.getCompleteId()
         + ", completeTime="
         + this.getCompleteTime()
         + ", quantity="
         + this.getQuantity()
         + ", price="
         + this.getPrice()
         + ", wages="
         + this.getWages()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTechArtifactAuxiliaryPrice)) {
         return false;
      }

      MesBuildingTechArtifactAuxiliaryPrice other = (MesBuildingTechArtifactAuxiliaryPrice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$artifactId = this.getArtifactId();
                  Object other$artifactId = other.getArtifactId();
                  if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                     Object this$auxiliaryPartId = this.getAuxiliaryPartId();
                     Object other$auxiliaryPartId = other.getAuxiliaryPartId();
                     if (this$auxiliaryPartId == null ? other$auxiliaryPartId == null : this$auxiliaryPartId.equals(other$auxiliaryPartId)) {
                        Object this$completeId = this.getCompleteId();
                        Object other$completeId = other.getCompleteId();
                        if (this$completeId == null ? other$completeId == null : this$completeId.equals(other$completeId)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$completeTime = this.getCompleteTime();
                              Object other$completeTime = other.getCompleteTime();
                              if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                 Object this$price = this.getPrice();
                                 Object other$price = other.getPrice();
                                 if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                    Object this$wages = this.getWages();
                                    Object other$wages = other.getWages();
                                    return this$wages == null ? other$wages == null : this$wages.equals(other$wages);
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
      return other instanceof MesBuildingTechArtifactAuxiliaryPrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $auxiliaryPartId = this.getAuxiliaryPartId();
      result = result * 59 + ($auxiliaryPartId == null ? 43 : $auxiliaryPartId.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $wages = this.getWages();
      return result * 59 + ($wages == null ? 43 : $wages.hashCode());
   }

   public static class MesBuildingTechArtifactAuxiliaryPriceBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long artifactId;
      private Long auxiliaryPartId;
      private Long completeId;
      private LocalDateTime completeTime;
      private Integer quantity;
      private BigDecimal price;
      private BigDecimal wages;

      MesBuildingTechArtifactAuxiliaryPriceBuilder() {
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder auxiliaryPartId(final Long auxiliaryPartId) {
         this.auxiliaryPartId = auxiliaryPartId;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder completeId(final Long completeId) {
         this.completeId = completeId;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder wages(final BigDecimal wages) {
         this.wages = wages;
         return this;
      }

      public MesBuildingTechArtifactAuxiliaryPrice build() {
         return new MesBuildingTechArtifactAuxiliaryPrice(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.artifactId,
            this.auxiliaryPartId,
            this.completeId,
            this.completeTime,
            this.quantity,
            this.price,
            this.wages
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTechArtifactAuxiliaryPrice.MesBuildingTechArtifactAuxiliaryPriceBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", artifactId="
            + this.artifactId
            + ", auxiliaryPartId="
            + this.auxiliaryPartId
            + ", completeId="
            + this.completeId
            + ", completeTime="
            + this.completeTime
            + ", quantity="
            + this.quantity
            + ", price="
            + this.price
            + ", wages="
            + this.wages
            + ")";
      }
   }
}
