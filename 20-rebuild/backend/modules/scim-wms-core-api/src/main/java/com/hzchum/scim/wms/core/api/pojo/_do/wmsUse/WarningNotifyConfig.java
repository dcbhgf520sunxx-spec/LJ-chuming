package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "WarningNotifyConfig对象", description = "预警通知对象 ")
@Entity
@TableName("wms_warning_notify_config")
@Table(name = "wms_warning_notify_config")
public class WarningNotifyConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "deptIds", value = "通知部门ID集", notes = "通知部门ID集")
   @JsonProperty("deptIds")
   @JSONField(name = "deptIds")
   @TableField("dept_ids")
   @Column(name = "dept_ids", columnDefinition = "varchar(255)  COMMENT '通知部门ID集'", nullable = true)
   private String deptIds;
   @ApiModelProperty(name = "userIds", value = "通知人员ID集", notes = "通知人员ID集")
   @JsonProperty("userIds")
   @JSONField(name = "userIds")
   @TableField("user_ids")
   @Column(name = "user_ids", columnDefinition = "varchar(255)  COMMENT '通知人员ID集'", nullable = true)
   private String userIds;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;

   public static WarningNotifyConfig.WarningNotifyConfigBuilder builder() {
      return new WarningNotifyConfig.WarningNotifyConfigBuilder();
   }

   public WarningNotifyConfig() {
   }

   public WarningNotifyConfig(final Long id, final String deptIds, final String userIds, final Long workshopId) {
      this.id = id;
      this.deptIds = deptIds;
      this.userIds = userIds;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public String getDeptIds() {
      return this.deptIds;
   }

   public String getUserIds() {
      return this.userIds;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public WarningNotifyConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("deptIds")
   public WarningNotifyConfig setDeptIds(final String deptIds) {
      this.deptIds = deptIds;
      return this;
   }

   @JsonProperty("userIds")
   public WarningNotifyConfig setUserIds(final String userIds) {
      this.userIds = userIds;
      return this;
   }

   @JsonProperty("workshopId")
   public WarningNotifyConfig setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "WarningNotifyConfig(id="
         + this.getId()
         + ", deptIds="
         + this.getDeptIds()
         + ", userIds="
         + this.getUserIds()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarningNotifyConfig)) {
         return false;
      }

      WarningNotifyConfig other = (WarningNotifyConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$deptIds = this.getDeptIds();
            Object other$deptIds = other.getDeptIds();
            if (this$deptIds == null ? other$deptIds == null : this$deptIds.equals(other$deptIds)) {
               Object this$userIds = this.getUserIds();
               Object other$userIds = other.getUserIds();
               return this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds);
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
      return other instanceof WarningNotifyConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $deptIds = this.getDeptIds();
      result = result * 59 + ($deptIds == null ? 43 : $deptIds.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   public static class WarningNotifyConfigBuilder {
      private Long id;
      private String deptIds;
      private String userIds;
      private Long workshopId;

      WarningNotifyConfigBuilder() {
      }

      @JsonProperty("id")
      public WarningNotifyConfig.WarningNotifyConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("deptIds")
      public WarningNotifyConfig.WarningNotifyConfigBuilder deptIds(final String deptIds) {
         this.deptIds = deptIds;
         return this;
      }

      @JsonProperty("userIds")
      public WarningNotifyConfig.WarningNotifyConfigBuilder userIds(final String userIds) {
         this.userIds = userIds;
         return this;
      }

      @JsonProperty("workshopId")
      public WarningNotifyConfig.WarningNotifyConfigBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WarningNotifyConfig build() {
         return new WarningNotifyConfig(this.id, this.deptIds, this.userIds, this.workshopId);
      }

      @Override
      public String toString() {
         return "WarningNotifyConfig.WarningNotifyConfigBuilder(id="
            + this.id
            + ", deptIds="
            + this.deptIds
            + ", userIds="
            + this.userIds
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
