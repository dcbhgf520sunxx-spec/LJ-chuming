package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmProjectAbandonRecord对象", description = "")
@Entity
@TableName("crm_project_abandon_record")
@Table(name = "crm_project_abandon_record")
@org.hibernate.annotations.Table(appliesTo = "crm_project_abandon_record")
public class CrmProjectAbandonRecord extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "abandonDate", value = "放弃日期", notes = "放弃日期")
   @TableField("abandon_date")
   @Column(name = "abandon_date", columnDefinition = "date  COMMENT '放弃日期'", nullable = true)
   private LocalDate abandonDate;
   @ApiModelProperty(name = "abandonAttachment", value = "放弃证明", notes = "放弃证明")
   @TableField("abandon_attachment")
   @Column(name = "abandon_attachment", columnDefinition = "varchar(255)  COMMENT '放弃证明'", nullable = true)
   private String abandonAttachment;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态", notes = "审核状态")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT '审核状态'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder builder() {
      return new CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder();
   }

   public CrmProjectAbandonRecord() {
   }

   public CrmProjectAbandonRecord(
      final Long id,
      final Long crmProjectInformationWarehousingId,
      final LocalDate abandonDate,
      final String abandonAttachment,
      final Long approveRecordId,
      final Integer crmCheckStatusEnum,
      final String remark
   ) {
      this.id = id;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.abandonDate = abandonDate;
      this.abandonAttachment = abandonAttachment;
      this.approveRecordId = approveRecordId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public LocalDate getAbandonDate() {
      return this.abandonDate;
   }

   public String getAbandonAttachment() {
      return this.abandonAttachment;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public CrmProjectAbandonRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectAbandonRecord setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmProjectAbandonRecord setAbandonDate(final LocalDate abandonDate) {
      this.abandonDate = abandonDate;
      return this;
   }

   public CrmProjectAbandonRecord setAbandonAttachment(final String abandonAttachment) {
      this.abandonAttachment = abandonAttachment;
      return this;
   }

   public CrmProjectAbandonRecord setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmProjectAbandonRecord setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectAbandonRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectAbandonRecord(id="
         + this.getId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", abandonDate="
         + this.getAbandonDate()
         + ", abandonAttachment="
         + this.getAbandonAttachment()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectAbandonRecord)) {
         return false;
      }

      CrmProjectAbandonRecord other = (CrmProjectAbandonRecord)o;
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
            Object this$approveRecordId = this.getApproveRecordId();
            Object other$approveRecordId = other.getApproveRecordId();
            if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
               Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
               Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
               if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                  Object this$abandonDate = this.getAbandonDate();
                  Object other$abandonDate = other.getAbandonDate();
                  if (this$abandonDate == null ? other$abandonDate == null : this$abandonDate.equals(other$abandonDate)) {
                     Object this$abandonAttachment = this.getAbandonAttachment();
                     Object other$abandonAttachment = other.getAbandonAttachment();
                     if (this$abandonAttachment == null ? other$abandonAttachment == null : this$abandonAttachment.equals(other$abandonAttachment)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectAbandonRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $abandonDate = this.getAbandonDate();
      result = result * 59 + ($abandonDate == null ? 43 : $abandonDate.hashCode());
      Object $abandonAttachment = this.getAbandonAttachment();
      result = result * 59 + ($abandonAttachment == null ? 43 : $abandonAttachment.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class CrmProjectAbandonRecordBuilder {
      private Long id;
      private Long crmProjectInformationWarehousingId;
      private LocalDate abandonDate;
      private String abandonAttachment;
      private Long approveRecordId;
      private Integer crmCheckStatusEnum;
      private String remark;

      CrmProjectAbandonRecordBuilder() {
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder abandonDate(final LocalDate abandonDate) {
         this.abandonDate = abandonDate;
         return this;
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder abandonAttachment(final String abandonAttachment) {
         this.abandonAttachment = abandonAttachment;
         return this;
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmProjectAbandonRecord build() {
         return new CrmProjectAbandonRecord(
            this.id,
            this.crmProjectInformationWarehousingId,
            this.abandonDate,
            this.abandonAttachment,
            this.approveRecordId,
            this.crmCheckStatusEnum,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "CrmProjectAbandonRecord.CrmProjectAbandonRecordBuilder(id="
            + this.id
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", abandonDate="
            + this.abandonDate
            + ", abandonAttachment="
            + this.abandonAttachment
            + ", approveRecordId="
            + this.approveRecordId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
