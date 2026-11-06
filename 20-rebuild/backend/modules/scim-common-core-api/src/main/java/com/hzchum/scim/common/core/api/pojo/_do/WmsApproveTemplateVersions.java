package com.hzchum.scim.common.core.api.pojo._do;

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

@ApiModel(value = "WmsApproveTemplateVersions对象", description = "审批主模板版本信息")
@Entity
@TableName("wms_approve_template_versions")
@Table(name = "wms_approve_template_versions")
@org.hibernate.annotations.Table(appliesTo = "wms_approve_template_versions", comment = "审批主模板版本信息")
public class WmsApproveTemplateVersions extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "applicantId", value = "创建人ID", notes = "创建人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '创建人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "moduleType", value = "例:1  枚举ModuleTypeEnum", notes = "例:1  枚举ModuleTypeEnum")
   @TableField("module_type")
   @Column(name = "module_type", columnDefinition = "int  COMMENT '例:1  枚举ModuleTypeEnum'", nullable = true)
   private Integer moduleType;
   @ApiModelProperty(name = "functionType", value = "例:1  枚举FunctionTypeEnum", notes = "例:1  枚举FunctionTypeEnum")
   @TableField("function_type")
   @Column(name = "function_type", columnDefinition = "int  COMMENT '例:1  枚举FunctionTypeEnum'", nullable = true)
   private Integer functionType;
   @ApiModelProperty(name = "approveProcessType", value = "审批流程类型 ApproveProcessTypeEnumV2", notes = "审批流程类型 ApproveProcessTypeEnumV2ApproveProcessTypeEnumV2")
   @TableField("approve_process_type")
   @Column(name = "approve_process_type", columnDefinition = "int  COMMENT '审批流程类型 ApproveProcessTypeEnumV2'", nullable = true)
   private Integer approveProcessType;
   @ApiModelProperty(name = "name", value = "该模版名称", notes = "该模版名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(100)  COMMENT '该模版名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "objType", value = "对应类型ApproveObjectTypeEnum 1部门 2岗位 3个人", notes = "对应类型ApproveObjectTypeEnum 1部门 2岗位 3个人")
   @TableField("obj_type")
   @Column(name = "obj_type", columnDefinition = "int  COMMENT '对应类型ApproveObjectTypeEnum 1部门 2岗位 3个人'", nullable = true)
   private Integer objType;
   @ApiModelProperty(name = "objIds", value = "对应类型的ID集合", notes = "对应类型的ID集合")
   @TableField("obj_ids")
   @Column(name = "obj_ids", columnDefinition = "varchar(200)  COMMENT '对应类型的ID集合'", nullable = true)
   private String objIds;
   @ApiModelProperty(name = "firstId", value = "最初版本ID 新建的话则是本身", notes = "最初版本ID 新建的话则是本身")
   @TableField("first_id")
   @Column(name = "first_id", columnDefinition = "bigint  COMMENT '最初版本ID 新建的话则是本身'", nullable = true)
   private Long firstId;
   @ApiModelProperty(name = "status", value = "启用状态 0未启用  1启用 默认启用1 修改时将老版本关闭启用新版本", notes = "启用状态 0未启用  1启用 默认启用1 修改时将老版本关闭启用新版本")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '启用状态 0未启用  1启用 默认启用1 修改时将老版本关闭启用新版本'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "useStatus", value = "最新的 0不是  1是 默认1", notes = "最新的 0不是  1是 默认1")
   @TableField("use_status")
   @Column(name = "use_status", columnDefinition = "tinyint(1) default '1' COMMENT '最新的 0不是  1是 默认1'", nullable = true)
   private Boolean useStatus;
   @ApiModelProperty(name = "mountMessage", value = "挂载信息 MountMessageDTO", notes = "挂载信息 MountMessageDTO")
   @TableField("mount_message")
   @Column(name = "mount_message", columnDefinition = "varchar(500) COMMENT '挂载信息 MountMessageDTO'", nullable = true)
   private String mountMessage;
   @ApiModelProperty(name = "templateName", value = "模版名称", notes = "模版名称")
   @TableField("template_name")
   @Column(name = "template_name", columnDefinition = "varchar(100) COMMENT '模版名称'", nullable = true)
   private String templateName;

   public static WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder builder() {
      return new WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder();
   }

   public WmsApproveTemplateVersions() {
   }

   public WmsApproveTemplateVersions(
      final Long id,
      final Long applicantId,
      final Integer moduleType,
      final Integer functionType,
      final Integer approveProcessType,
      final String name,
      final Integer objType,
      final String objIds,
      final Long firstId,
      final Boolean status,
      final Boolean useStatus,
      final String mountMessage,
      final String templateName
   ) {
      this.id = id;
      this.applicantId = applicantId;
      this.moduleType = moduleType;
      this.functionType = functionType;
      this.approveProcessType = approveProcessType;
      this.name = name;
      this.objType = objType;
      this.objIds = objIds;
      this.firstId = firstId;
      this.status = status;
      this.useStatus = useStatus;
      this.mountMessage = mountMessage;
      this.templateName = templateName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public Integer getModuleType() {
      return this.moduleType;
   }

   public Integer getFunctionType() {
      return this.functionType;
   }

   public Integer getApproveProcessType() {
      return this.approveProcessType;
   }

   public String getName() {
      return this.name;
   }

   public Integer getObjType() {
      return this.objType;
   }

   public String getObjIds() {
      return this.objIds;
   }

   public Long getFirstId() {
      return this.firstId;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Boolean getUseStatus() {
      return this.useStatus;
   }

   public String getMountMessage() {
      return this.mountMessage;
   }

   public String getTemplateName() {
      return this.templateName;
   }

   public WmsApproveTemplateVersions setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsApproveTemplateVersions setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsApproveTemplateVersions setModuleType(final Integer moduleType) {
      this.moduleType = moduleType;
      return this;
   }

   public WmsApproveTemplateVersions setFunctionType(final Integer functionType) {
      this.functionType = functionType;
      return this;
   }

   public WmsApproveTemplateVersions setApproveProcessType(final Integer approveProcessType) {
      this.approveProcessType = approveProcessType;
      return this;
   }

   public WmsApproveTemplateVersions setName(final String name) {
      this.name = name;
      return this;
   }

   public WmsApproveTemplateVersions setObjType(final Integer objType) {
      this.objType = objType;
      return this;
   }

   public WmsApproveTemplateVersions setObjIds(final String objIds) {
      this.objIds = objIds;
      return this;
   }

   public WmsApproveTemplateVersions setFirstId(final Long firstId) {
      this.firstId = firstId;
      return this;
   }

   public WmsApproveTemplateVersions setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public WmsApproveTemplateVersions setUseStatus(final Boolean useStatus) {
      this.useStatus = useStatus;
      return this;
   }

   public WmsApproveTemplateVersions setMountMessage(final String mountMessage) {
      this.mountMessage = mountMessage;
      return this;
   }

   public WmsApproveTemplateVersions setTemplateName(final String templateName) {
      this.templateName = templateName;
      return this;
   }

   @Override
   public String toString() {
      return "WmsApproveTemplateVersions(id="
         + this.getId()
         + ", applicantId="
         + this.getApplicantId()
         + ", moduleType="
         + this.getModuleType()
         + ", functionType="
         + this.getFunctionType()
         + ", approveProcessType="
         + this.getApproveProcessType()
         + ", name="
         + this.getName()
         + ", objType="
         + this.getObjType()
         + ", objIds="
         + this.getObjIds()
         + ", firstId="
         + this.getFirstId()
         + ", status="
         + this.getStatus()
         + ", useStatus="
         + this.getUseStatus()
         + ", mountMessage="
         + this.getMountMessage()
         + ", templateName="
         + this.getTemplateName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveTemplateVersions)) {
         return false;
      }

      WmsApproveTemplateVersions other = (WmsApproveTemplateVersions)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$moduleType = this.getModuleType();
            Object other$moduleType = other.getModuleType();
            if (this$moduleType == null ? other$moduleType == null : this$moduleType.equals(other$moduleType)) {
               Object this$functionType = this.getFunctionType();
               Object other$functionType = other.getFunctionType();
               if (this$functionType == null ? other$functionType == null : this$functionType.equals(other$functionType)) {
                  Object this$approveProcessType = this.getApproveProcessType();
                  Object other$approveProcessType = other.getApproveProcessType();
                  if (this$approveProcessType == null ? other$approveProcessType == null : this$approveProcessType.equals(other$approveProcessType)) {
                     Object this$objType = this.getObjType();
                     Object other$objType = other.getObjType();
                     if (this$objType == null ? other$objType == null : this$objType.equals(other$objType)) {
                        Object this$firstId = this.getFirstId();
                        Object other$firstId = other.getFirstId();
                        if (this$firstId == null ? other$firstId == null : this$firstId.equals(other$firstId)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$useStatus = this.getUseStatus();
                              Object other$useStatus = other.getUseStatus();
                              if (this$useStatus == null ? other$useStatus == null : this$useStatus.equals(other$useStatus)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$objIds = this.getObjIds();
                                    Object other$objIds = other.getObjIds();
                                    if (this$objIds == null ? other$objIds == null : this$objIds.equals(other$objIds)) {
                                       Object this$mountMessage = this.getMountMessage();
                                       Object other$mountMessage = other.getMountMessage();
                                       if (this$mountMessage == null ? other$mountMessage == null : this$mountMessage.equals(other$mountMessage)) {
                                          Object this$templateName = this.getTemplateName();
                                          Object other$templateName = other.getTemplateName();
                                          return this$templateName == null ? other$templateName == null : this$templateName.equals(other$templateName);
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
      return other instanceof WmsApproveTemplateVersions;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $moduleType = this.getModuleType();
      result = result * 59 + ($moduleType == null ? 43 : $moduleType.hashCode());
      Object $functionType = this.getFunctionType();
      result = result * 59 + ($functionType == null ? 43 : $functionType.hashCode());
      Object $approveProcessType = this.getApproveProcessType();
      result = result * 59 + ($approveProcessType == null ? 43 : $approveProcessType.hashCode());
      Object $objType = this.getObjType();
      result = result * 59 + ($objType == null ? 43 : $objType.hashCode());
      Object $firstId = this.getFirstId();
      result = result * 59 + ($firstId == null ? 43 : $firstId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $useStatus = this.getUseStatus();
      result = result * 59 + ($useStatus == null ? 43 : $useStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $objIds = this.getObjIds();
      result = result * 59 + ($objIds == null ? 43 : $objIds.hashCode());
      Object $mountMessage = this.getMountMessage();
      result = result * 59 + ($mountMessage == null ? 43 : $mountMessage.hashCode());
      Object $templateName = this.getTemplateName();
      return result * 59 + ($templateName == null ? 43 : $templateName.hashCode());
   }

   public static class WmsApproveTemplateVersionsBuilder {
      private Long id;
      private Long applicantId;
      private Integer moduleType;
      private Integer functionType;
      private Integer approveProcessType;
      private String name;
      private Integer objType;
      private String objIds;
      private Long firstId;
      private Boolean status;
      private Boolean useStatus;
      private String mountMessage;
      private String templateName;

      WmsApproveTemplateVersionsBuilder() {
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder moduleType(final Integer moduleType) {
         this.moduleType = moduleType;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder functionType(final Integer functionType) {
         this.functionType = functionType;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder approveProcessType(final Integer approveProcessType) {
         this.approveProcessType = approveProcessType;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder objType(final Integer objType) {
         this.objType = objType;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder objIds(final String objIds) {
         this.objIds = objIds;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder firstId(final Long firstId) {
         this.firstId = firstId;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder useStatus(final Boolean useStatus) {
         this.useStatus = useStatus;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder mountMessage(final String mountMessage) {
         this.mountMessage = mountMessage;
         return this;
      }

      public WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder templateName(final String templateName) {
         this.templateName = templateName;
         return this;
      }

      public WmsApproveTemplateVersions build() {
         return new WmsApproveTemplateVersions(
            this.id,
            this.applicantId,
            this.moduleType,
            this.functionType,
            this.approveProcessType,
            this.name,
            this.objType,
            this.objIds,
            this.firstId,
            this.status,
            this.useStatus,
            this.mountMessage,
            this.templateName
         );
      }

      @Override
      public String toString() {
         return "WmsApproveTemplateVersions.WmsApproveTemplateVersionsBuilder(id="
            + this.id
            + ", applicantId="
            + this.applicantId
            + ", moduleType="
            + this.moduleType
            + ", functionType="
            + this.functionType
            + ", approveProcessType="
            + this.approveProcessType
            + ", name="
            + this.name
            + ", objType="
            + this.objType
            + ", objIds="
            + this.objIds
            + ", firstId="
            + this.firstId
            + ", status="
            + this.status
            + ", useStatus="
            + this.useStatus
            + ", mountMessage="
            + this.mountMessage
            + ", templateName="
            + this.templateName
            + ")";
      }
   }
}
