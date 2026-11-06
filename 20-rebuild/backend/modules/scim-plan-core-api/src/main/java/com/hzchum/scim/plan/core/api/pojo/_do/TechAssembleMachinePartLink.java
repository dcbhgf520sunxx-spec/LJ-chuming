package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechAssembleMachinePartLink对象", description = "部件和翼腹板关联表 ")
@Entity
@TableName("tech_assemble_machine_part_link")
@Table(
   name = "tech_assemble_machine_part_link",
   indexes = {@Index(name = "assemble_id", columnList = "assemble_id"), @Index(name = "machine_part_id", columnList = "machine_part_id")}
)
public class TechAssembleMachinePartLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleId", value = "组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   @TableField("assemble_id")
   @Column(name = "assemble_id")
   private Long assembleId;
   @ApiModelProperty(name = "machinePartId", value = "零件id")
   @JsonProperty("machinePartId")
   @JSONField(name = "machinePartId")
   @TableField("machine_part_id")
   @Column(name = "machine_part_id")
   private Long machinePartId;
   @ApiModelProperty(name = "quantity", value = "翼腹板和部件数量比例")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;

   public static TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder builder() {
      return new TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder();
   }

   public TechAssembleMachinePartLink() {
   }

   public TechAssembleMachinePartLink(final Long id, final Long assembleId, final Long machinePartId, final Integer quantity) {
      this.id = id;
      this.assembleId = assembleId;
      this.machinePartId = machinePartId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public TechAssembleMachinePartLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("assembleId")
   public TechAssembleMachinePartLink setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("machinePartId")
   public TechAssembleMachinePartLink setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   @JsonProperty("quantity")
   public TechAssembleMachinePartLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleMachinePartLink(id="
         + this.getId()
         + ", assembleId="
         + this.getAssembleId()
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

      if (!(o instanceof TechAssembleMachinePartLink)) {
         return false;
      }

      TechAssembleMachinePartLink other = (TechAssembleMachinePartLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleId = this.getAssembleId();
         Object other$assembleId = other.getAssembleId();
         if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
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
      return other instanceof TechAssembleMachinePartLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TechAssembleMachinePartLinkBuilder {
      private Long id;
      private Long assembleId;
      private Long machinePartId;
      private Integer quantity;

      TechAssembleMachinePartLinkBuilder() {
      }

      @JsonProperty("id")
      public TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleId")
      public TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("machinePartId")
      public TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      @JsonProperty("quantity")
      public TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAssembleMachinePartLink build() {
         return new TechAssembleMachinePartLink(this.id, this.assembleId, this.machinePartId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechAssembleMachinePartLink.TechAssembleMachinePartLinkBuilder(id="
            + this.id
            + ", assembleId="
            + this.assembleId
            + ", machinePartId="
            + this.machinePartId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
