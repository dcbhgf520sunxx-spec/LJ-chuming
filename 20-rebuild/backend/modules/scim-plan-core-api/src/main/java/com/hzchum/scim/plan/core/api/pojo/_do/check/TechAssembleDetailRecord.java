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

@ApiModel(value = "TechAssembleDetailRecord对象", description = "构件和部件(单元件)关联审核表")
@Entity
@TableName("tech_assemble_detail_record")
@Table(
   name = "tech_assemble_detail_record",
   indexes = {
         @Index(name = "id_artifact_record_id", columnList = "artifact_record_id"),
         @Index(name = "id_inventory_operation_id", columnList = "inventory_operation_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "tech_assemble_detail_record", comment = "构件和部件(单元件)关联审核表")
public class TechAssembleDetailRecord extends BaseEntity<Long> {
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
   @Column(name = "assemble_record_id", columnDefinition = "bigint(20) comment '部件审核表Id'", nullable = false)
   private Long assembleRecordId;
   @ApiModelProperty(name = "artifactRecordId", value = "构件审核表Id")
   @JsonProperty("artifactRecordId")
   @JSONField(name = "artifactRecordId")
   @TableField("artifact_record_id")
   @Column(name = "artifact_record_id", columnDefinition = "bigint(20) comment '构件审核表Id'", nullable = false)
   private Long artifactRecordId;
   @ApiModelProperty(name = "quantity", value = "部件数量和构件数量比例")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  comment '部件数量和构件数量比例'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "booInventory", value = "是否清单导入 true是 false否")
   @TableField("bool_inventory")
   @Column(name = "bool_inventory", columnDefinition = "tinyint(1) default 1 comment '是否清单导入 1是 0否'")
   private Boolean booInventory;

   public static TechAssembleDetailRecord.TechAssembleDetailRecordBuilder builder() {
      return new TechAssembleDetailRecord.TechAssembleDetailRecordBuilder();
   }

   public TechAssembleDetailRecord() {
   }

   public TechAssembleDetailRecord(
      final Long id,
      final Long inventoryOperationId,
      final Long assembleRecordId,
      final Long artifactRecordId,
      final Integer quantity,
      final Boolean booInventory
   ) {
      this.id = id;
      this.inventoryOperationId = inventoryOperationId;
      this.assembleRecordId = assembleRecordId;
      this.artifactRecordId = artifactRecordId;
      this.quantity = quantity;
      this.booInventory = booInventory;
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

   public Long getArtifactRecordId() {
      return this.artifactRecordId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBooInventory() {
      return this.booInventory;
   }

   @JsonProperty("id")
   public TechAssembleDetailRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechAssembleDetailRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   @JsonProperty("assembleRecordId")
   public TechAssembleDetailRecord setAssembleRecordId(final Long assembleRecordId) {
      this.assembleRecordId = assembleRecordId;
      return this;
   }

   @JsonProperty("artifactRecordId")
   public TechAssembleDetailRecord setArtifactRecordId(final Long artifactRecordId) {
      this.artifactRecordId = artifactRecordId;
      return this;
   }

   @JsonProperty("quantity")
   public TechAssembleDetailRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechAssembleDetailRecord setBooInventory(final Boolean booInventory) {
      this.booInventory = booInventory;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleDetailRecord(id="
         + this.getId()
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", assembleRecordId="
         + this.getAssembleRecordId()
         + ", artifactRecordId="
         + this.getArtifactRecordId()
         + ", quantity="
         + this.getQuantity()
         + ", booInventory="
         + this.getBooInventory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleDetailRecord)) {
         return false;
      }

      TechAssembleDetailRecord other = (TechAssembleDetailRecord)o;
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
               Object this$artifactRecordId = this.getArtifactRecordId();
               Object other$artifactRecordId = other.getArtifactRecordId();
               if (this$artifactRecordId == null ? other$artifactRecordId == null : this$artifactRecordId.equals(other$artifactRecordId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$booInventory = this.getBooInventory();
                     Object other$booInventory = other.getBooInventory();
                     return this$booInventory == null ? other$booInventory == null : this$booInventory.equals(other$booInventory);
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
      return other instanceof TechAssembleDetailRecord;
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
      Object $artifactRecordId = this.getArtifactRecordId();
      result = result * 59 + ($artifactRecordId == null ? 43 : $artifactRecordId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $booInventory = this.getBooInventory();
      return result * 59 + ($booInventory == null ? 43 : $booInventory.hashCode());
   }

   public static class TechAssembleDetailRecordBuilder {
      private Long id;
      private Long inventoryOperationId;
      private Long assembleRecordId;
      private Long artifactRecordId;
      private Integer quantity;
      private Boolean booInventory;

      TechAssembleDetailRecordBuilder() {
      }

      @JsonProperty("id")
      public TechAssembleDetailRecord.TechAssembleDetailRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechAssembleDetailRecord.TechAssembleDetailRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      @JsonProperty("assembleRecordId")
      public TechAssembleDetailRecord.TechAssembleDetailRecordBuilder assembleRecordId(final Long assembleRecordId) {
         this.assembleRecordId = assembleRecordId;
         return this;
      }

      @JsonProperty("artifactRecordId")
      public TechAssembleDetailRecord.TechAssembleDetailRecordBuilder artifactRecordId(final Long artifactRecordId) {
         this.artifactRecordId = artifactRecordId;
         return this;
      }

      @JsonProperty("quantity")
      public TechAssembleDetailRecord.TechAssembleDetailRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAssembleDetailRecord.TechAssembleDetailRecordBuilder booInventory(final Boolean booInventory) {
         this.booInventory = booInventory;
         return this;
      }

      public TechAssembleDetailRecord build() {
         return new TechAssembleDetailRecord(this.id, this.inventoryOperationId, this.assembleRecordId, this.artifactRecordId, this.quantity, this.booInventory);
      }

      @Override
      public String toString() {
         return "TechAssembleDetailRecord.TechAssembleDetailRecordBuilder(id="
            + this.id
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", assembleRecordId="
            + this.assembleRecordId
            + ", artifactRecordId="
            + this.artifactRecordId
            + ", quantity="
            + this.quantity
            + ", booInventory="
            + this.booInventory
            + ")";
      }
   }
}
