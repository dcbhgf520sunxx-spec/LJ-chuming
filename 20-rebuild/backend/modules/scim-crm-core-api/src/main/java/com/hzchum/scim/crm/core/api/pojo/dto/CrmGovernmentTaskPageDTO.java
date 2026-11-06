package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmGovernmentTaskPageDTO {
   private Long id;
   @ApiModelProperty(name = "createTime", notes = "下达日期")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", notes = "企业名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "attachmentDTOList", notes = "备案文件")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "状态", notes = "状态")
   private Integer crmCheckStatusEnum;

   public static CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder builder() {
      return new CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder();
   }

   public CrmGovernmentTaskPageDTO() {
   }

   public CrmGovernmentTaskPageDTO(
      final Long id,
      final LocalDateTime createTime,
      final String crmEnterpriseWarehousingName,
      final List<AttachmentDTO> attachmentDTOList,
      final Integer crmCheckStatusEnum
   ) {
      this.id = id;
      this.createTime = createTime;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.attachmentDTOList = attachmentDTOList;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public CrmGovernmentTaskPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmGovernmentTaskPageDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmGovernmentTaskPageDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmGovernmentTaskPageDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public CrmGovernmentTaskPageDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmGovernmentTaskPageDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentTaskPageDTO)) {
         return false;
      }

      CrmGovernmentTaskPageDTO other = (CrmGovernmentTaskPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
         Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
         if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
               Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
               if (this$crmEnterpriseWarehousingName == null
                  ? other$crmEnterpriseWarehousingName == null
                  : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                  Object this$attachmentDTOList = this.getAttachmentDTOList();
                  Object other$attachmentDTOList = other.getAttachmentDTOList();
                  return this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList);
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
      return other instanceof CrmGovernmentTaskPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
   }

   public static class CrmGovernmentTaskPageDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private String crmEnterpriseWarehousingName;
      private List<AttachmentDTO> attachmentDTOList;
      private Integer crmCheckStatusEnum;

      CrmGovernmentTaskPageDTOBuilder() {
      }

      public CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmGovernmentTaskPageDTO build() {
         return new CrmGovernmentTaskPageDTO(this.id, this.createTime, this.crmEnterpriseWarehousingName, this.attachmentDTOList, this.crmCheckStatusEnum);
      }

      @Override
      public String toString() {
         return "CrmGovernmentTaskPageDTO.CrmGovernmentTaskPageDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ")";
      }
   }
}
