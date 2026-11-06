package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post.AssistDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssistListRequest", description = "")
public class AssistListRequest {
   @ApiModelProperty(name = "assistList", notes = "班组协同列表")
   @JsonProperty("assistList")
   @JSONField(name = "assistList")
   private List<AssistDTOParam> assistList;
   @ApiModelProperty(name = "id", notes = "任务工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "nextProcessIds", notes = "协同后续工序")
   @JsonProperty("nextProcessIds")
   @JSONField(name = "nextProcessIds")
   private List<Long> nextProcessIds;
   @ApiModelProperty(name = "artifactTaskId", notes = "构件任务Id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;

   public static AssistListRequest.AssistListRequestBuilder builder() {
      return new AssistListRequest.AssistListRequestBuilder();
   }

   public AssistListRequest() {
   }

   public AssistListRequest(final List<AssistDTOParam> assistList, final Long id, final List<Long> nextProcessIds, final Long artifactTaskId) {
      this.assistList = assistList;
      this.id = id;
      this.nextProcessIds = nextProcessIds;
      this.artifactTaskId = artifactTaskId;
   }

   public List<AssistDTOParam> getAssistList() {
      return this.assistList;
   }

   public Long getId() {
      return this.id;
   }

   public List<Long> getNextProcessIds() {
      return this.nextProcessIds;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   @JsonProperty("assistList")
   public AssistListRequest setAssistList(final List<AssistDTOParam> assistList) {
      this.assistList = assistList;
      return this;
   }

   @JsonProperty("id")
   public AssistListRequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("nextProcessIds")
   public AssistListRequest setNextProcessIds(final List<Long> nextProcessIds) {
      this.nextProcessIds = nextProcessIds;
      return this;
   }

   @JsonProperty("artifactTaskId")
   public AssistListRequest setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @Override
   public String toString() {
      return "AssistListRequest(assistList="
         + this.getAssistList()
         + ", id="
         + this.getId()
         + ", nextProcessIds="
         + this.getNextProcessIds()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ")";
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

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactTaskId = this.getArtifactTaskId();
         Object other$artifactTaskId = other.getArtifactTaskId();
         if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
            Object this$assistList = this.getAssistList();
            Object other$assistList = other.getAssistList();
            if (this$assistList == null ? other$assistList == null : this$assistList.equals(other$assistList)) {
               Object this$nextProcessIds = this.getNextProcessIds();
               Object other$nextProcessIds = other.getNextProcessIds();
               return this$nextProcessIds == null ? other$nextProcessIds == null : this$nextProcessIds.equals(other$nextProcessIds);
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
      return other instanceof AssistListRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $assistList = this.getAssistList();
      result = result * 59 + ($assistList == null ? 43 : $assistList.hashCode());
      Object $nextProcessIds = this.getNextProcessIds();
      return result * 59 + ($nextProcessIds == null ? 43 : $nextProcessIds.hashCode());
   }

   public static class AssistListRequestBuilder {
      private List<AssistDTOParam> assistList;
      private Long id;
      private List<Long> nextProcessIds;
      private Long artifactTaskId;

      AssistListRequestBuilder() {
      }

      @JsonProperty("assistList")
      public AssistListRequest.AssistListRequestBuilder assistList(final List<AssistDTOParam> assistList) {
         this.assistList = assistList;
         return this;
      }

      @JsonProperty("id")
      public AssistListRequest.AssistListRequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("nextProcessIds")
      public AssistListRequest.AssistListRequestBuilder nextProcessIds(final List<Long> nextProcessIds) {
         this.nextProcessIds = nextProcessIds;
         return this;
      }

      @JsonProperty("artifactTaskId")
      public AssistListRequest.AssistListRequestBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      public AssistListRequest build() {
         return new AssistListRequest(this.assistList, this.id, this.nextProcessIds, this.artifactTaskId);
      }

      @Override
      public String toString() {
         return "AssistListRequest.AssistListRequestBuilder(assistList="
            + this.assistList
            + ", id="
            + this.id
            + ", nextProcessIds="
            + this.nextProcessIds
            + ", artifactTaskId="
            + this.artifactTaskId
            + ")";
      }
   }
}
