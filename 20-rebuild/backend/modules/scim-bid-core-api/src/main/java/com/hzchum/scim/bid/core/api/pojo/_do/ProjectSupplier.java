package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "招标项目每一轮的科目", description = "")
@TableName("project_supplier")
@Table(name = "project_supplier")
public class ProjectSupplier implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "投标端供应商id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "UUID", value = "系统唯一id")
   @JsonProperty("UUID")
   @JSONField(name = "UUID")
   @TableField("UUID")
   @Column(name = "UUID")
   private String UUID;
   @ApiModelProperty(name = "bidStatus", value = "应标状态")
   @JsonProperty("bidStatus")
   @JSONField(name = "bidStatus")
   @TableField("bid_status")
   @Column(name = "bid_status", columnDefinition = "int default 0")
   private Integer bidStatus;

   public static ProjectSupplier.ProjectSupplierBuilder builder() {
      return new ProjectSupplier.ProjectSupplierBuilder();
   }

   public ProjectSupplier() {
   }

   public ProjectSupplier(final Long id, final Long projectId, final Long supplierId, final String UUID, final Integer bidStatus) {
      this.id = id;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.UUID = UUID;
      this.bidStatus = bidStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getUUID() {
      return this.UUID;
   }

   public Integer getBidStatus() {
      return this.bidStatus;
   }

   @JsonProperty("id")
   public ProjectSupplier setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectSupplier setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectSupplier setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("UUID")
   public ProjectSupplier setUUID(final String UUID) {
      this.UUID = UUID;
      return this;
   }

   @JsonProperty("bidStatus")
   public ProjectSupplier setBidStatus(final Integer bidStatus) {
      this.bidStatus = bidStatus;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSupplier)) {
         return false;
      }

      ProjectSupplier other = (ProjectSupplier)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$bidStatus = this.getBidStatus();
               Object other$bidStatus = other.getBidStatus();
               if (this$bidStatus == null ? other$bidStatus == null : this$bidStatus.equals(other$bidStatus)) {
                  Object this$UUID = this.getUUID();
                  Object other$UUID = other.getUUID();
                  return this$UUID == null ? other$UUID == null : this$UUID.equals(other$UUID);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSupplier;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $bidStatus = this.getBidStatus();
      result = result * 59 + ($bidStatus == null ? 43 : $bidStatus.hashCode());
      Object $UUID = this.getUUID();
      return result * 59 + ($UUID == null ? 43 : $UUID.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSupplier(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", UUID="
         + this.getUUID()
         + ", bidStatus="
         + this.getBidStatus()
         + ")";
   }

   public static class ProjectSupplierBuilder {
      private Long id;
      private Long projectId;
      private Long supplierId;
      private String UUID;
      private Integer bidStatus;

      ProjectSupplierBuilder() {
      }

      @JsonProperty("id")
      public ProjectSupplier.ProjectSupplierBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectSupplier.ProjectSupplierBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectSupplier.ProjectSupplierBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("UUID")
      public ProjectSupplier.ProjectSupplierBuilder UUID(final String UUID) {
         this.UUID = UUID;
         return this;
      }

      @JsonProperty("bidStatus")
      public ProjectSupplier.ProjectSupplierBuilder bidStatus(final Integer bidStatus) {
         this.bidStatus = bidStatus;
         return this;
      }

      public ProjectSupplier build() {
         return new ProjectSupplier(this.id, this.projectId, this.supplierId, this.UUID, this.bidStatus);
      }

      @Override
      public String toString() {
         return "ProjectSupplier.ProjectSupplierBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", UUID="
            + this.UUID
            + ", bidStatus="
            + this.bidStatus
            + ")";
      }
   }
}
