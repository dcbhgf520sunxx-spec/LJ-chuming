package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AbnormalTeamReportVORequest", description = "")
public class AbnormalTeamReportDTOParam {
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   public static AbnormalTeamReportDTOParam.AbnormalTeamReportDTOParamBuilder builder() {
      return new AbnormalTeamReportDTOParam.AbnormalTeamReportDTOParamBuilder();
   }

   public AbnormalTeamReportDTOParam(final Integer quantity, final Long teamId) {
      this.quantity = quantity;
      this.teamId = teamId;
   }

   public AbnormalTeamReportDTOParam() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("quantity")
   public AbnormalTeamReportDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("teamId")
   public AbnormalTeamReportDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalTeamReportDTOParam(quantity=" + this.getQuantity() + ", teamId=" + this.getTeamId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AbnormalTeamReportDTOParam)) {
         return false;
      } else {
         AbnormalTeamReportDTOParam other = (AbnormalTeamReportDTOParam)o;
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
      return other instanceof AbnormalTeamReportDTOParam;
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

   public static class AbnormalTeamReportDTOParamBuilder {
      private Integer quantity;
      private Long teamId;

      AbnormalTeamReportDTOParamBuilder() {
      }

      @JsonProperty("quantity")
      public AbnormalTeamReportDTOParam.AbnormalTeamReportDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("teamId")
      public AbnormalTeamReportDTOParam.AbnormalTeamReportDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public AbnormalTeamReportDTOParam build() {
         return new AbnormalTeamReportDTOParam(this.quantity, this.teamId);
      }

      @Override
      public String toString() {
         return "AbnormalTeamReportDTOParam.AbnormalTeamReportDTOParamBuilder(quantity=" + this.quantity + ", teamId=" + this.teamId + ")";
      }
   }
}
