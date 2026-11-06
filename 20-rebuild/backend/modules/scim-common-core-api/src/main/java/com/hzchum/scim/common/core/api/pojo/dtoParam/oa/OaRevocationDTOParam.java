package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("OaRevocationDTOParam")
public class OaRevocationDTOParam {
   @ApiModelProperty(name = "requestId", value = "流程ID")
   private String requestId;
   @ApiModelProperty(name = "isremind", value = "是否提醒 0：不提醒 1：提醒")
   private String isremind;
   @ApiModelProperty(name = "remark", value = "撤回流程是提交的意见")
   private String remark;
   @ApiModelProperty(name = "oaUserId", value = "oa用户id")
   private String oaUserId;
   @ApiModelProperty(name = "approveProcessType", value = "流程类型")
   private Integer approveProcessType;

   public static OaRevocationDTOParam.OaRevocationDTOParamBuilder builder() {
      return new OaRevocationDTOParam.OaRevocationDTOParamBuilder();
   }

   public OaRevocationDTOParam(final String requestId, final String isremind, final String remark, final String oaUserId, final Integer approveProcessType) {
      this.requestId = requestId;
      this.isremind = isremind;
      this.remark = remark;
      this.oaUserId = oaUserId;
      this.approveProcessType = approveProcessType;
   }

   public OaRevocationDTOParam() {
   }

   public String getRequestId() {
      return this.requestId;
   }

   public String getIsremind() {
      return this.isremind;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getOaUserId() {
      return this.oaUserId;
   }

   public Integer getApproveProcessType() {
      return this.approveProcessType;
   }

   public OaRevocationDTOParam setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   public OaRevocationDTOParam setIsremind(final String isremind) {
      this.isremind = isremind;
      return this;
   }

   public OaRevocationDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public OaRevocationDTOParam setOaUserId(final String oaUserId) {
      this.oaUserId = oaUserId;
      return this;
   }

   public OaRevocationDTOParam setApproveProcessType(final Integer approveProcessType) {
      this.approveProcessType = approveProcessType;
      return this;
   }

   @Override
   public String toString() {
      return "OaRevocationDTOParam(requestId="
         + this.getRequestId()
         + ", isremind="
         + this.getIsremind()
         + ", remark="
         + this.getRemark()
         + ", oaUserId="
         + this.getOaUserId()
         + ", approveProcessType="
         + this.getApproveProcessType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaRevocationDTOParam)) {
         return false;
      }

      OaRevocationDTOParam other = (OaRevocationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$approveProcessType = this.getApproveProcessType();
      Object other$approveProcessType = other.getApproveProcessType();
      if (this$approveProcessType == null ? other$approveProcessType == null : this$approveProcessType.equals(other$approveProcessType)) {
         Object this$requestId = this.getRequestId();
         Object other$requestId = other.getRequestId();
         if (this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId)) {
            Object this$isremind = this.getIsremind();
            Object other$isremind = other.getIsremind();
            if (this$isremind == null ? other$isremind == null : this$isremind.equals(other$isremind)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$oaUserId = this.getOaUserId();
                  Object other$oaUserId = other.getOaUserId();
                  return this$oaUserId == null ? other$oaUserId == null : this$oaUserId.equals(other$oaUserId);
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
      return other instanceof OaRevocationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $approveProcessType = this.getApproveProcessType();
      result = result * 59 + ($approveProcessType == null ? 43 : $approveProcessType.hashCode());
      Object $requestId = this.getRequestId();
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $isremind = this.getIsremind();
      result = result * 59 + ($isremind == null ? 43 : $isremind.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $oaUserId = this.getOaUserId();
      return result * 59 + ($oaUserId == null ? 43 : $oaUserId.hashCode());
   }

   public static class OaRevocationDTOParamBuilder {
      private String requestId;
      private String isremind;
      private String remark;
      private String oaUserId;
      private Integer approveProcessType;

      OaRevocationDTOParamBuilder() {
      }

      public OaRevocationDTOParam.OaRevocationDTOParamBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      public OaRevocationDTOParam.OaRevocationDTOParamBuilder isremind(final String isremind) {
         this.isremind = isremind;
         return this;
      }

      public OaRevocationDTOParam.OaRevocationDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OaRevocationDTOParam.OaRevocationDTOParamBuilder oaUserId(final String oaUserId) {
         this.oaUserId = oaUserId;
         return this;
      }

      public OaRevocationDTOParam.OaRevocationDTOParamBuilder approveProcessType(final Integer approveProcessType) {
         this.approveProcessType = approveProcessType;
         return this;
      }

      public OaRevocationDTOParam build() {
         return new OaRevocationDTOParam(this.requestId, this.isremind, this.remark, this.oaUserId, this.approveProcessType);
      }

      @Override
      public String toString() {
         return "OaRevocationDTOParam.OaRevocationDTOParamBuilder(requestId="
            + this.requestId
            + ", isremind="
            + this.isremind
            + ", remark="
            + this.remark
            + ", oaUserId="
            + this.oaUserId
            + ", approveProcessType="
            + this.approveProcessType
            + ")";
      }
   }
}
