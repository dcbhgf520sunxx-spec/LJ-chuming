package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

public class CrmProjectAbandonRecordDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "abandonDate", value = "放弃日期", notes = "放弃日期")
   private LocalDate abandonDate;
   @ApiModelProperty(name = "abandonAttachment", value = "放弃证明", notes = "放弃证明")
   private List<AttachmentDTO> abandonAttachment;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态", notes = "审核状态")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder builder() {
      return new CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder();
   }

   public CrmProjectAbandonRecordDetailDTO() {
   }

   public CrmProjectAbandonRecordDetailDTO(
      final Long id,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final LocalDate abandonDate,
      final List<AttachmentDTO> abandonAttachment,
      final Long approveRecordId,
      final Integer crmCheckStatusEnum,
      final String remark
   ) {
      this.id = id;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
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

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public LocalDate getAbandonDate() {
      return this.abandonDate;
   }

   public List<AttachmentDTO> getAbandonAttachment() {
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

   public CrmProjectAbandonRecordDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setAbandonDate(final LocalDate abandonDate) {
      this.abandonDate = abandonDate;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setAbandonAttachment(final List<AttachmentDTO> abandonAttachment) {
      this.abandonAttachment = abandonAttachment;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmProjectAbandonRecordDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectAbandonRecordDetailDTO(id="
         + this.getId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
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

      if (!(o instanceof CrmProjectAbandonRecordDetailDTO)) {
         return false;
      }

      CrmProjectAbandonRecordDetailDTO other = (CrmProjectAbandonRecordDetailDTO)o;
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
            Object this$approveRecordId = this.getApproveRecordId();
            Object other$approveRecordId = other.getApproveRecordId();
            if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
               Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
               Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
               if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                  Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                  Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                  if (this$crmProjectInformationWarehousingName == null
                     ? other$crmProjectInformationWarehousingName == null
                     : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectAbandonRecordDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $abandonDate = this.getAbandonDate();
      result = result * 59 + ($abandonDate == null ? 43 : $abandonDate.hashCode());
      Object $abandonAttachment = this.getAbandonAttachment();
      result = result * 59 + ($abandonAttachment == null ? 43 : $abandonAttachment.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class CrmProjectAbandonRecordDetailDTOBuilder {
      private Long id;
      private Long crmProjectInformationWarehousingId;
      private String crmProjectInformationWarehousingName;
      private LocalDate abandonDate;
      private List<AttachmentDTO> abandonAttachment;
      private Long approveRecordId;
      private Integer crmCheckStatusEnum;
      private String remark;

      CrmProjectAbandonRecordDetailDTOBuilder() {
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder abandonDate(final LocalDate abandonDate) {
         this.abandonDate = abandonDate;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder abandonAttachment(final List<AttachmentDTO> abandonAttachment) {
         this.abandonAttachment = abandonAttachment;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmProjectAbandonRecordDetailDTO build() {
         return new CrmProjectAbandonRecordDetailDTO(
            this.id,
            this.crmProjectInformationWarehousingId,
            this.crmProjectInformationWarehousingName,
            this.abandonDate,
            this.abandonAttachment,
            this.approveRecordId,
            this.crmCheckStatusEnum,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "CrmProjectAbandonRecordDetailDTO.CrmProjectAbandonRecordDetailDTOBuilder(id="
            + this.id
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
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
