package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmSupplierTaskPageDTO {
   @ApiModelProperty(name = "createTime", value = "下达时间", notes = "下达时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "attachmentIds", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "createUserName", value = "任务下发人", notes = "任务下发人")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "任务状态", notes = "任务状态")
   private Integer crmCheckStatusEnum;

   public static CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder builder() {
      return new CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder();
   }

   public CrmSupplierTaskPageDTO() {
   }

   public CrmSupplierTaskPageDTO(
      final LocalDateTime createTime,
      final String crmProjectInformationWarehousingName,
      final String crmEnterpriseWarehousingName,
      final List<AttachmentDTO> attachmentIds,
      final LocalDateTime deadlineForAcceptanceTime,
      final String createUserName,
      final Integer crmCheckStatusEnum
   ) {
      this.createTime = createTime;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.attachmentIds = attachmentIds;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.createUserName = createUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public CrmSupplierTaskPageDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmSupplierTaskPageDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmSupplierTaskPageDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmSupplierTaskPageDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmSupplierTaskPageDTO setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmSupplierTaskPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmSupplierTaskPageDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmSupplierTaskPageDTO(createTime="
         + this.getCreateTime()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSupplierTaskPageDTO)) {
         return false;
      }

      CrmSupplierTaskPageDTO other = (CrmSupplierTaskPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
      if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
            Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
            if (this$crmProjectInformationWarehousingName == null
               ? other$crmProjectInformationWarehousingName == null
               : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
               Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
               Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
               if (this$crmEnterpriseWarehousingName == null
                  ? other$crmEnterpriseWarehousingName == null
                  : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                     Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                     Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                     if (this$deadlineForAcceptanceTime == null
                        ? other$deadlineForAcceptanceTime == null
                        : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmSupplierTaskPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmSupplierTaskPageDTOBuilder {
      private LocalDateTime createTime;
      private String crmProjectInformationWarehousingName;
      private String crmEnterpriseWarehousingName;
      private List<AttachmentDTO> attachmentIds;
      private LocalDateTime deadlineForAcceptanceTime;
      private String createUserName;
      private Integer crmCheckStatusEnum;

      CrmSupplierTaskPageDTOBuilder() {
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder crmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder deadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmSupplierTaskPageDTO build() {
         return new CrmSupplierTaskPageDTO(
            this.createTime,
            this.crmProjectInformationWarehousingName,
            this.crmEnterpriseWarehousingName,
            this.attachmentIds,
            this.deadlineForAcceptanceTime,
            this.createUserName,
            this.crmCheckStatusEnum
         );
      }

      @Override
      public String toString() {
         return "CrmSupplierTaskPageDTO.CrmSupplierTaskPageDTOBuilder(createTime="
            + this.createTime
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", attachmentIds="
            + this.attachmentIds
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ")";
      }
   }
}
