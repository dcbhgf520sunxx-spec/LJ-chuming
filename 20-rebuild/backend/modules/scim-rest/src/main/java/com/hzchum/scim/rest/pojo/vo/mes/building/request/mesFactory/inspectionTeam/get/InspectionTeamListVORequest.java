package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.inspectionTeam.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "InspectionTeamListVORequest", description = "质检班组请求类")
public class InspectionTeamListVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;

   public static InspectionTeamListVORequest.InspectionTeamListVORequestBuilder builder() {
      return new InspectionTeamListVORequest.InspectionTeamListVORequestBuilder();
   }

   public InspectionTeamListVORequest() {
   }

   public InspectionTeamListVORequest(final Long id, final Long factoryId, final Long processId) {
      this.id = id;
      this.factoryId = factoryId;
      this.processId = processId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   @JsonProperty("id")
   public InspectionTeamListVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public InspectionTeamListVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public InspectionTeamListVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamListVORequest(id=" + this.getId() + ", factoryId=" + this.getFactoryId() + ", processId=" + this.getProcessId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamListVORequest)) {
         return false;
      }

      InspectionTeamListVORequest other = (InspectionTeamListVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionTeamListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }

   public static class InspectionTeamListVORequestBuilder {
      private Long id;
      private Long factoryId;
      private Long processId;

      InspectionTeamListVORequestBuilder() {
      }

      @JsonProperty("id")
      public InspectionTeamListVORequest.InspectionTeamListVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public InspectionTeamListVORequest.InspectionTeamListVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public InspectionTeamListVORequest.InspectionTeamListVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public InspectionTeamListVORequest build() {
         return new InspectionTeamListVORequest(this.id, this.factoryId, this.processId);
      }

      @Override
      public String toString() {
         return "InspectionTeamListVORequest.InspectionTeamListVORequestBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ")";
      }
   }
}
