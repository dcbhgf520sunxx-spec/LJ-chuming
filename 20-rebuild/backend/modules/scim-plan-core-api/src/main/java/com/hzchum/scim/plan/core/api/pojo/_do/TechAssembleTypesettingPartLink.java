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

@ApiModel(value = "TechAssembleTypesettingPartLink对象", description = "母件和翼腹板关联表 ")
@Entity
@TableName("tech_assemble_typesetting_part_link")
@Table(name = "tech_assemble_typesetting_part_link")
@org.hibernate.annotations.Table(appliesTo = "tech_assemble_typesetting_part_link", comment = "母件和翼腹板关联表 ")
public class TechAssembleTypesettingPartLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleTypesettingId", value = "母件ID", notes = "母件ID")
   @TableField("assemble_typesetting_id")
   @Column(name = "assemble_typesetting_id", columnDefinition = "bigint(20)  COMMENT '母件ID'", nullable = false)
   private Long assembleTypesettingId;
   @ApiModelProperty(name = "machinePartId", value = "零件ID", notes = "零件ID")
   @TableField("machine_part_id")
   @Column(name = "machine_part_id", columnDefinition = "bigint(20)  COMMENT '零件ID'", nullable = false)
   private Long machinePartId;
   @ApiModelProperty(name = "quantity", value = "翼板腹板和母件数量比例", notes = "翼板腹板和母件数量比例")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '翼板腹板和母件数量比例'", nullable = false)
   private Integer quantity;

   public static TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder builder() {
      return new TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder();
   }

   public TechAssembleTypesettingPartLink() {
   }

   public TechAssembleTypesettingPartLink(final Long id, final Long assembleTypesettingId, final Long machinePartId, final Integer quantity) {
      this.id = id;
      this.assembleTypesettingId = assembleTypesettingId;
      this.machinePartId = machinePartId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleTypesettingId() {
      return this.assembleTypesettingId;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public TechAssembleTypesettingPartLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechAssembleTypesettingPartLink setAssembleTypesettingId(final Long assembleTypesettingId) {
      this.assembleTypesettingId = assembleTypesettingId;
      return this;
   }

   public TechAssembleTypesettingPartLink setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   public TechAssembleTypesettingPartLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleTypesettingPartLink(id="
         + this.getId()
         + ", assembleTypesettingId="
         + this.getAssembleTypesettingId()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleTypesettingPartLink)) {
         return false;
      }

      TechAssembleTypesettingPartLink other = (TechAssembleTypesettingPartLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleTypesettingId = this.getAssembleTypesettingId();
         Object other$assembleTypesettingId = other.getAssembleTypesettingId();
         if (this$assembleTypesettingId == null ? other$assembleTypesettingId == null : this$assembleTypesettingId.equals(other$assembleTypesettingId)) {
            Object this$machinePartId = this.getMachinePartId();
            Object other$machinePartId = other.getMachinePartId();
            if (this$machinePartId == null ? other$machinePartId == null : this$machinePartId.equals(other$machinePartId)) {
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
      return other instanceof TechAssembleTypesettingPartLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleTypesettingId = this.getAssembleTypesettingId();
      result = result * 59 + ($assembleTypesettingId == null ? 43 : $assembleTypesettingId.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TechAssembleTypesettingPartLinkBuilder {
      private Long id;
      private Long assembleTypesettingId;
      private Long machinePartId;
      private Integer quantity;

      TechAssembleTypesettingPartLinkBuilder() {
      }

      public TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder assembleTypesettingId(final Long assembleTypesettingId) {
         this.assembleTypesettingId = assembleTypesettingId;
         return this;
      }

      public TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      public TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAssembleTypesettingPartLink build() {
         return new TechAssembleTypesettingPartLink(this.id, this.assembleTypesettingId, this.machinePartId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechAssembleTypesettingPartLink.TechAssembleTypesettingPartLinkBuilder(id="
            + this.id
            + ", assembleTypesettingId="
            + this.assembleTypesettingId
            + ", machinePartId="
            + this.machinePartId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
