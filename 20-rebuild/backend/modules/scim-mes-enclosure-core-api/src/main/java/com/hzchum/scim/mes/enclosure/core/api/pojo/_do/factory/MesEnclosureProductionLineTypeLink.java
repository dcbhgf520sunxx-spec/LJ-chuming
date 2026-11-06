package com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory;

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

@ApiModel(value = "MesEnclosureProductionLineTypeLink对象", description = "围护产线类型关联字典")
@Entity
@TableName("mes_enclosure_production_line_type_link")
@Table(name = "mes_enclosure_production_line_type_link")
@org.hibernate.annotations.Table(appliesTo = "mes_enclosure_production_line_type_link", comment = "围护产线类型关联字典")
public class MesEnclosureProductionLineTypeLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint  COMMENT '产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型id", notes = "字典类型id")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint  COMMENT '字典类型id'", nullable = true)
   private Long dictionaryId;

   public static MesEnclosureProductionLineTypeLink.MesEnclosureProductionLineTypeLinkBuilder builder() {
      return new MesEnclosureProductionLineTypeLink.MesEnclosureProductionLineTypeLinkBuilder();
   }

   public MesEnclosureProductionLineTypeLink() {
   }

   public MesEnclosureProductionLineTypeLink(final Long id, final Long productionLineId, final Long dictionaryId) {
      this.id = id;
      this.productionLineId = productionLineId;
      this.dictionaryId = dictionaryId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public MesEnclosureProductionLineTypeLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureProductionLineTypeLink setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MesEnclosureProductionLineTypeLink setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductionLineTypeLink(id="
         + this.getId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductionLineTypeLink)) {
         return false;
      }

      MesEnclosureProductionLineTypeLink other = (MesEnclosureProductionLineTypeLink)o;
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
            Object this$dictionaryId = this.getDictionaryId();
            Object other$dictionaryId = other.getDictionaryId();
            return this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductionLineTypeLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      return result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
   }

   public static class MesEnclosureProductionLineTypeLinkBuilder {
      private Long id;
      private Long productionLineId;
      private Long dictionaryId;

      MesEnclosureProductionLineTypeLinkBuilder() {
      }

      public MesEnclosureProductionLineTypeLink.MesEnclosureProductionLineTypeLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureProductionLineTypeLink.MesEnclosureProductionLineTypeLinkBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesEnclosureProductionLineTypeLink.MesEnclosureProductionLineTypeLinkBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public MesEnclosureProductionLineTypeLink build() {
         return new MesEnclosureProductionLineTypeLink(this.id, this.productionLineId, this.dictionaryId);
      }

      @Override
      public String toString() {
         return "MesEnclosureProductionLineTypeLink.MesEnclosureProductionLineTypeLinkBuilder(id="
            + this.id
            + ", productionLineId="
            + this.productionLineId
            + ", dictionaryId="
            + this.dictionaryId
            + ")";
      }
   }
}
