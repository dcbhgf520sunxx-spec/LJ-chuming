package com.hzchum.scim.crm.core.api.pojo._do;

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

@ApiModel(value = "CrmProjectFollowUpRecord对象", description = "项目备案跟进记录")
@Entity
@TableName("crm_project_follow_up_record")
@Table(name = "crm_project_follow_up_record")
@org.hibernate.annotations.Table(appliesTo = "crm_project_follow_up_record", comment = "项目备案跟进记录")
public class CrmProjectFollowUpRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '项目备案id'", nullable = true)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "followUpDate", value = "本次跟进日期", notes = "本次跟进日期")
   @TableField("follow_up_date")
   @Column(name = "follow_up_date", columnDefinition = "datetime  COMMENT '本次跟进日期'", nullable = true)
   private LocalDateTime followUpDate;
   @ApiModelProperty(name = "followUpMethods", value = "跟进方式   CrmProjectInformationConfig", notes = "跟进方式   CrmProjectInformationConfig")
   @TableField("follow_up_methods")
   @Column(name = "follow_up_methods", columnDefinition = "bigint(20)  COMMENT '跟进方式   CrmProjectInformationConfig'", nullable = true)
   private Long followUpMethods;
   @ApiModelProperty(name = "followUpAttachment", value = "跟进附件", notes = "跟进附件")
   @TableField("follow_up_attachment")
   @Column(name = "follow_up_attachment", columnDefinition = "varchar(255)  COMMENT '跟进附件'", nullable = true)
   private String followUpAttachment;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(2048)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态 参考枚举 CrmCheckStatusEnum'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;

   public static CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder builder() {
      return new CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder();
   }

   public CrmProjectFollowUpRecord() {
   }

   public CrmProjectFollowUpRecord(
      final Long id,
      final Long crmProjectInformationWarehousingId,
      final LocalDateTime followUpDate,
      final Long followUpMethods,
      final String followUpAttachment,
      final String remark,
      final Long createUserId,
      final Integer crmCheckStatusEnum,
      final Long approveRecordId
   ) {
      this.id = id;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.followUpDate = followUpDate;
      this.followUpMethods = followUpMethods;
      this.followUpAttachment = followUpAttachment;
      this.remark = remark;
      this.createUserId = createUserId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.approveRecordId = approveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public LocalDateTime getFollowUpDate() {
      return this.followUpDate;
   }

   public Long getFollowUpMethods() {
      return this.followUpMethods;
   }

   public String getFollowUpAttachment() {
      return this.followUpAttachment;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public CrmProjectFollowUpRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectFollowUpRecord setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmProjectFollowUpRecord setFollowUpDate(final LocalDateTime followUpDate) {
      this.followUpDate = followUpDate;
      return this;
   }

   public CrmProjectFollowUpRecord setFollowUpMethods(final Long followUpMethods) {
      this.followUpMethods = followUpMethods;
      return this;
   }

   public CrmProjectFollowUpRecord setFollowUpAttachment(final String followUpAttachment) {
      this.followUpAttachment = followUpAttachment;
      return this;
   }

   public CrmProjectFollowUpRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmProjectFollowUpRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmProjectFollowUpRecord setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectFollowUpRecord setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectFollowUpRecord(id="
         + this.getId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", followUpDate="
         + this.getFollowUpDate()
         + ", followUpMethods="
         + this.getFollowUpMethods()
         + ", followUpAttachment="
         + this.getFollowUpAttachment()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectFollowUpRecord)) {
         return false;
      }

      CrmProjectFollowUpRecord other = (CrmProjectFollowUpRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
         Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
         if (this$crmProjectInformationWarehousingId == null
            ? other$crmProjectInformationWarehousingId == null
            : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
            Object this$followUpMethods = this.getFollowUpMethods();
            Object other$followUpMethods = other.getFollowUpMethods();
            if (this$followUpMethods == null ? other$followUpMethods == null : this$followUpMethods.equals(other$followUpMethods)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                  Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                  if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                        Object this$followUpDate = this.getFollowUpDate();
                        Object other$followUpDate = other.getFollowUpDate();
                        if (this$followUpDate == null ? other$followUpDate == null : this$followUpDate.equals(other$followUpDate)) {
                           Object this$followUpAttachment = this.getFollowUpAttachment();
                           Object other$followUpAttachment = other.getFollowUpAttachment();
                           if (this$followUpAttachment == null ? other$followUpAttachment == null : this$followUpAttachment.equals(other$followUpAttachment)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof CrmProjectFollowUpRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $followUpMethods = this.getFollowUpMethods();
      result = result * 59 + ($followUpMethods == null ? 43 : $followUpMethods.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $followUpDate = this.getFollowUpDate();
      result = result * 59 + ($followUpDate == null ? 43 : $followUpDate.hashCode());
      Object $followUpAttachment = this.getFollowUpAttachment();
      result = result * 59 + ($followUpAttachment == null ? 43 : $followUpAttachment.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class CrmProjectFollowUpRecordBuilder {
      private Long id;
      private Long crmProjectInformationWarehousingId;
      private LocalDateTime followUpDate;
      private Long followUpMethods;
      private String followUpAttachment;
      private String remark;
      private Long createUserId;
      private Integer crmCheckStatusEnum;
      private Long approveRecordId;

      CrmProjectFollowUpRecordBuilder() {
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder followUpDate(final LocalDateTime followUpDate) {
         this.followUpDate = followUpDate;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder followUpMethods(final Long followUpMethods) {
         this.followUpMethods = followUpMethods;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder followUpAttachment(final String followUpAttachment) {
         this.followUpAttachment = followUpAttachment;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmProjectFollowUpRecord build() {
         return new CrmProjectFollowUpRecord(
            this.id,
            this.crmProjectInformationWarehousingId,
            this.followUpDate,
            this.followUpMethods,
            this.followUpAttachment,
            this.remark,
            this.createUserId,
            this.crmCheckStatusEnum,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "CrmProjectFollowUpRecord.CrmProjectFollowUpRecordBuilder(id="
            + this.id
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", followUpDate="
            + this.followUpDate
            + ", followUpMethods="
            + this.followUpMethods
            + ", followUpAttachment="
            + this.followUpAttachment
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
