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

@ApiModel(value = "MesInspectConfigUserLink对象", description = "质检用户表")
@Entity
@TableName("mes_inspect_config_user_link")
@Table(name = "mes_inspect_config_user_link")
@org.hibernate.annotations.Table(appliesTo = "mes_inspect_config_user_link", comment = "质检用户表")
public class MesInspectConfigUserLink extends BaseEntity<Long> implements Cloneable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inspectConfigId", value = "质检配置id", notes = "质检配置id")
   @TableField("inspect_config_id")
   @Column(name = "inspect_config_id", columnDefinition = "bigint(20)  COMMENT '质检配置id'", nullable = false)
   private Long inspectConfigId;
   @ApiModelProperty(name = "inspectUserId", value = "质检用户id", notes = "质检用户id")
   @TableField("inspect_user_id")
   @Column(name = "inspect_user_id", columnDefinition = "bigint(20)  COMMENT '质检用户id'", nullable = false)
   private Long inspectUserId;

   public MesInspectConfigUserLink clone() throws CloneNotSupportedException {
      return (MesInspectConfigUserLink)super.clone();
   }

   public static MesInspectConfigUserLink.MesInspectConfigUserLinkBuilder builder() {
      return new MesInspectConfigUserLink.MesInspectConfigUserLinkBuilder();
   }

   public MesInspectConfigUserLink() {
   }

   public MesInspectConfigUserLink(final Long id, final Long inspectConfigId, final Long inspectUserId) {
      this.id = id;
      this.inspectConfigId = inspectConfigId;
      this.inspectUserId = inspectUserId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectConfigId() {
      return this.inspectConfigId;
   }

   public Long getInspectUserId() {
      return this.inspectUserId;
   }

   public MesInspectConfigUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesInspectConfigUserLink setInspectConfigId(final Long inspectConfigId) {
      this.inspectConfigId = inspectConfigId;
      return this;
   }

   public MesInspectConfigUserLink setInspectUserId(final Long inspectUserId) {
      this.inspectUserId = inspectUserId;
      return this;
   }

   @Override
   public String toString() {
      return "MesInspectConfigUserLink(id="
         + this.getId()
         + ", inspectConfigId="
         + this.getInspectConfigId()
         + ", inspectUserId="
         + this.getInspectUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigUserLink)) {
         return false;
      }

      MesInspectConfigUserLink other = (MesInspectConfigUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectConfigId = this.getInspectConfigId();
         Object other$inspectConfigId = other.getInspectConfigId();
         if (this$inspectConfigId == null ? other$inspectConfigId == null : this$inspectConfigId.equals(other$inspectConfigId)) {
            Object this$inspectUserId = this.getInspectUserId();
            Object other$inspectUserId = other.getInspectUserId();
            return this$inspectUserId == null ? other$inspectUserId == null : this$inspectUserId.equals(other$inspectUserId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesInspectConfigUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectConfigId = this.getInspectConfigId();
      result = result * 59 + ($inspectConfigId == null ? 43 : $inspectConfigId.hashCode());
      Object $inspectUserId = this.getInspectUserId();
      return result * 59 + ($inspectUserId == null ? 43 : $inspectUserId.hashCode());
   }

   public static class MesInspectConfigUserLinkBuilder {
      private Long id;
      private Long inspectConfigId;
      private Long inspectUserId;

      MesInspectConfigUserLinkBuilder() {
      }

      public MesInspectConfigUserLink.MesInspectConfigUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigUserLink.MesInspectConfigUserLinkBuilder inspectConfigId(final Long inspectConfigId) {
         this.inspectConfigId = inspectConfigId;
         return this;
      }

      public MesInspectConfigUserLink.MesInspectConfigUserLinkBuilder inspectUserId(final Long inspectUserId) {
         this.inspectUserId = inspectUserId;
         return this;
      }

      public MesInspectConfigUserLink build() {
         return new MesInspectConfigUserLink(this.id, this.inspectConfigId, this.inspectUserId);
      }

      @Override
      public String toString() {
         return "MesInspectConfigUserLink.MesInspectConfigUserLinkBuilder(id="
            + this.id
            + ", inspectConfigId="
            + this.inspectConfigId
            + ", inspectUserId="
            + this.inspectUserId
            + ")";
      }
   }
}
