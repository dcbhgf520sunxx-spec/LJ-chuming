package com.hzchum.scim.system.core.api.pojo._do.notification;

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

@ApiModel(value = "SysPushFlowLinkConfig对象", description = "")
@Entity
@TableName("sys_push_flow_link_config")
@Table(name = "sys_push_flow_link_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_flow_link_config")
public class SysPushFlowLinkConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "sysPushFlowConfigId", value = "流程配置id", notes = "流程配置id")
   @TableField("sys_push_flow_config_id")
   @Column(name = "sys_push_flow_config_id", columnDefinition = "bigint(20)  COMMENT '流程配置id'", nullable = false)
   private Long sysPushFlowConfigId;
   @ApiModelProperty(name = "pId", value = "父级id", notes = "父级id")
   @TableField("p_id")
   @Column(name = "p_id", columnDefinition = "bigint(20)  COMMENT '父级id'", nullable = true)
   private Long pId;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   @TableField("notification_type_enum")
   @Column(name = "notification_type_enum", columnDefinition = "int(11)  COMMENT '通知业务'", nullable = false)
   private Integer notificationTypeEnum;

   public static SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder builder() {
      return new SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder();
   }

   public SysPushFlowLinkConfig() {
   }

   public SysPushFlowLinkConfig(final Long id, final Long sysPushFlowConfigId, final Long pId, final Integer notificationTypeEnum) {
      this.id = id;
      this.sysPushFlowConfigId = sysPushFlowConfigId;
      this.pId = pId;
      this.notificationTypeEnum = notificationTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSysPushFlowConfigId() {
      return this.sysPushFlowConfigId;
   }

   public Long getPId() {
      return this.pId;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public SysPushFlowLinkConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushFlowLinkConfig setSysPushFlowConfigId(final Long sysPushFlowConfigId) {
      this.sysPushFlowConfigId = sysPushFlowConfigId;
      return this;
   }

   public SysPushFlowLinkConfig setPId(final Long pId) {
      this.pId = pId;
      return this;
   }

   public SysPushFlowLinkConfig setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushFlowLinkConfig(id="
         + this.getId()
         + ", sysPushFlowConfigId="
         + this.getSysPushFlowConfigId()
         + ", pId="
         + this.getPId()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushFlowLinkConfig)) {
         return false;
      }

      SysPushFlowLinkConfig other = (SysPushFlowLinkConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysPushFlowConfigId = this.getSysPushFlowConfigId();
         Object other$sysPushFlowConfigId = other.getSysPushFlowConfigId();
         if (this$sysPushFlowConfigId == null ? other$sysPushFlowConfigId == null : this$sysPushFlowConfigId.equals(other$sysPushFlowConfigId)) {
            Object this$pId = this.getPId();
            Object other$pId = other.getPId();
            if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
               Object this$notificationTypeEnum = this.getNotificationTypeEnum();
               Object other$notificationTypeEnum = other.getNotificationTypeEnum();
               return this$notificationTypeEnum == null ? other$notificationTypeEnum == null : this$notificationTypeEnum.equals(other$notificationTypeEnum);
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
      return other instanceof SysPushFlowLinkConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysPushFlowConfigId = this.getSysPushFlowConfigId();
      result = result * 59 + ($sysPushFlowConfigId == null ? 43 : $sysPushFlowConfigId.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      return result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
   }

   public static class SysPushFlowLinkConfigBuilder {
      private Long id;
      private Long sysPushFlowConfigId;
      private Long pId;
      private Integer notificationTypeEnum;

      SysPushFlowLinkConfigBuilder() {
      }

      public SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder sysPushFlowConfigId(final Long sysPushFlowConfigId) {
         this.sysPushFlowConfigId = sysPushFlowConfigId;
         return this;
      }

      public SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder pId(final Long pId) {
         this.pId = pId;
         return this;
      }

      public SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushFlowLinkConfig build() {
         return new SysPushFlowLinkConfig(this.id, this.sysPushFlowConfigId, this.pId, this.notificationTypeEnum);
      }

      @Override
      public String toString() {
         return "SysPushFlowLinkConfig.SysPushFlowLinkConfigBuilder(id="
            + this.id
            + ", sysPushFlowConfigId="
            + this.sysPushFlowConfigId
            + ", pId="
            + this.pId
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ")";
      }
   }
}
