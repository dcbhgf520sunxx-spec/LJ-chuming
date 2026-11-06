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
import javax.persistence.Table;

@ApiModel(value = "TechArtifactStandardPartLinkRecord对象", description = "构件和配套件关联审核表 ")
@Entity
@TableName("tech_artifact_standard_part_link_record")
@Table(name = "tech_artifact_standard_part_link_record")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_standard_part_link_record", comment = "构件和配套件关联审核表 ")
public class TechArtifactStandardPartLinkRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
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
   @ApiModelProperty(name = "artifactRecordId", value = "构件审核表Id", notes = "构件审核表Id")
   @TableField("artifact_record_id")
   @Column(name = "artifact_record_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactRecordId;
   @ApiModelProperty(name = "standardPartRecordId", value = "标准件表(配套件)审核表Id", notes = "标准件表(配套件)审核表Id")
   @TableField("standard_part_record_id")
   @Column(name = "standard_part_record_id", columnDefinition = "bigint(20)  COMMENT '标准件表(配套件)id'", nullable = false)
   private Long standardPartRecordId;
   @ApiModelProperty(name = "quantity", value = "数量比例", notes = "数量比例")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量比例'", nullable = false)
   private Integer quantity;

   public static TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder builder() {
      return new TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder();
   }

   public TechArtifactStandardPartLinkRecord() {
   }

   public TechArtifactStandardPartLinkRecord(
      final Long id, final Long inventoryOperationId, final Long artifactRecordId, final Long standardPartRecordId, final Integer quantity
   ) {
      this.id = id;
      this.inventoryOperationId = inventoryOperationId;
      this.artifactRecordId = artifactRecordId;
      this.standardPartRecordId = standardPartRecordId;
      this.quantity = quantity;
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

   public Long getStandardPartRecordId() {
      return this.standardPartRecordId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public TechArtifactStandardPartLinkRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechArtifactStandardPartLinkRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechArtifactStandardPartLinkRecord setArtifactRecordId(final Long artifactRecordId) {
      this.artifactRecordId = artifactRecordId;
      return this;
   }

   public TechArtifactStandardPartLinkRecord setStandardPartRecordId(final Long standardPartRecordId) {
      this.standardPartRecordId = standardPartRecordId;
      return this;
   }

   public TechArtifactStandardPartLinkRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactStandardPartLinkRecord(id="
         + this.getId()
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", artifactRecordId="
         + this.getArtifactRecordId()
         + ", standardPartRecordId="
         + this.getStandardPartRecordId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactStandardPartLinkRecord)) {
         return false;
      }

      TechArtifactStandardPartLinkRecord other = (TechArtifactStandardPartLinkRecord)o;
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
               Object this$standardPartRecordId = this.getStandardPartRecordId();
               Object other$standardPartRecordId = other.getStandardPartRecordId();
               if (this$standardPartRecordId == null ? other$standardPartRecordId == null : this$standardPartRecordId.equals(other$standardPartRecordId)) {
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
      return other instanceof TechArtifactStandardPartLinkRecord;
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
      Object $standardPartRecordId = this.getStandardPartRecordId();
      result = result * 59 + ($standardPartRecordId == null ? 43 : $standardPartRecordId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class TechArtifactStandardPartLinkRecordBuilder {
      private Long id;
      private Long inventoryOperationId;
      private Long artifactRecordId;
      private Long standardPartRecordId;
      private Integer quantity;

      TechArtifactStandardPartLinkRecordBuilder() {
      }

      public TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder artifactRecordId(final Long artifactRecordId) {
         this.artifactRecordId = artifactRecordId;
         return this;
      }

      public TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder standardPartRecordId(final Long standardPartRecordId) {
         this.standardPartRecordId = standardPartRecordId;
         return this;
      }

      public TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactStandardPartLinkRecord build() {
         return new TechArtifactStandardPartLinkRecord(this.id, this.inventoryOperationId, this.artifactRecordId, this.standardPartRecordId, this.quantity);
      }

      @Override
      public String toString() {
         return "TechArtifactStandardPartLinkRecord.TechArtifactStandardPartLinkRecordBuilder(id="
            + this.id
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", artifactRecordId="
            + this.artifactRecordId
            + ", standardPartRecordId="
            + this.standardPartRecordId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
