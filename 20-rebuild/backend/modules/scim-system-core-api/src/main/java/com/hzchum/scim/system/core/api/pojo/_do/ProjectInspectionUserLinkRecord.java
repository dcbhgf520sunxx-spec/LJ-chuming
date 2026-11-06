package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "ProjectInspectionUserLinkRecord对象", description = "项目质检用户关联记录")
@Entity
@TableName("project_inspection_user_link_record")
@Table(name = "project_inspection_user_link_record")
@org.hibernate.annotations.Table(appliesTo = "project_inspection_user_link_record")
public class ProjectInspectionUserLinkRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inspectionUserId", value = "巡检线", notes = "巡检线")
   @TableField("inspection_user_id")
   @Column(name = "inspection_user_id", columnDefinition = "bigint(20)  COMMENT '巡检线'", nullable = false)
   private Long inspectionUserId;
   @ApiModelProperty(name = "removePointJson", value = "待删除的点位", notes = "待删除的点位")
   @TableField("remove_point_json")
   @Column(name = "remove_point_json", columnDefinition = "varchar(255)  COMMENT '待删除的点位'", nullable = false)
   private String removePointJson;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "applyAnnexJson", value = "申请附件", notes = "申请附件")
   @TableField("apply_annex_json")
   @Column(name = "apply_annex_json", columnDefinition = "varchar(255)  COMMENT '申请附件'", nullable = true)
   private String applyAnnexJson;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人'", nullable = true)
   private String createUserName;
   @ApiModelProperty(name = "auditorId", value = "审核人", notes = "审核人")
   @TableField("auditor_id")
   @Column(name = "auditor_id", columnDefinition = "bigint(20)  COMMENT '审核人'", nullable = true)
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人", notes = "审核人")
   @TableField("auditor_name")
   @Column(name = "auditor_name", columnDefinition = "varchar(255)  COMMENT '审核人'", nullable = true)
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "canAuditId", value = "可审核人", notes = "可审核人")
   @TableField("can_audit_id")
   @Column(name = "can_audit_id", columnDefinition = "bigint(20)  COMMENT '可审核人'", nullable = true)
   private Long canAuditId;
   @ApiModelProperty(name = "auditState", value = "审核状态", notes = "审核状态")
   @TableField("audit_state")
   @Column(name = "audit_state", columnDefinition = "int(5)  COMMENT '审核状态'", nullable = true)
   private Integer auditState;
   @ApiModelProperty(name = "recordSource", value = "上版记录", notes = "上版记录")
   @TableField("record_source")
   @Column(name = "record_source", columnDefinition = "bigint(20)  COMMENT '上版记录'", nullable = true)
   private Long recordSource;
   @ApiModelProperty(name = "isFirstEdit", value = "首次编辑", notes = "首次编辑")
   @TableField("is_first_edit")
   @Column(name = "is_first_edit", columnDefinition = "tinyint(1)  COMMENT '首次编辑'", nullable = true)
   private Boolean isFirstEdit;

   public static ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder builder() {
      return new ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder();
   }

   public ProjectInspectionUserLinkRecord() {
   }

   public ProjectInspectionUserLinkRecord(
      final Long id,
      final Long inspectionUserId,
      final String removePointJson,
      final String remark,
      final String applyAnnexJson,
      final Long createUserId,
      final String createUserName,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Long canAuditId,
      final Integer auditState,
      final Long recordSource,
      final Boolean isFirstEdit
   ) {
      this.id = id;
      this.inspectionUserId = inspectionUserId;
      this.removePointJson = removePointJson;
      this.remark = remark;
      this.applyAnnexJson = applyAnnexJson;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.canAuditId = canAuditId;
      this.auditState = auditState;
      this.recordSource = recordSource;
      this.isFirstEdit = isFirstEdit;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectionUserId() {
      return this.inspectionUserId;
   }

   public String getRemovePointJson() {
      return this.removePointJson;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getApplyAnnexJson() {
      return this.applyAnnexJson;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getCanAuditId() {
      return this.canAuditId;
   }

   public Integer getAuditState() {
      return this.auditState;
   }

   public Long getRecordSource() {
      return this.recordSource;
   }

   public Boolean getIsFirstEdit() {
      return this.isFirstEdit;
   }

   public ProjectInspectionUserLinkRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionUserLinkRecord setInspectionUserId(final Long inspectionUserId) {
      this.inspectionUserId = inspectionUserId;
      return this;
   }

   public ProjectInspectionUserLinkRecord setRemovePointJson(final String removePointJson) {
      this.removePointJson = removePointJson;
      return this;
   }

   public ProjectInspectionUserLinkRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectInspectionUserLinkRecord setApplyAnnexJson(final String applyAnnexJson) {
      this.applyAnnexJson = applyAnnexJson;
      return this;
   }

   public ProjectInspectionUserLinkRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public ProjectInspectionUserLinkRecord setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public ProjectInspectionUserLinkRecord setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   public ProjectInspectionUserLinkRecord setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   public ProjectInspectionUserLinkRecord setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public ProjectInspectionUserLinkRecord setCanAuditId(final Long canAuditId) {
      this.canAuditId = canAuditId;
      return this;
   }

   public ProjectInspectionUserLinkRecord setAuditState(final Integer auditState) {
      this.auditState = auditState;
      return this;
   }

   public ProjectInspectionUserLinkRecord setRecordSource(final Long recordSource) {
      this.recordSource = recordSource;
      return this;
   }

   public ProjectInspectionUserLinkRecord setIsFirstEdit(final Boolean isFirstEdit) {
      this.isFirstEdit = isFirstEdit;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionUserLinkRecord(id="
         + this.getId()
         + ", inspectionUserId="
         + this.getInspectionUserId()
         + ", removePointJson="
         + this.getRemovePointJson()
         + ", remark="
         + this.getRemark()
         + ", applyAnnexJson="
         + this.getApplyAnnexJson()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", canAuditId="
         + this.getCanAuditId()
         + ", auditState="
         + this.getAuditState()
         + ", recordSource="
         + this.getRecordSource()
         + ", isFirstEdit="
         + this.getIsFirstEdit()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionUserLinkRecord)) {
         return false;
      }

      ProjectInspectionUserLinkRecord other = (ProjectInspectionUserLinkRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectionUserId = this.getInspectionUserId();
         Object other$inspectionUserId = other.getInspectionUserId();
         if (this$inspectionUserId == null ? other$inspectionUserId == null : this$inspectionUserId.equals(other$inspectionUserId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$auditorId = this.getAuditorId();
               Object other$auditorId = other.getAuditorId();
               if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                  Object this$canAuditId = this.getCanAuditId();
                  Object other$canAuditId = other.getCanAuditId();
                  if (this$canAuditId == null ? other$canAuditId == null : this$canAuditId.equals(other$canAuditId)) {
                     Object this$auditState = this.getAuditState();
                     Object other$auditState = other.getAuditState();
                     if (this$auditState == null ? other$auditState == null : this$auditState.equals(other$auditState)) {
                        Object this$recordSource = this.getRecordSource();
                        Object other$recordSource = other.getRecordSource();
                        if (this$recordSource == null ? other$recordSource == null : this$recordSource.equals(other$recordSource)) {
                           Object this$isFirstEdit = this.getIsFirstEdit();
                           Object other$isFirstEdit = other.getIsFirstEdit();
                           if (this$isFirstEdit == null ? other$isFirstEdit == null : this$isFirstEdit.equals(other$isFirstEdit)) {
                              Object this$removePointJson = this.getRemovePointJson();
                              Object other$removePointJson = other.getRemovePointJson();
                              if (this$removePointJson == null ? other$removePointJson == null : this$removePointJson.equals(other$removePointJson)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$applyAnnexJson = this.getApplyAnnexJson();
                                    Object other$applyAnnexJson = other.getApplyAnnexJson();
                                    if (this$applyAnnexJson == null ? other$applyAnnexJson == null : this$applyAnnexJson.equals(other$applyAnnexJson)) {
                                       Object this$createUserName = this.getCreateUserName();
                                       Object other$createUserName = other.getCreateUserName();
                                       if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                          Object this$auditorName = this.getAuditorName();
                                          Object other$auditorName = other.getAuditorName();
                                          if (this$auditorName == null ? other$auditorName == null : this$auditorName.equals(other$auditorName)) {
                                             Object this$auditTime = this.getAuditTime();
                                             Object other$auditTime = other.getAuditTime();
                                             return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof ProjectInspectionUserLinkRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectionUserId = this.getInspectionUserId();
      result = result * 59 + ($inspectionUserId == null ? 43 : $inspectionUserId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $canAuditId = this.getCanAuditId();
      result = result * 59 + ($canAuditId == null ? 43 : $canAuditId.hashCode());
      Object $auditState = this.getAuditState();
      result = result * 59 + ($auditState == null ? 43 : $auditState.hashCode());
      Object $recordSource = this.getRecordSource();
      result = result * 59 + ($recordSource == null ? 43 : $recordSource.hashCode());
      Object $isFirstEdit = this.getIsFirstEdit();
      result = result * 59 + ($isFirstEdit == null ? 43 : $isFirstEdit.hashCode());
      Object $removePointJson = this.getRemovePointJson();
      result = result * 59 + ($removePointJson == null ? 43 : $removePointJson.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $applyAnnexJson = this.getApplyAnnexJson();
      result = result * 59 + ($applyAnnexJson == null ? 43 : $applyAnnexJson.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class ProjectInspectionUserLinkRecordBuilder {
      private Long id;
      private Long inspectionUserId;
      private String removePointJson;
      private String remark;
      private String applyAnnexJson;
      private Long createUserId;
      private String createUserName;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Long canAuditId;
      private Integer auditState;
      private Long recordSource;
      private Boolean isFirstEdit;

      ProjectInspectionUserLinkRecordBuilder() {
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder inspectionUserId(final Long inspectionUserId) {
         this.inspectionUserId = inspectionUserId;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder removePointJson(final String removePointJson) {
         this.removePointJson = removePointJson;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder applyAnnexJson(final String applyAnnexJson) {
         this.applyAnnexJson = applyAnnexJson;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder canAuditId(final Long canAuditId) {
         this.canAuditId = canAuditId;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder auditState(final Integer auditState) {
         this.auditState = auditState;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder recordSource(final Long recordSource) {
         this.recordSource = recordSource;
         return this;
      }

      public ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder isFirstEdit(final Boolean isFirstEdit) {
         this.isFirstEdit = isFirstEdit;
         return this;
      }

      public ProjectInspectionUserLinkRecord build() {
         return new ProjectInspectionUserLinkRecord(
            this.id,
            this.inspectionUserId,
            this.removePointJson,
            this.remark,
            this.applyAnnexJson,
            this.createUserId,
            this.createUserName,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.canAuditId,
            this.auditState,
            this.recordSource,
            this.isFirstEdit
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionUserLinkRecord.ProjectInspectionUserLinkRecordBuilder(id="
            + this.id
            + ", inspectionUserId="
            + this.inspectionUserId
            + ", removePointJson="
            + this.removePointJson
            + ", remark="
            + this.remark
            + ", applyAnnexJson="
            + this.applyAnnexJson
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", canAuditId="
            + this.canAuditId
            + ", auditState="
            + this.auditState
            + ", recordSource="
            + this.recordSource
            + ", isFirstEdit="
            + this.isFirstEdit
            + ")";
      }
   }
}
