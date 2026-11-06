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

@ApiModel(value = "MesInspectConfig对象", description = "质检基础配置")
@Entity
@TableName("mes_inspect_config")
@Table(name = "mes_inspect_config")
@org.hibernate.annotations.Table(appliesTo = "mes_inspect_config", comment = "质检基础配置")
public class MesInspectConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "artifactType", value = "构件类型 1普通构件 2次构件", notes = "构件类型 1普通构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) default '1' COMMENT '构件类型 1普通构件 2次构件'", nullable = true)
   private Integer artifactType;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "inspectType", value = "质检方式[0 全检 1抽检]", notes = "质检方式[0 全检 1抽检]")
   @TableField("inspect_type")
   @Column(name = "inspect_type", columnDefinition = "int(11)  COMMENT '质检方式[0 全检 1抽检]'", nullable = true)
   private Integer inspectType;
   @ApiModelProperty(name = "status", value = "状态  0 禁用 1 启用", notes = "状态  0 禁用 1 启用")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态   0 禁用 1 启用'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "firstInspectRate", value = "首检率", notes = "首检率")
   @TableField("first_inspect_rate")
   @Column(name = "first_inspect_rate", columnDefinition = "int(11)  COMMENT '首检率'", nullable = true)
   private Integer firstInspectRate;
   @ApiModelProperty(name = "inspectMethod", value = "检查方式[0 扫码检验 1不扫码检验]", notes = "检查方式[0 扫码检验 1不扫码检验]")
   @TableField("inspect_method")
   @Column(name = "inspect_method", columnDefinition = "int(11) default '0'   COMMENT '检查方式[0 扫码检验 1不扫码检验]'", nullable = true)
   private Integer inspectMethod;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static MesInspectConfig.MesInspectConfigBuilder builder() {
      return new MesInspectConfig.MesInspectConfigBuilder();
   }

   public MesInspectConfig() {
   }

   public MesInspectConfig(
      final Long id,
      final Long workshopId,
      final Integer taskTypeEnum,
      final Integer artifactType,
      final Long processId,
      final Integer inspectType,
      final Boolean status,
      final Integer firstInspectRate,
      final Integer inspectMethod,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.taskTypeEnum = taskTypeEnum;
      this.artifactType = artifactType;
      this.processId = processId;
      this.inspectType = inspectType;
      this.status = status;
      this.firstInspectRate = firstInspectRate;
      this.inspectMethod = inspectMethod;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getFirstInspectRate() {
      return this.firstInspectRate;
   }

   public Integer getInspectMethod() {
      return this.inspectMethod;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public MesInspectConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesInspectConfig setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesInspectConfig setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   public MesInspectConfig setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public MesInspectConfig setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesInspectConfig setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   public MesInspectConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public MesInspectConfig setFirstInspectRate(final Integer firstInspectRate) {
      this.firstInspectRate = firstInspectRate;
      return this;
   }

   public MesInspectConfig setInspectMethod(final Integer inspectMethod) {
      this.inspectMethod = inspectMethod;
      return this;
   }

   public MesInspectConfig setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesInspectConfig(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", processId="
         + this.getProcessId()
         + ", inspectType="
         + this.getInspectType()
         + ", status="
         + this.getStatus()
         + ", firstInspectRate="
         + this.getFirstInspectRate()
         + ", inspectMethod="
         + this.getInspectMethod()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfig)) {
         return false;
      }

      MesInspectConfig other = (MesInspectConfig)o;
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
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$artifactType = this.getArtifactType();
               Object other$artifactType = other.getArtifactType();
               if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$inspectType = this.getInspectType();
                     Object other$inspectType = other.getInspectType();
                     if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$firstInspectRate = this.getFirstInspectRate();
                           Object other$firstInspectRate = other.getFirstInspectRate();
                           if (this$firstInspectRate == null ? other$firstInspectRate == null : this$firstInspectRate.equals(other$firstInspectRate)) {
                              Object this$inspectMethod = this.getInspectMethod();
                              Object other$inspectMethod = other.getInspectMethod();
                              if (this$inspectMethod == null ? other$inspectMethod == null : this$inspectMethod.equals(other$inspectMethod)) {
                                 Object this$mesProductEnum = this.getMesProductEnum();
                                 Object other$mesProductEnum = other.getMesProductEnum();
                                 return this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum);
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
      return other instanceof MesInspectConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $firstInspectRate = this.getFirstInspectRate();
      result = result * 59 + ($firstInspectRate == null ? 43 : $firstInspectRate.hashCode());
      Object $inspectMethod = this.getInspectMethod();
      result = result * 59 + ($inspectMethod == null ? 43 : $inspectMethod.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      return result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
   }

   public static class MesInspectConfigBuilder {
      private Long id;
      private Long workshopId;
      private Integer taskTypeEnum;
      private Integer artifactType;
      private Long processId;
      private Integer inspectType;
      private Boolean status;
      private Integer firstInspectRate;
      private Integer inspectMethod;
      private Integer mesProductEnum;

      MesInspectConfigBuilder() {
      }

      public MesInspectConfig.MesInspectConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder firstInspectRate(final Integer firstInspectRate) {
         this.firstInspectRate = firstInspectRate;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder inspectMethod(final Integer inspectMethod) {
         this.inspectMethod = inspectMethod;
         return this;
      }

      public MesInspectConfig.MesInspectConfigBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesInspectConfig build() {
         return new MesInspectConfig(
            this.id,
            this.workshopId,
            this.taskTypeEnum,
            this.artifactType,
            this.processId,
            this.inspectType,
            this.status,
            this.firstInspectRate,
            this.inspectMethod,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesInspectConfig.MesInspectConfigBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", artifactType="
            + this.artifactType
            + ", processId="
            + this.processId
            + ", inspectType="
            + this.inspectType
            + ", status="
            + this.status
            + ", firstInspectRate="
            + this.firstInspectRate
            + ", inspectMethod="
            + this.inspectMethod
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
