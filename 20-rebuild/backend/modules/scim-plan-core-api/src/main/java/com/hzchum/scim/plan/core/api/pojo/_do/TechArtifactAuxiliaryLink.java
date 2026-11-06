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

@ApiModel(value = "TechArtifactAuxiliaryLink对象", description = "构件配套件关联表 ")
@Entity
@TableName("tech_artifact_auxiliary_link")
@Table(name = "tech_artifact_auxiliary_link")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_auxiliary_link", comment = "构件配套件关联表 ")
public class TechArtifactAuxiliaryLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactId", value = "构件ID", notes = "构件ID")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件ID'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "auxiliaryPartId", value = "配套件ID", notes = "配套件ID")
   @TableField("auxiliary_part_id")
   @Column(name = "auxiliary_part_id", columnDefinition = "bigint(20)  COMMENT '配套件ID'", nullable = false)
   private Long auxiliaryPartId;
   @ApiModelProperty(name = "quantity", value = "配套件数比构件数 (数量比)", notes = "配套件数比构件数 (数量比)")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '配套件数比构件数 (数量比)'", nullable = false)
   private Integer quantity;

   public static TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder builder() {
      return new TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder();
   }

   public TechArtifactAuxiliaryLink() {
   }

   public TechArtifactAuxiliaryLink(final Long id, final Long artifactId, final Long auxiliaryPartId, final Integer quantity) {
      this.id = id;
      this.artifactId = artifactId;
      this.auxiliaryPartId = auxiliaryPartId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getAuxiliaryPartId() {
      return this.auxiliaryPartId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public TechArtifactAuxiliaryLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactAuxiliaryLink setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public TechArtifactAuxiliaryLink setAuxiliaryPartId(final Long auxiliaryPartId) {
      this.auxiliaryPartId = auxiliaryPartId;
      return this;
   }

   public TechArtifactAuxiliaryLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactAuxiliaryLink(id="
         + this.getId()
         + ", artifactId="
         + this.getArtifactId()
         + ", auxiliaryPartId="
         + this.getAuxiliaryPartId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactAuxiliaryLink)) {
         return false;
      }

      TechArtifactAuxiliaryLink other = (TechArtifactAuxiliaryLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$auxiliaryPartId = this.getAuxiliaryPartId();
            Object other$auxiliaryPartId = other.getAuxiliaryPartId();
            if (this$auxiliaryPartId == null ? other$auxiliaryPartId == null : this$auxiliaryPartId.equals(other$auxiliaryPartId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof TechArtifactAuxiliaryLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $auxiliaryPartId = this.getAuxiliaryPartId();
      result = result * 59 + ($auxiliaryPartId == null ? 43 : $auxiliaryPartId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TechArtifactAuxiliaryLinkBuilder {
      private Long id;
      private Long artifactId;
      private Long auxiliaryPartId;
      private Integer quantity;

      TechArtifactAuxiliaryLinkBuilder() {
      }

      public TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder auxiliaryPartId(final Long auxiliaryPartId) {
         this.auxiliaryPartId = auxiliaryPartId;
         return this;
      }

      public TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactAuxiliaryLink build() {
         return new TechArtifactAuxiliaryLink(this.id, this.artifactId, this.auxiliaryPartId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechArtifactAuxiliaryLink.TechArtifactAuxiliaryLinkBuilder(id="
            + this.id
            + ", artifactId="
            + this.artifactId
            + ", auxiliaryPartId="
            + this.auxiliaryPartId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
