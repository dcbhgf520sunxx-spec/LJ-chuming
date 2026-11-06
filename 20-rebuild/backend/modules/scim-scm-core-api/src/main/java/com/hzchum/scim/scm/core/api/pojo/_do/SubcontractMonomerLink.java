package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "SubcontractMonomerLink对象", description = "单体分包订单关联表 ")
@Entity
@TableName("scm_subcontract_monomer_link")
@Table(name = "scm_subcontract_monomer_link")
@org.hibernate.annotations.Table(appliesTo = "scm_subcontract_monomer_link", comment = "单体分包订单关联表 ")
public class SubcontractMonomerLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "subcontractOrderId", value = "分包订单ID", notes = "分包订单ID")
   @JsonProperty("subcontractOrderId")
   @JSONField(name = "subcontractOrderId")
   @TableField("subcontract_order_id")
   @Column(name = "subcontract_order_id", columnDefinition = "bigint(20)  COMMENT '分包订单ID'", nullable = false)
   private Long subcontractOrderId;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   @JsonProperty("subcontractClassId")
   @JSONField(name = "subcontractClassId")
   @TableField("subcontract_class_id")
   @Column(name = "subcontract_class_id", columnDefinition = "bigint(20)  COMMENT '分包类别id'", nullable = false)
   private Long subcontractClassId;
   @ApiModelProperty(name = "boolSettlementStatus", value = "订单结算状态 1已结算0未结算", notes = "结算状态 1已结算0未结算")
   @JsonProperty("boolSettlementStatus")
   @JSONField(name = "boolSettlementStatus")
   @TableField("bool_settlement_status")
   @Column(name = "bool_settlement_status", columnDefinition = "tinyint(1) default '0' COMMENT '结算状态 1已结算0未结算'", nullable = false)
   private Boolean boolSettlementStatus;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分包单位(供应商)id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '分包单位(供应商)'")
   private String supplierName;

   public static SubcontractMonomerLink.SubcontractMonomerLinkBuilder builder() {
      return new SubcontractMonomerLink.SubcontractMonomerLinkBuilder();
   }

   public SubcontractMonomerLink() {
   }

   public SubcontractMonomerLink(
      final Long id,
      final Long subcontractOrderId,
      final Long subcontractClassId,
      final Boolean boolSettlementStatus,
      final Long monomerId,
      final Long projectId,
      final Long supplierId,
      final String supplierName
   ) {
      this.id = id;
      this.subcontractOrderId = subcontractOrderId;
      this.subcontractClassId = subcontractClassId;
      this.boolSettlementStatus = boolSettlementStatus;
      this.monomerId = monomerId;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSubcontractOrderId() {
      return this.subcontractOrderId;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   @JsonProperty("id")
   public SubcontractMonomerLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("subcontractOrderId")
   public SubcontractMonomerLink setSubcontractOrderId(final Long subcontractOrderId) {
      this.subcontractOrderId = subcontractOrderId;
      return this;
   }

   @JsonProperty("subcontractClassId")
   public SubcontractMonomerLink setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   @JsonProperty("boolSettlementStatus")
   public SubcontractMonomerLink setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
      return this;
   }

   @JsonProperty("monomerId")
   public SubcontractMonomerLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("projectId")
   public SubcontractMonomerLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("supplierId")
   public SubcontractMonomerLink setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public SubcontractMonomerLink setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @Override
   public String toString() {
      return "SubcontractMonomerLink(id="
         + this.getId()
         + ", subcontractOrderId="
         + this.getSubcontractOrderId()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ", monomerId="
         + this.getMonomerId()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractMonomerLink)) {
         return false;
      }

      SubcontractMonomerLink other = (SubcontractMonomerLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$subcontractOrderId = this.getSubcontractOrderId();
         Object other$subcontractOrderId = other.getSubcontractOrderId();
         if (this$subcontractOrderId == null ? other$subcontractOrderId == null : this$subcontractOrderId.equals(other$subcontractOrderId)) {
            Object this$subcontractClassId = this.getSubcontractClassId();
            Object other$subcontractClassId = other.getSubcontractClassId();
            if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
               Object this$boolSettlementStatus = this.getBoolSettlementStatus();
               Object other$boolSettlementStatus = other.getBoolSettlementStatus();
               if (this$boolSettlementStatus == null ? other$boolSettlementStatus == null : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           return this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SubcontractMonomerLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subcontractOrderId = this.getSubcontractOrderId();
      result = result * 59 + ($subcontractOrderId == null ? 43 : $subcontractOrderId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   public static class SubcontractMonomerLinkBuilder {
      private Long id;
      private Long subcontractOrderId;
      private Long subcontractClassId;
      private Boolean boolSettlementStatus;
      private Long monomerId;
      private Long projectId;
      private Long supplierId;
      private String supplierName;

      SubcontractMonomerLinkBuilder() {
      }

      @JsonProperty("id")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("subcontractOrderId")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      @JsonProperty("subcontractClassId")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      @JsonProperty("boolSettlementStatus")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      @JsonProperty("monomerId")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("projectId")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("supplierId")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public SubcontractMonomerLink.SubcontractMonomerLinkBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubcontractMonomerLink build() {
         return new SubcontractMonomerLink(
            this.id,
            this.subcontractOrderId,
            this.subcontractClassId,
            this.boolSettlementStatus,
            this.monomerId,
            this.projectId,
            this.supplierId,
            this.supplierName
         );
      }

      @Override
      public String toString() {
         return "SubcontractMonomerLink.SubcontractMonomerLinkBuilder(id="
            + this.id
            + ", subcontractOrderId="
            + this.subcontractOrderId
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ", monomerId="
            + this.monomerId
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ")";
      }
   }
}
