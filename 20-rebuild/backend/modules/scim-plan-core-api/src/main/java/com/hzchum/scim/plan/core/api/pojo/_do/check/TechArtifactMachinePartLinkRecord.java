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

@ApiModel(value = "TechArtifactMachinePartLinkRecord对象", description = "构件零件关联审核表 ")
@Entity
@TableName("tech_artifact_machine_part_link_record")
@Table(
   name = "tech_artifact_machine_part_link_record",
   indexes = {
         @Index(name = "id_artifact_record_id", columnList = "artifact_record_id"),
         @Index(name = "id_machine_part_record_id", columnList = "machine_part_record_id"),
         @Index(name = "id_inventory_operation_id", columnList = "inventory_operation_id")
   }
)
public class TechArtifactMachinePartLinkRecord extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "artifactRecordId", value = "构件审核表Id")
   @JsonProperty("artifactRecordId")
   @JSONField(name = "artifactRecordId")
   @TableField("artifact_record_id")
   @Column(name = "artifact_record_id")
   private Long artifactRecordId;
   @ApiModelProperty(name = "machinePartRecordId", value = "零件审核表Id")
   @JsonProperty("machinePartRecordId")
   @JSONField(name = "machinePartRecordId")
   @TableField("machine_part_record_id")
   @Column(name = "machine_part_record_id")
   private Long machinePartRecordId;
   @ApiModelProperty(name = "quantity", value = "零件和构件的数量比例")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) comment '零件和构件的数量比例'")
   private Integer quantity;
   @ApiModelProperty(name = "remark", value = "该构件内零件备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024) comment '该构件内零件备注'")
   private String remark;

   public static TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder builder() {
      return new TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder();
   }

   public TechArtifactMachinePartLinkRecord() {
   }

   public TechArtifactMachinePartLinkRecord(
      final Long id, final Long inventoryOperationId, final Long artifactRecordId, final Long machinePartRecordId, final Integer quantity, final String remark
   ) {
      this.id = id;
      this.inventoryOperationId = inventoryOperationId;
      this.artifactRecordId = artifactRecordId;
      this.machinePartRecordId = machinePartRecordId;
      this.quantity = quantity;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public Long getArtifactRecordId() {
      return this.artifactRecordId;
   }

   public Long getMachinePartRecordId() {
      return this.machinePartRecordId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public TechArtifactMachinePartLinkRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechArtifactMachinePartLinkRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   @JsonProperty("artifactRecordId")
   public TechArtifactMachinePartLinkRecord setArtifactRecordId(final Long artifactRecordId) {
      this.artifactRecordId = artifactRecordId;
      return this;
   }

   @JsonProperty("machinePartRecordId")
   public TechArtifactMachinePartLinkRecord setMachinePartRecordId(final Long machinePartRecordId) {
      this.machinePartRecordId = machinePartRecordId;
      return this;
   }

   public TechArtifactMachinePartLinkRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechArtifactMachinePartLinkRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactMachinePartLinkRecord(id="
         + this.getId()
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", artifactRecordId="
         + this.getArtifactRecordId()
         + ", machinePartRecordId="
         + this.getMachinePartRecordId()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactMachinePartLinkRecord)) {
         return false;
      }

      TechArtifactMachinePartLinkRecord other = (TechArtifactMachinePartLinkRecord)o;
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
            Object this$artifactRecordId = this.getArtifactRecordId();
            Object other$artifactRecordId = other.getArtifactRecordId();
            if (this$artifactRecordId == null ? other$artifactRecordId == null : this$artifactRecordId.equals(other$artifactRecordId)) {
               Object this$machinePartRecordId = this.getMachinePartRecordId();
               Object other$machinePartRecordId = other.getMachinePartRecordId();
               if (this$machinePartRecordId == null ? other$machinePartRecordId == null : this$machinePartRecordId.equals(other$machinePartRecordId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechArtifactMachinePartLinkRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inventoryOperationId = this.getInventoryOperationId();
      result = result * 59 + ($inventoryOperationId == null ? 43 : $inventoryOperationId.hashCode());
      Object $artifactRecordId = this.getArtifactRecordId();
      result = result * 59 + ($artifactRecordId == null ? 43 : $artifactRecordId.hashCode());
      Object $machinePartRecordId = this.getMachinePartRecordId();
      result = result * 59 + ($machinePartRecordId == null ? 43 : $machinePartRecordId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechArtifactMachinePartLinkRecordBuilder {
      private Long id;
      private Long inventoryOperationId;
      private Long artifactRecordId;
      private Long machinePartRecordId;
      private Integer quantity;
      private String remark;

      TechArtifactMachinePartLinkRecordBuilder() {
      }

      @JsonProperty("id")
      public TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      @JsonProperty("artifactRecordId")
      public TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder artifactRecordId(final Long artifactRecordId) {
         this.artifactRecordId = artifactRecordId;
         return this;
      }

      @JsonProperty("machinePartRecordId")
      public TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder machinePartRecordId(final Long machinePartRecordId) {
         this.machinePartRecordId = machinePartRecordId;
         return this;
      }

      public TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactMachinePartLinkRecord build() {
         return new TechArtifactMachinePartLinkRecord(
            this.id, this.inventoryOperationId, this.artifactRecordId, this.machinePartRecordId, this.quantity, this.remark
         );
      }

      @Override
      public String toString() {
         return "TechArtifactMachinePartLinkRecord.TechArtifactMachinePartLinkRecordBuilder(id="
            + this.id
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", artifactRecordId="
            + this.artifactRecordId
            + ", machinePartRecordId="
            + this.machinePartRecordId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
