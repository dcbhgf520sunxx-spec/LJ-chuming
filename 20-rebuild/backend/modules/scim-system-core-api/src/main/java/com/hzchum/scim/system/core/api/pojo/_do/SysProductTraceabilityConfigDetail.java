package com.hzchum.scim.system.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "SysProductTraceabilityConfigDetail对象", description = "产品溯源配置明细表")
@Entity
@TableName("sys_product_traceability_config_detail")
@Table(name = "sys_product_traceability_config_detail", indexes = @Index(name = "traceability_config_id", columnList = "traceability_config_id"))
@org.hibernate.annotations.Table(appliesTo = "sys_product_traceability_config_detail", comment = "产品溯源配置明细表")
public class SysProductTraceabilityConfigDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "traceabilityConfigId", value = "溯源配置id", notes = "溯源配置id")
   @TableField("traceability_config_id")
   @Column(name = "traceability_config_id", columnDefinition = "bigint(20) COMMENT '溯源配置id'", nullable = false)
   private Long traceabilityConfigId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = false)
   private Long projectId;

   public static SysProductTraceabilityConfigDetail.SysProductTraceabilityConfigDetailBuilder builder() {
      return new SysProductTraceabilityConfigDetail.SysProductTraceabilityConfigDetailBuilder();
   }

   public SysProductTraceabilityConfigDetail() {
   }

   public SysProductTraceabilityConfigDetail(final Long id, final Long traceabilityConfigId, final Long projectId) {
      this.id = id;
      this.traceabilityConfigId = traceabilityConfigId;
      this.projectId = projectId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTraceabilityConfigId() {
      return this.traceabilityConfigId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public SysProductTraceabilityConfigDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysProductTraceabilityConfigDetail setTraceabilityConfigId(final Long traceabilityConfigId) {
      this.traceabilityConfigId = traceabilityConfigId;
      return this;
   }

   public SysProductTraceabilityConfigDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @Override
   public String toString() {
      return "SysProductTraceabilityConfigDetail(id="
         + this.getId()
         + ", traceabilityConfigId="
         + this.getTraceabilityConfigId()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProductTraceabilityConfigDetail)) {
         return false;
      }

      SysProductTraceabilityConfigDetail other = (SysProductTraceabilityConfigDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$traceabilityConfigId = this.getTraceabilityConfigId();
         Object other$traceabilityConfigId = other.getTraceabilityConfigId();
         if (this$traceabilityConfigId == null ? other$traceabilityConfigId == null : this$traceabilityConfigId.equals(other$traceabilityConfigId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            return this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysProductTraceabilityConfigDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $traceabilityConfigId = this.getTraceabilityConfigId();
      result = result * 59 + ($traceabilityConfigId == null ? 43 : $traceabilityConfigId.hashCode());
      Object $projectId = this.getProjectId();
      return result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
   }

   public static class SysProductTraceabilityConfigDetailBuilder {
      private Long id;
      private Long traceabilityConfigId;
      private Long projectId;

      SysProductTraceabilityConfigDetailBuilder() {
      }

      public SysProductTraceabilityConfigDetail.SysProductTraceabilityConfigDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysProductTraceabilityConfigDetail.SysProductTraceabilityConfigDetailBuilder traceabilityConfigId(final Long traceabilityConfigId) {
         this.traceabilityConfigId = traceabilityConfigId;
         return this;
      }

      public SysProductTraceabilityConfigDetail.SysProductTraceabilityConfigDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SysProductTraceabilityConfigDetail build() {
         return new SysProductTraceabilityConfigDetail(this.id, this.traceabilityConfigId, this.projectId);
      }

      @Override
      public String toString() {
         return "SysProductTraceabilityConfigDetail.SysProductTraceabilityConfigDetailBuilder(id="
            + this.id
            + ", traceabilityConfigId="
            + this.traceabilityConfigId
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
