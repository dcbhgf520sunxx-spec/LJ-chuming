package com.hzchum.scim.rest.pojo.vo.mes.building.request.abnormal.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.AbnormalHandleDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AbnormalHandleVORequest", description = "")
public class AbnormalHandleVORequest {
   @ApiModelProperty(name = "abnormalId", notes = "异常id", value = "异常id")
   @JsonProperty("abnormalId")
   @JSONField(name = "abnormalId")
   private Long abnormalId;
   @ApiModelProperty(name = "voList", notes = "任务数量", value = "任务数量")
   @JsonProperty("voList")
   @JSONField(name = "voList")
   private List<AbnormalHandleDTOParam> voList;

   public static AbnormalHandleVORequest.AbnormalHandleVORequestBuilder builder() {
      return new AbnormalHandleVORequest.AbnormalHandleVORequestBuilder();
   }

   public AbnormalHandleVORequest(final Long abnormalId, final List<AbnormalHandleDTOParam> voList) {
      this.abnormalId = abnormalId;
      this.voList = voList;
   }

   public AbnormalHandleVORequest() {
   }

   public Long getAbnormalId() {
      return this.abnormalId;
   }

   public List<AbnormalHandleDTOParam> getVoList() {
      return this.voList;
   }

   @JsonProperty("abnormalId")
   public AbnormalHandleVORequest setAbnormalId(final Long abnormalId) {
      this.abnormalId = abnormalId;
      return this;
   }

   @JsonProperty("voList")
   public AbnormalHandleVORequest setVoList(final List<AbnormalHandleDTOParam> voList) {
      this.voList = voList;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalHandleVORequest(abnormalId=" + this.getAbnormalId() + ", voList=" + this.getVoList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AbnormalHandleVORequest)) {
         return false;
      } else {
         AbnormalHandleVORequest other = (AbnormalHandleVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$abnormalId = this.getAbnormalId();
            Object other$abnormalId = other.getAbnormalId();
            if (this$abnormalId == null ? other$abnormalId == null : this$abnormalId.equals(other$abnormalId)) {
               Object this$voList = this.getVoList();
               Object other$voList = other.getVoList();
               return this$voList == null ? other$voList == null : this$voList.equals(other$voList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalHandleVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $abnormalId = this.getAbnormalId();
      result = result * 59 + ($abnormalId == null ? 43 : $abnormalId.hashCode());
      Object $voList = this.getVoList();
      return result * 59 + ($voList == null ? 43 : $voList.hashCode());
   }

   public static class AbnormalHandleVORequestBuilder {
      private Long abnormalId;
      private List<AbnormalHandleDTOParam> voList;

      AbnormalHandleVORequestBuilder() {
      }

      @JsonProperty("abnormalId")
      public AbnormalHandleVORequest.AbnormalHandleVORequestBuilder abnormalId(final Long abnormalId) {
         this.abnormalId = abnormalId;
         return this;
      }

      @JsonProperty("voList")
      public AbnormalHandleVORequest.AbnormalHandleVORequestBuilder voList(final List<AbnormalHandleDTOParam> voList) {
         this.voList = voList;
         return this;
      }

      public AbnormalHandleVORequest build() {
         return new AbnormalHandleVORequest(this.abnormalId, this.voList);
      }

      @Override
      public String toString() {
         return "AbnormalHandleVORequest.AbnormalHandleVORequestBuilder(abnormalId=" + this.abnormalId + ", voList=" + this.voList + ")";
      }
   }
}
