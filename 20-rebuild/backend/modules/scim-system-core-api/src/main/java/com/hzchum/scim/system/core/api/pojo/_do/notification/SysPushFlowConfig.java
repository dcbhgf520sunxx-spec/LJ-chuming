package com.hzchum.scim.system.core.api.pojo._do.notification;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysPushFlowConfig对象", description = "")
@Entity
@TableName("sys_push_flow_config")
@Table(name = "sys_push_flow_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_flow_config")
public class SysPushFlowConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "流程名称", notes = "流程名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '流程名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1)  COMMENT '状态'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "finalEditor", notes = "最后编辑人")
   @TableField("final_editor")
   @Column(name = "final_editor", columnDefinition = "varchar(255)  COMMENT '最后编辑人'", nullable = false)
   private String finalEditor;
   @ApiModelProperty(name = "finalEditTime", notes = "最后编辑时间")
   @TableField("final_edit_time")
   @Column(name = "final_edit_time", columnDefinition = "datetime  COMMENT '最后编辑时间'", nullable = false)
   private LocalDateTime finalEditTime;

   public static SysPushFlowConfig.SysPushFlowConfigBuilder builder() {
      return new SysPushFlowConfig.SysPushFlowConfigBuilder();
   }

   public SysPushFlowConfig() {
   }

   public SysPushFlowConfig(final Long id, final String name, final Boolean status, final String finalEditor, final LocalDateTime finalEditTime) {
      this.id = id;
      this.name = name;
      this.status = status;
      this.finalEditor = finalEditor;
      this.finalEditTime = finalEditTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public String getFinalEditor() {
      return this.finalEditor;
   }

   public LocalDateTime getFinalEditTime() {
      return this.finalEditTime;
   }

   public SysPushFlowConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushFlowConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public SysPushFlowConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public SysPushFlowConfig setFinalEditor(final String finalEditor) {
      this.finalEditor = finalEditor;
      return this;
   }

   public SysPushFlowConfig setFinalEditTime(final LocalDateTime finalEditTime) {
      this.finalEditTime = finalEditTime;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushFlowConfig(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", status="
         + this.getStatus()
         + ", finalEditor="
         + this.getFinalEditor()
         + ", finalEditTime="
         + this.getFinalEditTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushFlowConfig)) {
         return false;
      }

      SysPushFlowConfig other = (SysPushFlowConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$finalEditor = this.getFinalEditor();
               Object other$finalEditor = other.getFinalEditor();
               if (this$finalEditor == null ? other$finalEditor == null : this$finalEditor.equals(other$finalEditor)) {
                  Object this$finalEditTime = this.getFinalEditTime();
                  Object other$finalEditTime = other.getFinalEditTime();
                  return this$finalEditTime == null ? other$finalEditTime == null : this$finalEditTime.equals(other$finalEditTime);
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
      return other instanceof SysPushFlowConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $finalEditor = this.getFinalEditor();
      result = result * 59 + ($finalEditor == null ? 43 : $finalEditor.hashCode());
      Object $finalEditTime = this.getFinalEditTime();
      return result * 59 + ($finalEditTime == null ? 43 : $finalEditTime.hashCode());
   }

   public static class SysPushFlowConfigBuilder {
      private Long id;
      private String name;
      private Boolean status;
      private String finalEditor;
      private LocalDateTime finalEditTime;

      SysPushFlowConfigBuilder() {
      }

      public SysPushFlowConfig.SysPushFlowConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushFlowConfig.SysPushFlowConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysPushFlowConfig.SysPushFlowConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SysPushFlowConfig.SysPushFlowConfigBuilder finalEditor(final String finalEditor) {
         this.finalEditor = finalEditor;
         return this;
      }

      public SysPushFlowConfig.SysPushFlowConfigBuilder finalEditTime(final LocalDateTime finalEditTime) {
         this.finalEditTime = finalEditTime;
         return this;
      }

      public SysPushFlowConfig build() {
         return new SysPushFlowConfig(this.id, this.name, this.status, this.finalEditor, this.finalEditTime);
      }

      @Override
      public String toString() {
         return "SysPushFlowConfig.SysPushFlowConfigBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", status="
            + this.status
            + ", finalEditor="
            + this.finalEditor
            + ", finalEditTime="
            + this.finalEditTime
            + ")";
      }
   }
}
