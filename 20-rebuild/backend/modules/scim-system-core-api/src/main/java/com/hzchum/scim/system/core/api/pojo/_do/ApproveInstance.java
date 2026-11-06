package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "ApproveInstance对象", description = "")
@Entity
@TableName("approve_instance")
@Table(name = "approve_instance")
public class ApproveInstance extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "actualId")
   @JsonProperty("actualId")
   @JSONField(name = "actualId")
   @TableField("actual_id")
   @Column(name = "actual_id", columnDefinition = "bigint(20)  COMMENT '实际对应ID'", nullable = true)
   private Long actualId;
   @ApiModelProperty(name = "approveProcess", value = "审批流程", notes = "审批流程")
   @JsonProperty("approveProcess")
   @JSONField(name = "approveProcess")
   @TableField("approve_process")
   @Column(name = "approve_process", columnDefinition = "varchar(2000)  COMMENT '审批流程'", nullable = true)
   private String approveProcess;
   @ApiModelProperty(name = "ccPosition", value = "抄送节点", notes = "抄送节点")
   @JsonProperty("ccPosition")
   @JSONField(name = "ccPosition")
   @TableField("cc_position")
   @Column(name = "cc_position", columnDefinition = "int(11)  COMMENT '抄送节点'", nullable = true)
   private Integer ccPosition;
   @ApiModelProperty(name = "ccUserIds", value = "抄送人ID集", notes = "抄送人ID集")
   @JsonProperty("ccUserIds")
   @JSONField(name = "ccUserIds")
   @TableField("cc_user_ids")
   @Column(name = "cc_user_ids", columnDefinition = "varchar(255)  COMMENT '抄送人ID集'", nullable = true)
   private String ccUserIds;
   @ApiModelProperty(name = "createUserId")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "error")
   @JsonProperty("error")
   @JSONField(name = "error")
   @TableField("error")
   @Column(name = "error", columnDefinition = "text  COMMENT '错误信息'", nullable = true)
   private String error;
   @ApiModelProperty(name = "fromValue")
   @JsonProperty("fromValue")
   @JSONField(name = "fromValue")
   @TableField("from_value")
   @Column(name = "from_value", columnDefinition = "text  COMMENT '表单数据'", nullable = true)
   private String fromValue;
   @ApiModelProperty(name = "info")
   @JsonProperty("info")
   @JSONField(name = "info")
   @TableField("info")
   @Column(name = "info", columnDefinition = "longtext  COMMENT '实例信息'", nullable = false)
   private String info;
   @ApiModelProperty(name = "instanceId", value = "审核实例ID", notes = "审核实例ID")
   @JsonProperty("instanceId")
   @JSONField(name = "instanceId")
   @TableField("instance_id")
   @Column(name = "instance_id", columnDefinition = "varchar(255)  COMMENT '审核实例ID'", nullable = true)
   private String instanceId;
   @ApiModelProperty(name = "boolNormal", value = "是否正常审批", notes = "是否正常审批")
   @JsonProperty("boolNormal")
   @JSONField(name = "boolNormal")
   @TableField("bool_normal")
   @Column(name = "bool_normal", columnDefinition = "int(11) default '1' COMMENT '是否正常审批'", nullable = false)
   private Integer boolNormal;
   @ApiModelProperty(name = "projectIds", value = "项目ID集", notes = "项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(64) default '' COMMENT '项目ID集'", nullable = false)
   private String projectIds;
   @ApiModelProperty(name = "status", value = "审批状态", notes = "审批状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '1' COMMENT '审批状态'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "templateId")
   @JsonProperty("templateId")
   @JSONField(name = "templateId")
   @TableField("template_id")
   @Column(name = "template_id", columnDefinition = "bigint(20)  COMMENT '审核模板ID'", nullable = false)
   private Long templateId;
   @ApiModelProperty(name = "type", value = "审核模板类型", notes = "审核模板类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '审核模板类型'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "createUserName")
   @JsonProperty("createUserName")
   @JSONField(name = "createUserName")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = true)
   private String createUserName;

   public static ApproveInstance.ApproveInstanceBuilder builder() {
      return new ApproveInstance.ApproveInstanceBuilder();
   }

   public ApproveInstance() {
   }

   public ApproveInstance(
      final Long id,
      final Long actualId,
      final String approveProcess,
      final Integer ccPosition,
      final String ccUserIds,
      final Long createUserId,
      final String error,
      final String fromValue,
      final String info,
      final String instanceId,
      final Integer boolNormal,
      final String projectIds,
      final Integer status,
      final Long templateId,
      final Integer type,
      final String createUserName
   ) {
      this.id = id;
      this.actualId = actualId;
      this.approveProcess = approveProcess;
      this.ccPosition = ccPosition;
      this.ccUserIds = ccUserIds;
      this.createUserId = createUserId;
      this.error = error;
      this.fromValue = fromValue;
      this.info = info;
      this.instanceId = instanceId;
      this.boolNormal = boolNormal;
      this.projectIds = projectIds;
      this.status = status;
      this.templateId = templateId;
      this.type = type;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getActualId() {
      return this.actualId;
   }

   public String getApproveProcess() {
      return this.approveProcess;
   }

   public Integer getCcPosition() {
      return this.ccPosition;
   }

   public String getCcUserIds() {
      return this.ccUserIds;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getError() {
      return this.error;
   }

   public String getFromValue() {
      return this.fromValue;
   }

   public String getInfo() {
      return this.info;
   }

   public String getInstanceId() {
      return this.instanceId;
   }

   public Integer getBoolNormal() {
      return this.boolNormal;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getTemplateId() {
      return this.templateId;
   }

   public Integer getType() {
      return this.type;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   @JsonProperty("id")
   public ApproveInstance setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("actualId")
   public ApproveInstance setActualId(final Long actualId) {
      this.actualId = actualId;
      return this;
   }

   @JsonProperty("approveProcess")
   public ApproveInstance setApproveProcess(final String approveProcess) {
      this.approveProcess = approveProcess;
      return this;
   }

   @JsonProperty("ccPosition")
   public ApproveInstance setCcPosition(final Integer ccPosition) {
      this.ccPosition = ccPosition;
      return this;
   }

   @JsonProperty("ccUserIds")
   public ApproveInstance setCcUserIds(final String ccUserIds) {
      this.ccUserIds = ccUserIds;
      return this;
   }

   @JsonProperty("createUserId")
   public ApproveInstance setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @JsonProperty("error")
   public ApproveInstance setError(final String error) {
      this.error = error;
      return this;
   }

   @JsonProperty("fromValue")
   public ApproveInstance setFromValue(final String fromValue) {
      this.fromValue = fromValue;
      return this;
   }

   @JsonProperty("info")
   public ApproveInstance setInfo(final String info) {
      this.info = info;
      return this;
   }

   @JsonProperty("instanceId")
   public ApproveInstance setInstanceId(final String instanceId) {
      this.instanceId = instanceId;
      return this;
   }

   @JsonProperty("boolNormal")
   public ApproveInstance setBoolNormal(final Integer boolNormal) {
      this.boolNormal = boolNormal;
      return this;
   }

   @JsonProperty("projectIds")
   public ApproveInstance setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("status")
   public ApproveInstance setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("templateId")
   public ApproveInstance setTemplateId(final Long templateId) {
      this.templateId = templateId;
      return this;
   }

   @JsonProperty("type")
   public ApproveInstance setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("createUserName")
   public ApproveInstance setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @Override
   public String toString() {
      return "ApproveInstance(id="
         + this.getId()
         + ", actualId="
         + this.getActualId()
         + ", approveProcess="
         + this.getApproveProcess()
         + ", ccPosition="
         + this.getCcPosition()
         + ", ccUserIds="
         + this.getCcUserIds()
         + ", createUserId="
         + this.getCreateUserId()
         + ", error="
         + this.getError()
         + ", fromValue="
         + this.getFromValue()
         + ", info="
         + this.getInfo()
         + ", instanceId="
         + this.getInstanceId()
         + ", boolNormal="
         + this.getBoolNormal()
         + ", projectIds="
         + this.getProjectIds()
         + ", status="
         + this.getStatus()
         + ", templateId="
         + this.getTemplateId()
         + ", type="
         + this.getType()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApproveInstance)) {
         return false;
      }

      ApproveInstance other = (ApproveInstance)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$actualId = this.getActualId();
         Object other$actualId = other.getActualId();
         if (this$actualId == null ? other$actualId == null : this$actualId.equals(other$actualId)) {
            Object this$ccPosition = this.getCcPosition();
            Object other$ccPosition = other.getCcPosition();
            if (this$ccPosition == null ? other$ccPosition == null : this$ccPosition.equals(other$ccPosition)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$boolNormal = this.getBoolNormal();
                  Object other$boolNormal = other.getBoolNormal();
                  if (this$boolNormal == null ? other$boolNormal == null : this$boolNormal.equals(other$boolNormal)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$templateId = this.getTemplateId();
                        Object other$templateId = other.getTemplateId();
                        if (this$templateId == null ? other$templateId == null : this$templateId.equals(other$templateId)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$approveProcess = this.getApproveProcess();
                              Object other$approveProcess = other.getApproveProcess();
                              if (this$approveProcess == null ? other$approveProcess == null : this$approveProcess.equals(other$approveProcess)) {
                                 Object this$ccUserIds = this.getCcUserIds();
                                 Object other$ccUserIds = other.getCcUserIds();
                                 if (this$ccUserIds == null ? other$ccUserIds == null : this$ccUserIds.equals(other$ccUserIds)) {
                                    Object this$error = this.getError();
                                    Object other$error = other.getError();
                                    if (this$error == null ? other$error == null : this$error.equals(other$error)) {
                                       Object this$fromValue = this.getFromValue();
                                       Object other$fromValue = other.getFromValue();
                                       if (this$fromValue == null ? other$fromValue == null : this$fromValue.equals(other$fromValue)) {
                                          Object this$info = this.getInfo();
                                          Object other$info = other.getInfo();
                                          if (this$info == null ? other$info == null : this$info.equals(other$info)) {
                                             Object this$instanceId = this.getInstanceId();
                                             Object other$instanceId = other.getInstanceId();
                                             if (this$instanceId == null ? other$instanceId == null : this$instanceId.equals(other$instanceId)) {
                                                Object this$projectIds = this.getProjectIds();
                                                Object other$projectIds = other.getProjectIds();
                                                if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                   Object this$createUserName = this.getCreateUserName();
                                                   Object other$createUserName = other.getCreateUserName();
                                                   return this$createUserName == null
                                                      ? other$createUserName == null
                                                      : this$createUserName.equals(other$createUserName);
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
      return other instanceof ApproveInstance;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $actualId = this.getActualId();
      result = result * 59 + ($actualId == null ? 43 : $actualId.hashCode());
      Object $ccPosition = this.getCcPosition();
      result = result * 59 + ($ccPosition == null ? 43 : $ccPosition.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $boolNormal = this.getBoolNormal();
      result = result * 59 + ($boolNormal == null ? 43 : $boolNormal.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $templateId = this.getTemplateId();
      result = result * 59 + ($templateId == null ? 43 : $templateId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $approveProcess = this.getApproveProcess();
      result = result * 59 + ($approveProcess == null ? 43 : $approveProcess.hashCode());
      Object $ccUserIds = this.getCcUserIds();
      result = result * 59 + ($ccUserIds == null ? 43 : $ccUserIds.hashCode());
      Object $error = this.getError();
      result = result * 59 + ($error == null ? 43 : $error.hashCode());
      Object $fromValue = this.getFromValue();
      result = result * 59 + ($fromValue == null ? 43 : $fromValue.hashCode());
      Object $info = this.getInfo();
      result = result * 59 + ($info == null ? 43 : $info.hashCode());
      Object $instanceId = this.getInstanceId();
      result = result * 59 + ($instanceId == null ? 43 : $instanceId.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class ApproveInstanceBuilder {
      private Long id;
      private Long actualId;
      private String approveProcess;
      private Integer ccPosition;
      private String ccUserIds;
      private Long createUserId;
      private String error;
      private String fromValue;
      private String info;
      private String instanceId;
      private Integer boolNormal;
      private String projectIds;
      private Integer status;
      private Long templateId;
      private Integer type;
      private String createUserName;

      ApproveInstanceBuilder() {
      }

      @JsonProperty("id")
      public ApproveInstance.ApproveInstanceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("actualId")
      public ApproveInstance.ApproveInstanceBuilder actualId(final Long actualId) {
         this.actualId = actualId;
         return this;
      }

      @JsonProperty("approveProcess")
      public ApproveInstance.ApproveInstanceBuilder approveProcess(final String approveProcess) {
         this.approveProcess = approveProcess;
         return this;
      }

      @JsonProperty("ccPosition")
      public ApproveInstance.ApproveInstanceBuilder ccPosition(final Integer ccPosition) {
         this.ccPosition = ccPosition;
         return this;
      }

      @JsonProperty("ccUserIds")
      public ApproveInstance.ApproveInstanceBuilder ccUserIds(final String ccUserIds) {
         this.ccUserIds = ccUserIds;
         return this;
      }

      @JsonProperty("createUserId")
      public ApproveInstance.ApproveInstanceBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      @JsonProperty("error")
      public ApproveInstance.ApproveInstanceBuilder error(final String error) {
         this.error = error;
         return this;
      }

      @JsonProperty("fromValue")
      public ApproveInstance.ApproveInstanceBuilder fromValue(final String fromValue) {
         this.fromValue = fromValue;
         return this;
      }

      @JsonProperty("info")
      public ApproveInstance.ApproveInstanceBuilder info(final String info) {
         this.info = info;
         return this;
      }

      @JsonProperty("instanceId")
      public ApproveInstance.ApproveInstanceBuilder instanceId(final String instanceId) {
         this.instanceId = instanceId;
         return this;
      }

      @JsonProperty("boolNormal")
      public ApproveInstance.ApproveInstanceBuilder boolNormal(final Integer boolNormal) {
         this.boolNormal = boolNormal;
         return this;
      }

      @JsonProperty("projectIds")
      public ApproveInstance.ApproveInstanceBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("status")
      public ApproveInstance.ApproveInstanceBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("templateId")
      public ApproveInstance.ApproveInstanceBuilder templateId(final Long templateId) {
         this.templateId = templateId;
         return this;
      }

      @JsonProperty("type")
      public ApproveInstance.ApproveInstanceBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("createUserName")
      public ApproveInstance.ApproveInstanceBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ApproveInstance build() {
         return new ApproveInstance(
            this.id,
            this.actualId,
            this.approveProcess,
            this.ccPosition,
            this.ccUserIds,
            this.createUserId,
            this.error,
            this.fromValue,
            this.info,
            this.instanceId,
            this.boolNormal,
            this.projectIds,
            this.status,
            this.templateId,
            this.type,
            this.createUserName
         );
      }

      @Override
      public String toString() {
         return "ApproveInstance.ApproveInstanceBuilder(id="
            + this.id
            + ", actualId="
            + this.actualId
            + ", approveProcess="
            + this.approveProcess
            + ", ccPosition="
            + this.ccPosition
            + ", ccUserIds="
            + this.ccUserIds
            + ", createUserId="
            + this.createUserId
            + ", error="
            + this.error
            + ", fromValue="
            + this.fromValue
            + ", info="
            + this.info
            + ", instanceId="
            + this.instanceId
            + ", boolNormal="
            + this.boolNormal
            + ", projectIds="
            + this.projectIds
            + ", status="
            + this.status
            + ", templateId="
            + this.templateId
            + ", type="
            + this.type
            + ", createUserName="
            + this.createUserName
            + ")";
      }
   }
}
