package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmGovernmentTaskPageDownLoadDTO {
   @ApiModelProperty(name = "createTime", notes = "下达日期")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", notes = "企业名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "状态", notes = "状态")
   private Integer crmCheckStatusEnum;

   public static CrmGovernmentTaskPageDownLoadDTO.CrmGovernmentTaskPageDownLoadDTOBuilder builder() {
      return new CrmGovernmentTaskPageDownLoadDTO.CrmGovernmentTaskPageDownLoadDTOBuilder();
   }

   public CrmGovernmentTaskPageDownLoadDTO() {
   }

   public CrmGovernmentTaskPageDownLoadDTO(final LocalDateTime createTime, final String crmEnterpriseWarehousingName, final Integer crmCheckStatusEnum) {
      this.createTime = createTime;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public CrmGovernmentTaskPageDownLoadDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public CrmGovernmentTaskPageDownLoadDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmGovernmentTaskPageDownLoadDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmGovernmentTaskPageDownLoadDTO(createTime="
         + this.getCreateTime()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentTaskPageDownLoadDTO)) {
         return false;
      }

      CrmGovernmentTaskPageDownLoadDTO other = (CrmGovernmentTaskPageDownLoadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
      if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
            Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
            return this$crmEnterpriseWarehousingName == null
               ? other$crmEnterpriseWarehousingName == null
               : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmGovernmentTaskPageDownLoadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      return result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
   }

   public static class CrmGovernmentTaskPageDownLoadDTOBuilder {
      private LocalDateTime createTime;
      private String crmEnterpriseWarehousingName;
      private Integer crmCheckStatusEnum;

      CrmGovernmentTaskPageDownLoadDTOBuilder() {
      }

      public CrmGovernmentTaskPageDownLoadDTO.CrmGovernmentTaskPageDownLoadDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public CrmGovernmentTaskPageDownLoadDTO.CrmGovernmentTaskPageDownLoadDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmGovernmentTaskPageDownLoadDTO.CrmGovernmentTaskPageDownLoadDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmGovernmentTaskPageDownLoadDTO build() {
         return new CrmGovernmentTaskPageDownLoadDTO(this.createTime, this.crmEnterpriseWarehousingName, this.crmCheckStatusEnum);
      }

      @Override
      public String toString() {
         return "CrmGovernmentTaskPageDownLoadDTO.CrmGovernmentTaskPageDownLoadDTOBuilder(createTime="
            + this.createTime
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ")";
      }
   }
}
