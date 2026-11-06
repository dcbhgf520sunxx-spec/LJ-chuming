package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回对象")
public class SHRJobtitleInfoDTO {
   @JsonProperty("岗位编号")
   private String positionCode;
   @JsonProperty("岗位名称")
   private String positionName;
   @JsonProperty("部门编号")
   private String orgCode;

   public static SHRJobtitleInfoDTO.SHRJobtitleInfoDTOBuilder builder() {
      return new SHRJobtitleInfoDTO.SHRJobtitleInfoDTOBuilder();
   }

   public SHRJobtitleInfoDTO() {
   }

   public SHRJobtitleInfoDTO(final String positionCode, final String positionName, final String orgCode) {
      this.positionCode = positionCode;
      this.positionName = positionName;
      this.orgCode = orgCode;
   }

   public String getPositionCode() {
      return this.positionCode;
   }

   public String getPositionName() {
      return this.positionName;
   }

   public String getOrgCode() {
      return this.orgCode;
   }

   @JsonProperty("岗位编号")
   public SHRJobtitleInfoDTO setPositionCode(final String positionCode) {
      this.positionCode = positionCode;
      return this;
   }

   @JsonProperty("岗位名称")
   public SHRJobtitleInfoDTO setPositionName(final String positionName) {
      this.positionName = positionName;
      return this;
   }

   @JsonProperty("部门编号")
   public SHRJobtitleInfoDTO setOrgCode(final String orgCode) {
      this.orgCode = orgCode;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SHRJobtitleInfoDTO)) {
         return false;
      }

      SHRJobtitleInfoDTO other = (SHRJobtitleInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$positionCode = this.getPositionCode();
      Object other$positionCode = other.getPositionCode();
      if (this$positionCode == null ? other$positionCode == null : this$positionCode.equals(other$positionCode)) {
         Object this$positionName = this.getPositionName();
         Object other$positionName = other.getPositionName();
         if (this$positionName == null ? other$positionName == null : this$positionName.equals(other$positionName)) {
            Object this$orgCode = this.getOrgCode();
            Object other$orgCode = other.getOrgCode();
            return this$orgCode == null ? other$orgCode == null : this$orgCode.equals(other$orgCode);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SHRJobtitleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $positionCode = this.getPositionCode();
      result = result * 59 + ($positionCode == null ? 43 : $positionCode.hashCode());
      Object $positionName = this.getPositionName();
      result = result * 59 + ($positionName == null ? 43 : $positionName.hashCode());
      Object $orgCode = this.getOrgCode();
      return result * 59 + ($orgCode == null ? 43 : $orgCode.hashCode());
   }

   @Override
   public String toString() {
      return "SHRJobtitleInfoDTO(positionCode=" + this.getPositionCode() + ", positionName=" + this.getPositionName() + ", orgCode=" + this.getOrgCode() + ")";
   }

   public static class SHRJobtitleInfoDTOBuilder {
      private String positionCode;
      private String positionName;
      private String orgCode;

      SHRJobtitleInfoDTOBuilder() {
      }

      @JsonProperty("岗位编号")
      public SHRJobtitleInfoDTO.SHRJobtitleInfoDTOBuilder positionCode(final String positionCode) {
         this.positionCode = positionCode;
         return this;
      }

      @JsonProperty("岗位名称")
      public SHRJobtitleInfoDTO.SHRJobtitleInfoDTOBuilder positionName(final String positionName) {
         this.positionName = positionName;
         return this;
      }

      @JsonProperty("部门编号")
      public SHRJobtitleInfoDTO.SHRJobtitleInfoDTOBuilder orgCode(final String orgCode) {
         this.orgCode = orgCode;
         return this;
      }

      public SHRJobtitleInfoDTO build() {
         return new SHRJobtitleInfoDTO(this.positionCode, this.positionName, this.orgCode);
      }

      @Override
      public String toString() {
         return "SHRJobtitleInfoDTO.SHRJobtitleInfoDTOBuilder(positionCode="
            + this.positionCode
            + ", positionName="
            + this.positionName
            + ", orgCode="
            + this.orgCode
            + ")";
      }
   }
}
