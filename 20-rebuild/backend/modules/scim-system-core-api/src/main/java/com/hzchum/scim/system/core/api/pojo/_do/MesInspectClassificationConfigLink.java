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

@ApiModel(value = "MesInspectClassificationConfigLink对象", description = "质检基础、零部构件类型 配置关联表")
@Entity
@TableName("mes_inspect_classification_config_link")
@Table(name = "mes_inspect_classification_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_inspect_classification_config_link", comment = "质检基础、零部构件类型 配置关联表")
public class MesInspectClassificationConfigLink extends BaseEntity<Long> implements Cloneable {
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
   @ApiModelProperty(name = "classificationId", value = "零构件类型id", notes = "零构件类型id")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint(20)  COMMENT '零构件类型id'", nullable = false)
   private Long classificationId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;

   public MesInspectClassificationConfigLink clone() throws CloneNotSupportedException {
      return (MesInspectClassificationConfigLink)super.clone();
   }

   public static MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder builder() {
      return new MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder();
   }

   public MesInspectClassificationConfigLink() {
   }

   public MesInspectClassificationConfigLink(final Long id, final Long inspectConfigId, final Long classificationId, final Integer taskTypeEnum) {
      this.id = id;
      this.inspectConfigId = inspectConfigId;
      this.classificationId = classificationId;
      this.taskTypeEnum = taskTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectConfigId() {
      return this.inspectConfigId;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public MesInspectClassificationConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesInspectClassificationConfigLink setInspectConfigId(final Long inspectConfigId) {
      this.inspectConfigId = inspectConfigId;
      return this;
   }

   public MesInspectClassificationConfigLink setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   public MesInspectClassificationConfigLink setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesInspectClassificationConfigLink(id="
         + this.getId()
         + ", inspectConfigId="
         + this.getInspectConfigId()
         + ", classificationId="
         + this.getClassificationId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectClassificationConfigLink)) {
         return false;
      }

      MesInspectClassificationConfigLink other = (MesInspectClassificationConfigLink)o;
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
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               return this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum);
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
      return other instanceof MesInspectClassificationConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectConfigId = this.getInspectConfigId();
      result = result * 59 + ($inspectConfigId == null ? 43 : $inspectConfigId.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      return result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
   }

   public static class MesInspectClassificationConfigLinkBuilder {
      private Long id;
      private Long inspectConfigId;
      private Long classificationId;
      private Integer taskTypeEnum;

      MesInspectClassificationConfigLinkBuilder() {
      }

      public MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder inspectConfigId(final Long inspectConfigId) {
         this.inspectConfigId = inspectConfigId;
         return this;
      }

      public MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesInspectClassificationConfigLink build() {
         return new MesInspectClassificationConfigLink(this.id, this.inspectConfigId, this.classificationId, this.taskTypeEnum);
      }

      @Override
      public String toString() {
         return "MesInspectClassificationConfigLink.MesInspectClassificationConfigLinkBuilder(id="
            + this.id
            + ", inspectConfigId="
            + this.inspectConfigId
            + ", classificationId="
            + this.classificationId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
