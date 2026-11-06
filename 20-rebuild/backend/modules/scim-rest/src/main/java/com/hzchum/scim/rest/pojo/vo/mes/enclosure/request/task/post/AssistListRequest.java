package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.post.AssistDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssistListRequest", description = "")
public class AssistListRequest {
   @ApiModelProperty(name = "assistList", notes = "班组协同列表")
   @JsonProperty("assistList")
   @JSONField(name = "assistList")
   private List<AssistDTOParam> assistList;

   public static AssistListRequest.AssistListRequestBuilder builder() {
      return new AssistListRequest.AssistListRequestBuilder();
   }

   public AssistListRequest() {
   }

   public AssistListRequest(final List<AssistDTOParam> assistList) {
      this.assistList = assistList;
   }

   public List<AssistDTOParam> getAssistList() {
      return this.assistList;
   }

   @JsonProperty("assistList")
   public AssistListRequest setAssistList(final List<AssistDTOParam> assistList) {
      this.assistList = assistList;
      return this;
   }

   @Override
   public String toString() {
      return "AssistListRequest(assistList=" + this.getAssistList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssistListRequest)) {
         return false;
      }

      AssistListRequest other = (AssistListRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assistList = this.getAssistList();
      Object other$assistList = other.getAssistList();
      return this$assistList == null ? other$assistList == null : this$assistList.equals(other$assistList);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssistListRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assistList = this.getAssistList();
      return result * 59 + ($assistList == null ? 43 : $assistList.hashCode());
   }

   public static class AssistListRequestBuilder {
      private List<AssistDTOParam> assistList;

      AssistListRequestBuilder() {
      }

      @JsonProperty("assistList")
      public AssistListRequest.AssistListRequestBuilder assistList(final List<AssistDTOParam> assistList) {
         this.assistList = assistList;
         return this;
      }

      public AssistListRequest build() {
         return new AssistListRequest(this.assistList);
      }

      @Override
      public String toString() {
         return "AssistListRequest.AssistListRequestBuilder(assistList=" + this.assistList + ")";
      }
   }
}
