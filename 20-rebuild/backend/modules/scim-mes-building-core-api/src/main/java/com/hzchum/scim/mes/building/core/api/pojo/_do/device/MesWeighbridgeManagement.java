package com.hzchum.scim.mes.building.core.api.pojo._do.device;

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

@ApiModel(value = "MesWeighbridgeManagement对象", description = "")
@Entity
@TableName("mes_weighbridge_management")
@Table(name = "mes_weighbridge_management")
@org.hibernate.annotations.Table(appliesTo = "mes_weighbridge_management")
public class MesWeighbridgeManagement extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) default null COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "name", value = "地磅名称", notes = "地磅名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '地磅名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "deviceId", value = "设备编码", notes = "设备编码")
   @TableField("device_id")
   @Column(name = "device_id", columnDefinition = "bigint(20)  COMMENT '设备编码'", nullable = true)
   private Long deviceId;
   @ApiModelProperty(name = "status", value = "状态 0禁用 1启用", notes = "状态 0禁用 1启用")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0禁用 1启用'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id", notes = "最后编辑人id")
   @TableField("last_editor_user_id")
   @Column(name = "last_editor_user_id", columnDefinition = "bigint(20)  COMMENT '最后编辑人id'", nullable = true)
   private Long lastEditorUserId;
   @ApiModelProperty(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = true)
   private Long userId;

   public static MesWeighbridgeManagement.MesWeighbridgeManagementBuilder builder() {
      return new MesWeighbridgeManagement.MesWeighbridgeManagementBuilder();
   }

   public MesWeighbridgeManagement() {
   }

   public MesWeighbridgeManagement(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final String name,
      final Long deviceId,
      final Boolean status,
      final Long lastEditorUserId,
      final Long userId
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.name = name;
      this.deviceId = deviceId;
      this.status = status;
      this.lastEditorUserId = lastEditorUserId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getName() {
      return this.name;
   }

   public Long getDeviceId() {
      return this.deviceId;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public MesWeighbridgeManagement setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesWeighbridgeManagement setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public MesWeighbridgeManagement setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("name")
   public MesWeighbridgeManagement setName(final String name) {
      this.name = name;
      return this;
   }

   public MesWeighbridgeManagement setDeviceId(final Long deviceId) {
      this.deviceId = deviceId;
      return this;
   }

   public MesWeighbridgeManagement setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public MesWeighbridgeManagement setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
      return this;
   }

   public MesWeighbridgeManagement setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesWeighbridgeManagement(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", name="
         + this.getName()
         + ", deviceId="
         + this.getDeviceId()
         + ", status="
         + this.getStatus()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWeighbridgeManagement)) {
         return false;
      }

      MesWeighbridgeManagement other = (MesWeighbridgeManagement)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$deviceId = this.getDeviceId();
               Object other$deviceId = other.getDeviceId();
               if (this$deviceId == null ? other$deviceId == null : this$deviceId.equals(other$deviceId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$lastEditorUserId = this.getLastEditorUserId();
                     Object other$lastEditorUserId = other.getLastEditorUserId();
                     if (this$lastEditorUserId == null ? other$lastEditorUserId == null : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesWeighbridgeManagement;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $deviceId = this.getDeviceId();
      result = result * 59 + ($deviceId == null ? 43 : $deviceId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesWeighbridgeManagementBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private String name;
      private Long deviceId;
      private Boolean status;
      private Long lastEditorUserId;
      private Long userId;

      MesWeighbridgeManagementBuilder() {
      }

      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("name")
      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder deviceId(final Long deviceId) {
         this.deviceId = deviceId;
         return this;
      }

      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public MesWeighbridgeManagement.MesWeighbridgeManagementBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesWeighbridgeManagement build() {
         return new MesWeighbridgeManagement(
            this.id, this.factoryId, this.workshopId, this.name, this.deviceId, this.status, this.lastEditorUserId, this.userId
         );
      }

      @Override
      public String toString() {
         return "MesWeighbridgeManagement.MesWeighbridgeManagementBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", name="
            + this.name
            + ", deviceId="
            + this.deviceId
            + ", status="
            + this.status
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
