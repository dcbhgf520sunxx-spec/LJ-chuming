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

@ApiModel(value = "TechArtifactStandardPartLink对象", description = "构件和配套件关联表 ")
@Entity
@TableName("tech_artifact_standard_part_link")
@Table(name = "tech_artifact_standard_part_link")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_standard_part_link", comment = "构件和配套件关联表 ")
public class TechArtifactStandardPartLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "standardPartId", value = "标准件表(配套件)id", notes = "标准件表(配套件)id")
   @TableField("standard_part_id")
   @Column(name = "standard_part_id", columnDefinition = "bigint(20)  COMMENT '标准件表(配套件)id'", nullable = false)
   private Long standardPartId;
   @ApiModelProperty(name = "quantity", value = "比例", notes = "比例")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '比例'", nullable = false)
   private Integer quantity;

   public static TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder builder() {
      return new TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder();
   }

   public TechArtifactStandardPartLink() {
   }

   public TechArtifactStandardPartLink(final Long id, final Long artifactId, final Long standardPartId, final Integer quantity) {
      this.id = id;
      this.artifactId = artifactId;
      this.standardPartId = standardPartId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getStandardPartId() {
      return this.standardPartId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public TechArtifactStandardPartLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactStandardPartLink setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public TechArtifactStandardPartLink setStandardPartId(final Long standardPartId) {
      this.standardPartId = standardPartId;
      return this;
   }

   public TechArtifactStandardPartLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactStandardPartLink(id="
         + this.getId()
         + ", artifactId="
         + this.getArtifactId()
         + ", standardPartId="
         + this.getStandardPartId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactStandardPartLink)) {
         return false;
      }

      TechArtifactStandardPartLink other = (TechArtifactStandardPartLink)o;
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
            Object this$standardPartId = this.getStandardPartId();
            Object other$standardPartId = other.getStandardPartId();
            if (this$standardPartId == null ? other$standardPartId == null : this$standardPartId.equals(other$standardPartId)) {
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
      return other instanceof TechArtifactStandardPartLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $standardPartId = this.getStandardPartId();
      result = result * 59 + ($standardPartId == null ? 43 : $standardPartId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TechArtifactStandardPartLinkBuilder {
      private Long id;
      private Long artifactId;
      private Long standardPartId;
      private Integer quantity;

      TechArtifactStandardPartLinkBuilder() {
      }

      public TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder standardPartId(final Long standardPartId) {
         this.standardPartId = standardPartId;
         return this;
      }

      public TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactStandardPartLink build() {
         return new TechArtifactStandardPartLink(this.id, this.artifactId, this.standardPartId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechArtifactStandardPartLink.TechArtifactStandardPartLinkBuilder(id="
            + this.id
            + ", artifactId="
            + this.artifactId
            + ", standardPartId="
            + this.standardPartId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
