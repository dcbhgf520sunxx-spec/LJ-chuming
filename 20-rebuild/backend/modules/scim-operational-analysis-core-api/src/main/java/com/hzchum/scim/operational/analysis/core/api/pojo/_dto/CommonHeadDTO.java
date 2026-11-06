package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import io.swagger.annotations.ApiModelProperty;

public class CommonHeadDTO {
   @ApiModelProperty(name = "dateTime", value = "时间", notes = "时间")
   private String dateTime;
   @ApiModelProperty(name = "branchCompanyName", value = "分支机构名称", notes = "分支机构名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;

   public static CommonHeadDTO.CommonHeadDTOBuilder builder() {
      return new CommonHeadDTO.CommonHeadDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommonHeadDTO)) {
         return false;
      }

      CommonHeadDTO other = (CommonHeadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTime = this.getDateTime();
      Object other$dateTime = other.getDateTime();
      if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
         Object this$branchCompanyName = this.getBranchCompanyName();
         Object other$branchCompanyName = other.getBranchCompanyName();
         if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
            Object this$workshopName = this.getWorkshopName();
            Object other$workshopName = other.getWorkshopName();
            return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CommonHeadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   @Override
   public String toString() {
      return "CommonHeadDTO(dateTime="
         + this.getDateTime()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", workshopName="
         + this.getWorkshopName()
         + ")";
   }

   public CommonHeadDTO(final String dateTime, final String branchCompanyName, final String workshopName) {
      this.dateTime = dateTime;
      this.branchCompanyName = branchCompanyName;
      this.workshopName = workshopName;
   }

   public CommonHeadDTO() {
   }

   public static class CommonHeadDTOBuilder {
      private String dateTime;
      private String branchCompanyName;
      private String workshopName;

      CommonHeadDTOBuilder() {
      }

      public CommonHeadDTO.CommonHeadDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public CommonHeadDTO.CommonHeadDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public CommonHeadDTO.CommonHeadDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public CommonHeadDTO build() {
         return new CommonHeadDTO(this.dateTime, this.branchCompanyName, this.workshopName);
      }

      @Override
      public String toString() {
         return "CommonHeadDTO.CommonHeadDTOBuilder(dateTime="
            + this.dateTime
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", workshopName="
            + this.workshopName
            + ")";
      }
   }
}
