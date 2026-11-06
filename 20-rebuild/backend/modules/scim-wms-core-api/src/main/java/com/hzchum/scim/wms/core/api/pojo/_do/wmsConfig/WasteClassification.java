package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@ApiModel(value = "WasteClassification对象", description = "废料种类-配置 ")
@Entity
@TableName("wms_waste_classification")
@Table(name = "wms_waste_classification")
@org.hibernate.annotations.Table(appliesTo = "wms_waste_classification", comment = "废料种类-配置 ")
public class WasteClassification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(32)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(32)  COMMENT '单位'", nullable = false)
   private String measureUnit;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long userId;

   public static WasteClassification.WasteClassificationBuilder builder() {
      return new WasteClassification.WasteClassificationBuilder();
   }

   public WasteClassification() {
   }

   public WasteClassification(final Long id, final String name, final String measureUnit, final Long userId) {
      this.id = id;
      this.name = name;
      this.measureUnit = measureUnit;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Long getUserId() {
      return this.userId;
   }

   public WasteClassification setId(final Long id) {
      this.id = id;
      return this;
   }

   public WasteClassification setName(final String name) {
      this.name = name;
      return this;
   }

   public WasteClassification setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public WasteClassification setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "WasteClassification(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteClassification)) {
         return false;
      }

      WasteClassification other = (WasteClassification)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$measureUnit = this.getMeasureUnit();
               Object other$measureUnit = other.getMeasureUnit();
               return this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit);
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
      return other instanceof WasteClassification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      return result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
   }

   public static class WasteClassificationBuilder {
      private Long id;
      private String name;
      private String measureUnit;
      private Long userId;

      WasteClassificationBuilder() {
      }

      public WasteClassification.WasteClassificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteClassification.WasteClassificationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WasteClassification.WasteClassificationBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public WasteClassification.WasteClassificationBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public WasteClassification build() {
         return new WasteClassification(this.id, this.name, this.measureUnit, this.userId);
      }

      @Override
      public String toString() {
         return "WasteClassification.WasteClassificationBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", measureUnit="
            + this.measureUnit
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
