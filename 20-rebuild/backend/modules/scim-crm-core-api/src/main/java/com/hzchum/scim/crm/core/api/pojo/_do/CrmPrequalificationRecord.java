package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmPrequalificationRecord对象", description = "资格预审记录")
@Entity
@TableName("crm_prequalification_record")
@Table(name = "crm_prequalification_record")
@org.hibernate.annotations.Table(appliesTo = "crm_prequalification_record")
public class CrmPrequalificationRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "文件受理截止日", notes = "文件受理截止日")
   @TableField("deadline_for_acceptance_time")
   @Column(name = "deadline_for_acceptance_time", columnDefinition = "date  COMMENT '文件受理截止日'", nullable = true)
   private LocalDate deadlineForAcceptanceTime;
   @ApiModelProperty(name = "address", value = "文件受理地点", notes = "文件受理地点")
   @TableField("address")
   @Column(name = "address", columnDefinition = "varchar(255)  COMMENT '文件受理地点'", nullable = true)
   private String address;
   @ApiModelProperty(name = "email", value = "文件受理邮箱", notes = "文件受理邮箱")
   @TableField("email")
   @Column(name = "email", columnDefinition = "varchar(255)  COMMENT '文件受理邮箱'", nullable = true)
   private String email;
   @ApiModelProperty(name = "cost", value = "预审费用", notes = "预审费用")
   @TableField("cost")
   @Column(name = "cost", columnDefinition = "decimal(10,2)  COMMENT '预审费用'", nullable = true)
   private BigDecimal cost;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态", notes = "审核状态")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "企业备案id", notes = "企业备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '企业备案id'", nullable = true)
   private Long crmProjectInformationWarehousingId;

   public static CrmPrequalificationRecord.CrmPrequalificationRecordBuilder builder() {
      return new CrmPrequalificationRecord.CrmPrequalificationRecordBuilder();
   }

   public CrmPrequalificationRecord() {
   }

   public CrmPrequalificationRecord(
      final Long id,
      final LocalDate deadlineForAcceptanceTime,
      final String address,
      final String email,
      final BigDecimal cost,
      final Long createUserId,
      final Integer crmCheckStatusEnum,
      final String attachmentIds,
      final Long approveRecordId,
      final String remark,
      final Long crmProjectInformationWarehousingId
   ) {
      this.id = id;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.address = address;
      this.email = email;
      this.cost = cost;
      this.createUserId = createUserId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.attachmentIds = attachmentIds;
      this.approveRecordId = approveRecordId;
      this.remark = remark;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getAddress() {
      return this.address;
   }

   public String getEmail() {
      return this.email;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public CrmPrequalificationRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmPrequalificationRecord setDeadlineForAcceptanceTime(final LocalDate deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmPrequalificationRecord setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmPrequalificationRecord setEmail(final String email) {
      this.email = email;
      return this;
   }

   public CrmPrequalificationRecord setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmPrequalificationRecord setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmPrequalificationRecord setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmPrequalificationRecord setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmPrequalificationRecord setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmPrequalificationRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmPrequalificationRecord setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPrequalificationRecord(id="
         + this.getId()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", address="
         + this.getAddress()
         + ", email="
         + this.getEmail()
         + ", cost="
         + this.getCost()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", remark="
         + this.getRemark()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPrequalificationRecord)) {
         return false;
      }

      CrmPrequalificationRecord other = (CrmPrequalificationRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
            Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
            if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
                  Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
                  if (this$crmProjectInformationWarehousingId == null
                     ? other$crmProjectInformationWarehousingId == null
                     : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                     Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                     Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                     if (this$deadlineForAcceptanceTime == null
                        ? other$deadlineForAcceptanceTime == null
                        : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                        Object this$address = this.getAddress();
                        Object other$address = other.getAddress();
                        if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                           Object this$email = this.getEmail();
                           Object other$email = other.getEmail();
                           if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                              Object this$cost = this.getCost();
                              Object other$cost = other.getCost();
                              if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                                 Object this$attachmentIds = this.getAttachmentIds();
                                 Object other$attachmentIds = other.getAttachmentIds();
                                 if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmPrequalificationRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class CrmPrequalificationRecordBuilder {
      private Long id;
      private LocalDate deadlineForAcceptanceTime;
      private String address;
      private String email;
      private BigDecimal cost;
      private Long createUserId;
      private Integer crmCheckStatusEnum;
      private String attachmentIds;
      private Long approveRecordId;
      private String remark;
      private Long crmProjectInformationWarehousingId;

      CrmPrequalificationRecordBuilder() {
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder deadlineForAcceptanceTime(final LocalDate deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder email(final String email) {
         this.email = email;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmPrequalificationRecord.CrmPrequalificationRecordBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmPrequalificationRecord build() {
         return new CrmPrequalificationRecord(
            this.id,
            this.deadlineForAcceptanceTime,
            this.address,
            this.email,
            this.cost,
            this.createUserId,
            this.crmCheckStatusEnum,
            this.attachmentIds,
            this.approveRecordId,
            this.remark,
            this.crmProjectInformationWarehousingId
         );
      }

      @Override
      public String toString() {
         return "CrmPrequalificationRecord.CrmPrequalificationRecordBuilder(id="
            + this.id
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", address="
            + this.address
            + ", email="
            + this.email
            + ", cost="
            + this.cost
            + ", createUserId="
            + this.createUserId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", attachmentIds="
            + this.attachmentIds
            + ", approveRecordId="
            + this.approveRecordId
            + ", remark="
            + this.remark
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ")";
      }
   }
}
