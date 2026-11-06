package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class AbnormalReportDTOParam {
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", notes = "teamId")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   public static AbnormalReportDTOParam.AbnormalReportDTOParamBuilder builder() {
      return new AbnormalReportDTOParam.AbnormalReportDTOParamBuilder();
   }

   public AbnormalReportDTOParam(final Integer reportQuantity, final Long id, final Long teamId) {
      this.reportQuantity = reportQuantity;
      this.id = id;
      this.teamId = teamId;
   }

   public AbnormalReportDTOParam() {
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("reportQuantity")
   public void setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("teamId")
   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalReportDTOParam)) {
         return false;
      }

      AbnormalReportDTOParam other = (AbnormalReportDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportQuantity = this.getReportQuantity();
      Object other$reportQuantity = other.getReportQuantity();
      if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            return this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalReportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   @Override
   public String toString() {
      return "AbnormalReportDTOParam(reportQuantity=" + this.getReportQuantity() + ", id=" + this.getId() + ", teamId=" + this.getTeamId() + ")";
   }

   public static class AbnormalReportDTOParamBuilder {
      private Integer reportQuantity;
      private Long id;
      private Long teamId;

      AbnormalReportDTOParamBuilder() {
      }

      @JsonProperty("reportQuantity")
      public AbnormalReportDTOParam.AbnormalReportDTOParamBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("id")
      public AbnormalReportDTOParam.AbnormalReportDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public AbnormalReportDTOParam.AbnormalReportDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public AbnormalReportDTOParam build() {
         return new AbnormalReportDTOParam(this.reportQuantity, this.id, this.teamId);
      }

      @Override
      public String toString() {
         return "AbnormalReportDTOParam.AbnormalReportDTOParamBuilder(reportQuantity="
            + this.reportQuantity
            + ", id="
            + this.id
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
