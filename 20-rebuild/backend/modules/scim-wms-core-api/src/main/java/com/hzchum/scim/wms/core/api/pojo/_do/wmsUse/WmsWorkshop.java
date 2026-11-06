package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "WmsWorkshop对象", description = "")
@Entity
@TableName("wms_workshop")
@Table(name = "wms_workshop")
@org.hibernate.annotations.Table(appliesTo = "wms_workshop")
public class WmsWorkshop extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "车间名", notes = "车间名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '车间名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "workshopId", value = "建钢车间ID", notes = "建钢车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "int  COMMENT '建钢车间ID'", nullable = true)
   private Integer workshopId;

   public static WmsWorkshop.WmsWorkshopBuilder builder() {
      return new WmsWorkshop.WmsWorkshopBuilder();
   }

   public WmsWorkshop() {
   }

   public WmsWorkshop(final Long id, final String name, final Integer workshopId) {
      this.id = id;
      this.name = name;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getWorkshopId() {
      return this.workshopId;
   }

   public WmsWorkshop setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsWorkshop setName(final String name) {
      this.name = name;
      return this;
   }

   public WmsWorkshop setWorkshopId(final Integer workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsWorkshop(id=" + this.getId() + ", name=" + this.getName() + ", workshopId=" + this.getWorkshopId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsWorkshop)) {
         return false;
      }

      WmsWorkshop other = (WmsWorkshop)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsWorkshop;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class WmsWorkshopBuilder {
      private Long id;
      private String name;
      private Integer workshopId;

      WmsWorkshopBuilder() {
      }

      public WmsWorkshop.WmsWorkshopBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsWorkshop.WmsWorkshopBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsWorkshop.WmsWorkshopBuilder workshopId(final Integer workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WmsWorkshop build() {
         return new WmsWorkshop(this.id, this.name, this.workshopId);
      }

      @Override
      public String toString() {
         return "WmsWorkshop.WmsWorkshopBuilder(id=" + this.id + ", name=" + this.name + ", workshopId=" + this.workshopId + ")";
      }
   }
}
