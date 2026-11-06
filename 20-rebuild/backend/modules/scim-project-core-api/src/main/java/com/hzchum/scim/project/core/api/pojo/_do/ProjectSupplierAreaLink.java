package com.hzchum.scim.project.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectSupplierAreaLink对象", description = "分包供应商和区域关联表 ")
@Entity
@TableName("project_supplier_area_link")
@Table(name = "project_supplier_area_link")
@org.hibernate.annotations.Table(appliesTo = "project_supplier_area_link", comment = "分包供应商和区域关联表 ")
public class ProjectSupplierAreaLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'")
   private Long areaId;
   @ApiModelProperty(name = "supplierId", value = "分包供应商id", notes = "分包供应商id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分包供应商id'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名称", notes = "供应商名称")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(128)  COMMENT '供应商名称'", nullable = false)
   private String supplierName;
   @ApiModelProperty(name = "boolRelationStatus", value = "关联状态 1正常 0已中止", notes = "关联状态 1正常 0已中止")
   @JsonProperty("boolRelationStatus")
   @JSONField(name = "boolRelationStatus")
   @TableField("bool_relation_status")
   @Column(name = "bool_relation_status", columnDefinition = "tinyint(1) default '1' COMMENT '关联状态 1正常 0已中止'", nullable = false)
   private Boolean boolRelationStatus;
   @ApiModelProperty(name = "breakTime", value = "中止时间", notes = "中止时间")
   @JsonProperty("breakTime")
   @JSONField(name = "breakTime")
   @TableField("break_time")
   @Column(name = "break_time", columnDefinition = "datetime(6)  COMMENT '中止时间'")
   private LocalDateTime breakTime;
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
   @Column(name = "subcontract_class_id", columnDefinition = "bigint(20) default '1'  COMMENT '分包类别id'", nullable = false)
   private Long subcontractClassId;
   @ApiModelProperty(name = "boolSettlementStatus", value = "订单结算状态 1已结算0未结算", notes = "结算状态 1已结算0未结算")
   @JsonProperty("boolSettlementStatus")
   @JSONField(name = "boolSettlementStatus")
   @TableField("bool_settlement_status")
   @Column(name = "bool_settlement_status", columnDefinition = "tinyint(1) default '0' COMMENT '结算状态 1已结算0未结算'", nullable = false)
   private Boolean boolSettlementStatus;

   public static ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder builder() {
      return new ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder();
   }

   public ProjectSupplierAreaLink() {
   }

   public ProjectSupplierAreaLink(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long supplierId,
      final String supplierName,
      final Boolean boolRelationStatus,
      final LocalDateTime breakTime,
      final Long subcontractOrderId,
      final Long subcontractClassId,
      final Boolean boolSettlementStatus
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.boolRelationStatus = boolRelationStatus;
      this.breakTime = breakTime;
      this.subcontractOrderId = subcontractOrderId;
      this.subcontractClassId = subcontractClassId;
      this.boolSettlementStatus = boolSettlementStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Boolean getBoolRelationStatus() {
      return this.boolRelationStatus;
   }

   public LocalDateTime getBreakTime() {
      return this.breakTime;
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

   @JsonProperty("id")
   public ProjectSupplierAreaLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectSupplierAreaLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProjectSupplierAreaLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProjectSupplierAreaLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectSupplierAreaLink setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public ProjectSupplierAreaLink setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("boolRelationStatus")
   public ProjectSupplierAreaLink setBoolRelationStatus(final Boolean boolRelationStatus) {
      this.boolRelationStatus = boolRelationStatus;
      return this;
   }

   @JsonProperty("breakTime")
   public ProjectSupplierAreaLink setBreakTime(final LocalDateTime breakTime) {
      this.breakTime = breakTime;
      return this;
   }

   @JsonProperty("subcontractOrderId")
   public ProjectSupplierAreaLink setSubcontractOrderId(final Long subcontractOrderId) {
      this.subcontractOrderId = subcontractOrderId;
      return this;
   }

   @JsonProperty("subcontractClassId")
   public ProjectSupplierAreaLink setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   @JsonProperty("boolSettlementStatus")
   public ProjectSupplierAreaLink setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSupplierAreaLink(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", boolRelationStatus="
         + this.getBoolRelationStatus()
         + ", breakTime="
         + this.getBreakTime()
         + ", subcontractOrderId="
         + this.getSubcontractOrderId()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSupplierAreaLink)) {
         return false;
      }

      ProjectSupplierAreaLink other = (ProjectSupplierAreaLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$boolRelationStatus = this.getBoolRelationStatus();
                     Object other$boolRelationStatus = other.getBoolRelationStatus();
                     if (this$boolRelationStatus == null ? other$boolRelationStatus == null : this$boolRelationStatus.equals(other$boolRelationStatus)) {
                        Object this$subcontractOrderId = this.getSubcontractOrderId();
                        Object other$subcontractOrderId = other.getSubcontractOrderId();
                        if (this$subcontractOrderId == null ? other$subcontractOrderId == null : this$subcontractOrderId.equals(other$subcontractOrderId)) {
                           Object this$subcontractClassId = this.getSubcontractClassId();
                           Object other$subcontractClassId = other.getSubcontractClassId();
                           if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                              Object this$boolSettlementStatus = this.getBoolSettlementStatus();
                              Object other$boolSettlementStatus = other.getBoolSettlementStatus();
                              if (this$boolSettlementStatus == null
                                 ? other$boolSettlementStatus == null
                                 : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                                 Object this$supplierName = this.getSupplierName();
                                 Object other$supplierName = other.getSupplierName();
                                 if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                    Object this$breakTime = this.getBreakTime();
                                    Object other$breakTime = other.getBreakTime();
                                    return this$breakTime == null ? other$breakTime == null : this$breakTime.equals(other$breakTime);
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
      return other instanceof ProjectSupplierAreaLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $boolRelationStatus = this.getBoolRelationStatus();
      result = result * 59 + ($boolRelationStatus == null ? 43 : $boolRelationStatus.hashCode());
      Object $subcontractOrderId = this.getSubcontractOrderId();
      result = result * 59 + ($subcontractOrderId == null ? 43 : $subcontractOrderId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $breakTime = this.getBreakTime();
      return result * 59 + ($breakTime == null ? 43 : $breakTime.hashCode());
   }

   public static class ProjectSupplierAreaLinkBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long supplierId;
      private String supplierName;
      private Boolean boolRelationStatus;
      private LocalDateTime breakTime;
      private Long subcontractOrderId;
      private Long subcontractClassId;
      private Boolean boolSettlementStatus;

      ProjectSupplierAreaLinkBuilder() {
      }

      @JsonProperty("id")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("boolRelationStatus")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder boolRelationStatus(final Boolean boolRelationStatus) {
         this.boolRelationStatus = boolRelationStatus;
         return this;
      }

      @JsonProperty("breakTime")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder breakTime(final LocalDateTime breakTime) {
         this.breakTime = breakTime;
         return this;
      }

      @JsonProperty("subcontractOrderId")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder subcontractOrderId(final Long subcontractOrderId) {
         this.subcontractOrderId = subcontractOrderId;
         return this;
      }

      @JsonProperty("subcontractClassId")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      @JsonProperty("boolSettlementStatus")
      public ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public ProjectSupplierAreaLink build() {
         return new ProjectSupplierAreaLink(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.supplierId,
            this.supplierName,
            this.boolRelationStatus,
            this.breakTime,
            this.subcontractOrderId,
            this.subcontractClassId,
            this.boolSettlementStatus
         );
      }

      @Override
      public String toString() {
         return "ProjectSupplierAreaLink.ProjectSupplierAreaLinkBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", boolRelationStatus="
            + this.boolRelationStatus
            + ", breakTime="
            + this.breakTime
            + ", subcontractOrderId="
            + this.subcontractOrderId
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ")";
      }
   }
}
