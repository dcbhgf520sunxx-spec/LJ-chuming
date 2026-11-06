package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmSpecialProgramsDetailDTO {
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", value = "crmSpecialBubmissionStatusEnum")
   private Integer crmSpecialBubmissionStatusEnum;
   @ApiModelProperty(name = "reportingTime", value = "提报时间")
   private LocalDateTime reportingTime;
   @ApiModelProperty(name = "businessEssentials", value = "业务要点", notes = "业务要点")
   private String businessEssentials;
   @ApiModelProperty(name = "reportUserName", value = "提报人")
   private String reportUserName;

   public static CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder builder() {
      return new CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder();
   }

   public CrmSpecialProgramsDetailDTO() {
   }

   public CrmSpecialProgramsDetailDTO(
      final Integer crmSpecialBubmissionStatusEnum, final LocalDateTime reportingTime, final String businessEssentials, final String reportUserName
   ) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.reportingTime = reportingTime;
      this.businessEssentials = businessEssentials;
      this.reportUserName = reportUserName;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public LocalDateTime getReportingTime() {
      return this.reportingTime;
   }

   public String getBusinessEssentials() {
      return this.businessEssentials;
   }

   public String getReportUserName() {
      return this.reportUserName;
   }

   public CrmSpecialProgramsDetailDTO setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      return this;
   }

   public CrmSpecialProgramsDetailDTO setReportingTime(final LocalDateTime reportingTime) {
      this.reportingTime = reportingTime;
      return this;
   }

   public CrmSpecialProgramsDetailDTO setBusinessEssentials(final String businessEssentials) {
      this.businessEssentials = businessEssentials;
      return this;
   }

   public CrmSpecialProgramsDetailDTO setReportUserName(final String reportUserName) {
      this.reportUserName = reportUserName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmSpecialProgramsDetailDTO(crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", reportingTime="
         + this.getReportingTime()
         + ", businessEssentials="
         + this.getBusinessEssentials()
         + ", reportUserName="
         + this.getReportUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSpecialProgramsDetailDTO)) {
         return false;
      }

      CrmSpecialProgramsDetailDTO other = (CrmSpecialProgramsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
      if (this$crmSpecialBubmissionStatusEnum == null
         ? other$crmSpecialBubmissionStatusEnum == null
         : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
         Object this$reportingTime = this.getReportingTime();
         Object other$reportingTime = other.getReportingTime();
         if (this$reportingTime == null ? other$reportingTime == null : this$reportingTime.equals(other$reportingTime)) {
            Object this$businessEssentials = this.getBusinessEssentials();
            Object other$businessEssentials = other.getBusinessEssentials();
            if (this$businessEssentials == null ? other$businessEssentials == null : this$businessEssentials.equals(other$businessEssentials)) {
               Object this$reportUserName = this.getReportUserName();
               Object other$reportUserName = other.getReportUserName();
               return this$reportUserName == null ? other$reportUserName == null : this$reportUserName.equals(other$reportUserName);
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
      return other instanceof CrmSpecialProgramsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $reportingTime = this.getReportingTime();
      result = result * 59 + ($reportingTime == null ? 43 : $reportingTime.hashCode());
      Object $businessEssentials = this.getBusinessEssentials();
      result = result * 59 + ($businessEssentials == null ? 43 : $businessEssentials.hashCode());
      Object $reportUserName = this.getReportUserName();
      return result * 59 + ($reportUserName == null ? 43 : $reportUserName.hashCode());
   }

   public static class CrmSpecialProgramsDetailDTOBuilder {
      private Integer crmSpecialBubmissionStatusEnum;
      private LocalDateTime reportingTime;
      private String businessEssentials;
      private String reportUserName;

      CrmSpecialProgramsDetailDTOBuilder() {
      }

      public CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder crmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
         this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
         return this;
      }

      public CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder reportingTime(final LocalDateTime reportingTime) {
         this.reportingTime = reportingTime;
         return this;
      }

      public CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder businessEssentials(final String businessEssentials) {
         this.businessEssentials = businessEssentials;
         return this;
      }

      public CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder reportUserName(final String reportUserName) {
         this.reportUserName = reportUserName;
         return this;
      }

      public CrmSpecialProgramsDetailDTO build() {
         return new CrmSpecialProgramsDetailDTO(this.crmSpecialBubmissionStatusEnum, this.reportingTime, this.businessEssentials, this.reportUserName);
      }

      @Override
      public String toString() {
         return "CrmSpecialProgramsDetailDTO.CrmSpecialProgramsDetailDTOBuilder(crmSpecialBubmissionStatusEnum="
            + this.crmSpecialBubmissionStatusEnum
            + ", reportingTime="
            + this.reportingTime
            + ", businessEssentials="
            + this.businessEssentials
            + ", reportUserName="
            + this.reportUserName
            + ")";
      }
   }
}
