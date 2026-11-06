package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmProjectFollowUpRecordDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "followUpDate", value = "本次跟进日期", notes = "本次跟进日期")
   private LocalDateTime followUpDate;
   @ApiModelProperty(name = "followUpMethodsName", value = "跟进方式   CrmProjectInformationConfig", notes = "跟进方式   CrmProjectInformationConfig")
   private String followUpMethodsName;
   @ApiModelProperty(name = "followUpAttachment", value = "跟进附件", notes = "跟进附件")
   private List<AttachmentDTO> followUpAttachment;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;

   public static CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder builder() {
      return new CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder();
   }

   public CrmProjectFollowUpRecordDTO() {
   }

   public CrmProjectFollowUpRecordDTO(
      final Long id,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final LocalDateTime followUpDate,
      final String followUpMethodsName,
      final List<AttachmentDTO> followUpAttachment,
      final String remark,
      final Long createUserId,
      final String createUserName,
      final Integer crmCheckStatusEnum,
      final Long approveRecordId
   ) {
      this.id = id;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.followUpDate = followUpDate;
      this.followUpMethodsName = followUpMethodsName;
      this.followUpAttachment = followUpAttachment;
      this.remark = remark;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.approveRecordId = approveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public LocalDateTime getFollowUpDate() {
      return this.followUpDate;
   }

   public String getFollowUpMethodsName() {
      return this.followUpMethodsName;
   }

   public List<AttachmentDTO> getFollowUpAttachment() {
      return this.followUpAttachment;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public CrmProjectFollowUpRecordDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setFollowUpDate(final LocalDateTime followUpDate) {
      this.followUpDate = followUpDate;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setFollowUpMethodsName(final String followUpMethodsName) {
      this.followUpMethodsName = followUpMethodsName;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setFollowUpAttachment(final List<AttachmentDTO> followUpAttachment) {
      this.followUpAttachment = followUpAttachment;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectFollowUpRecordDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectFollowUpRecordDTO(id="
         + this.getId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", followUpDate="
         + this.getFollowUpDate()
         + ", followUpMethodsName="
         + this.getFollowUpMethodsName()
         + ", followUpAttachment="
         + this.getFollowUpAttachment()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
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

      if (!(o instanceof CrmProjectFollowUpRecordDTO)) {
         return false;
      }

      CrmProjectFollowUpRecordDTO other = (CrmProjectFollowUpRecordDTO)o;
      if (!other.canEqual(this)) {
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
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
               Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
               if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                  Object this$approveRecordId = this.getApproveRecordId();
                  Object other$approveRecordId = other.getApproveRecordId();
                  if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                     Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                     Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                     if (this$crmProjectInformationWarehousingName == null
                        ? other$crmProjectInformationWarehousingName == null
                        : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                        Object this$followUpDate = this.getFollowUpDate();
                        Object other$followUpDate = other.getFollowUpDate();
                        if (this$followUpDate == null ? other$followUpDate == null : this$followUpDate.equals(other$followUpDate)) {
                           Object this$followUpMethodsName = this.getFollowUpMethodsName();
                           Object other$followUpMethodsName = other.getFollowUpMethodsName();
                           if (this$followUpMethodsName == null
                              ? other$followUpMethodsName == null
                              : this$followUpMethodsName.equals(other$followUpMethodsName)) {
                              Object this$followUpAttachment = this.getFollowUpAttachment();
                              Object other$followUpAttachment = other.getFollowUpAttachment();
                              if (this$followUpAttachment == null ? other$followUpAttachment == null : this$followUpAttachment.equals(other$followUpAttachment)
                                 )
                               {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$createUserName = this.getCreateUserName();
                                    Object other$createUserName = other.getCreateUserName();
                                    return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectFollowUpRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $followUpDate = this.getFollowUpDate();
      result = result * 59 + ($followUpDate == null ? 43 : $followUpDate.hashCode());
      Object $followUpMethodsName = this.getFollowUpMethodsName();
      result = result * 59 + ($followUpMethodsName == null ? 43 : $followUpMethodsName.hashCode());
      Object $followUpAttachment = this.getFollowUpAttachment();
      result = result * 59 + ($followUpAttachment == null ? 43 : $followUpAttachment.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmProjectFollowUpRecordDTOBuilder {
      private Long id;
      private Long crmProjectInformationWarehousingId;
      private String crmProjectInformationWarehousingName;
      private LocalDateTime followUpDate;
      private String followUpMethodsName;
      private List<AttachmentDTO> followUpAttachment;
      private String remark;
      private Long createUserId;
      private String createUserName;
      private Integer crmCheckStatusEnum;
      private Long approveRecordId;

      CrmProjectFollowUpRecordDTOBuilder() {
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder followUpDate(final LocalDateTime followUpDate) {
         this.followUpDate = followUpDate;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder followUpMethodsName(final String followUpMethodsName) {
         this.followUpMethodsName = followUpMethodsName;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder followUpAttachment(final List<AttachmentDTO> followUpAttachment) {
         this.followUpAttachment = followUpAttachment;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmProjectFollowUpRecordDTO build() {
         return new CrmProjectFollowUpRecordDTO(
            this.id,
            this.crmProjectInformationWarehousingId,
            this.crmProjectInformationWarehousingName,
            this.followUpDate,
            this.followUpMethodsName,
            this.followUpAttachment,
            this.remark,
            this.createUserId,
            this.createUserName,
            this.crmCheckStatusEnum,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "CrmProjectFollowUpRecordDTO.CrmProjectFollowUpRecordDTOBuilder(id="
            + this.id
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", followUpDate="
            + this.followUpDate
            + ", followUpMethodsName="
            + this.followUpMethodsName
            + ", followUpAttachment="
            + this.followUpAttachment
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
