package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.abnormal.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "abnormalReportSaveVORequest", description = "")
public class AbnormalReportSaveVORequest {
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量", value = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   private Integer reportQuantity;
   @ApiModelProperty(name = "nextProcessId", notes = "下一道工序id[零件专用]", value = "下一道工序id[零件专用]")
   @JsonProperty("nextProcessId")
   @JSONField(name = "nextProcessId")
   private Long nextProcessId;
   @ApiModelProperty(name = "id", notes = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", notes = "teamId", value = "teamId")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   public static AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder builder() {
      return new AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder();
   }

   public AbnormalReportSaveVORequest(final Integer reportQuantity, final Long nextProcessId, final Long id, final Long teamId) {
      this.reportQuantity = reportQuantity;
      this.nextProcessId = nextProcessId;
      this.id = id;
      this.teamId = teamId;
   }

   public AbnormalReportSaveVORequest() {
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("reportQuantity")
   public AbnormalReportSaveVORequest setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("nextProcessId")
   public AbnormalReportSaveVORequest setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("id")
   public AbnormalReportSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public AbnormalReportSaveVORequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalReportSaveVORequest(reportQuantity="
         + this.getReportQuantity()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ", id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalReportSaveVORequest)) {
         return false;
      }

      AbnormalReportSaveVORequest other = (AbnormalReportSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportQuantity = this.getReportQuantity();
      Object other$reportQuantity = other.getReportQuantity();
      if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
         Object this$nextProcessId = this.getNextProcessId();
         Object other$nextProcessId = other.getNextProcessId();
         if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   public static class AbnormalReportSaveVORequestBuilder {
      private Integer reportQuantity;
      private Long nextProcessId;
      private Long id;
      private Long teamId;

      AbnormalReportSaveVORequestBuilder() {
      }

      @JsonProperty("reportQuantity")
      public AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("nextProcessId")
      public AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("id")
      public AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public AbnormalReportSaveVORequest build() {
         return new AbnormalReportSaveVORequest(this.reportQuantity, this.nextProcessId, this.id, this.teamId);
      }

      @Override
      public String toString() {
         return "AbnormalReportSaveVORequest.AbnormalReportSaveVORequestBuilder(reportQuantity="
            + this.reportQuantity
            + ", nextProcessId="
            + this.nextProcessId
            + ", id="
            + this.id
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
