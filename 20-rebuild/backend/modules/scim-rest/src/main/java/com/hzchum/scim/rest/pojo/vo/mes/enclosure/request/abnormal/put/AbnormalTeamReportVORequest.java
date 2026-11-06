package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.abnormal.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AbnormalTeamReportVORequest", description = "")
public class AbnormalTeamReportVORequest {
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   public static AbnormalTeamReportVORequest.AbnormalTeamReportVORequestBuilder builder() {
      return new AbnormalTeamReportVORequest.AbnormalTeamReportVORequestBuilder();
   }

   public AbnormalTeamReportVORequest(final Integer quantity, final Long teamId) {
      this.quantity = quantity;
      this.teamId = teamId;
   }

   public AbnormalTeamReportVORequest() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("quantity")
   public AbnormalTeamReportVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("teamId")
   public AbnormalTeamReportVORequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalTeamReportVORequest(quantity=" + this.getQuantity() + ", teamId=" + this.getTeamId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AbnormalTeamReportVORequest)) {
         return false;
      } else {
         AbnormalTeamReportVORequest other = (AbnormalTeamReportVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               return this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalTeamReportVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   public static class AbnormalTeamReportVORequestBuilder {
      private Integer quantity;
      private Long teamId;

      AbnormalTeamReportVORequestBuilder() {
      }

      @JsonProperty("quantity")
      public AbnormalTeamReportVORequest.AbnormalTeamReportVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("teamId")
      public AbnormalTeamReportVORequest.AbnormalTeamReportVORequestBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public AbnormalTeamReportVORequest build() {
         return new AbnormalTeamReportVORequest(this.quantity, this.teamId);
      }

      @Override
      public String toString() {
         return "AbnormalTeamReportVORequest.AbnormalTeamReportVORequestBuilder(quantity=" + this.quantity + ", teamId=" + this.teamId + ")";
      }
   }
}
