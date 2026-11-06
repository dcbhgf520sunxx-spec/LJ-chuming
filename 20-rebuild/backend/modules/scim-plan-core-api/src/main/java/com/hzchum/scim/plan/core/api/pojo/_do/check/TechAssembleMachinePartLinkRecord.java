package com.hzchum.scim.plan.core.api.pojo._do.check;

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

@ApiModel(value = "TechAssembleMachinePartLinkRecord对象", description = "部件(单元件)和零件(翼腹板)关联审核表 ")
@Entity
@TableName("tech_assemble_machine_part_link_record")
@Table(
   name = "tech_assemble_machine_part_link_record",
   indexes = {
         @Index(name = "id_assemble_record_id", columnList = "assemble_record_id"),
         @Index(name = "id_machine_part__record_id", columnList = "machine_part__record_id")
   }
)
public class TechAssembleMachinePartLinkRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inventoryOperationId", value = "清单操作记录表Id")
   @JsonProperty("inventoryOperationId")
   @JSONField(name = "inventoryOperationId")
   @TableField("inventory_operation_id")
   @Column(name = "inventory_operation_id", columnDefinition = "bigint(20)  COMMENT '清单操作记录表Id'", nullable = false)
   private Long inventoryOperationId;
   @ApiModelProperty(name = "assembleRecordId", value = "部件审核表Id")
   @JsonProperty("assembleRecordId")
   @JSONField(name = "assembleRecordId")
   @TableField("assemble_record_id")
   @Column(name = "assemble_record_id")
   private Long assembleRecordId;
   @ApiModelProperty(name = "machinePartRecordId", value = "零件审核表Id")
   @JsonProperty("machinePartRecordId")
   @JSONField(name = "machinePartRecordId")
   @TableField("machine_part__record_id")
   @Column(name = "machine_part__record_id")
   private Long machinePartRecordId;
   @ApiModelProperty(name = "quantity", value = "数量比例")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;

   public static TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder builder() {
      return new TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder();
   }

   public TechAssembleMachinePartLinkRecord() {
   }

   public TechAssembleMachinePartLinkRecord(
      final Long id, final Long inventoryOperationId, final Long assembleRecordId, final Long machinePartRecordId, final Integer quantity
   ) {
      this.id = id;
      this.inventoryOperationId = inventoryOperationId;
      this.assembleRecordId = assembleRecordId;
      this.machinePartRecordId = machinePartRecordId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public Long getAssembleRecordId() {
      return this.assembleRecordId;
   }

   public Long getMachinePartRecordId() {
      return this.machinePartRecordId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public TechAssembleMachinePartLinkRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechAssembleMachinePartLinkRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   @JsonProperty("assembleRecordId")
   public TechAssembleMachinePartLinkRecord setAssembleRecordId(final Long assembleRecordId) {
      this.assembleRecordId = assembleRecordId;
      return this;
   }

   @JsonProperty("machinePartRecordId")
   public TechAssembleMachinePartLinkRecord setMachinePartRecordId(final Long machinePartRecordId) {
      this.machinePartRecordId = machinePartRecordId;
      return this;
   }

   @JsonProperty("quantity")
   public TechAssembleMachinePartLinkRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleMachinePartLinkRecord(id="
         + this.getId()
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", assembleRecordId="
         + this.getAssembleRecordId()
         + ", machinePartRecordId="
         + this.getMachinePartRecordId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleMachinePartLinkRecord)) {
         return false;
      }

      TechAssembleMachinePartLinkRecord other = (TechAssembleMachinePartLinkRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inventoryOperationId = this.getInventoryOperationId();
         Object other$inventoryOperationId = other.getInventoryOperationId();
         if (this$inventoryOperationId == null ? other$inventoryOperationId == null : this$inventoryOperationId.equals(other$inventoryOperationId)) {
            Object this$assembleRecordId = this.getAssembleRecordId();
            Object other$assembleRecordId = other.getAssembleRecordId();
            if (this$assembleRecordId == null ? other$assembleRecordId == null : this$assembleRecordId.equals(other$assembleRecordId)) {
               Object this$machinePartRecordId = this.getMachinePartRecordId();
               Object other$machinePartRecordId = other.getMachinePartRecordId();
               if (this$machinePartRecordId == null ? other$machinePartRecordId == null : this$machinePartRecordId.equals(other$machinePartRecordId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechAssembleMachinePartLinkRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inventoryOperationId = this.getInventoryOperationId();
      result = result * 59 + ($inventoryOperationId == null ? 43 : $inventoryOperationId.hashCode());
      Object $assembleRecordId = this.getAssembleRecordId();
      result = result * 59 + ($assembleRecordId == null ? 43 : $assembleRecordId.hashCode());
      Object $machinePartRecordId = this.getMachinePartRecordId();
      result = result * 59 + ($machinePartRecordId == null ? 43 : $machinePartRecordId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TechAssembleMachinePartLinkRecordBuilder {
      private Long id;
      private Long inventoryOperationId;
      private Long assembleRecordId;
      private Long machinePartRecordId;
      private Integer quantity;

      TechAssembleMachinePartLinkRecordBuilder() {
      }

      @JsonProperty("id")
      public TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      @JsonProperty("assembleRecordId")
      public TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder assembleRecordId(final Long assembleRecordId) {
         this.assembleRecordId = assembleRecordId;
         return this;
      }

      @JsonProperty("machinePartRecordId")
      public TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder machinePartRecordId(final Long machinePartRecordId) {
         this.machinePartRecordId = machinePartRecordId;
         return this;
      }

      @JsonProperty("quantity")
      public TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAssembleMachinePartLinkRecord build() {
         return new TechAssembleMachinePartLinkRecord(this.id, this.inventoryOperationId, this.assembleRecordId, this.machinePartRecordId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechAssembleMachinePartLinkRecord.TechAssembleMachinePartLinkRecordBuilder(id="
            + this.id
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", assembleRecordId="
            + this.assembleRecordId
            + ", machinePartRecordId="
            + this.machinePartRecordId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
