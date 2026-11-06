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
import javax.persistence.Table;

@ApiModel(value = "MesPartProcessConfigLink对象", description = "零件工序配置跟具体工序关联表")
@Entity
@TableName("mes_part_process_config_link")
@Table(name = "mes_part_process_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_part_process_config_link", comment = "零件工序配置跟具体工序关联表")
public class MesPartProcessConfigLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "processConfigId", value = "零件工序配置id", notes = "零件工序配置id")
   @TableField("process_config_id")
   @Column(name = "process_config_id", columnDefinition = "bigint(20)  COMMENT '零件工序配置id'", nullable = false)
   private Long processConfigId;
   @ApiModelProperty(name = "processId", value = "关联工序id", notes = "关联工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '关联工序id'", nullable = false)
   private Long processId;

   public static MesPartProcessConfigLink.MesPartProcessConfigLinkBuilder builder() {
      return new MesPartProcessConfigLink.MesPartProcessConfigLinkBuilder();
   }

   public MesPartProcessConfigLink() {
   }

   public MesPartProcessConfigLink(final Long id, final Long processConfigId, final Long processId) {
      this.id = id;
      this.processConfigId = processConfigId;
      this.processId = processId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessConfigId() {
      return this.processConfigId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public MesPartProcessConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesPartProcessConfigLink setProcessConfigId(final Long processConfigId) {
      this.processConfigId = processConfigId;
      return this;
   }

   public MesPartProcessConfigLink setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @Override
   public String toString() {
      return "MesPartProcessConfigLink(id=" + this.getId() + ", processConfigId=" + this.getProcessConfigId() + ", processId=" + this.getProcessId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPartProcessConfigLink)) {
         return false;
      }

      MesPartProcessConfigLink other = (MesPartProcessConfigLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processConfigId = this.getProcessConfigId();
         Object other$processConfigId = other.getProcessConfigId();
         if (this$processConfigId == null ? other$processConfigId == null : this$processConfigId.equals(other$processConfigId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesPartProcessConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processConfigId = this.getProcessConfigId();
      result = result * 59 + ($processConfigId == null ? 43 : $processConfigId.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }

   public static class MesPartProcessConfigLinkBuilder {
      private Long id;
      private Long processConfigId;
      private Long processId;

      MesPartProcessConfigLinkBuilder() {
      }

      public MesPartProcessConfigLink.MesPartProcessConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesPartProcessConfigLink.MesPartProcessConfigLinkBuilder processConfigId(final Long processConfigId) {
         this.processConfigId = processConfigId;
         return this;
      }

      public MesPartProcessConfigLink.MesPartProcessConfigLinkBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesPartProcessConfigLink build() {
         return new MesPartProcessConfigLink(this.id, this.processConfigId, this.processId);
      }

      @Override
      public String toString() {
         return "MesPartProcessConfigLink.MesPartProcessConfigLinkBuilder(id="
            + this.id
            + ", processConfigId="
            + this.processConfigId
            + ", processId="
            + this.processId
            + ")";
      }
   }
}
