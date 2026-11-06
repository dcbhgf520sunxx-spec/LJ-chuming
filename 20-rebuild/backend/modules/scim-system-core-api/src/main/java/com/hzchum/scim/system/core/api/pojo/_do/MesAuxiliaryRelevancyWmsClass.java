package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "MesAuxiliaryRelevancyWmsClass对象", description = "MES配套件表关联WMS物料表")
@Entity
@TableName("mes_auxiliary_relevancy_wms_class")
@Table(name = "mes_auxiliary_relevancy_wms_class")
@org.hibernate.annotations.Table(appliesTo = "mes_auxiliary_relevancy_wms_class", comment = "MES配套件表关联WMS物料表")
public class MesAuxiliaryRelevancyWmsClass extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "auxiliaryId", value = "MES配套件Id", notes = "MES配套件Id")
   @TableField("auxiliary_id")
   @Column(name = "auxiliary_id", columnDefinition = "bigint  COMMENT 'MES配套件Id'", nullable = true)
   private Long auxiliaryId;
   @ApiModelProperty(name = "classifyId", value = "WMS物料科目ID", notes = "WMS物料科目ID")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT 'WMS物料科目ID'", nullable = true)
   private Long classifyId;

   public static MesAuxiliaryRelevancyWmsClass.MesAuxiliaryRelevancyWmsClassBuilder builder() {
      return new MesAuxiliaryRelevancyWmsClass.MesAuxiliaryRelevancyWmsClassBuilder();
   }

   public MesAuxiliaryRelevancyWmsClass() {
   }

   public MesAuxiliaryRelevancyWmsClass(final Long id, final Long auxiliaryId, final Long classifyId) {
      this.id = id;
      this.auxiliaryId = auxiliaryId;
      this.classifyId = classifyId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAuxiliaryId() {
      return this.auxiliaryId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public MesAuxiliaryRelevancyWmsClass setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesAuxiliaryRelevancyWmsClass setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
      return this;
   }

   public MesAuxiliaryRelevancyWmsClass setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @Override
   public String toString() {
      return "MesAuxiliaryRelevancyWmsClass(id=" + this.getId() + ", auxiliaryId=" + this.getAuxiliaryId() + ", classifyId=" + this.getClassifyId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAuxiliaryRelevancyWmsClass)) {
         return false;
      }

      MesAuxiliaryRelevancyWmsClass other = (MesAuxiliaryRelevancyWmsClass)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryId = this.getAuxiliaryId();
         Object other$auxiliaryId = other.getAuxiliaryId();
         if (this$auxiliaryId == null ? other$auxiliaryId == null : this$auxiliaryId.equals(other$auxiliaryId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            return this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesAuxiliaryRelevancyWmsClass;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryId = this.getAuxiliaryId();
      result = result * 59 + ($auxiliaryId == null ? 43 : $auxiliaryId.hashCode());
      Object $classifyId = this.getClassifyId();
      return result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
   }

   public static class MesAuxiliaryRelevancyWmsClassBuilder {
      private Long id;
      private Long auxiliaryId;
      private Long classifyId;

      MesAuxiliaryRelevancyWmsClassBuilder() {
      }

      public MesAuxiliaryRelevancyWmsClass.MesAuxiliaryRelevancyWmsClassBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesAuxiliaryRelevancyWmsClass.MesAuxiliaryRelevancyWmsClassBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      public MesAuxiliaryRelevancyWmsClass.MesAuxiliaryRelevancyWmsClassBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MesAuxiliaryRelevancyWmsClass build() {
         return new MesAuxiliaryRelevancyWmsClass(this.id, this.auxiliaryId, this.classifyId);
      }

      @Override
      public String toString() {
         return "MesAuxiliaryRelevancyWmsClass.MesAuxiliaryRelevancyWmsClassBuilder(id="
            + this.id
            + ", auxiliaryId="
            + this.auxiliaryId
            + ", classifyId="
            + this.classifyId
            + ")";
      }
   }
}
