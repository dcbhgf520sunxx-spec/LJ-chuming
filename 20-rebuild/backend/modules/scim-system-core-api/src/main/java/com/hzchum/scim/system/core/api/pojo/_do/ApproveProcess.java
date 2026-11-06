package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "ApproveProcess对象", description = "")
@Entity
@TableName("approve_process")
@Table(name = "approve_process")
public class ApproveProcess extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "approveInfo", value = "审批流程", notes = "审批流程")
   @JsonProperty("approveInfo")
   @JSONField(name = "approveInfo")
   @TableField(value = "approve_info", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "approve_info", columnDefinition = "varchar(2000)  COMMENT '审批流程'", nullable = true)
   private String approveInfo;
   @ApiModelProperty(name = "approveInfoName", value = "审批流程名称", notes = "审批流程名称")
   @JsonProperty("approveInfoName")
   @JSONField(name = "approveInfoName")
   @TableField(value = "approve_info_Name", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "approve_info_Name", columnDefinition = "varchar(2000)  COMMENT '审批流程名称'", nullable = true)
   private String approveInfoName;
   @ApiModelProperty(name = "applicantIds", value = "可发起审批的用户ID", notes = "可发起审批的用户ID")
   @JsonProperty("applicantIds")
   @JSONField(name = "applicantIds")
   @TableField(value = "applicant_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "applicant_ids", columnDefinition = "varchar(255)  COMMENT '可发起审批的用户ID'", nullable = true)
   private String applicantIds;
   @ApiModelProperty(name = "ccPosition", value = "抄送节点", notes = "抄送节点")
   @JsonProperty("ccPosition")
   @JSONField(name = "ccPosition")
   @TableField(value = "cc_position", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "cc_position", columnDefinition = "int(11)  COMMENT '抄送节点'", nullable = true)
   private Integer ccPosition;
   @ApiModelProperty(name = "ccUserIds", value = "抄送用户ID", notes = "抄送用户ID")
   @JsonProperty("ccUserIds")
   @JSONField(name = "ccUserIds")
   @TableField(value = "cc_user_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "cc_user_ids", columnDefinition = "varchar(255)  COMMENT '抄送用户ID'", nullable = true)
   private String ccUserIds;
   @ApiModelProperty(name = "code", value = "审批流唯一代码", notes = "审批流唯一代码")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(255)  COMMENT '审批流唯一代码'", nullable = false)
   private String code;
   @ApiModelProperty(name = "type", value = "审批类型", notes = "审批类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '审批类型'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "updateStatus", value = "是否更新,审批摘要是否修改,修改后需要更新", notes = "是否更新,审批摘要是否修改,修改后需要更新")
   @JsonProperty("updateStatus")
   @JSONField(name = "updateStatus")
   @TableField("update_status")
   @Column(name = "update_status", columnDefinition = "int(11) default '0' COMMENT '是否更新,审批摘要是否修改,修改后需要更新'", nullable = false)
   private Integer updateStatus;

   public static ApproveProcess.ApproveProcessBuilder builder() {
      return new ApproveProcess.ApproveProcessBuilder();
   }

   public ApproveProcess() {
   }

   public ApproveProcess(
      final Long id,
      final String approveInfo,
      final String approveInfoName,
      final String applicantIds,
      final Integer ccPosition,
      final String ccUserIds,
      final String code,
      final Integer type,
      final Integer updateStatus
   ) {
      this.id = id;
      this.approveInfo = approveInfo;
      this.approveInfoName = approveInfoName;
      this.applicantIds = applicantIds;
      this.ccPosition = ccPosition;
      this.ccUserIds = ccUserIds;
      this.code = code;
      this.type = type;
      this.updateStatus = updateStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getApproveInfo() {
      return this.approveInfo;
   }

   public String getApproveInfoName() {
      return this.approveInfoName;
   }

   public String getApplicantIds() {
      return this.applicantIds;
   }

   public Integer getCcPosition() {
      return this.ccPosition;
   }

   public String getCcUserIds() {
      return this.ccUserIds;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getUpdateStatus() {
      return this.updateStatus;
   }

   @JsonProperty("id")
   public ApproveProcess setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("approveInfo")
   public ApproveProcess setApproveInfo(final String approveInfo) {
      this.approveInfo = approveInfo;
      return this;
   }

   @JsonProperty("approveInfoName")
   public ApproveProcess setApproveInfoName(final String approveInfoName) {
      this.approveInfoName = approveInfoName;
      return this;
   }

   @JsonProperty("applicantIds")
   public ApproveProcess setApplicantIds(final String applicantIds) {
      this.applicantIds = applicantIds;
      return this;
   }

   @JsonProperty("ccPosition")
   public ApproveProcess setCcPosition(final Integer ccPosition) {
      this.ccPosition = ccPosition;
      return this;
   }

   @JsonProperty("ccUserIds")
   public ApproveProcess setCcUserIds(final String ccUserIds) {
      this.ccUserIds = ccUserIds;
      return this;
   }

   @JsonProperty("code")
   public ApproveProcess setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("type")
   public ApproveProcess setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("updateStatus")
   public ApproveProcess setUpdateStatus(final Integer updateStatus) {
      this.updateStatus = updateStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ApproveProcess(id="
         + this.getId()
         + ", approveInfo="
         + this.getApproveInfo()
         + ", approveInfoName="
         + this.getApproveInfoName()
         + ", applicantIds="
         + this.getApplicantIds()
         + ", ccPosition="
         + this.getCcPosition()
         + ", ccUserIds="
         + this.getCcUserIds()
         + ", code="
         + this.getCode()
         + ", type="
         + this.getType()
         + ", updateStatus="
         + this.getUpdateStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApproveProcess)) {
         return false;
      }

      ApproveProcess other = (ApproveProcess)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$ccPosition = this.getCcPosition();
         Object other$ccPosition = other.getCcPosition();
         if (this$ccPosition == null ? other$ccPosition == null : this$ccPosition.equals(other$ccPosition)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$updateStatus = this.getUpdateStatus();
               Object other$updateStatus = other.getUpdateStatus();
               if (this$updateStatus == null ? other$updateStatus == null : this$updateStatus.equals(other$updateStatus)) {
                  Object this$approveInfo = this.getApproveInfo();
                  Object other$approveInfo = other.getApproveInfo();
                  if (this$approveInfo == null ? other$approveInfo == null : this$approveInfo.equals(other$approveInfo)) {
                     Object this$approveInfoName = this.getApproveInfoName();
                     Object other$approveInfoName = other.getApproveInfoName();
                     if (this$approveInfoName == null ? other$approveInfoName == null : this$approveInfoName.equals(other$approveInfoName)) {
                        Object this$applicantIds = this.getApplicantIds();
                        Object other$applicantIds = other.getApplicantIds();
                        if (this$applicantIds == null ? other$applicantIds == null : this$applicantIds.equals(other$applicantIds)) {
                           Object this$ccUserIds = this.getCcUserIds();
                           Object other$ccUserIds = other.getCcUserIds();
                           if (this$ccUserIds == null ? other$ccUserIds == null : this$ccUserIds.equals(other$ccUserIds)) {
                              Object this$code = this.getCode();
                              Object other$code = other.getCode();
                              return this$code == null ? other$code == null : this$code.equals(other$code);
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
      return other instanceof ApproveProcess;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $ccPosition = this.getCcPosition();
      result = result * 59 + ($ccPosition == null ? 43 : $ccPosition.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $updateStatus = this.getUpdateStatus();
      result = result * 59 + ($updateStatus == null ? 43 : $updateStatus.hashCode());
      Object $approveInfo = this.getApproveInfo();
      result = result * 59 + ($approveInfo == null ? 43 : $approveInfo.hashCode());
      Object $approveInfoName = this.getApproveInfoName();
      result = result * 59 + ($approveInfoName == null ? 43 : $approveInfoName.hashCode());
      Object $applicantIds = this.getApplicantIds();
      result = result * 59 + ($applicantIds == null ? 43 : $applicantIds.hashCode());
      Object $ccUserIds = this.getCcUserIds();
      result = result * 59 + ($ccUserIds == null ? 43 : $ccUserIds.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class ApproveProcessBuilder {
      private Long id;
      private String approveInfo;
      private String approveInfoName;
      private String applicantIds;
      private Integer ccPosition;
      private String ccUserIds;
      private String code;
      private Integer type;
      private Integer updateStatus;

      ApproveProcessBuilder() {
      }

      @JsonProperty("id")
      public ApproveProcess.ApproveProcessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("approveInfo")
      public ApproveProcess.ApproveProcessBuilder approveInfo(final String approveInfo) {
         this.approveInfo = approveInfo;
         return this;
      }

      @JsonProperty("approveInfoName")
      public ApproveProcess.ApproveProcessBuilder approveInfoName(final String approveInfoName) {
         this.approveInfoName = approveInfoName;
         return this;
      }

      @JsonProperty("applicantIds")
      public ApproveProcess.ApproveProcessBuilder applicantIds(final String applicantIds) {
         this.applicantIds = applicantIds;
         return this;
      }

      @JsonProperty("ccPosition")
      public ApproveProcess.ApproveProcessBuilder ccPosition(final Integer ccPosition) {
         this.ccPosition = ccPosition;
         return this;
      }

      @JsonProperty("ccUserIds")
      public ApproveProcess.ApproveProcessBuilder ccUserIds(final String ccUserIds) {
         this.ccUserIds = ccUserIds;
         return this;
      }

      @JsonProperty("code")
      public ApproveProcess.ApproveProcessBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("type")
      public ApproveProcess.ApproveProcessBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("updateStatus")
      public ApproveProcess.ApproveProcessBuilder updateStatus(final Integer updateStatus) {
         this.updateStatus = updateStatus;
         return this;
      }

      public ApproveProcess build() {
         return new ApproveProcess(
            this.id, this.approveInfo, this.approveInfoName, this.applicantIds, this.ccPosition, this.ccUserIds, this.code, this.type, this.updateStatus
         );
      }

      @Override
      public String toString() {
         return "ApproveProcess.ApproveProcessBuilder(id="
            + this.id
            + ", approveInfo="
            + this.approveInfo
            + ", approveInfoName="
            + this.approveInfoName
            + ", applicantIds="
            + this.applicantIds
            + ", ccPosition="
            + this.ccPosition
            + ", ccUserIds="
            + this.ccUserIds
            + ", code="
            + this.code
            + ", type="
            + this.type
            + ", updateStatus="
            + this.updateStatus
            + ")";
      }
   }
}
