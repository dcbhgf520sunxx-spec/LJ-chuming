package com.hzchum.scim.system.core.api.pojo._do.notification;

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

@ApiModel(value = "SysPushNotificationRecord对象", description = "")
@Entity
@TableName("sys_push_notification_record")
@Table(name = "sys_push_notification_record")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_record")
public class SysPushNotificationRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务所属模块", notes = "业务所属模块")
   @TableField("operational_module_type_enum")
   @Column(name = "operational_module_type_enum", columnDefinition = "int(11)  COMMENT '业务所属模块'", nullable = false)
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   @TableField("notification_type_enum")
   @Column(name = "notification_type_enum", columnDefinition = "int(11)  COMMENT '通知业务'", nullable = false)
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '所属项目'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;

   public static SysPushNotificationRecord.SysPushNotificationRecordBuilder builder() {
      return new SysPushNotificationRecord.SysPushNotificationRecordBuilder();
   }

   public SysPushNotificationRecord() {
   }

   public SysPushNotificationRecord(
      final Long id, final Integer operationalModuleTypeEnum, final Integer notificationTypeEnum, final Long projectId, final Long areaId, final Long monomerId
   ) {
      this.id = id;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.notificationTypeEnum = notificationTypeEnum;
      this.projectId = projectId;
      this.areaId = areaId;
      this.monomerId = monomerId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getOperationalModuleTypeEnum() {
      return this.operationalModuleTypeEnum;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public SysPushNotificationRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationRecord setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      return this;
   }

   public SysPushNotificationRecord setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
      return this;
   }

   public SysPushNotificationRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("areaId")
   public SysPushNotificationRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("monomerId")
   public SysPushNotificationRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationRecord(id="
         + this.getId()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationRecord)) {
         return false;
      }

      SysPushNotificationRecord other = (SysPushNotificationRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
         Object other$operationalModuleTypeEnum = other.getOperationalModuleTypeEnum();
         if (this$operationalModuleTypeEnum == null
            ? other$operationalModuleTypeEnum == null
            : this$operationalModuleTypeEnum.equals(other$operationalModuleTypeEnum)) {
            Object this$notificationTypeEnum = this.getNotificationTypeEnum();
            Object other$notificationTypeEnum = other.getNotificationTypeEnum();
            if (this$notificationTypeEnum == null ? other$notificationTypeEnum == null : this$notificationTypeEnum.equals(other$notificationTypeEnum)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     return this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId);
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
      return other instanceof SysPushNotificationRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      return result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
   }

   public static class SysPushNotificationRecordBuilder {
      private Long id;
      private Integer operationalModuleTypeEnum;
      private Integer notificationTypeEnum;
      private Long projectId;
      private Long areaId;
      private Long monomerId;

      SysPushNotificationRecordBuilder() {
      }

      public SysPushNotificationRecord.SysPushNotificationRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationRecord.SysPushNotificationRecordBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushNotificationRecord.SysPushNotificationRecordBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushNotificationRecord.SysPushNotificationRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("areaId")
      public SysPushNotificationRecord.SysPushNotificationRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("monomerId")
      public SysPushNotificationRecord.SysPushNotificationRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SysPushNotificationRecord build() {
         return new SysPushNotificationRecord(this.id, this.operationalModuleTypeEnum, this.notificationTypeEnum, this.projectId, this.areaId, this.monomerId);
      }

      @Override
      public String toString() {
         return "SysPushNotificationRecord.SysPushNotificationRecordBuilder(id="
            + this.id
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
            + ", monomerId="
            + this.monomerId
            + ")";
      }
   }
}
